package com.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static javax.xml.crypto.dsig.Transform.XPATH;

public class HotelSelectPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"co\"]")
    private WebElement destinationsInput;

    @FindBy(xpath = "//*[@id=\"cat_4\"]")
    private WebElement rating;

    @FindBy(xpath = "//*[@id=\"cat_5\"]")
    private WebElement fiveStarsInput;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/div/div/div/div[4]/div/div[3]/div[2]/div/input")
    private WebElement guestsSelect;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/div/div/div/div[4]/div/div[3]/div[2]/div/div/div/ul/li[1]/div[1]/div/label[2]/span")
    private WebElement guestsNumber;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/div/div/div/div[8]/div/a[1]")
    private WebElement searchHotelsButton;

    @FindBy(xpath = "//*[@id=\"content\"]/div[3]/div[2]/div[1]/div/div[1]/div[2]/a")
    private List<WebElement> detailHotelInformationButton;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/div/div/div/div[1]/div/div[1]/div[2]/div/a")
    private WebElement selectCountryBtn;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/div/div/div/div[1]/div/div[1]/div[2]/div/div/div/ul/li[3]")
    private WebElement country;

    private static final String TOP_HOTELS_URL = "https://tophotels.ru/";

    public HotelSelectPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public HotelSelectPage openPage() {
        return this;
    }


    public HotelDetailsPage openDetailedHotelInformation(int hotelNumber) {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        detailHotelInformationButton.get(hotelNumber - 1).click();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        return new HotelDetailsPage(driver);
    }

    public HotelSelectPage correctSearchForHotels(String destinations, int guestsNumber) {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        destinationsInput.sendKeys(destinations);
        destinationsInput.click();
        this.rating.click();
        this.guestsSelect.click();
        this.guestsNumber = driver.findElement(By.xpath(String.format(XPATH, guestsNumber)));
        this.guestsNumber.click();
        searchHotelsButton.click();
        return this;
    }

    public HotelsPage getFiveStarsHotels(){
        this.fiveStarsInput.click();
        this.searchHotelsButton.click();
        return new HotelsPage(driver);
    }

    public HotelsPage getCountryHotels(){
        this.selectCountryBtn.click();
        this.country.click();
        this.searchHotelsButton.click();
        return new HotelsPage(driver);
    }

}
