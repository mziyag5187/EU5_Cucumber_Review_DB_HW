package com.vytrack.step_definitions;

import com.vytrack.pages.VehiclesModelInfoPage;
import com.vytrack.utilities.DBUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class VehiclesModelInfoStepDefs {

    VehiclesModelInfoPage vehiclesModelInfoPage = new VehiclesModelInfoPage();

    @Then("the Vehicle model information should be same with database")
    public void the_Vehicle_model_information_should_be_same_with_database() {

        // actual result is the result coming from browser UI
        Map<String,String> actualMap = vehiclesModelInfoPage.getModelInfosAsMap();
        System.out.println("actualMap_From_UI = " + actualMap);

        String actualModelName = actualMap.get("Model Name");
        String actualMake = actualMap.get("Make");
        String actualCanBeRequested = actualMap.get("Can Be Requested");
        String actualFuelType = actualMap.get("Fuel Type");
        String actualVendors = actualMap.get("Vendors");

        // expected result is the result you got from db queries
        String query = "select ModelName, Make, Canberequested, FuelType_id, Vendors from oro_ext_vehiclesmodel\n" +
                "where ModelName = '"+actualModelName+"' and Make = 'Opel';";

        // we ran a query that give us expected result and stored it inside Map object
        Map<String,Object> expectedMap = DBUtils.getRowMap(query);
        System.out.println("expectedMap_From_DB = " + expectedMap);

        Assert.assertEquals(expectedMap.get("ModelName"), actualModelName);
        Assert.assertEquals(expectedMap.get("Make"), actualMake);
        //Assert.assertEquals(actualCanBeRequested,expectedMap.get("Canberequested"));
        Assert.assertEquals(expectedMap.get("FuelType_id"), actualFuelType.toLowerCase());
        Assert.assertEquals(expectedMap.get("Vendors"), actualVendors);


    }


}
