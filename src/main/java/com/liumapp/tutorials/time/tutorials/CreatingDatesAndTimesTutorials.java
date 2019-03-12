package com.liumapp.tutorials.time.tutorials;

import com.liumapp.tutorials.time.Console;
import com.liumapp.tutorials.time.interfaces.SimpleTutorials;

import java.time.*;

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
            this.demo2();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "done...";
    }

    /**
     * jdk1.8中使用时间的最简单方式
     */
    private void demo1 () {
        Console.textIO.getTextTerminal().println("demo1介绍了用最简单的方式，使用jdk1.8所提供的时间方法来获取当前时间：");
        Console.textIO.getTextTerminal().println("a simple demo of LocalDate : " + LocalDate.now());
        Console.textIO.getTextTerminal().println("a simple demo of LocalTime :" + LocalTime.now());
        Console.textIO.getTextTerminal().println("Java使用T来分隔日期和时间戳");
        Console.textIO.getTextTerminal().println("a simple demo of LocalDateTime : " + LocalDateTime.now());
        Console.textIO.getTextTerminal().println("a simple demo of ZonedDateTime :" + ZonedDateTime.now());
        Console.textIO.getTextTerminal().println("使用LocalDate获取指定的日期：");
        Console.textIO.getTextTerminal().println("获取2017年1月20日的日期: LocalDate.of(2017, Month.JANUARY, 20) = " + LocalDate.of(2017, Month.JANUARY, 20));
        Console.textIO.getTextTerminal().println("使用LocalTime获取指定的时间：");
        Console.textIO.getTextTerminal().println("获取19点35分12秒的时间： LocalTime.of(19, 35, 12) = " + LocalTime.of(19, 35, 12));
        Console.textIO.getTextTerminal().println("使用LocalDateTime获取指定的日期跟时间：");
        Console.textIO.getTextTerminal().println("获取2017年1月20日19点35分12秒的时间：LocalDateTime.of(2017, Month.JANUARY, 20, 19, 35, 12) = " + LocalDateTime.of(2017, Month.JANUARY, 20, 19, 35, 12));
        Console.textIO.getTextTerminal().println("需要注意一点，LocalDate, LocalTime, LocalDateTime的源码中，都是使用的私有构造方法，这意味着任何new LocalDate()等写法都是无法通过编译的，我们只能使用它们三者的静态方法");
    }

    /**
     * 在jdk1.7和更早版本的时间用法
     */
    private void demo2 () {
        Console.textIO.getTextTerminal().println("demo2介绍了jdk1.7跟更早版本之前的时间方法：");
        
    }
}
