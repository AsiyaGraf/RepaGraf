import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

public class TestChangePwd {
    private LoginPage loginPage;
    private ChangePassword changePassword;
    private Account account;
    private MainPage mainPage;

    @Before
    public void start() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        changePassword = new ChangePassword(driver);
        account = new Account(driver);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void test() throws IOException {
        String newPwd = "aaa1111118";
        BufferedReader reader = new BufferedReader(new FileReader("password.txt"));
        String currentPwd = reader.readLine();

        mainPage
                .open();

        loginPage
                .username("krosh111@inbox.ru")
                .password(currentPwd)
                .buttonLogin()
                .buttonAcc();

        account
                .closeCookie()
                .changePwd();

        changePassword
                .changePwd(currentPwd, newPwd, newPwd)
                .buttonChange()
                .buttonProfile()
                .buttonLogout();

        mainPage
                .open();

        loginPage
                .password(currentPwd)
                .buttonLogin()
                .alertMessage();
        loginPage
                .clearPwd()
                .password(newPwd)
                .buttonLogin()
                .buttonAcc();
        account
                .changePwd();
        changePassword
                .changePwd(newPwd, currentPwd, currentPwd)
                .buttonChange();

        FileWriter writer = new FileWriter("password.txt");
        writer.write(newPwd);
        writer.flush();
        writer.close();

    }
}


