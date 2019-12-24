package com.epam.ta.test;

import com.epam.ta.page.HomePage;
import com.epam.ta.util.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelsIncorrectSearchTests extends CommonConditions {
    public static final String incorrectEmail = "asd";
    public static final String incorrectSearchValue = "aaasfffaaaaaaaaa";
    public static final String oneSymbolSearchData = "a";
    public static final String enterMoreSymbolsTxt = "Введите больше символов для поиска";

    @Test
    public void searchWithNotCorrectData() throws InterruptedException {
        String result = new HomePage(driver)
                .openHomePage()
                .openHotelPage()
                .insertInputLineValue(incorrectSearchValue)
                .getSearchNotFoundResult();
        Assert.assertEquals(StringUtils.NOT_FOUND, result);
    }

    @Test
    public void searchWithOneSymbol() throws InterruptedException {
        String result = new HomePage(driver)
                .openHomePage()
                .openHotelPage()
                .insertInputLineValue(oneSymbolSearchData)
                .getSearchMoreSymbolsResult();
        Assert.assertEquals(enterMoreSymbolsTxt, result);
    }

    @Test
    public void helpForSearchTest() {
        boolean result = new HomePage(driver)
                .openHomePage()
                .openHelpForSearchPage()
                .enterContactValues(incorrectEmail);
        Assert.assertTrue(result);
    }

}
