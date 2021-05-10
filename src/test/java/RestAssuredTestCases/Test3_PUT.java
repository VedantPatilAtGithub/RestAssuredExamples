package RestAssuredTestCases;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Test3_PUT {
	@Test
	public void test1() {

			JSONObject request = new JSONObject();
			
			request.put("name", "Raj");
			request.put("job", "Automation Developer");
		
			System.out.println(request);
			
			given().
				header("ContentType", "application/json").
				contentType(ContentType.JSON).accept(ContentType.JSON).
				body(request.toJSONString()).
			when().
				put("https://reqres.in/api/uers/2").
			then().
			 statusCode(200).log().all();
			
			
	}
}
