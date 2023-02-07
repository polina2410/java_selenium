package org.epam.selenium.test;

import org.epam.selenium.model.User;
import org.epam.selenium.page.LogInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class UserAccessTests extends BaseTestClass {

    @Test
    public void userCanLogIn() {
        User testUser = dataReader.getUser();
        String loggedInURL = new LogInPage(driver, dataReader)
                .openLogInPage()
                .logIn(testUser)
                .waitMainPageLoad();
        assertThat(loggedInURL, is(equalTo(mainPageURL)));
    }

    @Test
    public void userCanLogOut() {
        User testUser = dataReader.getUser();
        boolean isUserLoggedOut = new LogInPage(driver, dataReader)
                .openLogInPage()
                .logIn(testUser)
                .openLogOutPage()
                .logOut();
        Assert.assertTrue(isUserLoggedOut, "user logged out");
    }

}
