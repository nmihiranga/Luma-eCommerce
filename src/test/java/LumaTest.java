import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedCondition.*;


public class LumaTest {
    private WebDriver driver;
    String baseUrl;


    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        baseUrl = "https://magento.softwaretestingboard.com/";
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    //scroll
    @Test
    void scroll() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(4000);
        js.executeScript("window.scrollBy(0,-2200)", "");
        Thread.sleep(4000);
    }

    //create account
    @Test
    void registration(){

    }

    //search
    @Test
    void search() throws InterruptedException {
        WebElement m = driver.findElement(By.id("search"));
        m.sendKeys("Men tops");
        m.sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)", "");
    }



    //registration and login
    //menus
    //scroll
    //add to cart
    //filters
    //payout

    @Test
    void logoToHome(){
        //driver.findElement(By.linkText("https://magento.softwaretestingboard.com/")).click();
    }

    @AfterTest
    void tearDown(){
        //driver.quit();
    }
}