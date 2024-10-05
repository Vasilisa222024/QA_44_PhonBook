package tests;

import dto.UserDto;
import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.HeaderMenuItem;

import java.time.Duration;

import  static pages.BasePage.clickButtonsOnHeader;
//import  static pages.BasePage.clickWait;

public class DeleteContactTests extends ApplicationManager {
    UserDto user = new UserDto("qa_44_qa@gmail.com", "Qaqaqa44@");
    ContactPage contactPage;

    @BeforeMethod
    public void login() {
        logger.info("start method login user random");
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = BasePage.clickButtonsOnHeader(HeaderMenuItem.LOGIN);
        contactPage = loginPage.typeloginForm(user).clickBtnLoginPositive();

    }



    @Test
    public void deleteContactPositiveTest() {
        int quantityBeforeDelete = contactPage.getContactNumber();
        System.out.println("--> " + quantityBeforeDelete);
        contactPage.clickFirstElementOfContactsList();
        contactPage.clickBtnRemoveContact();

        int quantityAfterDelete = contactPage.getContactNumber();
        System.out.println("--> " + quantityAfterDelete);
        Assert.assertEquals(quantityBeforeDelete -1, quantityAfterDelete);
    }
}
