package api.test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.Scanner;
import java.util.regex.Pattern;

import org.hamcrest.Matcher;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import api.payload.TestData;
import io.restassured.response.Response;

public class ValidateJsonResponseData {
	


	@Test(priority = 1)
	void testJsonResposeData() throws JsonMappingException, JsonProcessingException {
		int i = 0;
		Response res;
		res = given().contentType("ContentType.JSON").when().get("http://localhost:3000/EmployeeDetail");		
		JSONObject jsonObject = new JSONObject(res.asString());

//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter name: ");
//		String a = sc.nextLine();

		boolean breakLoop = false;
	      while (!breakLoop) {
			for (i = 0; i < jsonObject.getJSONArray("Employee").length(); i++) {
				String employeeName = jsonObject.getJSONArray("Employee").getJSONObject(i).get("Name").toString();
				if (jsonObject.getJSONArray("Employee").getJSONObject(2).get("Name").toString().equalsIgnoreCase("Indira")) {
					breakLoop = true;
					System.out.println(jsonObject.getJSONArray("Employee").getJSONObject(2).get("Address").toString());
				} else {
					System.err.println("No Record");
					breakLoop = true;
				}
			}
		}
	}
		
//		@Test(priority = 2)
//		void testData(int i) {
//			
//			i=0;
//			
//			Response res;
//			res = given().contentType("ContentType.JSON").when().get("http://localhost:3000/EmployeeDetail");		
//			JSONObject jsonObject = new JSONObject(res.asString());
//			
//			Scanner sc = new Scanner(System.in);
//			System.out.println("Which city address do you want: ");
//			String city = sc.nextLine();
//			for (int j=0; j<jsonObject.getJSONArray("Employee").getJSONObject(i).getJSONArray("Address").length(); j++) {
//
//			
//			String Address = jsonObject.getJSONArray("Employee").getJSONObject(i).getJSONArray("Address[j]").toString();
//			System.out.println(Address);
//		}
	      
	      

//
//	    	
//	    	
//	    	
//	    	if(jsonObject.getJSONArray("Employee").getJSONObject(i).get("Name").toString())

//	    	System.out.println(a);
//	    	System.out.println(employeeName);

//	    	switch (a) {
//	    		case "Rajesh":
//	    			System.out.println("Which city address do you want? ");
//	    			city = sc.nextLine();
//	    	    	String cityName = jsonObject.getJSONArray("Employee").getJSONObject(0).getJSONObject("Address1").toString();
//	    	    	
//	    	    	String cityName1 = JsonPath.read(cityName, "$..*").toString();
//	    	    	
//	    	        System.out.println(cityName1);
//
//	    	    	if (jsonObject.getJSONArray("Employee").getJSONObject(0).getJSONObject("Address1").get("city").toString().equalsIgnoreCase(city)) {  	    				
//	    	    				
//	    	    		System.out.println(a+ " " +city+ " address is " +jsonObject.getJSONArray("Employee").getJSONObject(0).getJSONObject("Address1").toString());
//	    	    	} else if(jsonObject.getJSONArray("Employee").getJSONObject(0).getJSONObject("Address2").get("city").toString().equalsIgnoreCase(city)) {
//	    	    		System.out.println(a + " " + city + " address is " + jsonObject.getJSONArray("Employee").getJSONObject(0).getJSONObject("Address2").toString());
//	    	    	} else if(jsonObject.getJSONArray("Employee").getJSONObject(0).getJSONObject("Address3").get("city").toString().equalsIgnoreCase(city)) {
//	    	    		System.out.println(a + " " + city + " address is " + jsonObject.getJSONArray("Employee").getJSONObject(0).getJSONObject("Address3").toString());
//	    	    	}
//	    	    	break;
//	    	}

	}

