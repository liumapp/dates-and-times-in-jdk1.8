package com.liumapp.tutorials.time.tutorials;

import com.liumapp.tutorials.time.interfaces.SimpleTutorials;

/**
 * file UsingInstantTutorials.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/3/14
 */
public class UsingInstantTutorials implements SimpleTutorials {

    @Override
    public String showHelpInfo() {
        return null;
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