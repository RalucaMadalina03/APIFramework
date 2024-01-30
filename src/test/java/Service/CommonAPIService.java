package Service;

import Rest.RestRequest;
import Rest.RestRequestType;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CommonAPIService {

    // Aceasta clasa contine metode pt tipuri de request-uri cu diferiti parametri

    public Response post(Object body,String url){
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.body(body);

        // de pus Logg-uri pt request si response

        Response response = performRequest(RestRequestType.RequestPost,requestSpecification,url);
        return response;

    }
    public Response post(String url,String token){
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Authorization","Bearer" + token);


        // de pus Logg-uri pt request si response

        Response response = performRequest(RestRequestType.Requestget,requestSpecification,url);
        return response;

    }
    // FAcem o instanta de RestRequest care sa apeleze metoda de perform

    private Response performRequest(String requestType,RequestSpecification requestSpecification, String URL ){

        return new RestRequest().performRequest(requestType,requestSpecification,URL);
    }
}
