package pages;

import org.openqa.selenium.*;
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
    @FindBy(xpath = "//div[@class=\"contact-page_leftdiv__yhyke\"]//div[@class=\"contact-item_card__2SOIM\"]")
    WebElement firstContactOnList;
    @FindBy(xpath = "//button[text()='Remove']")
    WebElement btnRemoveContact;

    @FindBy(xpath = "//*[text()='Edit']")
    WebElement btnEdit;
    @FindBy(xpath = "//div[@class='contact-item_card__2SOIM']")
    WebElement contactForEdit;
    @FindBy(xpath = "//*[text()='Save']")
    WebElement btnSaveEdit;
    @FindBy(xpath = "//div[@class='contact-item-detailed_card__50dTS']")
WebElement contactName;

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

public boolean urlContainsAdd(){
        return urlContains("add",3);
}

public  boolean isAlertPresent(int time) {
    try {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());
//alert.accept();
        return  true;
    }catch (TimeoutException exception){
        exception.printStackTrace();
        return false;
    }
}

    public void clickFirstElementOfContactsList() {
        firstContactOnList.click();

    }
    public ContactPage clickBtnRemoveContact ()
    {

        btnRemoveContact.click();
        pause(5);
        return this;
    }


    public int getContactNumber() {
        return driver
                .findElements(By.xpath("//div[@class='contact-item_card__2SOIM']"))
                .size();
    }
    public void clickBtnEdit(){
        btnEdit.click();
    }
    public  void clickContactForEdit(){
        contactForEdit.click();
    }
    public boolean saveEdits()
    {return btnSaveEdit.isDisplayed();

    }
    public String getContactName() {
        String name = contactName.getText();
       // String email = contactEmail.getText();
        return "Contact Info - Name: " + name ;//+ ", Email: " + email;
    }
}



