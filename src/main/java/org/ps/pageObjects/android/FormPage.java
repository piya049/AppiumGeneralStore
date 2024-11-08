package org.ps.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.ps.utils.AndroidActions;

public class FormPage extends AndroidActions {

    AndroidDriver androidDriver;

    public FormPage(AndroidDriver androidDriver) {
        super(androidDriver);
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
    }

    @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
    private WebElement nameField;

    @AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
    private WebElement femaleOption;

    @AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
    private WebElement maleOption;

    @AndroidFindBy(id="android:id/text1")
    private WebElement selectCountry;


    @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
    private WebElement shopButton;

    public void setNameField(String name){
        nameField.sendKeys(name);
        androidDriver.hideKeyboard();
    }

    public void setGender(String gender) {

        if(gender.contains("Female")){
            femaleOption.click();
        }
        else maleOption.click();

    }


    public void setSelectCountry(String country){
        selectCountry.click();
        scrollToText(country);
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Canada']" )).click();
    }

    public ProductCatalogue submitForm(){

        shopButton.click();
        return new ProductCatalogue(androidDriver);
    }


}
