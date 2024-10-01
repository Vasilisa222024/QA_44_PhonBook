package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.WDListner;

public class ApplicationManager {
    public Logger logger= LoggerFactory.getLogger(ApplicationManager.class);
   private WebDriver driver;
   public WebDriver getDriver(){
       return driver;
   }


   @BeforeMethod
    public void setUp(){
       //logger.info("Start method-------->setUp");
       driver=new ChromeDriver();
       /////////new realization WDlistner in Selenium 4////
       WebDriverListener webDriverListener=new WDListner();
       driver=new EventFiringDecorator<>(webDriverListener).decorate(driver);
       driver.manage().window().maximize();

   }
   @AfterMethod
    public void tearDown(){
     //  logger.info("Start method------->tearDown");
  //    if(driver!=null)
   //       driver.quit();
    //  }
   }
}
