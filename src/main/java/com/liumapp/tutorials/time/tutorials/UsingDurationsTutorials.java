package com.liumapp.tutorials.time.tutorials;

import com.liumapp.tutorials.time.Console;
import com.liumapp.tutorials.time.helper.ConsoleHelper;
import com.liumapp.tutorials.time.interfaces.SimpleTutorials;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * file UsingDurationsTutorials.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/3/15
 */
public class UsingDurationsTutorials implements SimpleTutorials {

    @Override
    public String showHelpInfo() {
        return "Durations是用来修改时、分、秒级别的时间，建议在运行Duration的案例之前，先执行Periods的案例";
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
     * 利用duration获取两个时间点的间隔时间
     */
    private void demo1 () {
        Console.textIO.getTextTerminal().println("demo1演示了利用duration获取两个时间点的间隔时间");
        OffsetDateTime beijing = OffsetDateTime.now(ZoneId.of("GMT+8"));//北京时间
        OffsetDateTime tokyo = OffsetDateTime.now(ZoneId.of("GMT+9"));//东京时间

        LocalDateTime start = beijing.toLocalDateTime();
        LocalDateTime end = tokyo.toLocalDateTime();

        Duration duration = Duration.between(start, end);

        Console.textIO.getTextTerminal().println("当前北京时间和东京时间之间的duration值为：" + duration + "\n" +
                "当然，就这么看的话估计看不出啥名堂，再用一些duration自带的方法可以得到更具体的信息");
        long seconds = duration.getSeconds();
        Console.textIO.getTextTerminal().println("比如通过duration.getSeconds()，我们可以得到当前北京时间和东京时间隔了：" + seconds + "秒");
    }

    /**
     * 同Periods的demo2，利用duration执行时间的变更操作
     */
    private void demo2 () {
        Console.textIO.getTextTerminal().println("demo2是在usingPeriodsTutorials-demo1的基础上使用duration修改");
        LocalDateTime A = LocalDateTime.of(2019, Month.MARCH, 1, 1, 0);
        LocalDateTime B = LocalDateTime.of(2019, Month.MARCH, 2, 2, 0);
        Duration duration = Duration.ofHours(1);
        while (A.isBefore(B)) {
            Console.textIO.getTextTerminal().println("the system found A is early than B , so print the msg");
            Console.textIO.getTextTerminal().println("A is : " + A + " B is : " + B);
            A = A.plus(duration);
        }
        Console.textIO.getTextTerminal().println("Now A is late than B ...");
        Console.textIO.getTextTerminal().println("A is : " + A + " B is : " + B);
    }



}
