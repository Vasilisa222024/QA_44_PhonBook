package tests;

import dto.UserDto;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import utils.HeaderMenuItem;
import utils.TestNGListner;

import java.lang.reflect.Method;

@Listeners(TestNGListner.class)

public class EditTests extends ApplicationManager {
    UserDto user = new UserDto("qa_44_qa@gmail.com", "Qaqaqa44@");
    ContactPage contactPage;
AddPage addPage;
    @BeforeMethod
    public void login(Method method) {
        logger.info("start method");
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = BasePage.clickButtonsOnHeader(HeaderMenuItem.LOGIN);
        contactPage = loginPage.typeloginForm(user).clickBtnLoginPositive();

    }
    @Test

    public  void editTestPosetive(Method method){
     logger.info("start method "+method.getName());
//        String contactInfo = contactPage.getContactName();
//        logger.info(" Contact: " + contactInfo);

    contactPage.clickContactForEdit();
    contactPage.clickBtnEdit();

        Assert.assertTrue(contactPage.saveEdits());
    }
}
