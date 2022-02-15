package com.Basic;

import com.Base.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;

import java.io.*;
import java.net.*;
import java.time.*;
import java.util.*;

public class AllActions extends BaseClass {
    public static String encode = "QXBwaXVtMTIzQA==";

    public static void main(String[] args) throws InterruptedException, IOException {
        FirefoxLaunch();

        //KeyboardActions();
        //MouseActions();
        //DragandDrop();
        //DropDown();
        //RadioButton();
        //Checkbox();
        //IFrame();
        //Slider();
        //EncodeDecode();
        //DateTime();

        SmallWait();
        FirefoxQuit();
    }
    public static void KeyboardActions(){
        Actions action = new Actions(driver);
        driver.navigate().to("https://google.com");

        //SendKeys
        //driver.findElement(By.name("q")).sendKeys("Selenium Keyboard Action"+ Keys.ENTER);
        //-------------------------------------------------------------------------------------------//

        //KeyDown
        /*Action key = action.keyDown(Keys.CONTROL).sendKeys("A").build();
        key.perform();*/
        //-------------------------------------------------------------------------------------------//

        //KeyUp
        WebElement element = driver.findElement(By.name("q"));
        action.keyDown(Keys.SHIFT).sendKeys(element,"selenium").keyUp(Keys.SHIFT).sendKeys(element,"selenium").perform();
        //-----------------------------------------------------------------------------------------//

        //ClearText
        element.clear();
    }

    public static void MouseActions() throws InterruptedException {
        Actions actions = new Actions(driver);

        /*driver.navigate().to("https://selenium08.blogspot.com/2020/01/click-and-hold.html");

        WebElement A = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/main/div/div[1]/div/article/div/div/div[3]/div[1]/div/ul/li[1]"));
        WebElement D = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/main/div/div[1]/div/article/div/div/div[3]/div[1]/div/ul/li[4]"));

        //actions.moveToElement(A).clickAndHold().moveToElement(D).build().perform();
        actions.moveToElement(A);
        actions.clickAndHold();
        actions.moveToElement(D).release().perform();

        Thread.sleep(5000);*/
        //-------------------------------------------------------------------------------//
        //driver.navigate().to("https://demoqa.com/buttons");

        //DoubleClick
        /*WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(doubleClickBtn).perform();

        if(driver.getPageSource().contains("You have done a double click")){
            System.out.println("Clicked");
        }
        else{
            System.out.println("Not Clicked");
        }*/
        //--------------------------------------------------------------------------------//

        //RightClick/ContextCLick
        /*WebElement rightClickBtn  = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClickBtn).perform();

        if(driver.getPageSource().contains("You have done a right click")){
            System.out.println("Clicked");
        }
        else{
            System.out.println("Not Clicked");
        }*/
        //-------------------------------------------------------------------------------//

        //Resize
        driver.navigate().to("https://jqueryui.com/resizable/");

        driver.switchTo().frame(0);

        WebElement resize = driver.findElement(By.xpath("/html/body/div/div[3]"));
        actions.dragAndDropBy(resize, 100, 50).perform();

        Thread.sleep(3000);
    }

    public static void DragandDrop(){
        Actions action = new Actions(driver);

        //Drag
        driver.navigate().to("https://jqueryui.com/draggable/");

        List<WebElement> frame = driver.findElements(By.tagName("iframe"));

        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
        System.out.println(drag.getText());

        action.moveToElement(drag).dragAndDropBy(drag, 50,0).build().perform();
        //--------------------------------------------------------------------------------//
        //Drag and Drop
        /*driver.navigate().to("https://selenium08.blogspot.com/2020/01/drag-drop.html");

        WebElement drag  = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
        WebElement drop  = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));

        actions.dragAndDrop(drag,drop).build().perform();*/
    }

    public static void DropDown() throws InterruptedException {
        driver.navigate().to("https://trytestingthis.netlify.app/");

        WebElement drop = driver.findElement(By.id("option"));
        Select select = new Select(drop);
        //-----------------------------------------------------------------------//
        //First Method
        /*select.selectByIndex(1);
        select.selectByValue("option 2");
        select.selectByVisibleText("Option 3");
        Thread.sleep(5000);*/
        //-----------------------------------------------------------------------//
        //Second Method
        /*List<WebElement> options = select.getOptions();

        for(WebElement option : options){
            System.out.println(option.getText());

            if(option.getText().equalsIgnoreCase("option 2")){
                option.click();
            }
            else {
                System.out.println("Not found");
            }
        }
        Thread.sleep(5000);*/
        //-----------------------------------------------------------------------//
        //Check if the Dropdown is sorted or not
        /*List originalList = new ArrayList();
        List sortedList = new ArrayList();

        List<WebElement> options = select.getOptions();

        for(WebElement option : options){
            originalList.add(option.getText());
            sortedList.add(option.getText());
        }
        System.out.println("Before sorting, Original List: " +originalList);
        System.out.println("Before sorting, Sorted List: " +sortedList);

        Collections.sort(sortedList);

        System.out.println("After sorting, Original List: " +originalList);
        System.out.println("After sorting, Sorted List: " +sortedList);

        if(originalList == sortedList){
            System.out.println("Sorted");
        }
        else {
            System.out.println("Not Sorted");
        }

        Thread.sleep(5000);*/
        //-----------------------------------------------------------------------//
        /*select.deselectByIndex(1);
        select.deselectByValue("option 2");
        select.deselectByVisibleText("Option 3");

        select.deselectAll();*/
    }

