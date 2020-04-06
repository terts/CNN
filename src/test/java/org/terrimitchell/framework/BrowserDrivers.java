package org.terrimitchell.framework;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDrivers {
    private static final int maxTime = 10;

    public static String setDriverPath(String browser) {
        String driverPath = "src" + File.separator + "test" + File.separator 
                + "resources" + File.separator;
        if (browser.equalsIgnoreCase("Firefox")) {
            driverPath += "geckodriver";
        } else if (browser.equalsIgnoreCase("Chrome")) {
            driverPath += "chromedriver";
        } else {
            driverPath = "";
        }
        if (System.getProperties().getProperty("os.name").startsWith("Win")) {
             driverPath += ".exe";
        }
        return driverPath;
    }
    
    public static WebDriver setChromeDriver(String browser) {
        System.setProperty("webdriver.chrome.driver", setDriverPath(browser));
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(maxTime, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver setFirefoxDriver(String browser) {
        System.setProperty("webdriver.gecko.driver", setDriverPath(browser));
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(maxTime, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver setDriver(String browser) {
        WebDriver driver = null;
        switch (browser.toLowerCase()) {
            case "chrome": 
                driver = setChromeDriver(browser);
                break;
            case "firefox": 
                driver = setFirefoxDriver(browser);
                break;
            default:
                break;
        }
        return driver;
    }
    
}