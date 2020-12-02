package com.sliide.QA_ENGINEER_SLIIDE_TEST;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import com.sliide.QA_ENGINEER_SLIIDE_TEST.DriverProvider.*;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.remote.Augmenter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static com.sliide.QA_ENGINEER_SLIIDE_TEST.DriverProvider.*;

public class NewsApp_LogIn_tests {



    AndroidDriver <AndroidElement> androidDriver = new DriverProvider().getDriverWithCapabilities(newsAppConfig());

    @Before
    public void beforeTest() {
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void afterTest() {
        androidDriver.closeApp();
    }


    @Test
    public void dummy() throws IOException, InterruptedException {
        AndroidElement el = androidDriver.findElement(By.id("com.test.news:id/editTextUserName"));
        String s = el.getAttribute("class");
        el.sendKeys("Useeeeer");
        AndroidElement loginButton= androidDriver.findElement(By.id("com.test.news:id/buttonLogin"));
        loginButton.click();
   /*     Coordinates cor = loginButton.getCoordinates();
        cor.inViewPort();*/
        Thread.sleep(5000);

        WebDriver driver1 = new Augmenter().augment(androidDriver);
        File file = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("Screenshot.png");
        FileUtils.copyFile(file, screenshot);
        BufferedImage bufferedImage = ImageIO.read(screenshot);
        BufferedImage bufferedImageCroped = Tools.cropImage(bufferedImage,900, 300, 550,250);
        File pathFile = new File("Screenshot_crop.png");
        ImageIO.write(bufferedImageCroped,"png", pathFile);
        pathFile = new File("ScreenshotPattern.png");
        screenshot = new File("Screenshot_crop.png");
        Boolean b = Tools.compareImage(pathFile,screenshot);


        System.out.println(b);
       /* System.out.println( loginButton.getCoordinates().inViewPort().toString());;*/




        }

    }




