package org.epam.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class NewMessageCreationPage extends BasePage {
    private final By newEmailButton = By.cssSelector("a[href='#compose']");

    private final By receiverField = By.className("composeYabbles");
    private final By titleField = By.name("subject");
    private final By textField = By.xpath("//*[contains(@class,'cke_wysiwyg_div cke_reset')]");
    private final By closeEmailButton = By.xpath("//*[contains(@class, 'button_close')]");

    protected NewMessageCreationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public MainPage createDraftMessage(String receiverEmail, String test_email_text, String test_email) {
        waitForElement(newEmailButton).click();
        waitForElement(receiverField).sendKeys(receiverEmail);
        waitForElement(titleField).sendKeys(test_email);
        waitForElement(textField).sendKeys(test_email_text);
        waitForElement(closeEmailButton).click();
        logger.debug("Draft message was created");
        return new MainPage(driver);
    }

}
