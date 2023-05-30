package IbmRestAssured.RestAssuredProject;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.then;
public class RestAPITesting {
	
	@Test(enabled = false)
	public void firsttestcase() {
		Response object = RestAssured.get("https://petstore.swagger.io/v2/pet/1");
		System.out.println("Statuscode => " + object.statusCode());
		System.out.println("Response Body =>" + object.asString());
		System.out.println("Pretty Response Body =>" + object.prettyPrint());
		System.out.println("Status line =>" + object.statusLine());
	
	}

	@Test
	public void secondtestcase() {
		given()
		.get("https://petstore.swagger.io/v2/pet/1")
		.then()
		.statusCode(200);
	}

	@Test
	public void postmethod() {
		
		String payload = "{\"Name\":\"Srinivas\",\"title\":\"json-server\",\"author\":\"typicode\"}";
		System.out.println(payload);
		
		given() 
		   .headers("content-type", "application/json")
		   .body(payload).
		 when()
		 .post("http://localhost:3000/employee").
		 then()
			.statusCode(201).log().all();
		}

	@Test
	public void putmethod() {
		
		String payload = "{\"Name\":\"Srinivas\",\"title\":\"software engineer\",\"author\":\"typicode\"}";
		System.out.println(payload);
		
		given() 
		   .headers("content-type", "application/json")
		   .body(payload).
		 when()
		 .put("http://localhost:3000/employee/4").
		 then()
			.statusCode(200).log().all();
		}

	@Test
	public void patchmethod() {
		
		String payload = "{\"title\":\"Testing engineer\"}";
		System.out.println(payload);
		
		given() 
		   .headers("content-type", "application/json")
		   .body(payload).
		 when()
		 .patch("http://localhost:3000/employee/4").
		 then()
			.statusCode(200).log().all();
		}	
	@Test
	public void getmethod() {
		
	//	String payload = "{\"title\":\"Testing engineer\"}";
	//	System.out.println(payload);
		
	//	given() 
		//   .headers("content-type", "application/json")
		 //  .body(payload).
		 when()
		 .get("http://localhost:3000/employee").
		 then()
			.statusCode(200).log().all();
		}
	
	@Test
	public void deletemethod() {
		
	//	String payload = "{\"title\":\"Testing engineer\"}";
	//	System.out.println(payload);
		
	//	given() 
		//   .headers("content-type", "application/json")
		 //  .body(payload).
		 when()
		 .delete("http://localhost:3000/employee/4").
		 then()
			.statusCode(200).log().all();
		}
	
	@Test
	public void getmethod1() {
		
	//	String payload = "{\"title\":\"Testing engineer\"}";
	//	System.out.println(payload);
		
	//	given() 
		//   .headers("content-type", "application/json")
		 //  .body(payload).
		Response obj =  when()
		 .get("http://localhost:3000/employee/3").
		 then()
			.statusCode(200).log().all().extract().response();
		
		 String actualname = obj.jsonPath().getString("Name");
		 System.out.println("actualname");
		 
//	Assert.assertEquals("Srinivas", actualname);
	Assert.assertEquals("Srinivas", actualname);
		 
	}
	
//##########################################################
	
	@Test
	public void Jsonbody() {
		
		JSONObject jsonbody = new JSONObject();
		
		jsonbody.put("Name", "Srinivas");
		jsonbody.put("title", "json-server");
		jsonbody.put("author", "typecode");
		
		System.out.print(jsonbody);
		
	}
	
	@Test
	public void Jsonbody1() {
		
		JSONObject jsonrootbody = new JSONObject();
		
		jsonrootbody.put("id", 0);
		jsonrootbody.put("Name", "Srinivas");
		jsonrootbody.put("status", "Available");
		
		JSONObject categoryobject = new JSONObject();
		
		JSONObject tagsobject = new JSONObject();
		
		categoryobject.put("id", 0);
		categoryobject.put("Name", "Mahasvin");
		
		tagsobject.put("id", 0);
		tagsobject.put("Name", "Mahasvin");
		
		jsonrootbody.put("category", categoryobject);
		jsonrootbody.put("tags" , tagsobject);
		
		
		
		System.out.print(jsonrootbody);
		
	}
	
	
}
