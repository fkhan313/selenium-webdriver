import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class HelloSelenium2Test {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
    }
    @Test
    public void smarterTest () {
        driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/v1/inventory.html");
        int countofItems = driver.findElements(By.className("inventory_item")).size();
        if (countofItems==6) {
            assertTrue(true);
        }
        else {
            fail();
        }

    }

    @After
    public void tearDown () {
        driver.quit();
    }
}
