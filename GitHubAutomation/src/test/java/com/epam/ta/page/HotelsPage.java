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

public class HotelsPage extends AbstractPage {
    private WebDriver webDriver;

    @FindBy(xpath = "/html/body/div[1]/header/div[8]/div[1]/div/div[2]")
    private WebElement findSearchLine;
    @FindBy(xpath = "/html/body/div[1]/div[4]/div[3]/div/div/div[2]/input[2]")
    private WebElement searchLine;
    @FindBy(xpath = "/html/body/div[1]/div[4]/div[4]/div/div[9]/div/span")
    private WebElement getCity;
    @FindBy(xpath = "/html/body/div[1]/div[4]/div[4]/div/div/div/span")
    private WebElement notFound;

    @FindBy(xpath = "//*[@id=\"co\"]")
    private WebElement destinationsInput;

    @FindBy(xpath = "//*[@id=\"cat_4\"]")
    private WebElement rating;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/div/div/div/div[4]/div/div[3]/div[2]/div/input")
    private WebElement guestsSelect;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/div/div/div/div[4]/div/div[3]/div[2]/div/div/div/ul/li[1]/div[1]/div/label[2]/span")
    private WebElement guestsNumber;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/div/div/div/div[8]/div/a[1]/span")
    private WebElement searchHotelsButton;

    @FindBy(xpath = "//*[@id=\"content\"]/div[3]/div[2]/div[1]/div/div[1]/div[2]/a")
    private List<WebElement> detailHotelInformationButton;



    public HotelsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public HotelsPage openPage() {
        return this;
    }

    public String getUrl() {
        return this.webDriver.getCurrentUrl();
    }

    public HotelsPage insertInputLineValue(String value) throws InterruptedException {
        this.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.findSearchLine.click();
        this.searchLine.sendKeys(value);
        return this;
    }

    public HotelsPage correctSearchForHotels(String destinations, int guestsNumber) {
        destinationsInput.sendKeys(destinations);
        destinationsInput.click();
        this.rating.click();
        this.guestsSelect.click();
        this.guestsNumber = driver.findElement(By.xpath(String.format(XPATH,guestsNumber)));
        this.guestsNumber.click();
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        searchHotelsButton.click();
        return this;
    }

    public HotelsPage getCity() {
        this.getCity.click();
        return this;
    }

    public HotelDetailsPage openDetailedHotelInformation(int hotelNumber) {
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
            detailHotelInformationButton.get(hotelNumber - 1).click();
            ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(newTab.get(1));
            return new HotelDetailsPage(driver);
    }

    public String getSearchNotFoundResult() throws InterruptedException {
        return this.notFound.getText();
    }
}
