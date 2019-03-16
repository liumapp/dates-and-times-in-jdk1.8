package com.liumapp.tutorials.time.tutorials;

import com.liumapp.tutorials.time.Console;
import com.liumapp.tutorials.time.adjusters.AfterSpecifiedMonth;
import com.liumapp.tutorials.time.adjusters.NextChristmas;
import com.liumapp.tutorials.time.helper.ConsoleHelper;
import com.liumapp.tutorials.time.interfaces.SimpleTutorials;
import net.bytebuddy.asm.Advice;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * file UsingTemporalAdjustersTutorials.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/3/16
 */
public class UsingTemporalAdjustersTutorials implements SimpleTutorials {
    @Override
    public String showHelpInfo() {
        return "TemporalAdjusters翻译过来叫临时调节器，跟ChronoUnit做对比的话，他可以帮助我们使用指定个数的时间单位获取未来或者过去的时间点\n";
    }

    @Override
    public String run() {
        try {
            this.demo1();
            ConsoleHelper.showDividingLine();
            this.demo2();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "done...\n";
    }

    /**
     * 通过当前时间点，获取指定个日、月的时间点
     */
    private void demo1 () {
        Console.textIO.getTextTerminal().println("demo1演示了通过当前时间点，获取指定个日、月的时间点");
        LocalDate localDate = LocalDate.now();
        LocalDate firstDayOfThisMonth = localDate.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate lastDayOfTHisMonth = localDate.with(TemporalAdjusters.lastDayOfMonth());
        LocalDate nextMonday = localDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        LocalDate firstDayOfNextMonth = localDate.with(TemporalAdjusters.firstDayOfNextMonth());
        Console.textIO.getTextTerminal().println("这个月的第一个天：" + firstDayOfThisMonth + "\n" +
                "这个月的最后一天：" + lastDayOfTHisMonth + "\n" +
                "下一个星期一：" + nextMonday + "\n" +
                "下个月的第一天：" + firstDayOfNextMonth);
    }

    /**
     * 创建自定义的TemporalAdjusters
     */
    private void demo2 () {
        Console.textIO.getTextTerminal().println("demo2演示了如何创建自定义的TemporalAdjusters");
        LocalDate localDate = LocalDate.now();
        LocalDate nextChristmas = localDate.with(new NextChristmas());
        LocalDate after13Month = localDate.with(new AfterSpecifiedMonth(13));
        Console.textIO.getTextTerminal().println("借助Custom TemporalAdjusters获取到的下一个圣诞节为：" + nextChristmas + "\n" +
                "13个月后的日期为：" + after13Month);

    }
}
