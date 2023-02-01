package org.epam.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage extends BasePage {
    private final By openUserMenuLocator = By.cssSelector("img[class='user-pic__image']");
    private final By logOutLocator = By.xpath("//*[contains(@href,'action=logout')]");

    public LogOutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public boolean logOut() {
        WebElement openUserMenu = waitForElement(openUserMenuLocator);
        action.moveToElement(openUserMenu).click();
        WebElement logOut = waitForElement(logOutLocator);
        js.executeScript("arguments[0].click();", logOut);
        logger.info("Logout performed");
        return true;
    }

}
