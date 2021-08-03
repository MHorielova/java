package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import java.util.StringJoiner;
import static java.io.File.separator;

public class TestConfig {

    protected WebDriver driver;

    public TestConfig() {
        StringJoiner pathToChromeDriver = new StringJoiner(separator);
        String path = pathToChromeDriver.add("src").add("test").add("resources").add("chromedriver").toString();
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
