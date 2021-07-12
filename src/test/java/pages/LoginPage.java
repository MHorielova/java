package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;
    public WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.loginButton = driver.findElement(By.xpath("//input[@data-test = 'login-button']"));
    }

    public WebElement getError() {
        return this.driver.findElement(By.xpath("//h3[@data-test = 'error']"));
    }
    public WebElement getErrorButton() {
        return this.driver.findElement(By.xpath("//button[@class = 'error-button']"));
    }

    public void logInCredentials() {
        String username = getFirstValue("login_credentials");
        String password = getFirstValue("login_password");
        driver.findElement(By.id("user-name")).sendKeys(username);;
        driver.findElement(By.name("password")).sendKeys(password);;
    }

    public String getFirstValue(String className) {
        String values = driver.findElement(By.className(className)).getText();
        return values.split("\n")[1];
    }
}

