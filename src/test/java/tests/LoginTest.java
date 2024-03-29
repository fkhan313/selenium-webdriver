package tests;

import base.TestBase;
import helper.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import pages.LoginPage;
import Listeners.ExtentReporterNG;
import util.ExcelUtil;


@Listeners(ExtentReporterNG.class)
public class LoginTest extends TestBase {
    LoginPage loginPage;

    public LoginTest(){
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage(driver);
    }

    @DataProvider
    public Object[][] getLoginData(){
       Object data [] [] = ExcelUtil.getTestData("login");
       return data;
    }
    @Test (dataProvider = "getLoginData")
    public void loginTest (String username, String password) {
        Reporter.log("Application Started",true);
        Assert.assertTrue(loginPage.isLoaded());
        loginPage.login(username, password);
        Utility.captureScreenshot(driver);
        String actualTitle=driver.getTitle();
        String expectedTitle = "Swag Labs";
        Assert.assertEquals(actualTitle,expectedTitle);
        Utility.captureScreenshot(driver);
        Reporter.log("Clicked on Login button", true);
    }

    @AfterMethod
    public void tearDown () throws InterruptedException {
        //Thread.sleep(1000);
        driver.quit();
        Reporter.log("Browser closed",true);
    }

}
