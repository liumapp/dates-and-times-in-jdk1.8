package com.liumapp.tutorials.time.tutorials;

import com.liumapp.tutorials.time.Console;
import com.liumapp.tutorials.time.helper.ConsoleHelper;
import com.liumapp.tutorials.time.interfaces.SimpleTutorials;

import java.time.Clock;
import java.time.Duration;
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
            this.demo2();
            ConsoleHelper.showDividingLine();
            this.demo3();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "done...\n";
    }

    /**
     * clock的一些简单方法
     */
    private void demo1 () {
        Console.textIO.getTextTerminal().println("demo1演示了clock的一些简单方法");
        Clock clock = Clock.systemDefaultZone();
        Instant instant = clock.instant();
        Clock clock1 = Clock.systemUTC();
        Clock clock2 = Clock.system(ZoneId.of("GMT+2"));
        Clock clock3 = Clock.system(ZoneId.of("Asia/Shanghai"));

        Console.textIO.getTextTerminal().println("通过clock获取系统时间戳： " + instant);
        Console.textIO.getTextTerminal().println("通过clock获取系统时间戳的第二种方式（UTC）：" + clock1.instant());
        Console.textIO.getTextTerminal().println("通过clock获取东二时区的时间：" + clock2.instant());
        Console.textIO.getTextTerminal().println("通过clock获取上海时间：" + clock3.instant());
        Console.textIO.getTextTerminal().println("通过clock获取本地系统的时区：" + clock + "，clock的源码中也是通过ZoneId.systemDefault()来获取本地系统的时区，所以我们直接使用ZoneId.systemDefault()也是可以的");
        Console.textIO.getTextTerminal().println("通过clock获取系统当前时间戳的微妙数，虽然我们平时更喜欢用System.currentTimeInMillis()，但使用clock.millis()更高效，当前时间戳的微秒数为：" + clock.millis());
    }

    /**
     * Clock与Duration结合使用，来进行时、分、秒级别的修改
     */
    private void demo2 () {
        Console.textIO.getTextTerminal().println("demo2演示了Clock与Duration结合使用，来进行时、分、秒级别的修改");
        Clock baseClock = Clock.systemDefaultZone();

        Clock clock = Clock.offset(baseClock, Duration.ofHours(72));
        Console.textIO.getTextTerminal().println("比当前时间后延72个小时的时间：" + clock.instant());

        clock = Clock.offset(baseClock, Duration.ofHours(-72));
        Console.textIO.getTextTerminal().println("比当前时间提前72个小时的时间：" + clock.instant());
    }

    /**
     *
     */
    private void demo3 () {
        Clock clockDefaultZone = Clock.systemDefaultZone();
        Clock clocktick = Clock.tick(clockDefaultZone, Duration.ofHours(2));

        System.out.println("Clock Default Zone: " + clockDefaultZone.instant());
        System.out.println("Clock tick: " + clocktick.instant());

        ZoneId zoneId = ZoneId.of("GMT+8");
        Clock clock = Clock.tickSeconds(zoneId);
        System.out.println(clock.instant());

        clock = Clock.tickMinutes(zoneId);

        System.out.println(clock.instant());
    }

}






