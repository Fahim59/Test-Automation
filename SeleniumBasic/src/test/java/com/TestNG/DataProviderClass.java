package com.TestNG;

public class DataProviderClass {

    @org.testng.annotations.DataProvider(name = "LoginData")
    public Object[][] getdata(){

        Object[][] data = {{"tomsmith","SuperSecretPassword!"},{"abcde","abcde"}};
        return data;
    }
}
