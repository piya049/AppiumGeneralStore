package org.ps;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.ps.pageObjects.ios.HomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest_IOS {

    public IOSDriver iosDriver;
    public AppiumDriverLocalService service;
    public HomePage homePage;


    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException {
        service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//Pshende//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone13 Pro");
        options.setApp("D://UIKitCatalog.app");
        options.setPlatformVersion("15.5");
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));
        iosDriver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
        iosDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage = new HomePage(iosDriver);

    }

    public void longPressAction(WebElement ele) {
        ((JavascriptExecutor) iosDriver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",
                ((RemoteWebElement) ele).getId(), "duration", 2000));
    }

    public void scrollToEndAction() {
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean)
                    ((JavascriptExecutor) iosDriver).executeScript("mobile: longClickGesture", ImmutableMap
                            .of("left", 100, "top", 100, "width", 200, "height", 200,
                                    "direction", "down",
                                    "percent", 3.0));
        } while (canScrollMore);
    }

    public void swipeAction(WebElement ele, String direction) {
        ((JavascriptExecutor) iosDriver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
                ((RemoteWebElement) ele).getId(), "direction", direction,
                "percent", 0.75));

    }

    public Double getFormattedAmount(String amount) {
        Double price = Double.parseDouble(amount.substring(1));
        return price;
    }

    @AfterClass
    public void tearDown() {
        iosDriver.quit();
        service.stop();
    }

}
