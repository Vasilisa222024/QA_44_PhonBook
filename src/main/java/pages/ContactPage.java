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

import static pages.BasePage.driver;
import static pages.BasePage.setDriver;

public class ContactPage extends BasePage {
    public ContactPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements
                (new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//a[text()='CONTACTS']")
    WebElement btnContacts;
    @FindBy(xpath = "//div[@class='contact-page_leftdiv__yhyke']//div[@class='contact-item_card__2SOIM'][last()]/h3")
    WebElement lastPhoneInList;


//    public void closeAlert() {
//        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(3))
//                .until(ExpectedConditions.alertIsPresent());
//        System.out.println(alert.getText());
//        alert.accept();
//    }

    public boolean isElementContactsPresent() {
        return btnContacts.isDisplayed();
    }

    public boolean isLastPhoneEquals(String phone){
       return lastPhoneInList.getText().equals(phone);}


}

