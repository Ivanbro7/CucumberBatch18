package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class HardCodedExample2HW {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3MTA3ODU5NjcsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTcxMDgyOTE2NywidXNlcklkIjoiNjQzOSJ9.AB9UgxwfvDao8Rn33g-PsNdaoAbLk_hw8r4YTY4FQ54";
    static String employee_id;


    //@Test
    public void aGetAllEmployees(){

        RequestSpecification request = given().
                header("Authorization",token);

        Response response = request.when().get("/getAllEmployees.php");
        response.prettyPrint();
        response.then().statusCode(200);

    }

    //@Test
    public void bGetJobTitle(){

        RequestSpecification request = given().
                header("Authorization",token);

        Response response = request.when().get("/jobTitle.php");
        response.prettyPrint();
        response.then().statusCode(200);

    }

    @Test
    public void cPartiallyUpdateEmployee(){

        RequestSpecification request = given().
                header("Authorization",token).
                header("Content-Type","application/json").
                body("{\n" +
                        "  \"employee_id\": \"106027A\",\n" +
                        "  \"emp_job_title\": \"Psychopath\"\n" +
                        "}");

        Response response = request.when().patch("/updatePartialEmplyeesDetails.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(201);
        response.then().assertThat().body("Message", equalTo("Employee record updated successfully"));

    }
}
