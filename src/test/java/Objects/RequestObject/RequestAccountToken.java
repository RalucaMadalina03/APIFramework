package Objects.RequestObject;

public class RequestAccountToken  {
    //facem reprezentarea asa cum arata in requestul de pe swagger
    //2 variabile numite asa cum sunt in request
    private String userName;

    private String password;

    public RequestAccountToken(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
