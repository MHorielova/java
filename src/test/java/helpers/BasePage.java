package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver driver;

    protected BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
//    protected WebElement byId(String id){
//        return driver.findElement(By.id(id));
//    }
//    protected WebElement byName(String name){
//        return driver.findElement(By.name(name));
//    }
//    protected WebElement byXpath(String xpath){
//        return driver.findElement(By.xpath(xpath));
//    }
    protected WebElement byClassName(String className) {
        return driver.findElement(By.className(className));
    }

    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}