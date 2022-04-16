package stepDefinationss;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import io.restassured.path.json.JsonPath;
import pojo.addNewPlace;
import pojo.location;
import resources.apiResources;
import resources.testDataBuilder;
import resources.utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import static org.junit.Assert.*;
import io.cucumber.junit.CucumberOptions;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;

@RunWith(Cucumber.class)
public class firstStepDefinationss extends utils {
	public static String place_id;
	RequestSpecification me1;
	ResponseSpecification ress;
	Response me2;
	testDataBuilder x=new testDataBuilder();
	@Given("Add place payload {string} {string} {string}")
	public void add_place_payload(String name, String language, String address) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		me1=given().log().all().spec(requestSpecificationn()).body(x.getting(name,language,address));
	}



	@When("user call {string} API with {string} http request")
	public void user_call_API_with_http_request(String resource, String method) {
	    // Write code here that turns the phrase above into concrete actions
		apiResources mine=
				apiResources.valueOf(resource);
				ress=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
				if(method.equalsIgnoreCase("post")) {
				me2=me1.when().post(mine.getResource());
				}
				else
					if(method.equalsIgnoreCase("Get")) {
						me2=me1.when().get(mine.getResource());
					}
	}

	@Then("the APIS call is success with status code {int}")
	public void the_APIS_call_is_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(me2.getStatusCode(),200);
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {
	    // Write code here that turns the phrase above into concrete actions
		 
		   assertEquals(getValue(key,me2),value);
		 
	}
	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_Id_created_maps_to_using(String string, String getplaceapi) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		 place_id= getValue("place_id",me2);
		
		
		me1=given().spec(requestSpecificationn()).queryParam("place_id",place_id );
		user_call_API_with_http_request(getplaceapi,"post");
		String x=getValue("name",me2);
		assertEquals(x,string); 
		
			
		
		
	    
	}

	@Given("DeletePlace payload")
	public void deleteplace_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		me1=given().spec(requestSpecificationn()).body(x.dletePlacePayLoad(place_id));
	    
	}

	

	





	







}
