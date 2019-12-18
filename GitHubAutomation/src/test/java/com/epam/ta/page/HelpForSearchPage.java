package com.epam.ta.page;

import com.epam.ta.util.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HelpForSearchPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"bookingcomplex-name\"]")
    private WebElement editNameField;

    @FindBy(xpath = "//*[@id=\"bookingcomplex-phone\"]")
    private WebElement editPhoneNumberField;

    @FindBy(xpath = "//*[@id=\"bookingcomplex-email\"]")
    private WebElement editEmailField;

    @FindBy(xpath = "//*[@id=\"booking-form-complex-1\"]/div[2]/div[6]/div[3]/div/div/i")
    private WebElement inputError;

    public HelpForSearchPage(WebDriver webDriver) {
        super(webDriver);
        driver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public HelpForSearchPage openPage(){
        return this;
    }

    public boolean enterContactValues(String incorrectEmail){
        this.editNameField.click();
        this.editNameField.sendKeys(StringUtils.NAME);
        this.editPhoneNumberField.click();
        this.editPhoneNumberField.sendKeys(StringUtils.PHONE_NUMBER);
        this.editEmailField.click();
        this.editEmailField.sendKeys(incorrectEmail);
        if(inputError.isDisplayed()){
            return false;
        }
        return true;
    }


}
