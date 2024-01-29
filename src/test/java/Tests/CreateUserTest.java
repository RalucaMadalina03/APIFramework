package Tests;

import RequestObject.RequestAcount;
import RequestObject.RequestAcountToken;
import ResponseObject.ResponseAccountSuccess;
import ResponseObject.ResponseTokenSuccess;
import com.beust.ah.A;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateUserTest {


    public String userID;
    public String username;
    public String password;
    public String token;

    @Test
    public void MetodaTest(){
        System.out.println("Step one : Create user");
        createUser();
        System.out.println("Step 2 : Generate Token ");
        generateToken();
        System.out.println("Step 3 : Optain new user ");
        interractNewUser();
    }

    public void createUser(){
        // Definim caracteristicile clientului
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://demoqa.com");
        requestSpecification.contentType("application/json");


        // Configuram request- ul

         username = "Mada" + System.currentTimeMillis();
         password = "Madalina01!";

//        JSONObject requestbody = new JSONObject();
//        requestbody.put("userName" , username);
//        requestbody.put("password" , "Madalina01!");

        RequestAcount requestAcount = new RequestAcount(username,password);
        requestSpecification.body(requestAcount);


        // Accesam response-ul

        Response response = requestSpecification.post("/Account/v1/User");
        ResponseBody body = response.getBody();
        body.prettyPrint();

        // Validam statusul reqestului

        // System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),201);

        //Validam respons body

        ResponseAccountSuccess responseAccountSuccess = response.body().as(ResponseAccountSuccess.class);

        Assert.assertNotNull(responseAccountSuccess.getUserID()); // verificam ca exista o valoare pt field
        Assert.assertEquals(responseAccountSuccess.getUsername(),username);
        Assert.assertNotNull(responseAccountSuccess.getBooks());

        userID = responseAccountSuccess.getUserID();

    }

    // Facem un request care ne genereaza un Token


    public  void generateToken() {

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://demoqa.com");
        requestSpecification.contentType("application/json");

        RequestAcountToken requestAcountToken = new RequestAcountToken(username, password);
        requestSpecification.body(requestAcountToken);

        // Accesam response-ul

        Response response = requestSpecification.post("/Account/v1/GenerateToken");
        ResponseBody body = response.getBody();
        body.prettyPrint();

        Assert.assertEquals(response.getStatusCode(),200);
        ResponseTokenSuccess responseTokenSuccess = response.body().as(ResponseTokenSuccess.class);

        Assert.assertNotNull(responseTokenSuccess.getToken()); // verificam ca exista o valoare pt field
        Assert.assertNotNull(responseTokenSuccess.getExpires());
        Assert.assertEquals(responseTokenSuccess.getStatus(),"Success");
        Assert.assertEquals(responseTokenSuccess.getResult(),"User authorized successfully. ");

        token = responseTokenSuccess.getToken();

    }
// Facem un get pentru userul creat

    public void interractNewUser(){

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://demoqa.com");
        requestSpecification.contentType("application/json");
        requestSpecification.header("Authorization","Bearer" + token);

        Response response = requestSpecification.get("/Account/v1/User/"+ userID ); // compunere de endpoint din url-uri

        Assert.assertEquals(response.getStatusCode(),200);
        ResponseAccountSuccess responseAccountSuccess = response.body().as(ResponseAccountSuccess.class);

        Assert.assertNotNull(responseAccountSuccess.getUserId()); // verificam ca exista o valoare pt field
        Assert.assertEquals(responseAccountSuccess.getUsername(),username);
        Assert.assertNotNull(responseAccountSuccess.getBooks());



    }
    }


