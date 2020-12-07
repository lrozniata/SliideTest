package com.sliide.QA_ENGINEER_SLIIDE_TEST;

import com.sliide.QA_ENGINEER_SLIIDE_TEST.Activities.Activities;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverProvider {

    private static final String APPIUM_SERVER_URL = "http://127.0.0.1:4723/wd/hub";


    public static DesiredCapabilities devicePreparation() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "3549e29f");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
        return capabilities;
    }

   public static DesiredCapabilities newsAppConfig() {
        File appArchive = new File("apps/app-debug.apk");
        DesiredCapabilities capabilities = devicePreparation();
        capabilities.setCapability(MobileCapabilityType.APP, appArchive.getAbsolutePath());
        return capabilities;
    }


    public AndroidDriver<AndroidElement> getDriverWithCapabilities(DesiredCapabilities desiredCapabilities) {
        try {
            return new AndroidDriver<>(new URL(APPIUM_SERVER_URL), desiredCapabilities);
        } catch (MalformedURLException ex) {
            throw new IllegalArgumentException(APPIUM_SERVER_URL);
        }

    }

    public static DesiredCapabilities newsAppConfigWithActivity(String appPackage, String actvityName) {

        DesiredCapabilities capabilities = devicePreparation();

        capabilities.setCapability(MobileCapabilityType.APP, new Activity(appPackage, actvityName));
        //capabilities.setCapability(MobileCapabilityType.APP, new Activity("\"com.test.news", "NewsActivity"));
        return capabilities;
    }

}

