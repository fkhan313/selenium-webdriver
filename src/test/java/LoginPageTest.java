import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class LoginPageTest {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void smarterTest1 () {
        driver.navigate().to("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();
        LoginPage loginPage= new LoginPage(driver);
        loginPage.login();
    }

    @After
    public void tearDown () throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
