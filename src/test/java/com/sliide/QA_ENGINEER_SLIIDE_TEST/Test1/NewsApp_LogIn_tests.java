package com.sliide.QA_ENGINEER_SLIIDE_TEST.Test1;

import com.sliide.QA_ENGINEER_SLIIDE_TEST.Activities.LoginActivityElement;
import com.sliide.QA_ENGINEER_SLIIDE_TEST.DriverProvider;
import com.sliide.QA_ENGINEER_SLIIDE_TEST.Tools;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.sliide.QA_ENGINEER_SLIIDE_TEST.DriverProvider.*;

public class NewsApp_LogIn_tests {


    AndroidDriver<AndroidElement> androidDriver = new DriverProvider().getDriverWithCapabilities(newsAppConfig());

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
        AndroidElement el2 = androidDriver.findElement(By.id("com.test.news:id/editTextPassword"));
        String s = el2.getAttribute("class");
        System.out.println(s);


        el.sendKeys("Useeeeer");
        File wrongCredaentiialImageBeforeLogin = Tools.takeScreenshotFromScreen(androidDriver, 900, 300, 550, 250, "BeforeLigin.png");
        AndroidElement loginButton = androidDriver.findElement(By.id("com.test.news:id/buttonLogin"));
        loginButton.click();

        Thread.sleep(5000);

        File wrongCredaentiialImageAfterLogin = Tools.takeScreenshotFromScreen(androidDriver, 900, 300, 550, 250, "AfterLigin.png");




       /* WebDriver driver1 = new Augmenter().augment(androidDriver);
        File file = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("Screenshot.png");
        FileUtils.copyFile(file, screenshot);
        BufferedImage bufferedImage = ImageIO.read(screenshot);
        BufferedImage bufferedImageCroped = Tools.cropImage(bufferedImage,900, 300, 550,250);
        File pathFile = new File("Screenshot_crop.png");
        ImageIO.write(bufferedImageCroped,"png", pathFile);
        screenshot = new File("Screenshot_crop.png");
        pathFile = new File("WrongUserNamePattern.png");*/

        Boolean b = Tools.compareImage(wrongCredaentiialImageBeforeLogin, wrongCredaentiialImageAfterLogin);


