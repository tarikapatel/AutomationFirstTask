package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BuildComputer {
    static WebDriver driver;

    public BuildComputer() {
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.xpath("//Div[@class='header-menu']/ul[1]/li[1]/a")).click();
        driver.findElement(By.xpath("//ul[@class='sublist']/li[1]/a")).click();
        driver.findElement(By.xpath("//div[@class='product-item']/div[2]/h2/a[@href='/build-your-own-computer']")).click();
        String actualText = driver.findElement(By.xpath("//div[@class='product-name']/h1")).getText();
        System.out.println(actualText);
        driver.close();
    }
}
