package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

       /*
    This method will accept int (in seconds) and execute Thread.sleep for given
    duration
     */

    public static void sleep (int second){
        second *= 1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e){
        }
    }


    public static void switchWindowAndVerify(String expectedInUrl, String expectedInTitle){
        Set<String> allWindowsHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowsHandles){
            Driver.getDriver().switchTo().window(each);
            System.out.println("Current URL: "+ Driver.getDriver().getCurrentUrl());

            if(Driver.getDriver().getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }

        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }


    public static void verifyTitle(String expectedTitle){
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);

    }


/**
 * This method will verify if the current URL contains expected value
 * @param expectedInURL


 */
    public static void verifyURLContains(String expectedInURL){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInURL));


    }

    /**
     * This will method accept a dropdown as a WebElement
     * and return all the options' text in a List of String
     * @param dropdownElement
     * @return List<String> actualAsString
     */

    public static List<String> dropdownOptionsAsString(WebElement dropdownElement){
        Select select = new Select(dropdownElement);

        //All month <options> as a web element
        List<WebElement> actualOptionsAsWebElement =select.getOptions();

        //List of all ACTUAL month <options> as a string
        List<String> actualOptionsAsString = new ArrayList<>();

        for (WebElement each : actualOptionsAsWebElement) {
            actualOptionsAsString.add(each.getText());
        }

        return actualOptionsAsString;
    }


    /**
     * This method will accept a group radio buttons as a List of WebElement
     * It will loop through the List, and click to the radio button with provided attribute
     * @param radioButtons
     * @param attributeValue
     */

    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue){

        for (WebElement each : radioButtons){
            if (each.getAttribute("value").equalsIgnoreCase(attributeValue)){
                each.click();
            }
        }
    }
    }




