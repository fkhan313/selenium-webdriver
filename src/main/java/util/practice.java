package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class practice {
    /*private static WebDriver driver;

    public practice(WebDriver driver) {
        this.driver = driver;
    }*/

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://429-kube.shibumi.com/shibumi/93a7d7fe-353a-44a6-95ac-213dc48dad21/apps");
        driver.findElement(By.id("UsernameEntry__username")).sendKeys("consultant@shibumi.com");
        TakesScreenshot ts= (TakesScreenshot) driver;
        File src= ts.getScreenshotAs(OutputType.FILE);
        File destination= new File("./MyScreenshot.png");
        try {
            FileHandler.copy(src,destination);
        } catch (IOException e) {
            System.out.println("Something went wrong"+ e.getMessage());
        }

        Thread.sleep(500);
        driver.quit();

    }



}
