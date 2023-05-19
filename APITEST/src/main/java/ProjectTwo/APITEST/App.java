package ProjectTwo.APITEST;


import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.Assert;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
        Response getmethod	= get("https://reqres.in/api/users?page=2");
        
        getmethod.prettyPrint();

    	int statusCode = getmethod.statusCode();
    	System.out.println("Reponse staus code is "+statusCode);
    	Assert.assertEquals(statusCode, 200);
    	
    	if(statusCode ==200) {
    		System.out.println("API call was success");
    	} else {
    		System.out.println("API call failed.");
    	}
    	
    	
    	File ot = new File("C:\\Users\\asimf\\eclipse-workspace\\APITEST\\postbody.json");
    	
    	Response postmethod = given().contentType(ContentType.JSON).body(ot).post("https://reqres.in/api/users");
    	postmethod.prettyPrint();
    	
    	int statusCode2 = postmethod.statusCode();
    	System.out.println("Reponse staus code is "+statusCode2);
    	Assert.assertEquals(statusCode2,201);
    	
    }
}
