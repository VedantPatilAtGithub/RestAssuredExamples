package LocalDataTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;


public class Test1 {

	public void test1() {
	//Response response = get("http://localhost:3000/users?id=2");
	baseURI = "http://localhost:3000";
			
			
	given().
		param("firstName", "Vedant").
		get("/users").
	then().
		statusCode(200).
		log().
		all();
	}
@Test
	public void test2() {
	
	baseURI = "http://localhost:3000";
	
	JSONObject request = new JSONObject();
	
	request.put("firstName", "Tom");
	request.put("lastName", "Cooper");
	request.put("subjectId", 1);

	
	given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		header("ContentType", "application/json").
		body(request.toJSONString()).
		post("/users").
		then().
		 statusCode(201).
		 log().all();
	}
@Test
public void test3() {
	
	baseURI = "http://localhost:3000";
	
	JSONObject request = new JSONObject();
	
	request.put("firstName", "Jerry");
	
	given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		header("ContentType", "application/json").
		body(request.toJSONString()).
		patch("/users/4").
		then().
		 statusCode(200).
		 log().all();
	}

}
