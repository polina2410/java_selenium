package org.epam.selenium.service;

import org.epam.selenium.model.User;

public interface TestDataReader {

    User getUser();

    String getPageUrl();
}
