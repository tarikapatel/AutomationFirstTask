package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BuildComputer {

    static WebDriver driver;

public static void main(String[]args){

    System.setProperty("webdriver.chrome.driver","src/test/Driver/chromedriver.exe");
    //object for driver
    driver = new ChromeDriver(); //open browser
    //open browser in full screen
    driver.manage().window().maximize();
    //type URL
    driver.get("https://demo.nopcommerce.com/");
    //click on Computers
    driver.findElement(By.xpath("//Div[@class='header-menu']/ul[1]/li[1]/a")).click();
    //Click on Desktop
    driver.findElement(By.xpath("//ul[@class='sublist']/li[1]/a")).click();
    //click on Build your computer
    driver.findElement(By.xpath("//div[@class='product-item']/div[2]/h2/a[@href='/build-your-own-computer']")).click();
    //close browser
    driver.close();
}
}
