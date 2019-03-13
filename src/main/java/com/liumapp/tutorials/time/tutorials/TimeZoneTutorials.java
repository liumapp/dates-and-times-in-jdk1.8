package com.liumapp.tutorials.time.tutorials;

import com.liumapp.tutorials.time.Console;
import com.liumapp.tutorials.time.interfaces.SimpleTutorials;

import java.time.*;
import java.util.TimeZone;

/**
 * file TimeZoneTutorials.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/3/13
 */
public class TimeZoneTutorials implements SimpleTutorials {
    @Override
    public String showHelpInfo() {
        return "TimeZoneTutorials演示时区的更换方法";
    }

    @Override
    public String run() {
        try {
            this.demo1();
            this.demo2();
            this.demo3();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "done...\n";
    }

    /**
     * jdk1.8中直接设置时区的方法
     */
    private void demo1 () {
        Console.textIO.getTextTerminal().println("demo1演示了jdk1.8中直接设置时区的方法");
        ZoneId zone = ZoneId.of("US/Eastern");
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(2019, 3, 13, 14, 58, 20, 200,zone);
        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(date, time, zone);
        ZonedDateTime zonedDateTime3 = ZonedDateTime.of(dateTime, zone);
        Console.textIO.getTextTerminal().println("方式一获取到的时间为：" + zonedDateTime1);
        Console.textIO.getTextTerminal().println("方式二获取到的时间为：" + zonedDateTime2);
        Console.textIO.getTextTerminal().println("方式三获取到的时间为：" + zonedDateTime3);
    }

    /**
     * 查找指定的时区
     */
    private void demo2 () {
        Console.textIO.getTextTerminal().println("demo2演示了如何查找指定的时区");
        Console.textIO.getTextTerminal().println("通过查询shanghai这个关键词来打印上海所在的时区");
        ZoneId.getAvailableZoneIds().stream().filter(z -> z.contains("Shanghai"))
                .sorted().forEach(Console.textIO.getTextTerminal()::println);
    }

    /**
     * 推荐使用这种方式：
     * 通过设置GMT/UTC的偏移量来更改时区
     */
    private void demo3 () {
        Console.textIO.getTextTerminal().println("demo3演示了如何通过设置GMT/UTC的偏移量来更改时区");
        Console.textIO.getTextTerminal().println("通过GMT偏移量获取北京时间：");
        
    }
}
