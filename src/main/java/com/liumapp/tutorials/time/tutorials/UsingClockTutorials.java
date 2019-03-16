package com.liumapp.tutorials.time.tutorials;

import com.liumapp.tutorials.time.Console;
import com.liumapp.tutorials.time.helper.ConsoleHelper;
import com.liumapp.tutorials.time.interfaces.SimpleTutorials;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

/**
 * file UsingClockTutorials.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/3/16
 */
public class UsingClockTutorials implements SimpleTutorials {
    @Override
    public String showHelpInfo() {
        return "UsingClockTutorials";
    }

    @Override
    public String run() {
        try {
            this.demo1();
            ConsoleHelper.showDividingLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "done...\n";
    }

    /**
     * get instant by clock
     */
    private void demo1 () {
        Console.textIO.getTextTerminal().println("demo1演示了通过clock获取系统当前时间戳");
        Clock clock = Clock.systemDefaultZone();
        Instant instant = clock.instant();
        Clock clock1 = Clock.systemUTC();
        Clock clock2 = Clock.system(ZoneId.of("GMT+2"));


        Console.textIO.getTextTerminal().println("通过clock获取系统时间戳： " + instant);
        Console.textIO.getTextTerminal().println("通过clock获取系统时间戳的第二种方式（UTC）：" + clock1.instant());
        Console.textIO.getTextTerminal().println("通过clock获取东二时区的时间：" + clock2.instant());
        Console.textIO.getTextTerminal().println("通过clock获取本地系统的时区：" + clock + "，clock的源码中也是通过ZoneId.systemDefault()来获取本地系统的时区，所以我们直接使用ZoneId.systemDefault()也是可以的");
        Console.textIO.getTextTerminal().println("通过clock获取系统当前时间戳的微妙数，虽然我们平时更喜欢用System.currentTimeInMillis()，但使用clock.millis()更高效，当前时间戳的微秒数为：" + clock.millis());



    }

    /**
     *
     */
    private void demo2 () {

    }
}
