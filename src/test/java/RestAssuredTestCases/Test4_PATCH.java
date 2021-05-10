package RestAssuredTestCases;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Test4_PATCH {
	@Test
	public void test1() {

			JSONObject request = new JSONObject();
			
			request.put("name", "Vedant");
			request.put("job", "Automation Developer");
		
			System.out.println(request);
			
			given().
				header("ContentType", "application/json").
				contentType(ContentType.JSON).accept(ContentType.JSON).
				body(request.toJSONString()).
			when().
				patch("https://reqres.in/api/users/2").
			then().
			 statusCode(200).log().all();
			
			
	}
}
