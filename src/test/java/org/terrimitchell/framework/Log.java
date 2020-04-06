package org.terrimitchell.framework;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class Log {
    private final static String fontRed = "<font color=\"#dd0000\">";
    private final static String fontGreen = "<font color=\"#00aa00\">";
    private final static String fontEnd = "</font>";

    public static SoftAssert softAssertTrue(boolean condition, String pass, String fail, 
            SoftAssert sa) {
        sa.assertTrue(condition);
        if (condition) {
            Reporter.log(fontGreen + "PASSED: " + pass + fontEnd);
        } else {
            Reporter.log(fontRed + "FAILED: " + fail + fontEnd);
        }
        return sa;
    }
    
    public static void assertTrue(boolean condition, String pass, String fail) {
        if (condition) {
            Reporter.log(fontGreen + "PASSED: " + pass + fontEnd);
        } else {
            Reporter.log(fontRed + "FAILED: " + fail + fontEnd);
        }
        Assert.assertTrue(condition);
    }
    
    public static void printDescription(String description) {
        Reporter.log("<h3>" + description + "</h3>");
    }
    
}