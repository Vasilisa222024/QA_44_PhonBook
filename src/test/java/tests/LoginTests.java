package tests;

import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class LoginTests extends ApplicationManager {
    @Test
    public void loginPositiveTest(){
       boolean res=
        new HomePage(getDriver())
                .clickbtnLoginHeader()
                .typeloginForm
                ("qa_44_qa@gmail.com" ,"Qaqaqa44@")
                .clickBtnLoginPositive()
                .isElementContactsPresent()
               ;
        Assert.assertTrue(res);
//Assert.assertEquals (100, 200);
//Assert.assertTrue(true);
//Assert .assertFalse(false);
//Assert.assertNotEquals(100,100);



    }
    @Test
    public void loginNegativeTest_wrongPassword () {

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
    public void loginNegativeTest_wrongEmail () {

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
}
