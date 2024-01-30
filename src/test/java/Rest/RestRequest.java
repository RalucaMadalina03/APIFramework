package Rest;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestRequest {

    // Trebuie sa fac o metoda care sa execute un request la in endpoint

    public Response performRequest(String requestType, RequestSpecification requestSpecification, String URL){
        switch (requestType){
            case RestRequestType.RequestDelete:
                return prepare(requestSpecification).delete(URL);
            case RestRequestType.Requestget:
                return prepare(requestSpecification).get(URL);
            case RestRequestType.RequestPost:
                return prepare(requestSpecification).post(URL);
            case RestRequestType.Requestput:
                return prepare(requestSpecification).put(URL);
        }
        return null;

    }


    // Trebuoie sa configurez setarile pt client

    public RequestSpecification prepare(RequestSpecification requestSpecification){
        requestSpecification.baseUri("https://demoqa.com");
        requestSpecification.contentType("application/json");

        return requestSpecification;
    }
}
