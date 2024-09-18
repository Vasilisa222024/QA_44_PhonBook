package tests;

import dto.UserDto;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import static utils.RandomUtils.generateEmail;
import static utils.RandomUtils.generateString;

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
}