        System.out.println(b);


    }

    @Test

    public void Scenario_1() {

        //Given - the user opens app for the first time (when not logged in yet)

        //User name Input
        AndroidElement LoginField = LoginActivityElement.getUserName_EditTextByID(androidDriver);

        String loginField_classNameProperty = LoginField.getAttribute("class");
        String loginField_textProperty = LoginField.getAttribute("text");
        String loginField_enabledProperty = LoginField.getAttribute("enabled");
        String loginField_focusedProperty = LoginField.getAttribute("focused");
        String loginField_clickAbleProperty = LoginField.getAttribute("clickable");
        String loginField_long_clicableProperty = LoginField.getAttribute("long-clickable");
        String loginField_passwordProperty = LoginField.getAttribute("password");


        //Password Input
        AndroidElement PasswordField = LoginActivityElement.getPassword_EditTextByID(androidDriver);

        String password_classNameProperty = PasswordField.getAttribute("class");
        String password_textProperty = PasswordField.getAttribute("text");
        String password_enabledProperty = PasswordField.getAttribute("enabled");
        String password_focusedProperty = PasswordField.getAttribute("focused");
        String password_clickAbleProperty = PasswordField.getAttribute("clickable");
        String password_long_clicableProperty = PasswordField.getAttribute("long-clickable");
        String password_passwordProperty = PasswordField.getAttribute("password");


        //Loginn Button

        AndroidElement LoginButton = LoginActivityElement.getLogin_Button(androidDriver);

        String loginButton_classNameProperty = LoginButton.getAttribute("class");
        String loginButton_textProperty = LoginButton.getAttribute("text");
        String loginButton_enabledProperty = LoginButton.getAttribute("enabled");
        String loginButton_clickAbleProperty = LoginButton.getAttribute("clickable");

        //Then - login screen with user name and password entries and login button is displayed

        //Login Field Verification

        Assert.assertEquals("android.widget.EditText", loginField_classNameProperty);
        Assert.assertEquals("User name", loginField_textProperty);
        Assert.assertEquals("true", loginField_enabledProperty);
        Assert.assertEquals("true", loginField_focusedProperty);
        Assert.assertEquals("true", loginField_clickAbleProperty);
        Assert.assertEquals("true", loginField_long_clicableProperty);
        Assert.assertEquals("false", loginField_passwordProperty);

        //Password Field Verification

        Assert.assertEquals("android.widget.EditText", password_classNameProperty);
        Assert.assertEquals("Password", password_textProperty);
        Assert.assertEquals("true", password_enabledProperty);
        Assert.assertEquals("false", password_focusedProperty);
        Assert.assertEquals("true", password_clickAbleProperty);
        Assert.assertEquals("true", password_long_clicableProperty);
        Assert.assertEquals("true", password_passwordProperty);

        //Password Field verification after focus on it

        PasswordField.click();
        password_classNameProperty = PasswordField.getAttribute("class");
        password_textProperty = PasswordField.getAttribute("text");
        password_enabledProperty = PasswordField.getAttribute("enabled");
        password_focusedProperty = PasswordField.getAttribute("focused");
        password_clickAbleProperty = PasswordField.getAttribute("clickable");
        password_long_clicableProperty = PasswordField.getAttribute("long-clickable");
        password_passwordProperty = PasswordField.getAttribute("password");


        Assert.assertEquals("android.widget.EditText", password_classNameProperty);
        Assert.assertEquals("Password", password_textProperty);
        Assert.assertEquals("true", password_enabledProperty);
        Assert.assertEquals("true", password_focusedProperty);
        Assert.assertEquals("true", password_clickAbleProperty);
        Assert.assertEquals("true", password_long_clicableProperty);
        Assert.assertEquals("true", password_passwordProperty);


        //LoginButton verification

        Assert.assertEquals("android.widget.Button", loginButton_classNameProperty);
        Assert.assertEquals("LOGIN", loginButton_textProperty);
        Assert.assertEquals("true", loginButton_enabledProperty);
        Assert.assertEquals("true", loginButton_clickAbleProperty);


    }

    @Test
    public void Scanario_2() throws IOException, InterruptedException {




        /*  Given - the user provided wrong user name and/or password - Wong Password
            When - login button is clicked
           */


        UserCredentials userCredentials = new UserCredentials("user", "wrongpassword#$%^");


        File wrongCredaentiialImageBeforeLogin = Tools.takeScreenshotFromScreen(androidDriver, 900, 430, 550, 250, "BeforeLoginPasswordFiled.png");


        LoginActivityElement.logIn(androidDriver, userCredentials);
        LoginActivityElement.getPassword_EditTextByID(androidDriver).click();

        Thread.sleep(5000);
        File wrongCredaentiialImageAfterLogin = Tools.takeScreenshotFromScreen(androidDriver, 900, 430, 550, 250, "AfterLoginPasswordFiled.png");

        // Then - error markers are displayed

        Boolean diff = Tools.compareImage(wrongCredaentiialImageBeforeLogin, wrongCredaentiialImageAfterLogin);

        //ToDo Righ now it is not device independent

        Boolean diffWithPattern = Tools.compareImage(wrongCredaentiialImageAfterLogin, new File("WrongPasswordPattern.png"));

        Assert.assertFalse(diff);
        Assert.assertTrue(diffWithPattern);


        androidDriver = new DriverProvider().getDriverWithCapabilities(newsAppConfig());
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        userCredentials = new UserCredentials("suer", "password");

        // By the way yue give me wrong credentials in QA ENGINEER SLIIDE TEST.pdf :)


        wrongCredaentiialImageBeforeLogin = Tools.takeScreenshotFromScreen(androidDriver, 900, 300, 550, 250, "BeforeLoginUserField.png");

           /* Given - the user provided wrong user name and/or password - Wong userName
            When - login button is clicked
           */
        LoginActivityElement.logIn(androidDriver, userCredentials);


        Thread.sleep(5000);
        wrongCredaentiialImageAfterLogin = Tools.takeScreenshotFromScreen(androidDriver, 900, 300, 550, 250, "AfterLoginUserField.png");

        // Then - error markers are displayed

        diff = Tools.compareImage(wrongCredaentiialImageBeforeLogin, wrongCredaentiialImageAfterLogin);

        //ToDo Righ now it is not device independent
        diffWithPattern = Tools.compareImage(wrongCredaentiialImageAfterLogin, new File("WrongUserNamePattern.png"));

        Assert.assertFalse(diff);
        Assert.assertTrue(diffWithPattern);

        androidDriver.closeApp();




    }


    @Test
    public void Scanario_3() throws {

        UserCredentials userCredentials = new UserCredentials("user", "password");

     LoginActivityElement.logIn(androidDriver,userCredentials );






    }


}




