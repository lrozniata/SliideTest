package com.sliide.QA_ENGINEER_SLIIDE_TEST.Activities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity {

    public static List<AndroidElement> ImageViews;




    public static AndroidElement getImaGeViewTop(AndroidDriver androidDriver) {

        List<AndroidElement> imageList = new ArrayList<>();

        imageList = androidDriver.findElementsById("com.test.news:id/imageView");
        ArrayList xCoordinatesLit =  new ArrayList<>();
        for (AndroidElement el: imageList
             ) {
            el.getAttribute("bounds");


        }











}
}
