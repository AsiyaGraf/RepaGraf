import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "login-username")
    private WebElement emailInput;
    @FindBy (id = "login-password")
    private WebElement pwdInput;
    @FindBy (id = "login-button")
    private WebElement buttonLogin;
    @FindBy (xpath = "//button[@data-testid='account-settings-link']")
    private WebElement btnAcc;
    @FindBy (xpath = "//p[text()=\"Неправильное имя пользователя или пароль.\"]")
    private WebElement alert;

    public LoginPage username(String email){
        emailInput.sendKeys(email);
        return this;
    }
    public LoginPage password(String password){
        pwdInput.sendKeys(password);
        return this;
    }
    public LoginPage buttonLogin(){
        buttonLogin.click();
        return this;
    }
    public LoginPage buttonAcc(){
        btnAcc.click();
        return this;
    }
    public LoginPage alertMessage(){
        Assert.assertTrue("Авторизация прошла успешно", alert.getText().contains("Неправильное имя пользователя или пароль."));
        System.out.println("Авторизация не удалась");
        return this;
    }
    public LoginPage clearPwd(){
        driver.findElement(By.cssSelector("#login-password")).clear();
        return this;
    }
}
