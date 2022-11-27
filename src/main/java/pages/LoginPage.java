package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends TestBase  {
    private WebDriver driver;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getUsernameField() {
        //using explicit wait while identifying elements
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement userNameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
        return userNameField;
        //return driver.findElement(By.id("user-name"));
    }

    public WebElement getPasswordField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
        return passwordField;
        //return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-button")));
        return loginButton;
        //return driver.findElement(By.id("login-button"));
    }

    public void login(String username, String password) {

            getUsernameField().sendKeys(username);
            getPasswordField().sendKeys(password);
            getLoginButton().click();

    }

    public boolean isLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-name"))).isDisplayed();
    }



}

