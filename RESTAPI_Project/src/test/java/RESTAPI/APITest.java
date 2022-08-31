package RESTAPI;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


public class APITest {
    @Test

    //Get Random UserID and print its email address to the console
    public void GetRandomUserID() {
        Response response =when().get("https://jsonplaceholder.typicode.com/users?id=2")
                .then().assertThat().statusCode(200).extract().response();
        String responsemessage = response.asString();
        System.out.println(responsemessage);
        JsonPath jsonPath = new JsonPath(responsemessage);
        String Email = jsonPath.getString("email");
        System.out.println("The user email address: "+Email);
    }
    /*--------------------------------------------------------*/
    @Test
    //Get this user's associated posts and do a post using same userID  with a non-empty title and body
    public void Post() {
        Response response = given().contentType(
                ContentType.JSON).when().get("https://jsonplaceholder.typicode.com/posts?userId=2")
                .then().assertThat().statusCode(200).extract().response();
        String responsemessage = response.asString();
        System.out.println(responsemessage);
        JsonPath jsonPath = new JsonPath(responsemessage);
        String Posts = jsonPath.getString("title");
        System.out.println("User Posts: "+Posts);

    }
}
