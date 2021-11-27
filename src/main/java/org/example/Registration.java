package org.example;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Registration {
    static WebDriver driver;

    public Registration() {
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        driver.findElement(By.id("FirstName")).sendKeys(new CharSequence[]{"Testertwo"});
        driver.findElement(By.id("LastName")).sendKeys(new CharSequence[]{"Testingtwo"});
        driver.findElement(By.id("Email")).sendKeys(new CharSequence[]{"Testertwo@getnada.com"});
        driver.findElement(By.id("Password")).sendKeys(new CharSequence[]{"Testone123!"});
        driver.findElement(By.id("ConfirmPassword")).sendKeys(new CharSequence[]{"Testone123!"});
        driver.findElement(By.id("register-button")).click();
        String actualText = driver.findElement(By.xpath("//div[@class='result']")).getText();
        System.out.println(actualText);
    }
}
