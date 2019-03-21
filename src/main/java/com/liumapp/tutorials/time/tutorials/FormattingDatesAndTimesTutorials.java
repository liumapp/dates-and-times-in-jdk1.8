package com.liumapp.tutorials.time.tutorials;

import com.liumapp.tutorials.time.Console;
import com.liumapp.tutorials.time.helper.ConsoleHelper;
import com.liumapp.tutorials.time.interfaces.SimpleTutorials;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

/**
 * file FormattingDatesAndTimesTutorials.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/3/12
 */
public class FormattingDatesAndTimesTutorials implements SimpleTutorials {
    @Override
    public String showHelpInfo() {
        return "在jdk1.8中使用DateTimeFormatter来设置时间日期的格式\n";
    }

    @Override
    public String run() {
        try {
            this.demo1();
            ConsoleHelper.showDividingLine();
            this.demo2();
            ConsoleHelper.showDividingLine();
            this.demo3();
            ConsoleHelper.showDividingLine();
            this.demo4();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "done...\n";
    }

    /**
     * DateTimeFormatter改变日期格式的最简演示
     */
    private void demo1 () {
        Console.textIO.getTextTerminal().println("demo1是DateTimeFormatter改变日期格式的最简演示");
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        Console.textIO.getTextTerminal().println("下面打印出来的日期格式都是jdk1.8中的标准日期格式（以ISO开头）：");
        Console.textIO.getTextTerminal().println("format of date is : " + date.format(DateTimeFormatter.ISO_LOCAL_DATE));
        Console.textIO.getTextTerminal().println("format of time is : " + time.format(DateTimeFormatter.ISO_LOCAL_TIME));
        Console.textIO.getTextTerminal().println("format of date time is : " + dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        Console.textIO.getTextTerminal().println("当然也会有其他jdk自带的日期格式:");
        DateTimeFormatter shortDateTime = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        DateTimeFormatter mediumDateTime = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);//这种形式是最常用的
        Console.textIO.getTextTerminal().println("short format style : " + shortDateTime.format(dateTime));
        Console.textIO.getTextTerminal().println("medium format style : " + mediumDateTime.format(dateTime));
    }

    /**
     * 创建自定义的时间日期格式
     */
    private void demo2 () {
        Console.textIO.getTextTerminal().println("demo2演示了如何创建自定义的时间日期格式");
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm");
        Console.textIO.getTextTerminal().println("自定义时间格式：MMMM dd, yyyy, hh:mm，输出当前时间为：" + dateTimeFormatter.format(dateTime));
        Console.textIO.getTextTerminal().println("注意事项：\n" +
                "* M代表月，如果是一月的话，一个M输出1，两个M输出01，三个M输出Jan，四个M输出January\n" +
                "* d代表日，如果是1号的话，一个d输出1，两个d输出01\n" +
                "* y代表年，如果是2019年的话，两个y输出19，四个y输出2019，不允许出现1个y或者3个y的情况\n" +
                "* hh与mm分别代表小时与分钟");
    }

    /**
     * jdk1.7及更早以前版本的修改日期格式方法
     */
    private void demo3 () {
        Console.textIO.getTextTerminal().println("demo3演示了jdk1.7及更早以前版本的修改日期格式方法");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Console.textIO.getTextTerminal().println("自定义时间格式：yyyy-mm-dd hh:mm:ss，输出当前时间为：" + simpleDateFormat.format(new Date()));
    }

    /**
     * 微秒数转指定日期格式
     * 指定日期格式转微妙数
     */
    private void demo4 () {
        Console.textIO.getTextTerminal().println("demo4演示了微秒数转指定日期格式以及指定日期格式转微妙数");
        String date1 = "28/1/2019 13:44:29";
        String date2 = "1553062540363";
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("d/M/yyyy HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(date1, formatter1);
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("GMT+8"));
        Console.textIO.getTextTerminal().println("现有时间" + date1 + " 经过转换后获得微秒数为：" + zonedDateTime.toInstant().toEpochMilli());
        Instant instant = Instant.ofEpochMilli(Long.parseLong(date2));
        ZonedDateTime time2 = instant.atZone(ZoneId.of("GMT+8"));
        Console.textIO.getTextTerminal().println("现有时间戳 " + date2 + " 经过转换后获得的日期为：" + formatter1.format(time2));
    }
}
