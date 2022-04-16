package Cucumberoptionss;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import io.restassured.RestAssured;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pojo.addNewPlace;
import pojo.location;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",plugin="json:target/jsonReportssss/cucumber-report.json",glue="stepDefinationss",tags= {"@Addplace"})
public class testRunnerr {
	
	
}
