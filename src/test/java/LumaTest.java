import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


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
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,-2200)", "");
        Thread.sleep(3000);
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
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"send2\"]/span")).click();
    }

    //personal details add
    @Test(priority = 3, enabled = false)
    void detailsAdd() throws InterruptedException {
        driver.findElement(By.xpath("//header/div[1]/div[1]/ul[1]/li[2]/span[1]/button[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Address Book")).click();
        driver.findElement(By.id("telephone")).sendKeys("732185509");
        driver.findElement(By.id("street_1")).sendKeys("Street 1");
        driver.findElement(By.id("city")).sendKeys("City 1");
        driver.findElement(By.id("region_id")).click();
        driver.findElement(By.xpath("//option[contains(text(),'Alaska')]")).click();
        driver.findElement(By.id("zip")).sendKeys("21000");
        driver.findElement(By.id("country")).click();
        driver.findElement(By.xpath("//option[contains(text(),'Albania')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//body/div[2]/main[1]/div[2]/div[1]/form[1]/div[1]/div[1]/button[1]")).click();
    }

    //search
    @Test(priority = 4)
    void search() throws InterruptedException {
        WebElement m = driver.findElement(By.id("search"));
        m.sendKeys("Men tops");
        m.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)", "");
    }

    //add to cart
    @Test(priority = 5)
    void addToCart(){
        driver.findElement(By.id("option-label-size-143-item-168")).click();
        driver.findElement(By.id("option-label-color-93-item-57")).click();
        //driver.findElement(By.id("qty")).sendKeys("2");
        driver.findElement(By.cssSelector("body.page-products.page-with-filter.catalogsearch-result-index.page-layout-2columns-left:nth-child(2) div.page-wrapper:nth-child(5) main.page-main div.columns:nth-child(4) div.column.main:nth-child(1) div.search.results:nth-child(6) div.products.wrapper.grid.products-grid:nth-child(3) ol.products.list.items.product-items li.item.product.product-item:nth-child(1) div.product-item-info div.product.details.product-item-details:nth-child(2) div.product-item-inner div.product.actions.product-item-actions div.actions-primary form:nth-child(1) > button.action.tocart.primary:nth-child(4)")).click();
    }

    //payout
    @Test(priority = 6, enabled = false)
    void payout() throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(By.xpath("//header/div[2]/div[1]/a[1]")).click();
        driver.findElement(By.id("top-cart-btn-checkout")).click();
        Thread.sleep(8000);
        driver.findElement(By.xpath("//body/div[3]/main[1]/div[2]/div[1]/div[3]/div[4]/ol[1]/li[2]/div[1]/div[3]/form[1]/div[3]/div[1]/button[1]")).click();
        // Didn't work. Couldn't find element by all the ways.
    }

    //logout
    @Test(priority = 7)
    void logout() throws InterruptedException {
        driver.findElement(By.xpath("//header/div[1]/div[1]/ul[1]/li[2]/span[1]/button[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Sign Out")).click();
    }

    //browser quit
    @AfterTest
    void tearDown(){
        driver.quit();
    }
}
