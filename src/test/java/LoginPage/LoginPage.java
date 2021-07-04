package LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.StringJoiner;

import static java.io.File.separator;

public class LoginPage {

    public WebDriver driver;

    public WebElement getLoginButton(){
        WebElement loginButton = driver.findElement(By.xpath("//div[@class = 'login-box']//input[@data-test = 'login-button']"));
        return loginButton;
    }

    public WebElement getError1() {
        WebElement error1 = driver.findElement(By.xpath("//h3[@data-test = 'error']"));
        return error1;
    }
    public WebElement getErrorButton() {
        WebElement errorButton = driver.findElement(By.xpath("//button[@class = 'error-button']"));
        return  errorButton;
    }

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
        driver.quit();
    }

    public void logInCredentials(){
        String username = getFirstValue("login_credentials");
        String password = getFirstValue("login_password");
        WebElement userNameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.name("password"));
        userNameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    public String getFirstValue(String className) {
        String values = driver.findElement(By.className(className)).getText();
        return values.split("\n")[1];
    }

    public void isUserLoggedInCheck() {
        if(driver.getCurrentUrl().contains("inventory")){
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}

