package com.liumapp.tutorials.time.tutorials;

import com.liumapp.tutorials.time.Console;
import com.liumapp.tutorials.time.helper.ConsoleHelper;
import com.liumapp.tutorials.time.interfaces.SimpleTutorials;

import java.time.*;

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
        ZonedDateTime time1 = clock1.instant().atZone(clock1.getZone());
        Clock clock2 = Clock.system(ZoneId.of("GMT+2"));
        ZonedDateTime time2 = clock2.instant().atZone(clock2.getZone());
        Clock clock3 = Clock.system(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime time3 = clock3.instant().atZone(clock3.getZone());

        Console.textIO.getTextTerminal().println("通过clock获取系统时间戳： " + instant);
        Console.textIO.getTextTerminal().println("通过clock获取系统时间戳的第二种方式（UTC）：" + time1);
        Console.textIO.getTextTerminal().println("通过clock获取东二时区的时间：" + time2);
        Console.textIO.getTextTerminal().println("通过clock获取上海时间：" + time3);
        Console.textIO.getTextTerminal().println("通过clock获取本地系统的时区：" + clock + "，clock的源码中也是通过ZoneId.systemDefault()来获取本地系统的时区，所以我们直接使用ZoneId.systemDefault()也是可以的");
        Console.textIO.getTextTerminal().println("通过clock获取系统当前时间戳的微妙数，虽然我们平时更喜欢用System.currentTimeInMillis()，但使用clock.millis()更高效，当前时间戳的微秒数为：" + clock.millis());
        Console.textIO.getTextTerminal().println("注意，我们不能直接通过clock的instant来获取本地时区的时间，因为无论怎样设置，clock的instant都会是英国伦敦时间，即GMT标准时间/UTC世界标准时间");
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


}






