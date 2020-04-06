package org.terrimitchell.election_test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElectionPage {
    @FindBy(css = "body > h1")
    WebElement title;

    WebDriver driver;
    
    public ElectionPage(WebDriver driver) {           
        this.driver = driver; 
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return title.getText();
    }

}
