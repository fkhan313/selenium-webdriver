import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebElement usernameField;
    public WebElement passwordField;
    public WebElement loginButton;

    public void login() {
        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();
    }

}

