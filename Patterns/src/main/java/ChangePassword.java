import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePassword {
    private WebDriver driver;

    public ChangePassword(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "old_password")
    private WebElement oldPwd;
    @FindBy (id = "new_password")
    private WebElement newPwd;
    @FindBy (id = "new_password_confirmation")
    private WebElement newPwdConfirm;
    @FindBy (xpath = "//button[@class='ButtonLegacy-o653de-1 crQDxy']")
    private WebElement btnChange;
    @FindBy (xpath = "//span[text()='Профиль']")
    private WebElement btnProfile;
    @FindBy (xpath = "//a[text()='Выйти']")
    private WebElement btnLogout;


    public ChangePassword changePwd(String oldPass, String newPass, String newConfirmPass){
        oldPwd.sendKeys(oldPass);
        newPwd.sendKeys(newPass);
        newPwdConfirm.sendKeys(newConfirmPass);
        return this;
    }

    public ChangePassword buttonChange(){
        btnChange.click();
        return this;
    }
    public ChangePassword buttonProfile(){
        btnProfile.click();
        return this;
    }
    public ChangePassword buttonLogout(){
        btnLogout.click();
        return this;
    }

}
