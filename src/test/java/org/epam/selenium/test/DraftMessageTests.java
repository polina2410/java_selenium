package org.epam.selenium.test;

import org.epam.selenium.model.User;
import org.epam.selenium.page.LogInPage;
import org.epam.selenium.service.UserCreator;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertFalse;

public class DraftMessageTests extends BaseTestClass {

    @Test
    public void testSubjectOfDraft() {
        User testUser = UserCreator.withCredentialsFromProperty();
        String subjectOfDraftMessage = new LogInPage(driver)
                .openLogInPage()
                .logIn(testUser)
                .openNewMessagesCreationPage()
                .createDraftMessage(receiverEmail, draftText, "test email")
                .openDraftPage()
                .waitDraftPageUpload()
                .getDraftEmail();
        assertThat(subjectOfDraftMessage, is(equalTo(receiverEmail)));
    }

    @Test
    public void testTextOfDraft() {
        User testUser = UserCreator.withCredentialsFromProperty();
        String textOfDraftMessage = new LogInPage(driver)
                .openLogInPage()
                .logIn(testUser)
                .openNewMessagesCreationPage()
                .createDraftMessage(receiverEmail, draftText, "test email")
                .openDraftPage()
                .waitDraftPageUpload()
                .getDraftText();
        assertThat(textOfDraftMessage, is(equalTo(draftText)));
    }

    @Test
    public void testMessageIsNotInDraftFolder() {
        User testUser = UserCreator.withCredentialsFromProperty();
        List<WebElement> messageIsNotInDraftFolder = new LogInPage(driver)
                .openLogInPage()
                .logIn(testUser)
                .openNewMessagesCreationPage()
                .createDraftMessage(receiverEmail, draftText, "test email")
                .openDraftPage()
                .waitDraftPageUpload()
                .sendDraftMessage()
                .getListOfMessages();
        assertFalse(messageIsNotInDraftFolder.stream().anyMatch(e -> e.getText().equals("test email")));
    }
}
