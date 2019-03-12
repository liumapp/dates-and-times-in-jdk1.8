package com.liumapp.tutorials.time.tutorials;

import com.liumapp.tutorials.time.Console;
import com.liumapp.tutorials.time.interfaces.SimpleTutorials;

import java.time.ZonedDateTime;

/**
 * file ManipulatingDatesAndTimesTutorials.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/3/11
 */
public class ManipulatingDatesAndTimesTutorials implements SimpleTutorials {
    @Override
    public String showHelpInfo() {
        return "ManipulatingDatesAndTimesTutorials会介绍如何在已经获取到的时间信息上进行操作";
    }

    @Override
    public String run() {
        try {
            this.demo1();
            this.demo2();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "done...";
    }

    /**
     * jdk1.8版本的在已有的日期上添加秒、分、时、日、周、月、年等信息
     */
    private void demo1 () {
        Console.textIO.getTextTerminal().println("demo1演示在已有的日期上添加日、周、月、年等信息：");
        ZonedDateTime date = ZonedDateTime.now();
        Console.textIO.getTextTerminal().println("当前日期为：ZonedDateTime.now() = " + date);
        Console.textIO.getTextTerminal().println("增加20秒的方法：date.plusSeconds(20) = " + date.plusSeconds(20));
        Console.textIO.getTextTerminal().println("增加10分钟的方法：date.plusMinutes(10) = " + date.plusMinutes(10));
        Console.textIO.getTextTerminal().println("增加3小时的方法：date.plusHours(3) = " + date.plusHours(3));
        Console.textIO.getTextTerminal().println("增加一天的方法： date.plusDays(1) = " + date.plusDays(1));
        Console.textIO.getTextTerminal().println("增加一周的方法： date.plusWeeks(1) = " + date.plusWeeks(1));
        Console.textIO.getTextTerminal().println("增加一个月的方法：date.plusMonths(1) = " + date.plusMonths(1));
        Console.textIO.getTextTerminal().println("增加一年的方法：date.plusYears(1) = " + date.plusYears(1));
    }

    /**
     * jdk1.7及更早版本的在已有的日期上添加秒、分、时、日、周、月、年等信息
     */
    private void demo2 () {

    }

}
