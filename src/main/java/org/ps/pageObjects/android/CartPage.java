package org.ps.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.ps.utils.AndroidActions;

import java.util.List;

public class CartPage extends AndroidActions {
    AndroidDriver androidDriver;

    public CartPage(AndroidDriver androidDriver) {
        super(androidDriver);
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    private List<WebElement> productList;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement totalAmount;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
    private WebElement terms;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement acceptButton;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
    private WebElement proceed;

    @AndroidFindBy(className = "android.widget.CheckBox")
    private WebElement checkBox;


    public List<WebElement> getProductList() {
        return productList;
    }

    public double getProductSum(){
        int count  = productList.size();
        double totalSum =0;
        for (int i = 0; i<count; i++){
            String amountString =productList.get(i).getText();
            Double price =getFormattedAmount(amountString);
            totalSum = totalSum + price;
        }
        return totalSum;
    }

    public Double getTotalAmountADisplayed(){
        return getFormattedAmount(totalAmount.getText());
    }

    public void acceptTermsConditions(){
        longPressAction(terms);
        acceptButton.click();
    }

    public Double getFormattedAmount(String amount){
        Double price = Double.parseDouble(amount.substring(1));
        return price;
    }

    public void submitOrder(){

        checkBox.click();
        proceed.click();
    }

}
