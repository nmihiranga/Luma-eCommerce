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
    @Test(priority = 0)
    void scroll() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(4000);
        js.executeScript("window.scrollBy(0,-2200)", "");
        Thread.sleep(4000);
    }

    //create account
    @Test(priority = 1)
    void registration() throws InterruptedException {
        driver.findElement(By.linkText("Create an Account")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)", "");
        driver.findElement(By.id("firstname")).sendKeys("test");
        driver.findElement(By.id("lastname")).sendKeys("user");
        driver.findElement(By.id("email_address")).sendKeys("test1@testmail.com");
        driver.findElement(By.id("password")).sendKeys("test1@testmail#Com");
        driver.findElement(By.id("password-confirmation")).sendKeys("test1@testmail#Com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span")).click();
    }

    //sign in
    @Test(priority = 2)
    void signIn() throws InterruptedException {
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.id("email")).sendKeys("test1@testmail.com");
        driver.findElement(By.id("pass")).sendKeys("test1@testmail#Com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"send2\"]/span")).click();
    }

    //search
    @Test(priority = 3)
    void search() throws InterruptedException {
        WebElement m = driver.findElement(By.id("search"));
        m.sendKeys("Men tops");
        m.sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)", "");
    }




    //menus

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
