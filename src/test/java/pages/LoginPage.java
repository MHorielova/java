package pages;

import helpers.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage  extends BasePage {

    @FindBy(xpath = "//input[@data-test = 'login-button']")
    public WebElement loginButton;
    @FindBy(id = "user-name")
    private WebElement usernameField;
    @FindBy(name = "password")
    private WebElement passwordField;
    @FindBy(xpath = "//h3[@data-test = 'error']")
    private WebElement error;
    @FindBy(xpath = "//button[@class = 'error-button']")
    private WebElement errorButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getError() {
        return error;
    }
    public WebElement getErrorButton() {
        return errorButton;
    }

    private void logIn(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void logInByStandardUser(){
        String username = getFirstValue("login_credentials");
        String password = getFirstValue("login_password");
        logIn(username, password);
    }

    private String getFirstValue(String className) {
        String values = byClassName(className).getText();
        return values.split("\n")[1];
    }
}

