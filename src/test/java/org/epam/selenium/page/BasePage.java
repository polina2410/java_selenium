//mvn -Dbrowser=chrome -Denvironment=qa -Dsurefire.suiteXmlFiles=src\\test\\resources\\testng-smoke.xml clean test
package org.epam.selenium.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    public static final int TIMEOUT = 10;

    protected WebDriver driver;
    protected Actions action;
    protected JavascriptExecutor js;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
        this.js = (JavascriptExecutor) driver;
    }

    protected WebElement waitForElement(By path) {
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        return waiter.until(ExpectedConditions.visibilityOfElementLocated(path));
    }

    public final Logger logger = LogManager.getRootLogger();

}
