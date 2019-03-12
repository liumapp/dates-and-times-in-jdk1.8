package com.liumapp.tutorials.time.tutorials;

import com.liumapp.tutorials.time.Console;
import com.liumapp.tutorials.time.interfaces.SimpleTutorials;
import net.bytebuddy.asm.Advice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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

    }
}
