package com.liumapp.tutorials.time.tutorials;

import com.liumapp.tutorials.time.Console;
import com.liumapp.tutorials.time.interfaces.SimpleTutorials;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "done...";
    }

    /**
     * 在已有的日期上添加日、周、月、年等信息
     */
    private void demo1 () {
        Console.textIO.getTextTerminal().println("demo1演示在已有的日期上添加日、周、月、年等信息：");
        ZonedDateTime date = ZonedDateTime.now();
        Console.textIO.getTextTerminal().println("增加一天的方法： date.plusDays(1) + " + date.plusDays(1));
        
    }
}
