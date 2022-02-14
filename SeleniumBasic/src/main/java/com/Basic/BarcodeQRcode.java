package com.Basic;

import com.Base.*;
import com.google.zxing.*;
import com.google.zxing.NotFoundException;
import com.google.zxing.client.j2se.*;
import com.google.zxing.common.*;
import org.openqa.selenium.*;

import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;

public class BarcodeQRcode extends BaseClass {
    public static void main(String[] args) throws InterruptedException, IOException, NotFoundException {
        FirefoxLaunch();
        OpenWebsite("http://testautomationpractice.blogspot.com/");

        //BarCode();
        QRCode();

        SmallWait();
        FirefoxQuit();
    }
    public static void BarCode() throws IOException, NotFoundException {
        String barcode = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/footer/div/div[2]/div[2]/table/tbody/tr/td[2]/div/div[1]/div[1]/img[1]")).getAttribute("src");
        System.out.println(barcode);

        URL url = new URL(barcode);

        BufferedImage bimg = ImageIO.read(url);
        LuminanceSource lsource = new BufferedImageLuminanceSource(bimg);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(lsource));
        Result result = new MultiFormatReader().decode(bitmap);
        System.out.println(result.getText());
        //--------------------------------------------------------------------//

        String barcode1 = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/footer/div/div[2]/div[2]/table/tbody/tr/td[2]/div/div[1]/div[1]/img[2]")).getAttribute("src");
        System.out.println(barcode1);

        URL url1 = new URL(barcode1);

        BufferedImage bimg1 = ImageIO.read(url1);
        LuminanceSource lsource1 = new BufferedImageLuminanceSource(bimg1);
        BinaryBitmap bitmap1 = new BinaryBitmap(new HybridBinarizer(lsource1));
        Result result1 = new MultiFormatReader().decode(bitmap1);
        System.out.println(result1.getText());
    }

    public static void QRCode() throws IOException, NotFoundException {
        String qrcode = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/footer/div/div[2]/div[2]/table/tbody/tr/td[2]/div/div[2]/div[1]/img")).getAttribute("src");
        System.out.println(qrcode);

        URL url3 = new URL(qrcode);

        BufferedImage bimg2 = ImageIO.read(url3);
        LuminanceSource lsource2 = new BufferedImageLuminanceSource(bimg2);
        BinaryBitmap bitmap2 = new BinaryBitmap(new HybridBinarizer(lsource2));
        Result result2 = new MultiFormatReader().decode(bitmap2);
        System.out.println(result2.getText());
    }
}
