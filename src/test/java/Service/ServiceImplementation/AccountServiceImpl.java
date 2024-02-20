package Service.ServiceImplementation;

import EndPoints.AccountEndPoints;
import Objects.RequestObject.RequestAccount;
import Objects.RequestObject.RequestAccountToken;
import Service.APIService.AccountAPiService;
import Service.InterfaceService.AccountServiceInterface;
import io.restassured.response.Response;

public class AccountServiceImpl implements AccountServiceInterface {

    public AccountAPiService accountAPIService;
    public Response createAccount(RequestAccount requestAccount) {
        accountAPIService=new AccountAPiService();
        return accountAPIService.post(requestAccount, AccountEndPoints.ACCOUNT_CREATE);

    }

    @Override
    public Response generateToken(RequestAccountToken requestAccountToken) {
        accountAPIService = new AccountAPiService();
        return accountAPIService.post(requestAccountToken, AccountEndPoints.ACCOUNT_TOKEN);
    }

    @Override
    public Response getSpecificAccount(String userID, String token) {
        accountAPIService = new AccountAPiService();
        String finalEndpoint = AccountEndPoints.ACCOUNT_USERSPECIFIC.replace("{userID}",userID);
        return accountAPIService.get(finalEndpoint,token);
    }

    @Override
    public Response deleteSpecificUser(String userID, String token) {
        accountAPIService = new AccountAPiService();
        String finalEndpoint = AccountEndPoints.ACCOUNT_DELETE.replace("{userID}",userID);
        return accountAPIService.delete(finalEndpoint,token);

    }
    //implementarea serviciului definit in inerfaceService

}
