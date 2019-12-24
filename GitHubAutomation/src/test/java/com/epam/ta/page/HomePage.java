package com.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage extends AbstractPage {
    private static final String TOP_HOTELS_URL = "https://tophotels.ru/";

    @FindBy(xpath = "/html/body/div[1]/header/div[8]/div[1]/div/ul[1]/li[2]/a")
    private WebElement hotelsTab;

    @FindBy(xpath = "/html/body/div[1]/header/div[8]/div[1]/div/button[1]/i")
    private WebElement searchCreteria;


    private WebElement commonElement;

    @FindBy(xpath = "/html/body/div[1]/header/div[8]/div[1]/div/ul[1]/li[4]/a")
    private WebElement helpPageBtn;

    final static private String XPATH_TO_SWITCH_BTN = "/html/body/div[1]/div[1]/div[4]/div[2]/div/div[1]";

    final static String XPATH_OF_LANG_BTN = "/html/body/div[1]/div[1]/div[4]/div[2]/div/div[2]/div";
    private WebElement engLangBtn;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        driver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public HomePage openPage() {
        return this;
    }

    public HomePage openHomePage() {
        driver.get(TOP_HOTELS_URL);
        return this;
    }

    public HotelPage openHotelPage() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.hotelsTab.click();
        return new HotelPage(driver);
    }

    public HelpForSearchPage openHelpForSearchPage() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.helpPageBtn.click();
        return new HelpForSearchPage(driver);
    }

    public HomePage switchLangEng() {
        this.commonElement = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_TO_SWITCH_BTN)));
        this.commonElement.click();
        this.engLangBtn = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_OF_LANG_BTN)));
        this.engLangBtn.click();
        return new HomePage(driver);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
