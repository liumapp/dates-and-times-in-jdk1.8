package com.liumapp.tutorials.time.tutorials;

import com.liumapp.tutorials.time.Console;
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
        return "Durations是用来修改时、分、秒级别的时间";
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

}
