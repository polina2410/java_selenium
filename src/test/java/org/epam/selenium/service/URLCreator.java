package org.epam.selenium.service;

import org.epam.selenium.model.PageURL;

public class URLCreator {
    public static final String TESTDATA_PAGE_URL = "testdata.URL";

    public static PageURL URL() {
        return new PageURL(TestDataReader.getTestData(TESTDATA_PAGE_URL));
    }
}
