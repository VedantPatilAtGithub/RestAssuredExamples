package RestAssuredTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Test1_GET {
	@Test
	void test01() {
		Response response= RestAssured.get("https://reqres.in/api/users?page=2");
		
		System.out.println	(response.getBody().asString());
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	@Test
	void test02() {
		given().get("https://reqres.in/api/users?page=2").then().body("data.id[0]", equalTo(7)).log().all();
		given().get("https://reqres.in/api/users?page=2").then().body("data[0].first_name", equalTo("Michael"));
		given().get("https://reqres.in/api/users?page=2").then().body("data.first_name", hasItems("Michael", "Lindsay"));
	}
}
