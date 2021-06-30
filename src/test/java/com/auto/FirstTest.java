
package com.auto;
//import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.util.StringJoiner;

import static java.io.File.separator;

public class FirstTest {
    private WebDriver driver;


    @BeforeMethod
    public void setUp() {
        StringJoiner pathToChromeDriver = new StringJoiner(separator);
        String path = pathToChromeDriver.add("src").add("test").add("resources").add("chromedriver").toString();
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();//открыть браузер на весь экран
    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void firstTest() {
        WebElement loginButton = driver.findElement(By.xpath("//div[@class='login-box']//input[@data-test='login-button']"));
        loginButton.click();//вынесли логин баттон, логин кнопку можем юзать много раз
        //String expectedText = "Epic sadface:Username is required";
        //WebElement error = driver.findElement(By.xpath("h3//[@data-test = 'error']"));
       // SoftAssert softAssert = new SoftAssert();
        //softAssert.assertEquals(error.getText(), expectedText, "Wrong error message");

        String username = getFirstValue("login_credentials");
        String password = getFirstValue("login_password");
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        loginButton.click();
        userLoggedInCheck();
        //Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "User not log in");

        //переписываем логин для динамических полей(если они меняются, но указаны как пример на логин пейдже)
        //driver.findElement(By.xpath("//div[@class='login-box']//input[@data-test='login-button']")).click();
    }

    private void userLoggedInCheck() {
        WebElement burgerMenuButton = driver.findElement(By.id("react-burger-menu-btn"));
        WebElement logOutButton = driver.findElement(By.id("logout_sidebar_link"));
        burgerMenuButton.click();
        if (logOutButton.isDisplayed()){
            System.out.println("true");
        } else {
            System.out.println("false");;
        }
    }

    private String getFirstValue(String className) {
        String values = driver.findElement(By.className(className)).getText();
        return values.split("\n")[1];
    }

}
