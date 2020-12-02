package com.sliide.QA_ENGINEER_SLIIDE_TEST;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverProvider {

    private static final String APPIUM_SERVER_URL = "http://127.0.0.1:4723/wd/hub";


    static DesiredCapabilities devicePreparation() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "3549e29f");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
        return capabilities;
    }

    static DesiredCapabilities newsAppConfig() {
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

}

