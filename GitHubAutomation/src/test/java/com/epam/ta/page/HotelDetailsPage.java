package com.epam.ta.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HotelDetailsPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    private WebDriver webDriver;

    @FindBy(xpath = "/html/body/div[2]/div[5]/div[3]/a")
    private WebElement priceButton;

    public HotelDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public HotelDetailsPage openPricePage() {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        priceButton.click();
        return this;
    }

    public String getUrl() {
        return this.webDriver.getCurrentUrl();
    }

    @Override
    public HotelDetailsPage openPage() {
        return this;
    }
}
