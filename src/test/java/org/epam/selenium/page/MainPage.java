package org.epam.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    private final By newEmailButton = By.cssSelector("a[href='#compose']");


    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String waitMainPageLoad() {
        waitForElement(newEmailButton);
        logger.info("Got current URL");
        return driver.getCurrentUrl();
    }

    public LogOutPage openLogOutPage() {
        logger.info("Logout page open");
        return new LogOutPage(driver);
    }

    public NewMessageCreationPage openNewMessagesCreationPage() {
        logger.info("New messages page open");
        return new NewMessageCreationPage(driver);
    }

    public DraftPage openDraftPage() {
        logger.info("Draft page open");
        return new DraftPage(driver);
    }
}
