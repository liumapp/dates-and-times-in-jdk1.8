package com.liumapp.tutorials.time.tutorials;

import com.liumapp.tutorials.time.interfaces.SimpleTutorials;

/**
 * file FormattingDatesAndTimesTutorials.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/3/12
 */
public class FormattingDatesAndTimesTutorials implements SimpleTutorials {
    @Override
    public String showHelpInfo() {
        return "演示时间日期格式的使用方法\n";
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
     *
     */
    private void demo1 () {
        
    }
}
