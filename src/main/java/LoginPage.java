import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage  {
    private WebDriver driver;


    public LoginPage(WebDriver driver) {
        //super(driver);
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

    public void login() {

        getUsernameField().sendKeys("standard_user");
        getPasswordField().sendKeys("secret_sauce");
        getLoginButton().click();
    }

    public boolean isLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-name"))).isDisplayed();
    }



}

