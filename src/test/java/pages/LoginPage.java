package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    @FindBy(className = "orangehrm-login-branding")
    private WebElement orangehrmLogo;

    @FindBy(className = "orangehrm-login-title")
    private WebElement loginText;
    @FindBy(xpath ="//input[@name='username']")
    private WebElement userNameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(className = "orangehrm-login-button")
    private  WebElement loginButton;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void orangeLogo() {
        orangehrmLogo.isDisplayed();
    }
    public  void loginPageText(){
        loginText.isDisplayed();
    }
    public void setUsername(String username) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(userNameInput));
        userNameInput.sendKeys(username);
    }
    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }
    public void clickLoginButton(){
        loginButton.click();
    }
}
