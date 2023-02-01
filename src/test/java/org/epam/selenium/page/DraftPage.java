package org.epam.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DraftPage extends BasePage {

    private final By openDraftFolder = By.cssSelector("a[href='#draft']");
    private final By draftEmail = By.cssSelector("span[title='test email']");
    private final By subjectDraft = By.cssSelector("input[name='subject']");
    private final By emailDraft = By.className("ComposeYabble-Text");
    private final By bodyDraft = By.cssSelector(".cke_wysiwyg_div > div");
    private final By sendButton = By.xpath("//*[contains(@class, 'Button_new')]");
    private final By messageSent = By.xpath("//*[text()='Письмо отправлено']");

    private final By openSentFolder = By.cssSelector("a[href='#sent']");
    private final By sentFolderOpen = By.cssSelector("div[aria-label^=\"Выбрано, Отправленные\"]");

    public DraftPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getDraftEmail() {
        waitForElement(openDraftFolder).click();
        waitForElement(draftEmail).click();
        return driver.findElement(emailDraft).getText();
    }

    public DraftPage waitDraftPageUpload() {
        waitForElement(openDraftFolder).click();
        waitForElement(draftEmail).click();
        waitForElement(subjectDraft).click();
        return this;
    }

    public String getDraftText() {
        return driver.findElement(bodyDraft).getText();
    }

    public DraftPage sendDraftMessage() {
        driver.findElement(sendButton).click();
        waitForElement(messageSent);
        logger.info("Draft message was sent");
        return this;
    }

    public List<WebElement> getListOfMessages() {
        js.executeScript("location.reload()");
        return driver.findElements(draftEmail);
    }

    public SentPage openSentPage() {
        waitForElement(openSentFolder).click();
        waitForElement(sentFolderOpen);
        logger.info("Sent messages page is open");
        return new SentPage(driver);
    }
}
