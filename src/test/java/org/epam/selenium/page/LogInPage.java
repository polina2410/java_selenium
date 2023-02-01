package org.epam.selenium.page;

import org.epam.selenium.model.PageURL;
import org.epam.selenium.model.User;
import org.epam.selenium.service.URLCreator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends BasePage {
    PageURL pageURL = URLCreator.URL();
    private final By passwordEnter = By.name("passwd");
    private final By enterButton = By.id("passp:sign-in");
    private final By loginEnter = By.id("passp-field-login");
    private final By logInButton = By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/button");

    public LogInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public LogInPage openLogInPage() {
        driver.navigate().to(pageURL.toString());
        logger.info("Login page opened");
        return this;
    }

    public MainPage logIn(User user) {
        waitForElement(logInButton).click();
        driver.findElement(loginEnter).sendKeys(user.getUsername());
        driver.findElement(enterButton).click();
        waitForElement(passwordEnter).sendKeys(user.getPassword());
        driver.findElement(enterButton).click();
        logger.info("Login performed");
        return new MainPage(driver);
    }
}