    public static void RadioButton(){
        driver.navigate().to("https://trytestingthis.netlify.app/");

        List<WebElement> gender = driver.findElements(By.name("gender"));
        //System.out.println(gender.size());
        for(WebElement option : gender){
            System.out.println(option.getAttribute("value")); //printing the options

            if(option.getAttribute("value").equalsIgnoreCase("male")){
                //JavascriptExecutor jse = (JavascriptExecutor)driver;
                //jse.executeScript("arguments[0].click()", option);
                option.click();
            }
            System.out.println(option.isSelected()); //print which one is selected
        }
    }

    public static void Checkbox(){
        driver.navigate().to("https://trytestingthis.netlify.app/");

        List<WebElement> cbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
        int size = cbox.size();
        System.out.println(size);
        //---------------------------------------------------------------------------//
        //Select specific checkbox

        /*for(WebElement option : cbox){

            String y = option.getAttribute("value");

            if(y.equalsIgnoreCase("Option 1")){
                option.click();
            }
            System.out.println(option.isSelected());
        }*/
        //--------------------------------------------------------//
        //Select all the checkboxes

        /*for(int i = 0; i < size; i++) {
            cbox.get(i).click();
        }*/
        //--------------------------------------------------------//
        //Select multiple checkboxes

        for(WebElement option : cbox){

            String y = option.getAttribute("value");

            if(y.equalsIgnoreCase("Option 1")){
                option.click();
            }
            if(y.equalsIgnoreCase("Option 2")){
                option.click();
            }
            System.out.println(option.isSelected());
        }
    }

    public static void IFrame(){
        driver.navigate().to("https://jqueryui.com/draggable/");

        List<WebElement> frame = driver.findElements(By.tagName("iframe"));
        //System.out.println(frame.size());

        //1st method, find frame by index

        driver.switchTo().frame(0);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
        System.out.println(element.getText());

        driver.switchTo().defaultContent(); //to find other elements outside the frame switch to is must
        WebElement element1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/p[1]"));
        System.out.println(element1.getText());
        //----------------------------------------------------------------------------------------------//

        /*//2nd Method, find frame by xpath

        WebElement frame1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/iframe"));
        driver.switchTo().frame(frame1);
        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
        System.out.println(element2.getText());

        driver.switchTo().defaultContent(); //to find other elements outside the frame switch to is must
        WebElement element3 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/p[1]"));
        System.out.println(element1.getText());*/
    }

    public static void Slider() throws InterruptedException {
        Actions action = new Actions(driver);

        driver.navigate().to("https://jqueryui.com/slider/");

        List<WebElement> frame = driver.findElements(By.tagName("iframe"));

        driver.switchTo().frame(0);
        WebElement slider = driver.findElement(By.xpath("//*[@id=\"slider\"]"));

        action.moveToElement(slider).dragAndDropBy(slider,30,0).build().perform();

        Thread.sleep(3000);
    }

    public static String Password(){ //Use this on another class
        /*String password = "Appium123@"; //QXBwaXVtMTIzQA==

        String encode = new String (Base64.getEncoder().encode(password.getBytes()));
        String decode = new String (Base64.getDecoder().decode(encode.getBytes()));

        System.out.println(encode);
        System.out.println(decode);*/

        return new String (Base64.getDecoder().decode(encode.getBytes()));
    }

    public static void EncodeDecode(){
        driver.navigate().to("https://www.rediff.com/");

        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("login1")).sendKeys("seleniumt@rediffmail.com");
        driver.findElement(By.id("password")).sendKeys(Password());
        driver.findElement(By.name("proceed")).click();
    }

    public static void DateTime() throws InterruptedException {

        driver.navigate().to("https://nxtgenaiacademy.com/demo-site/");

        /*driver.findElement(By.id("vfb-18")).click();

        String text = "March 2023";
        String[] result = text.split(" ");
        String month = result[0];
        String year = result[1];
        //~~~~~~~~~~~~~~~~~~~~~~//

        String title = driver.findElement(By.className("ui-datepicker-title")).getText();

        String[] result1 = title.split(" ");
        String year1 = result1[1];

        int year2 = Integer.parseInt(year);
        int year3 = Integer.parseInt(year1);
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
        if(year2 > year3){

            if(title != text){

                while(true){
                    String yeartext = driver.findElement(By.className("ui-datepicker-year")).getText();

                    if(yeartext.equals(year)){
                        break;
                    }
                    else {
                        driver.findElement(By.cssSelector(".ui-icon-circle-triangle-e")).click();
                    }
                }
                while(true){
                    String monthtext = driver.findElement(By.className("ui-datepicker-month")).getText();

                    if(monthtext.equals(month)){
                        break;
                    }
                    else {
                        driver.findElement(By.cssSelector(".ui-icon-circle-triangle-e")).click();
                    }
                }
            }
        }
        else if(year2 == year3){ //It will not find previous months from the given one.

            while(true){
                String monthtext = driver.findElement(By.className("ui-datepicker-month")).getText();

                if(monthtext.equals(month)){
                    break;
                }
                else{
                    driver.findElement(By.cssSelector(".ui-icon-circle-triangle-e")).click();
                }
            }
        }
        else{
            while(true){
                String yeartext = driver.findElement(By.className("ui-datepicker-year")).getText();

                if(yeartext.equals(year)){
                    break;
                }
                else {
                    driver.findElement(By.cssSelector(".ui-icon-circle-triangle-w")).click();
                }
            }
            while(true){
                String monthtext = driver.findElement(By.className("ui-datepicker-month")).getText();

                if(monthtext.equals(month)){
                    break;
                }
                else {
                    driver.findElement(By.cssSelector(".ui-icon-circle-triangle-w")).click();
                }
            }
        }
        driver.findElement(By.xpath("//a[normalize-space()='1']")).click();*/
        //---------------------------------------------------------------------------------//
        driver.findElement(By.id("vfb-18")).sendKeys("03/01/2023" +Keys.ENTER);
    }
}
