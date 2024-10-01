package tests;

import manager.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.HeaderMenuItem;
import utils.TestNGListner;

import static pages.BasePage.clickButtonsOnHeader;

@Listeners(TestNGListner.class)


public class LoginTests extends ApplicationManager {
    @Test
    public void loginPositiveTest() {
        boolean res =
                new HomePage(getDriver())
                        .clickbtnLoginHeader()
                        .typeloginForm
                                ("qa_44_qa@gmail.com", "Qaqaqa44@")
                        .clickBtnLoginPositive()
                        .isElementContactsPresent();
        Assert.assertTrue(res);
//Assert.assertEquals (100, 200);
//Assert.assertTrue(true);
//Assert .assertFalse(false);
//Assert.assertNotEquals(100,100);


    }

    @Test
    public void loginNegativeTest_wrongPassword() {

        Assert.assertTrue(
                new HomePage(getDriver())
                        .clickbtnLoginHeader()
                        .typeloginForm
                                ("qa_44_qa@gmail.com", "!!!Qaqaqa44@")
                        .clickBtnLoginNegative()
                        .closeAllert()
                        .isTextInElementPresent_errorMessage())

        ;
    }


    @Test
    public void loginNegativeTest_wrongEmail() {
        logger.info("");
//unregisterUser
        Assert.assertTrue(
                new HomePage(getDriver())
                        .clickbtnLoginHeader()
                        .typeloginForm
                                ("qa33_44_qa@gmail.com", "Qaqaqa44@")
                        .clickBtnLoginNegative()
                        .closeAllert()
                        .isTextInElementPresent_errorMessage())

        ;
    }

    @Test
    public void loginNegativeTest_wrongEmail_WOAT() {

        Assert.assertTrue(
                new HomePage(getDriver())
                        .clickbtnLoginHeader()
                        .typeloginForm
                                ("qa33qagmail.com", "Qaqaqa44@")
                        .clickBtnLoginNegative()
                        .closeAllert()
                        .isTextInElementPresent_errorMessage())

        ;
    }
    @Test
    public void loginNegativeTest_wrongEmail_WOAT_Enum() {

new HomePage(getDriver());
        LoginPage loginPage=clickButtonsOnHeader(HeaderMenuItem.LOGIN);
                       loginPage.typeloginForm
                                ("qa33qagmail.com", "Qaqaqa44@")
                        .clickBtnLoginNegative()
                        .closeAllert()
                        .isTextInElementPresent_errorMessage()

        ;
    }
}
