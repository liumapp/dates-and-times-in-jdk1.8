package com.liumapp.tutorials.time.tutorials;

import com.liumapp.tutorials.time.Console;
import com.liumapp.tutorials.time.interfaces.SimpleTutorials;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

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
        Console.textIO.getTextTerminal().println("A is : " + A + " B is : " + B);
        while (A.isBefore(B)) {
            Console.textIO.getTextTerminal().println("the system found A is early than B , so print the msg");
            Console.textIO.getTextTerminal().println("A is : " + A + " B is : " + B);
            A.plusMonths(1);
        }
        Console.textIO.getTextTerminal().println("Now A is late than B ...");
        Console.textIO.getTextTerminal().println("A is : " + A + " B is : " + B);
    }
}
