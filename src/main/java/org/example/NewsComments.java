package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewsComments {
    static WebDriver driver;
    public static void main(String[]args){
        System.setProperty("webdriver.chrome.driver","src/test/Driver/chromedriver.exe");
        //open Browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //type URL
        driver.get("https://demo.nopcommerce.com/");
        //click detail button
        driver.findElement(By.xpath("//div[@class='news-items']/div[2]/div[3]/a[@href='/nopcommerce-new-release']")).click();
        //Type Title
        driver.findElement(By.id("AddNewComment_CommentTitle")).sendKeys("Review");
        //Type comment
        driver.findElement(By.id("AddNewComment_CommentText")).sendKeys("Good Website");
        //Click on NewComment button
        driver.findElement(By.xpath("//button[@class='button-1 news-item-add-comment-button']")).click();
        String actualText = driver.findElement(By.xpath("//div[@class='result']")).getText();
        System.out.println(actualText);
        //close browser
        driver.close();

    }
}
