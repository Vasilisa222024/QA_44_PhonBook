package tests;

import data_provider.DPAddContact;
import dto.ContactDtoLombok;
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

import static pages.BasePage.clickButtonsOnHeader;
import static utils.RandomUtils.*;
@Listeners(TestNGListner.class)

public class AddContactsTest extends ApplicationManager {
    UserDto user = new UserDto("qa_44_qa@gmail.com", "Qaqaqa44@");
    AddPage addPage;

    @BeforeMethod
    public void login() {
        logger.info("start method login user random");
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = BasePage.clickButtonsOnHeader(HeaderMenuItem.LOGIN);

        loginPage.typeloginForm(user).clickBtnLoginPositive();
        addPage = clickButtonsOnHeader(HeaderMenuItem.ADD);

    }

    @Test
    public void addNewContactsPositiveTest(Method method) {
        ContactDtoLombok contact = ContactDtoLombok.builder()
                .name(generateString(5))
                .lastName(generateString(5))
                .phone(generatePHone(10))
                .email(generateEmail(7))
                .address(generateString(7))
                .description(generateString(11))
                .build();
logger.info("start-->"+method.getName()+"with data:"+contact.toString());
        Assert.assertTrue(addPage.fillContactsForm(contact)
                .clickSaveBtnContactPositive()
                .isLastPhoneEquals(contact.getPhone()));



    }

    ///URL////////
    @Test
    public void addNewContactsNegativTest_fielnameIsEmpty(Method method) {
        ContactDtoLombok contact = ContactDtoLombok.builder()
                .name(generateString(0))
                .lastName(generateString(5))
                .phone(generatePHone(10))
                .email(generateEmail(7))
                .address(generateString(7))
                .description(generateString(11))
                .build();

        Assert.assertTrue(addPage.fillContactsForm(contact)
                .clickSaveBtnContactPositive()
                .urlContainsAdd())

        ;
logger.info("start-->"+method.getName()+"wtis data "+contact.toString());
    }

    //ALIRT//////////////
    @Test
    public void addNewContactsNegativTest_wronEmail() {
        ContactDtoLombok contact = ContactDtoLombok.builder()
                .name(generateString(4))
                .lastName(generateString(5))
                .phone(generatePHone(10))
                .email(generateString(7))
                .address(generateString(7))
                .description(generateString(11))
                .build();

        Assert.assertTrue(addPage.fillContactsForm(contact)
                .clickSaveBtnContactPositive()
                .isAlertPresent(5))

        ;

    }

////Data Provider

    @Test
            (dataProvider = "addNewContactDP", dataProviderClass = DPAddContact.class)
    public void addNewContactNegativeTest_wrongEmailDP(ContactDtoLombok contact) {
        System.out.println("----->" + contact);
        Assert.assertTrue(addPage.fillContactsForm(contact)
                .clickSaveBtnContactPositive()
                .isAlertPresent(5))
        ;
    }

    @Test(dataProvider = "addNewContactDPFile", dataProviderClass = DPAddContact.class)
    public void addNewContactNegativeTest_wrongEmailDPFile(ContactDtoLombok contact) {
        System.out.println("----->" + contact);
        Assert.assertTrue(addPage.fillContactsForm(contact)
                .clickSaveBtnContactPositive()
                .isAlertPresent(5))
        ;
    }

    @Test
    public void addNewContactsNegativTest_fielPhone_16digits() {
        ContactDtoLombok contact = ContactDtoLombok.builder()
                .name(generateString(4))
                .lastName(generateString(5))
                .phone(generatePHone(16))
                .email(generateEmail(7))
                .address(generateString(7))
                .description(generateString(11))
                .build();

        Assert.assertTrue(addPage.fillContactsForm(contact)
                .clickSaveBtnContactNegative()

                .ErrorMasegeAlirt("Phone not valid: Phone number must contain only digits! " +
                        "And length min 10, max 15!"))

        ;

    }

    @Test//////////BUG//////////
    public void addNewContactsNegativTest_wronEmailWoDot() {
        ContactDtoLombok contact = ContactDtoLombok.builder()
                .name(generateString(5))
                .lastName(generateString(5))
                .phone(generatePHone(11))
                .email(generateEmailWoDot(7))
                .address(generateString(7))
                .description(generateString(11))
                .build();

        Assert.assertTrue(addPage.fillContactsForm(contact)
                .clickSaveBtnContactNegative()
                .ErrorMasegeAlirt(""))
        ;

    }

    @Test
    public void addNewContactsNegativTest_wronEmailWOAt() {
        ContactDtoLombok contact = ContactDtoLombok.builder()
                .name(generateString(5))
                .lastName(generateString(5))
                .phone(generatePHone(11))
                .email(generateEmailWoAt(7))
                .address(generateString(7))
                .description(generateString(11))
                .build();

        addPage.fillContactsForm(contact)
                .clickSaveBtnContactPositive()

        ;

    }

    @Test  //BUG////////////////
    public void addNewContactsNegativTest_wronEmail_RussianLetters() {
        ContactDtoLombok contact = ContactDtoLombok.builder()
                .name(generateString(5))
                .lastName(generateString(5))
                .phone(generatePHone(11))
                .email(generateEmailRussianLetters(7))
                .address(generateString(4))
                .description(generateString(11))
                .build();

        Assert.assertTrue(addPage.fillContactsForm(contact)
                .clickSaveBtnContactNegative()//????/

                .ErrorMasegeAlirt("Email not valid: " +
                        "must be a well-formed email address"))
        ;

    }

    @Test//     ?????????????Btn Negative
    public void addNewContactsNegativTest_fieladdressIsEmpty() {
        ContactDtoLombok contact = ContactDtoLombok.builder()
                .name(generateString(5))
                .lastName(generateString(5))
                .phone(generatePHone(11))
                .email(generateEmailWoAt(7))
                .address(generateString(0))
                .description(generateString(11))
                .build();

        Assert.assertTrue(addPage.fillContactsForm(contact)
                .clickSaveBtnContactNegative()
                .ErrorMasegeAlirt("Email not valid:" +
                        " must be a well-formed email address"));


        ;

    }


}