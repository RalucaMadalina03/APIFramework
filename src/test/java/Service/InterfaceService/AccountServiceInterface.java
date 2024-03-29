package Service.InterfaceService;

import Objects.RequestObject.RequestAccount;
import Objects.RequestObject.RequestAccountToken;
import io.restassured.response.Response;

public interface AccountServiceInterface  {

    Response createAccount(RequestAccount requestAccount); //reprezinta primul post pe care serviciul o poate face
    Response generateToken(RequestAccountToken requestAccountToken); //definesti ce metoda vrei sa faca si in parametrii ii pui structura
    Response getSpecificAccount(String userID, String token);
    Response deleteSpecificUser(String userID, String token);

}