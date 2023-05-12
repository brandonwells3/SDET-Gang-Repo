package api_tests;

import static org.testng.Assert.*;
import java.io.File;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import static io.restassured.RestAssured.*;

public class CraterAPIToken {


String baseUrl="http://crater.primetech-apps.com/";
	public static String  token;
	
	
	@Test(priority=0,groups="tokenValidation")
	public void validLogin() {
		String endPoint="api/v1/auth/login";
		String jsonBodyString="{\r"
				+ "\"username\":\"entityadmin@primetechschool.com\",\r"
				+ "\"password\":\"primetech@school\",\r\n"
				+ "\"device_name\":\"mobile_app\"\r"
				+ "}\r";
		Response  response=given().accept(ContentType.JSON)
		.contentType("application/json").header("Company",1).and()
		.body(jsonBodyString)
		.when().post(baseUrl+endPoint);
		//response.prettyPrint();
		
		String jsonString = response.asString();
		String actualType=JsonPath.from(jsonString).get("type");
		String actulaToken=JsonPath.from(jsonString).get("token");
		
		token=actualType+" "+actulaToken;
		//System.out.println(token);
	}
	
	@Test(priority=1,dependsOnMethods="validLogin",groups="tokenValidation")
	public void tokenValidation() {
		String endPoint="api/v1/auth/check";
		
		Header someHeader = new Header("Authorization", token);

		Response response=given().accept(ContentType.JSON).contentType("application/json")
		.header(someHeader).get(baseUrl+endPoint);
		assertEquals(response.getStatusCode(), 200);
		assertEquals(response.asString(),"1");
		//response.prettyPrint();
	}
	
	@Test(priority=2,groups="tokenValidation")
	public void incorrectAuthorization() {
		String endPoint="api/v1/auth/check";
		String expectedResult="{\"message\":\"Unauthenticated.\"}";
		Header someHeader = new Header("Authorization", token+"asdf");

		Response response=given().accept(ContentType.JSON).contentType("application/json")
		.header(someHeader).get(baseUrl+endPoint);
		
		assertEquals(response.getStatusCode(), 401);
		assertEquals(response.asString(),expectedResult);
	}
	@Test(priority=3,groups="tokenValidation")
	public void incorrectEndPoint() {
		String endPoint="api/v1/auth/check"+1;
		
		Header someHeader = new Header("Authorization", token+"asdf");

		Response response=given().accept(ContentType.JSON).contentType("application/json")
		.header(someHeader).get(baseUrl+endPoint);
		
		assertEquals(response.getStatusCode(), 404);
		
	}
}
