package Service.ServiceImplementation;

import EndPoints.AccountEndPoints;
import RequestObject.RequestAcount;
import RequestObject.RequestAcountToken;
import Service.APIService.AccountAPiService;
import Service.InterfaceService.AccountServiceInterface;
import io.restassured.response.Response;

public class AccountServiceImpl implements AccountServiceInterface {

    public AccountAPiService accountAPiService;
    @Override
    public Response createAccount(RequestAcount requestAcount) {
        accountAPiService = new AccountAPiService();
        return accountAPiService.post(requestAcount, AccountEndPoints.ACCOUNT_CREATE);
    }

    @Override
    public Response generateToken(RequestAcountToken requestAcountToken) {
        accountAPiService = new AccountAPiService();
        return accountAPiService.post(requestAcountToken,AccountEndPoints.ACCOUNT_TOKEN);
    }

    @Override
    public Response getSpecificAccount(String userID, String token) {
        return null;
    }
}
