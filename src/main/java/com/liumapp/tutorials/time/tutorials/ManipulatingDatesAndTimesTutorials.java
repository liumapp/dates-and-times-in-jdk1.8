package com.liumapp.tutorials.time.tutorials;

import com.liumapp.tutorials.time.interfaces.SimpleTutorials;

/**
 * file ManipulatingDatesAndTimesTutorials.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/3/11
 */
public class ManipulatingDatesAndTimesTutorials implements SimpleTutorials {
    @Override
    public String showHelpInfo() {
        return "ManipulatingDatesAndTimesTutorials会介绍如何在已经获取到的时间信息上进行操作";
    }

    @Override
    public String run() {
        try {
            this.demo1();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "done...";
    }

    private void demo1 () {

    }
}
