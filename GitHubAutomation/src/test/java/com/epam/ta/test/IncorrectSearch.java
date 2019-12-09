package com.epam.ta.test;

import com.epam.ta.page.HomePage;
import com.epam.ta.page.HotelsPage;
import com.epam.ta.util.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IncorrectSearch {
    private static final String CHROME_DRIVER_PATH = "D:\\EpamTesting\\automation-training\\selenium\\src\\test\\java\\com\\bsu\\driver\\chromedriver.exe";


    private WebDriver webDriver;

    @BeforeMethod
    public void browserStart() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        this.webDriver = new ChromeDriver();
    }

    @AfterMethod
    public void browserExit() {
        this.webDriver.quit();
        this.webDriver = null;
    }

    @Test
    public void incorrectSearch() throws InterruptedException {
        HotelsPage hotelsPage = new HomePage(this.webDriver)
                .openHomePage()
                .openHotelsPage()
                .insertInputLineValue(StringUtils.incorrectSearchValue);
        String result = hotelsPage.getSearchNotFoundResult();
        Assert.assertEquals(StringUtils.NOT_FOUND, result);
    }

}
