package com.yurekli.qrReader;

import com.google.zxing.NotFoundException;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Main {
    public static final long PERIOD_IN_MS = 3000;
    public static void main(String[] args) {
        while(true) {
            try{
                BufferedImage image = ScreenshotUtility.getScreenshot();
                String result = QrReader.readFromImage(image);
                System.out.println(result);
                URI uri = new URI(result);
                Desktop desk = Desktop.getDesktop();
                desk.browse(uri);
            }
            catch (AWTException awtException){
                awtException.printStackTrace();
            }
            catch (NotFoundException notFoundException){
                System.out.println("No QR found.");
            }
            catch (URISyntaxException e) {
                System.out.println("Non URI result");
            }
            catch (IOException e) {
                System.out.println("Couldn't open URI.");
            }
            finally {
                System.out.println();
                try {
                    Thread.sleep(PERIOD_IN_MS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}