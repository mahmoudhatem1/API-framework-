package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.addNewPlace;
import pojo.location;

public class testDataBuilder {
	public addNewPlace getting(String name,String language,String address) {
		addNewPlace myplace=new addNewPlace();
		myplace.setAccuracy(50);
		myplace.setAddress(address);
		myplace.setLanguage(language);
		myplace.setName(name);
		myplace.setPhone_number("(+91) 983 893 3937");
		myplace.setWebsite("http://google.com");
		location myLocation=new location();
		myLocation.setLat(-38.383494);
		myLocation.setLng(33.427362);
		myplace.setLocation(myLocation);
		List<String> myList=new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		myplace.setTypes(myList);
		return myplace;
	}
	public String dletePlacePayLoad(String id) {
		return "{\\r\\n    \\\"place_id\\\":\\\""+id+"\\\"\\r\\n}\\r\\n";
	
}
}