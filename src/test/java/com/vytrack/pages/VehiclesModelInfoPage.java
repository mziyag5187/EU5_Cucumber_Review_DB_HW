package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehiclesModelInfoPage extends BasePage {

    @FindBy(css = "div.control-label")
    public List<WebElement> labelsOfModelInfos;

    public Map<String,String> getModelInfosAsMap(){

            Map<String,String> modelInfos = new HashMap<>();

            for(int i=1; i<=labelsOfModelInfos.size(); i++){
                String labelName = Driver.get().findElement(By.xpath("(//label[@class='control-label'])["+i+"]")).getText();
                String labelValue = Driver.get().findElement(By.xpath("(//div[@class='control-label'])["+i+"]")).getText();
                modelInfos.put(labelName,labelValue);
            }
            return modelInfos;
    }




}
