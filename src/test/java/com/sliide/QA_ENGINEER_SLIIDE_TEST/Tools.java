package com.sliide.QA_ENGINEER_SLIIDE_TEST;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;

public class Tools {
    /**
     * Crops an image to the specified region
     * @param bufferedImage the image that will be crop
     * @param x the upper left x coordinate that this region will start
     * @param y the upper left y coordinate that this region will start
     * @param width the width of the region that will be crop
     * @param height the height of the region that will be crop
     * @return the image that was cropped.
     */
    public static BufferedImage cropImage(BufferedImage bufferedImage, int x, int y, int width, int height){
        BufferedImage croppedImage = bufferedImage.getSubimage(x, y, width, height);
        return croppedImage;
    }

    public static boolean compareImage(File fileA, File fileB) {
        try {
            // take buffer data from botm image files //
            BufferedImage biA = ImageIO.read(fileA);
            DataBuffer dbA = biA.getData().getDataBuffer();
            int sizeA = dbA.getSize();
            BufferedImage biB = ImageIO.read(fileB);
            DataBuffer dbB = biB.getData().getDataBuffer();
            int sizeB = dbB.getSize();
            // compare data-buffer objects //
            if(sizeA == sizeB) {
                for(int i=0; i<sizeA; i++) {
                    if(dbA.getElem(i) != dbB.getElem(i)) {
                        return false;
                    }
                }
                return true;
            }
            else {
                return false;
            }
        }
        catch (Exception e) {
            System.out.println("Failed to compare image files ...");
            return  false;
        }
    }


   public static File takeScreenshotFromScreen(AndroidDriver androidDriver , int x, int y, int width, int height, String ScreenShotName) throws IOException, InterruptedException {

        WebDriver driver1 = (new Augmenter()).augment(androidDriver);
        File file = (File)((TakesScreenshot)driver1).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("Screenshot.png");
        FileUtils.copyFile(file, screenshot);
        BufferedImage bufferedImage = ImageIO.read(screenshot);
        BufferedImage bufferedImageCroped = Tools.cropImage(bufferedImage,x,y, width, height);
       File croppedScreenshot = new File(ScreenShotName);
       ImageIO.write(bufferedImageCroped,"png", croppedScreenshot);

        return croppedScreenshot;
    }



}
