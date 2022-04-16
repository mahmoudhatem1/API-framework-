package stepDefinationss;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {
		
		firstStepDefinationss toRunBefore =new firstStepDefinationss();
		if(firstStepDefinationss.place_id==null) {
		toRunBefore.add_place_payload("first", "second", "third");
		toRunBefore.user_call_API_with_http_request("AddPlaceAPI", "post");
		toRunBefore.verify_place_Id_created_maps_to_using("first","GetPlaceAPI");
		}
		}

}
