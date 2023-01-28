package helper;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

    public static Alert waitForAlert(WebDriver driver) {
        Alert alt = null;

        for (int i = 0; i <= 15; i++) {
            try {
                alt = driver.switchTo().alert();
                break;
            } catch (NoAlertPresentException e) {
                System.out.println("No Alert Found- Waiting for Alert");

                waitForSeconds(1);
            }
        }

        return alt;
    }

    public static Alert waitForAlert(WebDriver driver, int time) {
        Alert alt = null;

        for (int i = 0; i <= time; i++) {
            try {
                alt = driver.switchTo().alert();
                break;
            } catch (NoAlertPresentException e) {
                System.out.println("No Alert Found- Waiting for Alert");

                waitForSeconds(1);
            }
        }

        return alt;
    }

    public static void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {

        }
    }


    public static void captureScreenshot(WebDriver driver) {
        try {

            FileHandler.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), new File("./screenshots/Screenshot_" + getCurrentTime() + ".png"));

        } catch (IOException e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
    }

    public static String getCurrentTime() {

        String date = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss").format(new Date());
        return date;
    }

    public static void captureScreenshotOfWebElement(WebDriver driver, WebElement element) {
        /*
         * 	Implement this for screenshot of WebElement
         *
         */

    }

}
