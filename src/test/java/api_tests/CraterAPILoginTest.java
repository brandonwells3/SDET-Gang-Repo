package api_tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.BrowserUtils;
import org.testng.Assert;
import static io.restassured.RestAssured.*;

public class CraterAPILoginTest {
	private static String token;

	BrowserUtils utils = new BrowserUtils();
	Response response;
		
	@BeforeTest
	public void setup() {
		baseURI = "http://crater.primetech-apps.com/api/v1";
	}
	
	//DONE
	@Test(priority = 1)
	public void getLoginStatus() {
		String endpoint = "/auth/login";
		String requestBody = "{\n"
				+ "    \"username\": \"entityadmin@primetechschool.com\",\n"
				+ "    \"password\" : \"primetech@school\",\n"
				+ "    \"device_name\":\"mobile_app\"\n"
				+ "}";
				
		
		response = given().header("Company", "1").accept(ContentType.JSON).contentType("application/json").body(requestBody).post(endpoint).thenReturn();
		
		System.out.println(response.getBody().asString());
		Assert.assertEquals(response.getStatusCode(), 200);
		
		token = response.jsonPath().get("token");
	}
	
	//DONE
	@Test (priority = 2)
	public void getLogoutStatus() {
		String endpoint = "/auth/logout";
		
		response = given().header("Authorization", "Bearer " + token).header("Company", "1").accept(ContentType.JSON).contentType("application/json").post(endpoint).thenReturn();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(response.getStatusCode());
	}
	
	//DONE
	@Test
	public void getIncorrectEnd() {
		String endpoint = "/auth/log";
		String requestBody = "{\n"
				+ "    \"username\": \"entityadmin@primetechschool.com\",\n"
				+ "    \"password\" : \"primetech@school\",\n"
				+ "    \"device_name\":\"mobile_app\"\n"
				+ "}";
				
		
		response = given().header("Authorization", "Bearer " + token).header("Company", "1").accept(ContentType.JSON).contentType("application/json").body(requestBody).post(endpoint).thenReturn();
		
		Assert.assertEquals(response.getStatusCode(), 404);
		System.out.println(response.getStatusCode());
		
	}
	
	//DONE
	@Test
	public void getWrongBody() {
		String endpoint = "/auth/login";
		String requestBody = "{\n"
				+ "    \"usname\": \"entityadmin@primetechschool.com\",\n"
				+ "    \"paword\" : \"primetech@school\",\n"
				+ "    \"dee_name\":\"mobile_app\"\n"
				+ "}";
				
		
		response = given().header("Authorization", "Bearer " + token).header("Company", "1").accept(ContentType.JSON).contentType("application/json").body(requestBody).post(endpoint).thenReturn();
		
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 422);

	}
	
	//DONE
	@Test
	public void getWrongCreds() {
		String endpoint = "/auth/login";
		String requestBody = "{\n"
				+ "    \"username\": \"entitoadmin@primetechschool.com\",\n"
				+ "    \"password\" : \"primet3ch@school\",\n"
				+ "    \"device_name\":\"mobile_app\"\n"
				+ "}";
				
		
		response = given().header("Company", "1").accept(ContentType.JSON).contentType("application/json").body(requestBody).put(endpoint).thenReturn();
		
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 405);

	}
	
}
