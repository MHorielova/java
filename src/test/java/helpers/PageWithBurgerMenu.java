package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageWithBurgerMenu extends BasePage{

    @FindBy(id = "react-burger-menu-btn")
    public WebElement burgerMenu;
    @FindBy(id = "logout_sidebar_link")
    public WebElement logOut;

    public PageWithBurgerMenu(WebDriver driver) {
        super(driver);
    }

    public void logOut(){
        burgerMenu.click();
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 2nd variant of timeout
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(logOut));
        logOut.click();
    }
}
