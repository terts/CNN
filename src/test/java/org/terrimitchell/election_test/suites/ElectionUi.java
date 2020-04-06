package org.terrimitchell.election_test.suites;

import org.openqa.selenium.WebDriver;
import org.terrimitchell.election_test.pages.ElectionPage;
import org.terrimitchell.framework.BrowserDrivers;
import org.terrimitchell.framework.Log;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ElectionUi {
    
    static final String LOCALHOST = "http://localhost";
    static final String CLOUD = "https://storage.googleapis.com/tm-election/index.html";
    
    // For simplicity, not setting this up to be able to run multi-threaded.
    WebDriver driver;
    
    @Parameters({"browser"})
    @Test
    public void validateUiElectionTitle(String browser) {
        Log.printDescription("Verify title of UI page for Elections lookup.");
        SoftAssert sa = new SoftAssert();
        driver = BrowserDrivers.setDriver(browser);
        driver.navigate().to(CLOUD);
        ElectionPage election = new ElectionPage(driver);
        sa = Log.softAssertTrue(election.getTitle().equals("Terri Mitchell's Election Test UI"), 
                "Title is correct.", 
                "Title is NOT correct.", 
                sa);
        sa.assertAll();
    }
    
    @AfterMethod(alwaysRun = true)
    public void cleanup() {
        driver.close();
    }
    
}
