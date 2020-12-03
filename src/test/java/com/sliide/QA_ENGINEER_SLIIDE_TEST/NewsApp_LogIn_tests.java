package com.sliide.QA_ENGINEER_SLIIDE_TEST;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
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
        //String s = el.getAttribute("class");


        el.sendKeys("Useeeeer");
        File wrongCredaentiialImageBeforeLogin = Tools.takeScreenshotFromScreen(androidDriver,900,300,550,250, "BeforeLigin.png");
        AndroidElement loginButton= androidDriver.findElement(By.id("com.test.news:id/buttonLogin"));
        loginButton.click();

        Thread.sleep(5000);

        File wrongCredaentiialImageAfterLogin = Tools.takeScreenshotFromScreen(androidDriver,900,300,550,250, "AfterLigin.png");




       /* WebDriver driver1 = new Augmenter().augment(androidDriver);
        File file = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("Screenshot.png");
        FileUtils.copyFile(file, screenshot);
        BufferedImage bufferedImage = ImageIO.read(screenshot);
        BufferedImage bufferedImageCroped = Tools.cropImage(bufferedImage,900, 300, 550,250);
        File pathFile = new File("Screenshot_crop.png");
        ImageIO.write(bufferedImageCroped,"png", pathFile);
        screenshot = new File("Screenshot_crop.png");
        pathFile = new File("ScreenshotPattern.png");*/

        Boolean b = Tools.compareImage(wrongCredaentiialImageBeforeLogin,wrongCredaentiialImageAfterLogin);


        System.out.println(b);





        }

    }




