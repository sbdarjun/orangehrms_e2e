import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class MainClass {
    private WebDriver driver;
    private LoginPage loginPage;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage(driver);
    }
    @Test
    public void loginTest() {
        loginPage.setUsername("your_email@example.com");
        loginPage.setPassword("your_password");
        loginPage.clickLoginButton();
//        Assert.assertTrue(homePage.isUserLoggedIn());
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
