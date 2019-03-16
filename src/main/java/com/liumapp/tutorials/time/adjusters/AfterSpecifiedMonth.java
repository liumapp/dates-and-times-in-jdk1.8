package com.liumapp.tutorials.time.adjusters;

import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

/**
 * file AfterSpecifiedMonth.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/3/16
 */
public class AfterSpecifiedMonth implements TemporalAdjuster {

    private int monthNumber;

    public AfterSpecifiedMonth(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    @Override
    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.PROLEPTIC_MONTH, monthNumber);
    }
}
