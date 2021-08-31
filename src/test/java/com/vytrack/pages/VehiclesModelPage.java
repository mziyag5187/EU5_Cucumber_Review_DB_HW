package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class VehiclesModelPage extends BasePage{



    public void clickToModel(String modelName){
        String xpath ="//td[@data-column-label='Model Name'][.='"+modelName+"']/..";
        WebElement model = Driver.get().findElement(By.xpath(xpath));
        BrowserUtils.waitFor(3);
        model.click();
    }






}
