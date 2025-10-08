package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    public static WebDriver webDriver;

    public static void start() {
        if (webDriver == null) {
            // ChromeDriver path ayarlaman gerekebilir, yoksa Selenium Manager halledecek
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
        }
    }

    public static void stop() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}

