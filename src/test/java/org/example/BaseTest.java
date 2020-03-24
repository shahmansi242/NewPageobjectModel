package org.example;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest extends Utils {
    BrowserSelector browserSelector = new BrowserSelector();

    @BeforeMethod
    public void openBrowser() {

        browserSelector.openBrowser();


    }

    @AfterMethod
    public void closeBrowser(ITestResult result) {
        if (!result.isSuccess()){
            takeScreenShot(result.getName()+timeStamp());

        }
        driver.quit();


    }

}

