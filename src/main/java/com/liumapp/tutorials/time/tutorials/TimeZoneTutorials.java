package com.liumapp.tutorials.time.tutorials;

import com.liumapp.tutorials.time.Console;
import com.liumapp.tutorials.time.interfaces.SimpleTutorials;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Set;

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
        Console.textIO.getTextTerminal().println("或者通过下述方式，将jdk1.8支持的时区打印出来，然后找到自己想要的：");
        Set<String> set = ZoneId.getAvailableZoneIds();
        set.forEach(Console.textIO.getTextTerminal()::println);
    }

    /**
     * 推荐使用这种方式：
     * 通过GMT/UTC的偏移量来获取不同时区的时间
     */
    private void demo3 () {
        Console.textIO.getTextTerminal().println("demo3演示了如何通过GMT/UTC的偏移量来获取不同时区的时间");
        Console.textIO.getTextTerminal().println("如果要通过GMT偏移量获取北京当前时间的话，因为北京时间是东8时区，所以要用GMT+8，得到的时间为：");
        OffsetDateTime offsetDateTime = OffsetDateTime.now(ZoneId.of("GMT+8"));
        Console.textIO.getTextTerminal().println(offsetDateTime + "\n");
        Console.textIO.getTextTerminal().println("如果输出的时间是类似这种的：'2019-03-14T21:44:49.468+08:00'.\n" +
                "那么表示的意思是：我们本地时区当前的时间是2019-03-14T21:44:49.468，+08:00的意思是：\n" +
                "本地时区的时间与GMT/UTC的标准时间提前了8个小时\n" +
                "也就是说，此时此刻，GMT/UTC的标准时间，或者说英国伦敦的时间是2019-03-14T13:44:49.468\n");
        Console.textIO.getTextTerminal().println("那么如何通过GMT的偏移量获取指定时区的时间呢？\n" +
                "我们这里以日本东京为例，因为东京是在东9时区，所以他的UTC/GMT偏移量为+9\n" +
                "那么他的时间将会比我们晚一个小时");

        OffsetDateTime offsetDateTimeOfTokyo = OffsetDateTime.now(ZoneId.of("GMT+9"));
        OffsetDateTime offsetDateTimeOfTokyo2 = OffsetDateTime.now(ZoneId.of("UTC+09:00"));
        OffsetDateTime offsetDateTimeOfTokyo3 = OffsetDateTime.now(ZoneId.of("Etc/GMT-9"));
        Console.textIO.getTextTerminal().println("它的offsetDateTime表现形式为" + offsetDateTimeOfTokyo + "\n" +
                "具体日期为：" + offsetDateTimeOfTokyo.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "\n" +
                "或者" + offsetDateTimeOfTokyo2.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "\n" +
                "或者" + offsetDateTimeOfTokyo3.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "\n" +
                "那么同理，我们可以用OffsetDateTime.now(ZoneId.of(\"GMT+9\"))或者 OffsetDateTime.now(ZoneId.of(\"UTC+09:00\"))\n" +
                "之类的形式，来获取世界上任意一个时区的时间，如果是东2时区，那么GMT+2，如果是西2时区，那么GMT-2，如果像周边小国，只跟我们\n" +
                "隔了半个小时，那么UTC+08:30或者UTC+07:30即可");
    }

}
