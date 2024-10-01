package tests;

import data_provider.DPAddContact;
import data_provider.DPRegistration;
import dto.UserDto;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.TestNGListner;

import static utils.RandomUtils.generateEmail;
import static utils.RandomUtils.generateString;
@Listeners(TestNGListner.class)

public class RegistrationTest extends ApplicationManager {
    @Test
    public void registrationPosetivTest() {
        Assert.assertTrue(new HomePage(getDriver())
                .clickbtnLoginHeader()
                .typeloginForm("qa445holkh@gmail.com", "1j3#AAa1")
                .clickBtnRegistrationPositiv()
                .isElementContactsPresent());


    }

    @Test
    public void registrationNegativeTest_wrongEmail_Field_email_is_empty() {
        Assert.assertTrue(
                new HomePage(getDriver())
                        .clickbtnLoginHeader()
                        .typeloginForm("", "1j3#AAa1")
                        .clickBtnRegistrationNegative()
                        .closeAllert()
                        .isTextInElementPresent_errorMessageRegistration())

        ;


    }

    @Test
    public void registrationNegativeTest_wrongEmail() {
        String email = generateString(12);
        UserDto user = new UserDto(email, "Qartrt234$");
        new HomePage(getDriver())
                .clickbtnLoginHeader()
                .typeloginForm(user)
                .clickBtnRegistrationNegative()
                .closeAllert()
                .isTextInElementPresent_errorMessageRegistration("Registration failed with code 400")

        ;


    }
    @Test(dataProvider = "addNewRegistration",dataProviderClass = DPRegistration.class)
    public void registrationNegativeTest_wrongEmailDP(UserDto user) {
        System.out.println("--> " + user);

       Assert.assertTrue( new HomePage(getDriver())
                .clickbtnLoginHeader()
                .typeloginForm(user)
                .clickBtnRegistrationNegative()
               .closeAllert()
               .isTextInElementPresent_errorMessageRegistration("Registration failed with code 400"))

        ;


    }
}
