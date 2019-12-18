package com.epam.ta.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage extends AbstractPage{
    private static final String TOP_HOTELS_URL = "https://tophotels.ru/";

    @FindBy(xpath = "/html/body/div[1]/header/div[8]/div[1]/div/ul[1]/li[2]/a")
    private WebElement hotelsTab;

    @FindBy(xpath = "/html/body/div[1]/header/div[8]/div[1]/div/button[1]/i")
    private WebElement searchCreteria;

    @FindBy(xpath = "/html/body/div[1]/header/div[9]/div[1]/div/ul[1]/li[4]/a")
    private WebElement helpForSearchButton;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[4]/div[2]/div/div[1]")
    private WebElement switchLangBtn;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[4]/div[2]/div/div[2]/div")
    private WebElement engLangBtn;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        driver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public HomePage openPage(){
        return this;
    }

    public HomePage openHomePage() {
        driver.get(TOP_HOTELS_URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return this;
    }

    public HotelPage openHotelPage() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.hotelsTab.click();
        return new HotelPage(driver);
    }

    public HelpForSearchPage openHelpForSearchPage(){
        this.helpForSearchButton.click();
        return new HelpForSearchPage(driver);
    }

    public HomePage switchLangEng(){
        this.switchLangBtn.click();
        this.engLangBtn.click();
        return new HomePage(driver);
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }
}
