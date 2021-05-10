package RestAssuredTestCases;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Test5_DELETE {
	@Test
	public void test1() {
			
			given().
				delete("https://reqres.in/api/users/2").
			then().
			 statusCode(204).log().all();
	}
}
