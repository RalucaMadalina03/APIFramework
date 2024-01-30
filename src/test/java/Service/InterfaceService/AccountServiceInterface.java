package Service.InterfaceService;

import RequestObject.RequestAcount;
import RequestObject.RequestAcountToken;
import io.restassured.response.Response;

public interface AccountServiceInterface {

    Response createAccount (RequestAcount requestAcount);
    Response generateToken (RequestAcountToken requestAcountToken);
    Response getSpecificAccount(String userID,String token);


}
