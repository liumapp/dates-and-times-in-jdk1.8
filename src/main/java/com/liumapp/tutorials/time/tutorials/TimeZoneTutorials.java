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
        Console.textIO.getTextTerminal().println("通过查询Shanghai这个关键词来打印上海所在的时区");
        ZoneId.getAvailableZoneIds().stream().filter(z -> z.contains("Shanghai"))
                .sorted().forEach(Console.textIO.getTextTerminal()::println);
    }

    /**
     * 推荐使用这种方式：
     * 通过设置GMT/UTC的偏移量来更改时区
     */
    private void demo3 () {
        Console.textIO.getTextTerminal().println("demo3演示了如何通过设置GMT/UTC的偏移量来获取不同时区的时间");
        Console.textIO.getTextTerminal().println("通过GMT偏移量获取当前时间：");
        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        Console.textIO.getTextTerminal().println(offsetDateTime + "\n");
        Console.textIO.getTextTerminal().println("如果输出的时间是类似这种的：'2017-07-03T21:44:49.468+08:00'.\n" +
                "那么表示的意思是：我们本地时区当前的时间是2017-07-03T21:44:49.468，+08:00的意思是：\n" +
                "本地时区的时间与GMT/UTC的标准时间提前了8个小时\n" +
                "也就是说，此时此刻，GMT/UTC的标准时间，或者说英国伦敦的时间是2017-07-03T13:44:49.468\n");

//        LocalDateTime localDateTime = LocalDateTime.now();
//        Console.textIO.getTextTerminal().println("本地的当前时间为：" + localDateTime);
//        ZoneOffset zoneOffset = ZoneOffset.of("+2");
//        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, zoneOffset);
//        Console.textIO.getTextTerminal().println("跟当前时区偏移两个时区的时间为: " + offsetDateTime);


//        ZoneOffset offset = ZoneOffset.UTC;
//        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, offset);
//        Console.textIO.getTextTerminal().println("本地当前时间为：" + localDateTime + "\n" +
//                "GMT/UTC标准时间为：" + offsetDateTime);
//        ZonedDateTime zonedDateTime = ZonedDateTime.now();

    }
}
