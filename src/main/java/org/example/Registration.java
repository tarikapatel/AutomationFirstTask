package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Registration {
    static WebDriver driver;

    public static void main(String []args){

        System.setProperty("webdriver.chrome.driver","src/test/Driver/chromedriver.exe");
        //object for driver
        driver = new ChromeDriver();//Open the browser
        //open browser in Full screen
        driver.manage().window().maximize();
        //waits to screen available before executing next steps
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        // type the URL
        driver.get("https://demo.nopcommerce.com/");
        //click on Register button
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        //type first name
        driver.findElement(By.id("FirstName")).sendKeys("Testertwo");
        //type second name
        driver.findElement(By.id("LastName")).sendKeys("Testingtwo");
        //type email
        driver.findElement(By.id("Email")).sendKeys("Testertwo@getnada.com");
        //type Password
        driver.findElement(By.id("Password")).sendKeys("Testone123!");
        //type confirm password
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Testone123!");
        //click on register button
        driver.findElement(By.id("register-button")).click();
        String actualText = driver.findElement(By.xpath("//div[@class='result']")).getText();
        System.out.println(actualText);
        //close browser
        //driver.close();
    }
}
