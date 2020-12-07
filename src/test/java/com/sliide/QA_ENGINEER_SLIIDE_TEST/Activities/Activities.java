package com.sliide.QA_ENGINEER_SLIIDE_TEST.Activities;

public enum Activities {


    LOGIN_ACTIVITY("com.test.news/com.test.news.features.login.presentation.LoginActivity"),
    NEWS_ACTIVITY("com.test.news/com.test.news.features.news.presentation.NewsActivity");

    String activityName;

    Activities(String s) {
        this.activityName=s;
    }
}
