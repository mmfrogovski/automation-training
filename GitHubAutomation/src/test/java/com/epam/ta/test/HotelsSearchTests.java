package com.epam.ta.test;

import com.epam.ta.model.SearchCriteria;
import com.epam.ta.page.HomePage;
import com.epam.ta.page.HotelsPage;
import com.epam.ta.page.MapPage;
import com.epam.ta.service.SearchCriteriaCreator;
import com.epam.ta.util.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelsSearchTests extends CommonConditions {
    private static final String URL_TOP_HOTELS_MINSK = "https://tophotels.ru/catalog/hotel/158/1863";
    private static final String city = "Minsk";
    private static final String HOTEL_PRICE_PAGE = "https://toursales.ru/hotel/141612/tL1EK1R#search";
    private static final String resultTag = "Отели 5*";

    @Test
    public void getHotelPricePage() {
        SearchCriteria searchCriteria = SearchCriteriaCreator.withCredentialsFromProperty();
        String hotelPricePage = new HomePage(driver)
                .openHomePage()
                .openHotelPage()
                .openHotelSelectPage()
                .correctSearchForHotels(searchCriteria.getDestination(), searchCriteria.getNumberOfGuests())
                .openDetailedHotelInformation(1)
                .getUrl();
        Assert.assertEquals(hotelPricePage, HOTEL_PRICE_PAGE);
    }

    @Test
    public void searchForCity() throws InterruptedException {
        String url = new HomePage(driver)
                .openHomePage()
                .openHotelPage()
                .insertInputLineValue(city)
                .getCity()
                .getUrl();
        Assert.assertEquals(url, URL_TOP_HOTELS_MINSK);
    }

    @Test
    public void searchForFiveStarsHotels() {
        String fiveStarsText = new HomePage(driver)
                .openHomePage()
                .openHotelPage()
                .openHotelSelectPage()
                .getFiveStarsHotels()
                .getTag();
        Assert.assertEquals(resultTag, fiveStarsText);
    }

    @Test
    public void searchWithMap(){
        MapPage page = new HomePage(driver)
                .openHomePage()
                .openHotelPage()
                .openHotelSelectPage()
                .getCountryHotels()
                .getHotelsOnMap();
        Assert.assertEquals(page.getClass(), MapPage.class);
    }

    @Test
    public void langSwitch(){
        String page = new HomePage(driver)
                .openHomePage()
                .switchLangEng()
                .getUrl();
        Assert.assertEquals(page, StringUtils.TOP_HOTELS_URL_ENG);
    }
}
