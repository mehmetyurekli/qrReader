package com.yurekli.qrReader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ScreenshotUtility {

    public static BufferedImage getScreenshot() throws AWTException {
        Robot robot = new Robot();
        Rectangle rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        return robot.createScreenCapture(rectangle);
    }
}
