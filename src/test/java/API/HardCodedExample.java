package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExample {
    //baseURI will append to an endpoint eg:/createEmployee.php. So we won't see baseURI being explicitly used.
    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3MTA3ODU5NjcsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTcxMDgyOTE2NywidXNlcklkIjoiNjQzOSJ9.AB9UgxwfvDao8Rn33g-PsNdaoAbLk_hw8r4YTY4FQ54";
    static String employee_id;

    @Test
    public void acreateEmployee(){
        //it will create the request
        RequestSpecification request = given().
                header("Content-Type","application/json").
                header("Authorization",token).
                body("{\n" +
                        "  \"emp_firstname\": \"Loser\",\n" +
                        "  \"emp_lastname\": \"Trump\",\n" +
                        "  \"emp_middle_name\": \"BetaMale\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"1986-03-29\",\n" +
                        "  \"emp_status\": \"permanent\",\n" +
                        "  \"emp_job_title\": \"Felon\"\n" +
                        "}");
        //it will give us the response after hitting the endpoint
        Response response =  request.when().post("/createEmployee.php");

        //assertThat is the method we use to validate the response
        response.then().assertThat().statusCode(201);
        //this method is used to print the response in console
        response.prettyPrint();
        //hamcrest matchers
        response.then().assertThat().body("Message", equalTo("Employee Created"));
        response.then().assertThat().body("Employee.emp_firstname", equalTo("Loser"));
        response.then().assertThat().body("Employee.emp_lastname", equalTo("Trump"));
        response.then().assertThat().header("Connection",equalTo("Keep-Alive"));
        //to fetch the employee id from response body, we need response variable
        employee_id = response.jsonPath().getString("Employee.employee_id");


    }

    @Test
    public void bgetCreatedEmployee(){
        //prepare the request
        RequestSpecification request = given().
                header("Content-Type","application/json").
                header("Authorization",token).
                queryParam("employee_id",employee_id);

        //hitting the endpoint
        Response response = request.when().get("/getOneEmployee.php");
        //validate the response
        response.then().assertThat().statusCode(200);
        response.prettyPrint();

        String temporaryEmpId = response.jsonPath().getString("employee.employee_id");
        //here we are comparing both emp id's from get and post call
        Assert.assertEquals(temporaryEmpId,employee_id);
        //validate the body from get call
        response.then().assertThat().
                body("employee.emp_lastname",equalTo("Trump"));
        response.then().assertThat().
                body("employee.emp_firstname",equalTo("Loser"));

    }

    @Test
    public void cUpdateEmployee(){
        //prepare the request
        RequestSpecification request = given().
                header("Content-Type","application/json").
                header("Authorization",token).
                body("{\n" +
                        "  \"employee_id\": \""+employee_id+"\",\n" +
                        "  \"emp_firstname\": \"Loser\",\n" +
                        "  \"emp_lastname\": \"trump\",\n" +
                        "  \"emp_middle_name\": \"BetaMale\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2014-03-09\",\n" +
                        "  \"emp_status\": \"Permanent\",\n" +
                        "  \"emp_job_title\": \"felon\"\n" +
                        "}");

        //hitting the endpoint
        Response response = request.when().put("/updateEmployee.php");
        //validation of response
        response.then().assertThat().statusCode(200);
        response.then().assertThat().
                body("Message",equalTo("Employee record Updated"));
        response.prettyPrint();
    }

    @Test
    public void dGetUpdatedEmployee(){
        //prepare the request
        RequestSpecification request = given().
                header("Content-Type","application/json").
                header("Authorization",token).
                queryParam("employee_id",employee_id);

        Response response = request.when().get("/getOneEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }






}
