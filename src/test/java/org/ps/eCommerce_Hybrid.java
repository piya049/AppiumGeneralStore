package org.ps;

import org.ps.pageObjects.android.CartPage;
import org.ps.pageObjects.android.ProductCatalogue;
import org.testng.Assert;
import org.testng.annotations.Test;

public class eCommerce_Hybrid extends BaseTest_Android {

    @Test
    public void fillForm() throws InterruptedException {

        formPage.setNameField("Piya");
        formPage.setGender("female");
        formPage.setSelectCountry("Canada");

//      androidDriver.findElements(By.xpath("//android.eidget.TextView[@text='ADD TO CART']")).get(0).click();
//      androidDriver.findElements(By.xpath("//android.eidget.TextView[@text='ADD TO CART']")).get(0).click();
//      androidDriver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        ProductCatalogue productCatalogue = formPage.submitForm();
        productCatalogue.addItemToCartByIndex(0);
        productCatalogue.addItemToCartByIndex(0);
        CartPage cartPage = productCatalogue.goToCartPage();

//        WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.attributeContains(androidDriver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

        double totalSum = cartPage.getProductSum();
        double displayFormattedSum = cartPage.getTotalAmountADisplayed();

        Assert.assertEquals(totalSum, displayFormattedSum);
        cartPage.acceptTermsConditions();

//      androidDriver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        cartPage.submitOrder();
        Thread.sleep(6000);

    }

}
