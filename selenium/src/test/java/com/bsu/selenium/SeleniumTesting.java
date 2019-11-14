package com.bsu.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumTesting {
    private static final String CHROME_DRIVER_PATH = "D:\\EpamTesting\\automation-training\\selenium\\src\\test\\java\\com\\bsu\\driver\\chromedriver.exe";
    private static final String URL_TOP_HOTELS_MINSK = "https://tophotels.ru/catalog/hotel/158/1863";
    private static final String NOT_FOUND = "поиск не дал результатов";
    private static final String city = "Minsk";
    private static final String incorrectSearchValue = "aaasfffaaaaaaaaa";


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
    public void searchForCity() throws InterruptedException {
        String url = new HomePage(this.webDriver)
                .openHomePage()
                .openHotelsPage()
                .insertInputLineValue(city)
                .getCity()
                .getUrl();
        Assert.assertEquals(url, URL_TOP_HOTELS_MINSK);
    }

    @Test
    public void incorrectSearch() throws InterruptedException {
        HotelsPage hotelsPage = new HomePage(this.webDriver)
                .openHomePage()
                .openHotelsPage()
                .insertInputLineValue(incorrectSearchValue);
        String result = hotelsPage.getSearchNotFoundResult();
        Assert.assertEquals(NOT_FOUND, result);
    }

}
