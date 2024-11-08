package org.ps;

import org.ps.pageObjects.ios.AlertViews;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSBasics extends BaseTest_IOS{

    @Test
    public void iosBasicTest(){

       AlertViews alertViews = homePage.selectAlertViews();
       alertViews.selectTextMenu("Hello World");
       String actualMsg = alertViews.getConfirmMsg();
       Assert.assertEquals(actualMsg, "A message should be short, complete sentence");

    }
}
