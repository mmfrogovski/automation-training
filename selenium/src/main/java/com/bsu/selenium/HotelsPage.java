package com.bsu.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HotelsPage {
    private WebDriver webDriver;

    @FindBy(xpath = "/html/body/div[1]/header/div[8]/div[1]/div/div[2]")
    private WebElement findSearchLine;
    @FindBy(xpath = "/html/body/div[1]/div[4]/div[3]/div/div/div[2]/input[2]")
    private WebElement searchLine;
    @FindBy(xpath = "/html/body/div[1]/div[4]/div[4]/div/div[9]/div/span")
    private WebElement getCity;
    @FindBy(xpath = "/html/body/div[1]/div[4]/div[4]/div/div/div/span")
    private WebElement notFound;


    public HotelsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
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

    public HotelsPage getCity() {
        this.getCity.click();
        return this;
    }

    public String getSearchNotFoundResult() throws InterruptedException {
        return this.notFound.getText();
    }
}
