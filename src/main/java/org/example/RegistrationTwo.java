package org.example;

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


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class RegistrationTwo {
    static WebDriver driver;

    public static void clickOnElement(By by){
        driver.findElement(by).click();
    }
    public static void typeText(By by, String text){
        driver.findElement(by).sendKeys(text);
    }
    public static String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }
    public static String currentTimeStamp(){
       return new SimpleDateFormat("ddMMyyyyhhmmss").format(new Date());
    }
    public static void waitForClickable(By by, int timeInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public static void waitForVisible(By by, int timeInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    @BeforeMethod
    public void openBrowser(){
        System.out.println(currentTimeStamp());//to check the date stamp is returning
        System.setProperty("webdriver.chrome.driver","src/test/Driver/chromedriver.exe");
        //object for driver
        driver = new ChromeDriver();//Open the browser
        //open browser in Full screen
        driver.manage().window().maximize();
        //waits to screen available before executing next steps
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test
    public void verifyUserShouldBeAbleToRegisterSuccessfully(){

        //click on Register button
        clickOnElement(By.xpath("//a[@class='ico-register']"));
        //verify user is on register page
        Assert.assertTrue(driver.getCurrentUrl().contains(("register")));
        //type first name
        typeText(By.id("FirstName"),"Johnn");
        //type second name
        typeText(By.id("LastName"),"Smithh");
        //select day from dropdown
        Select selectDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
        selectDay.selectByVisibleText("15");
        //select month from dropdown
        Select selectMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        selectMonth.selectByValue("4");
        //select year from dropdown
        Select selectYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
        selectYear.selectByValue("1926");
        //type email
        String email = "Johnsmith+" + currentTimeStamp() + "@gmail.com";
        System.out.println(email);
        driver.findElement(By.id("Email")).sendKeys(email);

        waitForVisible(By.id("Newsletter"),10);

        clickOnElement(By.id("Newsletter"));

        //type Password
        typeText(By.id ("Password"),"Test123!");
        //type confirm password
        typeText(By.id ("ConfirmPassword"),"Test123!");

        waitForClickable(By.id("register-button"),10);
        //click on register button
        clickOnElement(By.id("register-button"));

        String actualRegisterSuccessMessage = getTextFromElement(By.xpath("//div[@class='result']"));
        String expectedRegisterSuccessMessage = "Your registration completed";
        Assert.assertEquals(actualRegisterSuccessMessage,expectedRegisterSuccessMessage);
      //Assert.assertTrue(actualRegisterSuccessMessage.equals(expectedRegisterSuccessMessage),"Register success message is in correct");
    }

    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }

}
