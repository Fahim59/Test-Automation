package com.Basic;

import com.Base.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;

import java.util.*;

public class AllActions extends BaseClass {
    public static void main(String[] args) throws InterruptedException {
        FirefoxLaunch();

        //KeyboardActions();
        //MouseActions();
        //DropDown();
        //RadioButton();
        IFrame();

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

        //DragAndDrop
        driver.navigate().to("https://selenium08.blogspot.com/2020/01/drag-drop.html");

        WebElement drag  = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
        WebElement drop  = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));

        actions.dragAndDrop(drag,drop).build().perform();
    }

    public static void DropDown() throws InterruptedException {
        driver.navigate().to("https://trytestingthis.netlify.app/");

        WebElement drop = driver.findElement(By.id("option"));
        Select select = new Select(drop);
        //-----------------------------------------------------------------------//
        //First Method
        select.selectByIndex(1);
        select.selectByValue("option 2");
        select.selectByVisibleText("Option 3");
        Thread.sleep(5000);
        //-----------------------------------------------------------------------//
        //Second Method
        List<WebElement> options = select.getOptions();

        for(WebElement option : options){
            System.out.println(option.getText());

            if(option.getText().equalsIgnoreCase("option 2")){
                option.click();
            }
            else {
                System.out.println("Not found");
            }
        }
        Thread.sleep(5000);

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
                option.click();
            }
            System.out.println(option.isSelected()); //print which one is selected
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
}
