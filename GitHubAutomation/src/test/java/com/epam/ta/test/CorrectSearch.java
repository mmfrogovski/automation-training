package com.epam.ta.test;

import com.epam.ta.model.SearchCriteria;
import com.epam.ta.page.HomePage;
import com.epam.ta.service.SearchCriteriaCreator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CorrectSearch {
    private static final String CHROME_DRIVER_PATH = "D:\\EpamTesting\\automation-training\\selenium\\src\\test\\java\\com\\bsu\\driver\\chromedriver.exe";
    private static final String URL_TOP_HOTELS_MINSK = "https://tophotels.ru/catalog/hotel/158/1863";
    private static final String city = "Minsk";
    private static final String HOTEL_PRICE_PAGE = "https://toursales.ru/hotel/141612/tL1EK1R#search";


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
    public void getHotelPricePage() {
        SearchCriteria searchСriteria = SearchCriteriaCreator.withCredentialsFromProperty();
        String hotelPricePage = new HomePage(webDriver)
                .openHomePage()
                .openHotelsPage()
                .correctSearchForHotels(searchСriteria.getDestination(), searchСriteria.getNumberOfGuests())
                .openDetailedHotelInformation(1)
                .getUrl();
        Assert.assertEquals(hotelPricePage, HOTEL_PRICE_PAGE);
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

}
