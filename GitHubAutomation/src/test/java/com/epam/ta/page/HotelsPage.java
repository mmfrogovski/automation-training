package com.epam.ta.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HotelsPage extends AbstractPage{
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div[2]/div[2]/a")
    private WebElement tag;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div[1]/a")
    private WebElement getMapBtn;

    public HotelsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public HotelsPage openPage(){
        return this;
    }

    public String getTag(){
        return tag.getText();
    }

    public MapPage getHotelsOnMap(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.getMapBtn.click();
        return new MapPage(driver);
    }

}
