package com.liumapp.tutorials.time;

import com.liumapp.tutorials.time.enums.Tutorials;
import com.liumapp.tutorials.time.interfaces.SimpleTutorials;
import com.liumapp.tutorials.time.tutorials.CreatingDatesAndTimesTutorials;
import com.liumapp.tutorials.time.tutorials.ManipulatingDatesAndTimesTutorials;
import com.liumapp.tutorials.time.tutorials.ParsingDatesAndTimesTutorials;
import com.liumapp.tutorials.time.tutorials.WorkingWithPeriodsTutorials;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;

/**
 * file Console.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/3/11
 */
public class Console {

    public static TextIO textIO;

    public static void main (String[] args) {
        textIO = TextIoFactory.getTextIO();
        showPrimaryMenu();
    }

    private static void showPrimaryMenu () {
        Tutorials tutorials = textIO.newEnumInputReader(Tutorials.class)
                .read("What kind of tutorials are you interested in ?");
        handleTutorial(tutorials);
    }

    private static void handleTutorial (Tutorials tutorials) {
        switch (tutorials) {
            case CreatingDatesAndTimesTutorials:
                running(new CreatingDatesAndTimesTutorials());
                break;
            case ManipulatingDatesAndTimesTutorials:
                running(new ManipulatingDatesAndTimesTutorials());
                break;
            case WorkingWithPeriodsTutorials:
                running(new WorkingWithPeriodsTutorials());
                break;
            case ParsingDatesAndTimesTutorials:
                running(new ParsingDatesAndTimesTutorials());
                break;
            default:
        }
        showPrimaryMenu();
    }

    private static void running (SimpleTutorials simpleTutorials) {
        textIO.getTextTerminal().println(simpleTutorials.showHelpInfo());
        textIO.getTextTerminal().println(simpleTutorials.run());
    }


}
