package framework.helpers;

import aquality.selenium.core.logging.Logger;
import org.openqa.selenium.grid.config.ConfigException;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Locale;

public class RobotHelper {

    private static final int WAIT = 1000;

    public static void uploadMediaByRobotForOS(String pathname) {

        try {

            Robot robot = new Robot();

            if (System.getProperty("os.name").toLowerCase(Locale.ROOT).startsWith("mac")) {

                File file = new File(pathname);
                StringSelection stringSelection = new StringSelection(file.getAbsolutePath());

                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

                robot.keyPress(KeyEvent.VK_META);
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_META);
                robot.keyRelease(KeyEvent.VK_TAB);
                robot.delay(WAIT);

                robot.keyPress(KeyEvent.VK_META);
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_G);
                robot.keyRelease(KeyEvent.VK_META);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                robot.keyRelease(KeyEvent.VK_G);

                robot.keyPress(KeyEvent.VK_META);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_META);
                robot.keyRelease(KeyEvent.VK_V);

                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                robot.delay(WAIT);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                robot.delay(WAIT);
                robot.keyRelease(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);

            } else if (System.getProperty("os.name").toLowerCase(Locale.ROOT).startsWith("windows")) {

                StringSelection path = new StringSelection(pathname);
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path, null);

                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);

            } else {
                throw new ConfigException("Incorrect operating system specified");
            }
        } catch (AWTException e) {
            Logger.getInstance().error("Robot not initialized. " + e);
        }
    }
}