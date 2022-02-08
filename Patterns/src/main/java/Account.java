import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Account {
    private WebDriver driver;

    public Account(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "#onetrust-close-btn-container>button")
    private WebElement closeCookie;
    @FindBy (id = "change_password")
    private WebElement pageChange;

    public Account closeCookie(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(closeCookie));
        closeCookie.click();
        return this;
    }
    public Account changePwd(){
        pageChange.click();
        return this;
    }
}
