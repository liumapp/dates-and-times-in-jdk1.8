package com.liumapp.tutorials.time.tutorials;

import com.liumapp.tutorials.time.interfaces.SimpleTutorials;

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

    private void demo1 () {
        
    }

}
