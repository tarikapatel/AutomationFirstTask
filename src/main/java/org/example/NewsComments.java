package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewsComments {
    static WebDriver driver;

    public NewsComments() {
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.xpath("//div[@class='news-items']/div[2]/div[3]/a[@href='/nopcommerce-new-release']")).click();
        driver.findElement(By.id("AddNewComment_CommentTitle")).sendKeys(new CharSequence[]{"Review"});
        driver.findElement(By.id("AddNewComment_CommentText")).sendKeys(new CharSequence[]{"Good Website"});
        driver.findElement(By.xpath("//button[@class='button-1 news-item-add-comment-button']")).click();
        String actualText = driver.findElement(By.xpath("//div[@class='result']")).getText();
        System.out.println(actualText);
        driver.close();
    }
}
