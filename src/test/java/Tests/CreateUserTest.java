

//public class CreateUserTest extends Hooks {
//
//
//    public String userID;
//    public String username;
//    public String password;
//    public String token;
//    public AccountActions accountActions;
//
//    @Test
//    public void MetodaTest(){ //facem intregul flow in acest test pentru a pastra logica de creare user, autentificare, token
//        //Adica facem aici toate REQUESTURILE DE BACKEND
//
//        System.out.println("Step 1 : Create user");
//        createUser();
//        System.out.println("Step 2 : Generate Token ");
//        generateToken();
//        System.out.println("Step 3 : Optain new user ");
//        interractNewUser();
//    }
//
//    public void createUser(){
////        // Definim caracteristicile clientului
////        RequestSpecification requestSpecification = RestAssured.given();
////        requestSpecification.baseUri("https://demoqa.com");
////        requestSpecification.contentType("application/json");
//
//        accountActions = new AccountActions();
//        username = "Mada" + System.currentTimeMillis(); // va genera valoare unica
//        password = "Madalina01!";
//        RequestAccount requestAccount = new RequestAccount(username,password);
//        ResponseAccountSuccess responseAccountSuccess= accountActions.createNewAccount(requestAccount);
//
//        userID = responseAccountSuccess.getUserId();  //am salvat userID-ul pentru a-l folosi la urmatorul pas
//
//
//        // Configuram request- ul
//
////         username = "Mada" + System.currentTimeMillis(); // va genera valoare unica
////         password = "Madalina01!";
//
////        JSONObject requestbody = new JSONObject();
////        requestbody.put("userName" , username);
////        requestbody.put("password" , "Madalina01!");
//
////        RequestAcount requestAcount = new RequestAcount(username,password);
////        requestSpecification.body(requestAcount); // atasam body-ul pe constructia clientului(cea de sus)
//
//
//        // Accesam response-ul
//
////        Response response = requestSpecification.post("/Account/v1/User"); // accesam raspunsul trimitand un request de tip Post
////        ResponseBody body = response.getBody();
////        body.prettyPrint();
////
////        // Validam statusul reqestului
////
////        // System.out.println(response.getStatusCode());
////        Assert.assertEquals(response.getStatusCode(),201);
////
////        //Validam respons body
////
////        ResponseAccountSuccess responseAccountSuccess = response.body().as(ResponseAccountSuccess.class);
////
////        Assert.assertNotNull(responseAccountSuccess.getUserId()); // verificam ca exista o valoare pt field
////        Assert.assertEquals(responseAccountSuccess.getUsername(),username);
////        Assert.assertNotNull(responseAccountSuccess.getBooks());
////
////        userID = responseAccountSuccess.getUserId();  //am salvat userID-ul pentru a-l folosi la urmatorul pas
//
//    }
//
//    // Facem un request care ne genereaza un Token
//
//
//    public  void generateToken() { //PASUL 2 - FACEM POSTUL CARE NE DA UN TOKEN
//
//        RequestSpecification requestSpecification = RestAssured.given();
//        requestSpecification.baseUri("https://demoqa.com");
//        requestSpecification.contentType("application/json");
//
//        RequestAccountToken requestAccountToken = new RequestAccountToken(username, password);
//        requestSpecification.body(requestAccountToken);
//
//        // Accesam response-ul
//
//        Response response = requestSpecification.post("/Account/v1/GenerateToken");
//        ResponseBody body = response.getBody();
//        body.prettyPrint();
//
//        Assert.assertEquals(response.getStatusCode(),200);  //validarea de status code
//
//        ResponseTokenSuccess responseTokenSuccess = response.body().as(ResponseTokenSuccess.class);
//
//        Assert.assertNotNull(responseTokenSuccess.getToken()); // verificam ca exista o valoare pt field
//        Assert.assertNotNull(responseTokenSuccess.getExpires()); // verificam ca exista o valoare, ca nu e nul
//        Assert.assertEquals(responseTokenSuccess.getStatus(),"Success");
//        Assert.assertEquals(responseTokenSuccess.getResult(),"User authorized successfully. ");
//
//        token = responseTokenSuccess.getToken(); // am extras/salvat tokenul pt a-l folosi pentru uurmatorul pas
//
//    }
//// Facem un get pentru userul creat
//
//    public void interractNewUser(){   //PASUL 3 FACEM AUTORIZAREA
//
//        RequestSpecification requestSpecification = RestAssured.given();
//        requestSpecification.baseUri("https://demoqa.com");
//        requestSpecification.contentType("application/json");
//        requestSpecification.header("Authorization","Bearer" + token);  //autorizare care foloseste token
//
//        Response response = requestSpecification.get("/Account/v1/User/"+ userID ); // compunere de endpoint din url-uri
//
//        Assert.assertEquals(response.getStatusCode(),200);
//
//        ResponseAccountAuthSucces responseAccountAuthSuccess = response.body().as(ResponseAccountAuthSuccess.class);
//        Assert.assertNotNull(responseAccountAuthSuccess.getUserId()); //verificam ca exista o valoare pt id, cat nu e nul
//        Assert.assertEquals(responseAccountAuthSuccess.getUsername(),username); //verif ca username are valoarea din request
//        Assert.assertNotNull(responseAccountAuthSuccess.getBooks()); //verificam ca books sa contina cel putin "["
//
//    }
//    }


