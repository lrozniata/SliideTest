package com.sliide.QA_ENGINEER_SLIIDE_TEST.Activities;

import com.sliide.QA_ENGINEER_SLIIDE_TEST.Test1.UserCredentials;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class LoginActivityElement {


    public static AndroidElement UserName_EditText;
    public static AndroidElement Password_EditText;
    public static AndroidElement Login_Button;



    public static AndroidElement getUserName_EditTextByID(AndroidDriver androidDriver) {
        UserName_EditText = (AndroidElement) androidDriver.findElement(By.id("com.test.news:id/editTextUserName"));


        return UserName_EditText;
    }
    public static AndroidElement getPassword_EditTextByID(AndroidDriver androidDriver) {
        Password_EditText = (AndroidElement) androidDriver.findElement(By.id("com.test.news:id/editTextPassword"));


        return Password_EditText;
    }


    public static AndroidElement getLogin_Button(AndroidDriver androidDriver) {
        Login_Button = (AndroidElement) androidDriver.findElement(By.id("com.test.news:id/buttonLogin"));

        return Login_Button;
    }



public static  void logIn(AndroidDriver androidDriver, UserCredentials userCredentials){

        getUserName_EditTextByID(androidDriver).clear();
        getUserName_EditTextByID(androidDriver).sendKeys(userCredentials.getUserName());
    //getUserName_EditTextByID(androidDriver).click();

        getPassword_EditTextByID(androidDriver).clear();
        getPassword_EditTextByID(androidDriver).sendKeys(userCredentials.getPassword());



        getLogin_Button(androidDriver).click();


}

}
