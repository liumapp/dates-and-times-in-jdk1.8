package com.liumapp.tutorials.time.tutorials;

import com.liumapp.tutorials.time.Console;
import com.liumapp.tutorials.time.helper.ConsoleHelper;
import com.liumapp.tutorials.time.interfaces.SimpleTutorials;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * file UsingChronoUnitTutorials.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/3/15
 */
public class UsingChronoUnitTutorials implements SimpleTutorials {
    @Override
    public String showHelpInfo() {
        return "ChronoUnit可以帮助我们用不同的时间单位衡量两个日期之间的间距";
    }

    @Override
    public String run() {
        try {
            this.demo1();
            ConsoleHelper.showDividingLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "done...\n";
    }

    /**
     * 用不同的时间单位衡量两个日期之间的间距
     */
    private void demo1 () {
        Console.textIO.getTextTerminal().println("demo1演示用不同的时间单位，来衡量1978年3月2号0时0分距离此时此刻的间距");
        LocalDateTime old = LocalDateTime.of(1978, Month.MARCH, 2, 0, 0);
        LocalDateTime now = LocalDateTime.now();
        long years = ChronoUnit.YEARS.between(old, now);
        long months = ChronoUnit.MONTHS.between(old, now);
        long days = ChronoUnit.DAYS.between(old, now);
        long hours = ChronoUnit.HOURS.between(old, now);
        long mins = ChronoUnit.MINUTES.between(old, now);
        //你也可以用秒、微妙、纳秒这些单位
        Console.textIO.getTextTerminal().println("1978年3月2号0时0分距离现在" + now + "\n" +
                "隔了:" + years + "年\n或者" + months + "月\n或者" + days + "天\n或者" + hours + "小时\n或者" + mins + "分钟\n");
    }
}
