package com.sliide.QA_ENGINEER_SLIIDE_TEST.Test1;

public class UserCredentials {

    private String userName;
     private String password;

    public UserCredentials(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
