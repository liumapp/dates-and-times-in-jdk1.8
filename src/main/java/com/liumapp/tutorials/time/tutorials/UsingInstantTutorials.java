package com.liumapp.tutorials.time.tutorials;

import com.liumapp.tutorials.time.Console;
import com.liumapp.tutorials.time.interfaces.SimpleTutorials;

import java.time.Instant;

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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "done...\n";
    }

    /**
     * 通过Instant获取当前时间戳
     */
    private void demo1 () {
        Console.textIO.getTextTerminal().println("demo1演示了通过Instant获取当前时间戳");
        Instant instant = Instant.now();
        Console.textIO.getTextTerminal().println("当前时间戳为：" + instant);
        Console.textIO.getTextTerminal().println("获取具体时间戳的秒（距离1970-01-01的秒数）:" + instant.getEpochSecond());
    }



}
