import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@data-ga-action='log-in']")
    private WebElement buttonLogin;

    public MainPage open(){
        driver.get("https://accounts.spotify.com/ru");
        return this;
    }
    public MainPage Btnlogin(){
        buttonLogin.click();
        return this;
    }
}
