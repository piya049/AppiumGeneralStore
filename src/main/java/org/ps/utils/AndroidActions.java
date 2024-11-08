package org.ps.utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class AndroidActions {

    public AndroidDriver androidDriver;

    public AndroidActions(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    public void longPressAction(WebElement ele){
        ((JavascriptExecutor)androidDriver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",
                ((RemoteWebElement)ele).getId(), "duration", 2000));
    }

    public void scrollToEndAction(){
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean)
                    ((JavascriptExecutor)androidDriver).executeScript("mobile: longClickGesture", ImmutableMap
                            .of("left", 100, "top", 100, "width", 200, "height", 200,
                                    "direction", "down",
                                    "percent", 3.0));
        } while(canScrollMore);
    }

    public void scrollToText(String text){
        androidDriver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))"));
    }

    public void swipeAction(WebElement ele, String direction){
        ((JavascriptExecutor)androidDriver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
                ((RemoteWebElement)ele).getId(), "direction", direction,
                "percent", 0.75));

    }

    public Double getFormattedAmount(String amount){
        Double price = Double.parseDouble(amount.substring(1));
        return price;
    }

}
