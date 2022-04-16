package resources;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.specification.RequestSpecification;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class utils {
	public static RequestSpecification reqq;
	
	public RequestSpecification requestSpecificationn() throws IOException {
		if(reqq==null) {
	PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));	
		
		reqq=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURl")).addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).addQueryParam("key","qaclick123" ).build();
	return reqq;
		}
		return reqq;
	}
	public static String getGlobalValue(String key)throws IOException{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\ok\\eclipse-workspace\\APIFramework\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
	}
	public String getValue(String key,Response res) {
		String responseToString=res.asString();
		JsonPath js=new JsonPath( responseToString);
		return js.getString(key);
		
	}

}
