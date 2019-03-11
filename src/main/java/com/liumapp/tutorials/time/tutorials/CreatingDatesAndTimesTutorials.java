package com.liumapp.tutorials.time.tutorials;

import com.liumapp.tutorials.time.interfaces.SimpleTutorials;

/**
 * file CreatingDatesAndTimesTutorials.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/3/11
 */
public class CreatingDatesAndTimesTutorials implements SimpleTutorials {
    @Override
    public String showHelpInfo() {
        return "* LocalDate 只有日期，没有时间戳和时区的概念\n" +
                "* LocalTime 只有时间戳，没有日期和时区的概念\n" +
                "* LocalDateTime 有日期和时间戳，但是没有时区的概念\n" +
                "* ZonedDateTime 有日期、时间戳和时区\n" +
                "Oracle建议我们忽略时区，除非真的必须要用到它。（不过企业应用一般都是要考虑这个玩意儿）";
    }

    @Override
    public String run() {
        return null;
    }
}
