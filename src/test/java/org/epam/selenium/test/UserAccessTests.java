package org.epam.selenium.test;

import org.epam.selenium.model.User;
import org.epam.selenium.page.LogInPage;
import org.epam.selenium.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class UserAccessTests extends BaseClassTest {

    protected static final String mainPageURL = "https://mail.yandex.ru/?uid=1729372994#tabs/relevant";

    @Test
    public void userCanLogIn() {
        User testUser = UserCreator.withCredentialsFromProperty();
        String loggedInURL = new LogInPage(driver)
                .openLogInPage()
                .logIn(testUser)
                .waitMainPageLoad();
        assertThat(loggedInURL, is(equalTo(mainPageURL)));
    }

    @Test
    public void userCanLogOut() {
        User testUser = UserCreator.withCredentialsFromProperty();
        boolean isUserLoggedOut = new LogInPage(driver)
                .openLogInPage()
                .logIn(testUser)
                .openLogOutPage()
                .logOut();
        Assert.assertTrue(isUserLoggedOut, "user logged out");
    }

}
