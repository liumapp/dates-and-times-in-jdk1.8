package com.liumapp.tutorials.time.tutorials;

import com.liumapp.tutorials.time.Console;
import com.liumapp.tutorials.time.interfaces.SimpleTutorials;

import java.time.Clock;
import java.time.Instant;

/**
 * file UsingClockTutorials.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/3/16
 */
public class UsingClockTutorials implements SimpleTutorials {
    @Override
    public String showHelpInfo() {
        return "UsingClockTutorials";
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
     * get instant by clock
     */
    private void demo1 () {
        Clock clock = Clock.systemDefaultZone();
        Instant instant = clock.instant();
        Console.textIO.getTextTerminal().println("通过clock获取系统时间戳： " + instant);
    }

    private void demo2 () {

    }
}
