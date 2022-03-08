package com.TestNG.DataProvider;

public class DataProviderClass {

    @org.testng.annotations.DataProvider(name = "LoginData")
    public Object[][] getdata(){

        Object[][] data = {{"tomsmith","SuperSecretPassword!"},{"abcde","abcde"}};
        return data;
    }

    /*@org.testng.annotations.DataProvider(name = "Login")
    public Object[][] myData(){

        Object[][] data = new Object[1][2];
        data [0][0] = "tomsmith";
        data [0][1] = "SuperSecretPassword!";

        return data;
    }*/
}
