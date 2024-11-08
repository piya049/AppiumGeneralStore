package org.ps.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.ps.utils.AndroidActions;

import java.util.List;

public class ProductCatalogue extends AndroidActions {
    AndroidDriver androidDriver;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
    public List<WebElement> addToCart;

    @AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
    public WebElement cart;



    public ProductCatalogue(AndroidDriver androidDriver) {
        super(androidDriver);
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);

    }

    public void addItemToCartByIndex(int index)
    {
        addToCart.get(index).click();
    }

    public CartPage goToCartPage() throws InterruptedException {
        cart.click();
        Thread.sleep(2000);
        return new CartPage(androidDriver);
    }
}
