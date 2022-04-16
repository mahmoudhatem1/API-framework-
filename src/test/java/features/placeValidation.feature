Feature: Validating Place APIS
@Addplace
Scenario Outline: Verify if place is being succesfully added using AddPlace APIS
Given Add place payload "<name>" "<language>" "<address>"
When user call "AddPlaceAPI" API with "post" http request
Then the APIS call is success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And verify place_Id created maps to "<name>" using "GetPlaceAPI"
Examples:
		| name  | language | address              |
		| ahmedd | English  | world acrosss center |
@DeletePlace		
Scenario: verify if delete place functionality is working
Given DeletePlace payload
When user call "DeletePlaceAPI" API with "post" http request
		