package com.bsu.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage {
    private static final String TOP_HOTELS_URL = "https://tophotels.ru/";
    private WebDriver webDriver;

    @FindBy(xpath = "/html/body/div[1]/header/div[8]/div[1]/div/ul[1]/li[2]/a")
    private WebElement hotelsTab;


    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }



    public HomePage openHomePage() {
        this.webDriver.get(TOP_HOTELS_URL);
        this.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return this;
    }

    public HotelsPage openHotelsPage() {
        this.hotelsTab.click();
        this.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new HotelsPage(this.webDriver);
    }


}
