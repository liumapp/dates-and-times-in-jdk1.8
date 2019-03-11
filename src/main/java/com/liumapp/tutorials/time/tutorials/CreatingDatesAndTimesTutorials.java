package com.liumapp.tutorials.time.tutorials;

import com.liumapp.tutorials.time.Console;
import com.liumapp.tutorials.time.interfaces.SimpleTutorials;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;

/**
 * file CreatingDatesAndTimesTutorials.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/3/11
 */
public class CreatingDatesAndTimesTutorials implements SimpleTutorials {
    @Override
    public String showHelpInfo() {
        return "* LocalDate 只有日期，没有时间戳和时区的概念\n" +
                "* LocalTime 只有时间戳，没有日期和时区的概念\n" +
                "* LocalDateTime 有日期和时间戳，但是没有时区的概念\n" +
                "* ZonedDateTime 有日期、时间戳和时区\n" +
                "Oracle建议我们忽略时区，除非真的必须要用到它。（不过企业应用一般都是要考虑这个玩意儿）";
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

    private void demo1 () {
        Console.textIO.getTextTerminal().println("a simple demo of LocalDate : " + LocalDate.now());
        Console.textIO.getTextTerminal().println("a simple demo of LocalTime :" + LocalTime.now());
        Console.textIO.getTextTerminal().println("a simple demo of LocalDateTime : " + LocalDateTime.now());
        Console.textIO.getTextTerminal().println("a simple demo of ZonedDateTime :" + ZonedDateTime.now());
    }
}
