package com.liumapp.tutorials.time.tutorials;

import com.liumapp.tutorials.time.Console;
import com.liumapp.tutorials.time.interfaces.SimpleTutorials;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * file ParsingDatesAndTimesTutorials.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/3/11
 */
public class ParsingDatesAndTimesTutorials implements SimpleTutorials {

    @Override
    public String showHelpInfo() {
        return "ParsingDatesAndTimesTutorials演示如何将一个时间字符串转换成具体的日期对象：LocalDate, LocalDateTime, LocalTime等等";
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
     * 时间字符串转换为LocalDate与LocalTime对象
     */
    private void demo1 () {
        Console.textIO.getTextTerminal().println("demo1演示了如何把时间字符串转换为LocalDate与LocalTime对象");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse("2019-03-13", dateTimeFormatter);
        LocalTime time = LocalTime.parse("19:23");
        Console.textIO.getTextTerminal().println("获取到的date对象为：" + date + "\n" +
                "获取到的time对象为：" + time);
    }

    /**
     * OffsetDateTime转换为LocalDateTime
     */
    private void demo2 () {
        Console.textIO.getTextTerminal().println("demo2演示OffsetDateTime转换为LocalDateTime");
        
    }
}
