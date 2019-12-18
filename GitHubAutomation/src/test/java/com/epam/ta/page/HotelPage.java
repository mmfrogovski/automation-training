package com.epam.ta.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HotelPage extends AbstractPage {

    @FindBy(xpath = "/html/body/div[1]/header/div[8]/div[1]/div/div[2]")
    private WebElement findSearchLine;
    @FindBy(xpath = "/html/body/div[1]/div[4]/div[3]/div/div/div[2]/input[2]")
    private WebElement searchLine;
    @FindBy(xpath = "/html/body/div[1]/div[4]/div[4]/div/div[9]/div/span")
    private WebElement getCity;
    @FindBy(xpath = "/html/body/div[1]/div[4]/div[4]/div/div/div/span")
    private WebElement notFound;
    @FindBy(xpath = "/html/body/div[1]/header/div[8]/div[1]/div/button[1]/i")
    private WebElement selectHotelPageButton;


    public HotelPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public HotelPage openPage() {
        return this;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public HotelPage insertInputLineValue(String value) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.findSearchLine.click();
        this.searchLine.sendKeys(value);
        return this;
    }

    public HotelPage getCity() {
        this.getCity.click();
        return this;
    }

    public HotelSelectPage openHotelSelectPage() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.selectHotelPageButton.click();
        return new HotelSelectPage(driver);
    }

    public String getSearchNotFoundResult() throws InterruptedException {
        return this.notFound.getText();
    }
}
