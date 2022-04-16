package resources;

public enum apiResources {
	AddPlaceAPI("/maps/api/place/add/json"),
	GetPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/DELETE/json");
	private String resource;
	apiResources(String resource){
		this.resource=resource;
	}
	public String getResource() {
		return resource;
	}

}
