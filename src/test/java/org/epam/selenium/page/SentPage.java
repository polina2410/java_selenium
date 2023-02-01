package org.epam.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SentPage extends BasePage {
    private final By draftEmail = By.cssSelector("span[title='test email']");


    public SentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public List<WebElement> getListOfMessages() {
        return driver.findElements(draftEmail);
    }
}
