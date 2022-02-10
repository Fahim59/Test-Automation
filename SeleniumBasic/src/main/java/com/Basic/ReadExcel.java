package com.Basic;

import com.Base.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.io.*;
import java.util.*;

public class ReadExcel extends BaseClass{
    public static void main(String[] args) throws IOException, InterruptedException {
        //FirefoxLaunch();
        //OpenWebsite("https://nxtgenaiacademy.com/demo-site/");

        //ExcelSheetReading();
        ExcelSheetWriting();

        //FirefoxQuit();
    }

    public static void ExcelSheetReading() throws IOException, InterruptedException {
        DataFormatter formatter = new DataFormatter();
        FileInputStream file = new FileInputStream("F:/Testing/Registration.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int noOfrow = sheet.getLastRowNum();
        System.out.println("No of records: " +noOfrow);

        for(int row = 1; row <= noOfrow; row++){
            try{
                XSSFRow current_row = sheet.getRow(row);

                String First_Name = current_row.getCell(0).getStringCellValue();
                String Last_Name = current_row.getCell(1).getStringCellValue();
                String Gender = current_row.getCell(2).getStringCellValue();
                String Address = current_row.getCell(3).getStringCellValue();
                String Street = current_row.getCell(4).getStringCellValue();
                String State = current_row.getCell(5).getStringCellValue();
                String City = current_row.getCell(6).getStringCellValue();
                String Country = current_row.getCell(7).getStringCellValue();
                String Email = current_row.getCell(8).getStringCellValue();
                String Dob = current_row.getCell(9).toString();
                String Phone = formatter.formatCellValue(current_row.getCell(10));
                String Subject = current_row.getCell(11).getStringCellValue();
                String Query = current_row.getCell(12).getStringCellValue();
                //---------------------------------------------------------------------------------------//
                //int Text = (int)current_row.getCell(13).getNumericCellValue(); //For integer values. 75 -> instead of 75.0

                String Text = formatter.formatCellValue(current_row.getCell(13));
                //---------------------------------------------------------------------------------------//
                //System.out.println(First_Name +" - "+ Last_Name +" - "+ Gender +" - "+ Address +" - "+ Street +" - "+ State +" - "+  City +" - "+  Country +" - "+  Email +" - "+  Dob +" - "+  Phone +" - "+  Subject +" - "+  Query +" - "+  Text);
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
                driver.findElement(By.id("vfb-5")).sendKeys(First_Name); //Firstname
                //---------------------------------------------------------------------------------------//
                driver.findElement(By.id("vfb-7")).sendKeys(Last_Name); //Lastname
                //---------------------------------------------------------------------------------------//
                List<WebElement> gender = driver.findElements(By.xpath("//input[@type='radio']")); //Gender

                for(WebElement option : gender){

                      if(option.getAttribute("value").equalsIgnoreCase(Gender)){
                          option.click();
                      }
                }
                //---------------------------------------------------------------------------------------//
                driver.findElement(By.id("vfb-13-address")).sendKeys(Address); //Address
                //---------------------------------------------------------------------------------------//
                driver.findElement(By.id("vfb-13-address-2")).sendKeys(Street); //Street Address
                //---------------------------------------------------------------------------------------//
                driver.findElement(By.id("vfb-13-state")).sendKeys(State); //State
                //---------------------------------------------------------------------------------------//
                driver.findElement(By.id("vfb-13-zip")).sendKeys(City); //City
                //---------------------------------------------------------------------------------------//
                Select select = new Select(driver.findElement(By.id("vfb-13-country"))); //Country Dropdown

                List<WebElement> options = select.getOptions();

                for(WebElement option : options){

                     if(option.getText().equalsIgnoreCase(Country)){
                         option.click();
                     }
                }
                //------------------------------------------------------------------------------------------//
                driver.findElement(By.id("vfb-14")).sendKeys(Email); //Email
                //------------------------------------------------------------------------------------------//
                String month = "March 2022"; //DateOfBirth

                driver.findElement(By.id("vfb-18")).click();

                while(true){
                     String text = driver.findElement(By.className("ui-datepicker-title")).getText();

                     if(text.equals(month)){
                        break;
                     }
                     else {
                        driver.findElement(By.cssSelector(".ui-icon-circle-triangle-e")).click();
                     }
                }
                driver.findElement(By.xpath("//a[normalize-space()='20']")).click();
                //-----------------------------------------------------------------------------------------//
                driver.findElement(By.id("vfb-19")).sendKeys(Phone); //Phone
                //-----------------------------------------------------------------------------------------//
                Thread.sleep(4000);

                List<WebElement> course = driver.findElements(By.xpath("//input[@type='checkbox']")); //Course Checkbox
                for(WebElement x : course){

                    String y = x.getAttribute("value");

                    if(y.equalsIgnoreCase(Subject)){
                        x.click();
                    }
                }
                //-----------------------------------------------------------------------------------------//
                driver.findElement(By.id("vfb-23")).sendKeys(Query); //Query
                //-----------------------------------------------------------------------------------------//
                driver.findElement(By.id("vfb-3")).sendKeys(Text); //Text
                //driver.findElement(By.id("vfb-3")).sendKeys(String.valueOf(Text)); //For integer values
                //-----------------------------------------------------------------------------------------//
                driver.findElement(By.id("vfb-4")).click(); //Button
                //-----------------------------------------------------------------------------------------//
                if(driver.getPageSource().contains("Registration Form is Successfully Submitted")){
                    System.out.println("Registration Successful");
                }
                else{
                    System.out.println("Registration Failed");
                }
            }
            catch(NullPointerException NPE){
                System.out.println("Exception Occurred: " +NPE.getMessage());
            }
        }
    }

    public static void ExcelSheetWriting() throws IOException {
        FileOutputStream file = new FileOutputStream("F:/Testing/Test.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet 1");

        for(int i = 0; i <= 5; i++){
            XSSFRow row = sheet.createRow(i);

            for(int j = 0; j < 3; j++){
                row.createCell(j).setCellValue("xyz");
            }
        }
        workbook.write(file);
        file.close();

        System.out.println("File Created");
    }
}