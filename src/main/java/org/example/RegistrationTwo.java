package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTwo {
    static WebDriver driver;

    public RegistrationTwo() {
    }

    public static void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public static void typeText(By by, String text) {
        driver.findElement(by).sendKeys(new CharSequence[]{text});
    }

    public static String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public static String currentTimeStamp() {
        return (new SimpleDateFormat("ddMMyyyyhhmmss")).format(new Date());
    }

    public static void waitForClickable(By by, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, (long)timeInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitForVisible(By by, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, (long)timeInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    @BeforeMethod
    public void openBrowser() {
        System.out.println(currentTimeStamp());
        System.setProperty("webdriver.chrome.driver", "src/test/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test
    public void verifyUserShouldBeAbleToRegisterSuccessfully() {
        clickOnElement(By.xpath("//a[@class='ico-register']"));
        Assert.assertTrue(driver.getCurrentUrl().contains("register"));
        typeText(By.id("FirstName"), "Johnn");
        typeText(By.id("LastName"), "Smithh");
        Select selectDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
        selectDay.selectByVisibleText("15");
        Select selectMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        selectMonth.selectByValue("4");
        Select selectYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
        selectYear.selectByValue("1926");
        String email = "Johnsmith+" + currentTimeStamp() + "@gmail.com";
        System.out.println(email);
        driver.findElement(By.id("Email")).sendKeys(new CharSequence[]{email});
        waitForVisible(By.id("Newsletter"), 10);
        clickOnElement(By.id("Newsletter"));
        typeText(By.id("Password"), "Test123!");
        typeText(By.id("ConfirmPassword"), "Test123!");
        waitForClickable(By.id("register-button"), 10);
        clickOnElement(By.id("register-button"));
        String actualRegisterSuccessMessage = getTextFromElement(By.xpath("//div[@class='result']"));
        String expectedRegisterSuccessMessage = "Your registration completed";
        Assert.assertEquals(actualRegisterSuccessMessage, expectedRegisterSuccessMessage);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }
}
