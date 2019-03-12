package com.liumapp.tutorials.time.tutorials;

import com.liumapp.tutorials.time.Console;
import com.liumapp.tutorials.time.interfaces.SimpleTutorials;

import java.time.*;

/**
 * file WorkingWithPeriodsTutorials.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/3/11
 */
public class WorkingWithPeriodsTutorials implements SimpleTutorials {
    @Override
    public String showHelpInfo() {
        return "";
    }

    @Override
    public String run() {
        try {
            this.demo1();
            this.demo2();
            this.demo3();
            this.demo4();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "done...\n";
    }

    /**
     * 设置两个时间点，时间A与时间B，当时间A小于时间B的时候，执行输出动作，并对A递增一个月，直到A大于B为止
     */
    private void demo1 () {
        Console.textIO.getTextTerminal().println("设置两个时间点，时间A与时间B，当时间A小于时间B的时候，执行输出动作，并对A递增一个月，直到A大于B为止");
        LocalDate A = LocalDate.of(2019, Month.MARCH, 1);
        LocalDate B = LocalDate.of(2019, Month.JULY, 30);
        while (A.isBefore(B)) {
            Console.textIO.getTextTerminal().println("the system found A is early than B , so print the msg");
            Console.textIO.getTextTerminal().println("A is : " + A + " B is : " + B);
            A = A.plusMonths(1);
        }
        Console.textIO.getTextTerminal().println("Now A is late than B ...");
        Console.textIO.getTextTerminal().println("A is : " + A + " B is : " + B);
    }

    /**
     * 在demo1的基础上使用periods修改
     */
    private void demo2 () {
        Console.textIO.getTextTerminal().println("demo2是在demo1的基础上使用periods修改");
        LocalDate A = LocalDate.of(2019, Month.MARCH, 1);
        LocalDate B = LocalDate.of(2019, Month.JULY, 30);
        Period period = Period.ofMonths(1);
        while (A.isBefore(B)) {
            Console.textIO.getTextTerminal().println("the system found A is early than B , so print the msg");
            Console.textIO.getTextTerminal().println("A is : " + A + " B is : " + B);
            A = A.plus(period);
        }
        Console.textIO.getTextTerminal().println("Now A is late than B ...");
        Console.textIO.getTextTerminal().println("A is : " + A + " B is : " + B);
    }

    /**
     * 创建periods的不同方式
     */
    private void demo3 () {
        Console.textIO.getTextTerminal().println("demo3演示了创建periods的不同方式");
    }

    /**
     * 将LocalDate、LocalDateTime、zonedDateTime等时间转换为距离1970年1月1日的时间戳
     */
    private void demo4 () {
        Console.textIO.getTextTerminal().println("demo4演示了将LocalDate、LocalDateTime、zonedDateTime等时间转换为距离1970年1月1日的时间戳");
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        Console.textIO.getTextTerminal().println("localDate = " + localDate + "\n" +
                "localDateTime = " + localDateTime + "\n" +
                "zonedDateTime = " + zonedDateTime);
        long dateNumber = localDate.toEpochDay();
        long secondNumber = localDateTime.toEpochSecond(ZoneOffset.UTC);//指定时区偏移量
        long secondNumber2 = zonedDateTime.toEpochSecond();//ZonedDateTime已经自带时区，所以不需要额外指定
        Console.textIO.getTextTerminal().println("the dateNumber of localDate is : " + dateNumber + "\n" +
                "the second number to 1970-01-01 of localDateTime is : " + secondNumber + "\n" +
                "the second number to 1970-01-01 of zonedDateTime is : " + secondNumber2);
        Console.textIO.getTextTerminal().println("注意，LocalTime是没有获取时间戳方法的，因为并没有具体的日期信息");
    }

}
