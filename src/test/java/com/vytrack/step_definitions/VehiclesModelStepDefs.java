package com.vytrack.step_definitions;

import com.vytrack.pages.VehiclesModelPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.When;

public class VehiclesModelStepDefs {

    VehiclesModelPage vehiclesModelPage = new VehiclesModelPage();

    @When("the user clicks the {string} from List")
    public void the_user_clicks_the_from_List(String modelName) {
        BrowserUtils.waitFor(2);
        vehiclesModelPage.clickToModel(modelName);
    }


}
