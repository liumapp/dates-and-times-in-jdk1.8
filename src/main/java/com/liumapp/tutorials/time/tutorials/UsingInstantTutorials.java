package com.liumapp.tutorials.time.tutorials;

import com.liumapp.tutorials.time.Console;
import com.liumapp.tutorials.time.helper.ConsoleHelper;
import com.liumapp.tutorials.time.interfaces.SimpleTutorials;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

/**
 * file UsingInstantTutorials.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/3/14
 */
public class UsingInstantTutorials implements SimpleTutorials {

    @Override
    public String showHelpInfo() {
        return "Instant是用来返回当前时间戳的";
    }

    @Override
    public String run() {
        try {
            this.demo1();
            ConsoleHelper.showDividingLine();
            this.demo2();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "done...\n";
    }

    /**
     * 通过Instant获取当前时间戳
     */
    private void demo1 () {
        Console.textIO.getTextTerminal().println("demo1演示了通过Instant获取当前时间戳，不过首先我们先来一段错误的代码：");
        Instant instant = Instant.now();
        Console.textIO.getTextTerminal().println("当前时间戳为：" + instant);
        Console.textIO.getTextTerminal().println("获取具体时间戳的秒（距离1970-01-01的秒数）:" + instant.getEpochSecond());

        Console.textIO.getTextTerminal().println("正确的方式为：");
        Instant instant1 = Instant.now(Clock.system(ZoneId.of("GMT+8")));
        Console.textIO.getTextTerminal().println("东8时区的时间戳为：" + instant1);
    }

    /**
     * jdk1.7及更早版本获取时间戳的方法
     */
    private void demo2 () {
        Console.textIO.getTextTerminal().println("jdk1.7及更早版本获取时间戳的方法");
        Date date = new Date();
        Console.textIO.getTextTerminal().println("通过date获取当前时间戳（距离1970的微秒数）" + date.getTime() + "更具体一点的时间为： " + date.toString());
    }



}
