package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements
                (new AjaxElementLocatorFactory(driver,10),this);
    }
    @FindBy(xpath = "//input[@name='email']")
    WebElement inputEmail;
    @FindBy(xpath = "//input[@name='password']")
    WebElement inputPassword;
    @FindBy(xpath = "//button[@name='login']")
    WebElement btnLoginsumbit;//qa_44_qa@gmail.com//Qaqaqa44@
    @FindBy(xpath = "//button[@name='registration']")
    WebElement btnRegsumbit;
//NEGATIVE MASEGE
    @FindBy(xpath = "//div[@class='login_login__3EHKB']/div")

    WebElement errorMasegeLogin;
    @FindBy(xpath = "//div[@class='login_login__3EHKB']/div")
    WebElement errorMasegeRegistration;
    public LoginPage typeloginForm(String email,String password){
       inputEmail.sendKeys(email);
       inputPassword.sendKeys(password);
       return this;
    }
    public ContactPage clickBtnLoginPositive() {
        btnLoginsumbit.click();
        return new ContactPage(driver);
    }
        public LoginPage clickBtnLoginNegative(){
            btnLoginsumbit.click();
            return this;
    }
    public ContactPage clickBtnRegistrationPositiv(){
        btnRegsumbit.click();
       return new ContactPage(driver);
    }
    public LoginPage closeAllert() {
        pause(3);
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());
        alert.accept();
        return new LoginPage(driver);
    }

    public boolean isTextInElementPresent_errorMessage(){
       return isElementPresent(errorMasegeLogin,"Login Failed with code 401");
    }
    public LoginPage clickBtnRegistrationNegative(){
        btnRegsumbit.click();
        return new LoginPage(driver);}
    public boolean isTextInElementPresent_errorMessageRegistration(){
        return isElementPresent(errorMasegeRegistration,"Registration failed with code 400");
    }


}
