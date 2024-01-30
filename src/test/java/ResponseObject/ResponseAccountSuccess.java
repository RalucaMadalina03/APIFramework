package ResponseObject;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResponseAccountSuccess {

    //invatam despre adnotari JsonProperty numit si alias, porecla

    @JsonProperty("userId")  //definim fiecare camp din consolta pentru a stii cum sa il citeasca
    private String userId;

    @JsonProperty("username")
    private String username;

    @JsonProperty("books")
    private List<BookObject> books;

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public List<BookObject> getBooks() {
        return books;
    }


}
