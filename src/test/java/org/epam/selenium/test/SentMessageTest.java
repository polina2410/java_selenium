package org.epam.selenium.test;

import org.epam.selenium.model.User;
import org.epam.selenium.page.LogInPage;
import org.epam.selenium.service.UserCreator;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class SentMessageTest extends BaseClassTest {

    @Test
    public void checkMessageIsInSentFolder() {
        User testUser = UserCreator.withCredentialsFromProperty();
        List<WebElement> messageIsInSentFolder = new LogInPage(driver)
                .openLogInPage()
                .logIn(testUser)
                .openNewMessagesCreationPage()
                .createDraftMessage(receiverEmail, draftText, "test email")
                .openDraftPage()
                .waitDraftPageUpload()
                .sendDraftMessage()
                .openSentPage()
                .getListOfMessages();
        assertTrue(messageIsInSentFolder.stream().anyMatch(e -> e.getText().equals("test email")));
    }
}
