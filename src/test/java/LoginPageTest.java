import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class LoginPageTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test (description = "Testing login functionality")
    public void loginTest () {
        Reporter.log("Application Started",true);
        driver.navigate().to("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        LoginPage loginPage= new LoginPage(driver);
        assertTrue(loginPage.isLoaded());
        loginPage.login();
        Reporter.log("Clicked on Login button", true);
    }

    @AfterMethod
    public void tearDown () throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
        Reporter.log("Browser closed",true);
    }
}
