package pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.HeaderMenuItem;

import java.time.Duration;

public class BasePage {
    static WebDriver driver;

    public static void setDriver(WebDriver wd) {
        driver = wd;
    }

    public void pause(int time) {
        try {
            Thread.sleep(time * 1000l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isElementPresent(WebElement element, String text) {
        return element.getText().contains(text);
    }

    public static <T extends BasePage> T clickButtonsOnHeader(HeaderMenuItem headerMenuItem) {
        try {


            //new Aleksey
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(headerMenuItem.getLocator())));

            //HW
            // WebElement element = driver.findElement(By.xpath(headerMenuItem.getLocator()));
            element.click();

        }catch (TimeoutException timeoutException){
            timeoutException.printStackTrace();
            System.out.println(" created timeoutException");
        }
        switch (headerMenuItem) {
            case HOME -> {
                return (T) new HomePage(driver);
            }
            case ABOUT -> {
                return (T) new AboutPage(driver);
            }
            case CONTACTS -> {
                return (T) new ContactPage(driver);
            }
            case ADD -> {
                return (T) new AddPage(driver);

            }
            case LOGIN -> {
                return (T) new LoginPage(driver);

            }
            default -> throw new IllegalArgumentException
                    ("Invalid header menu item: ");

        }
    }
    public void closeAlert() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());
        alert.accept();
    }
    public boolean urlContains (String urlPart,int time){
        return new WebDriverWait(driver,Duration.ofSeconds(time))
                .until(ExpectedConditions.urlContains(urlPart));
    }
}
