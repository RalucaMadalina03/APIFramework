package Objects.ResponseObject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookObject {
    @JsonProperty("isbn")
    public String isbn;                              //sa vedem daca trebuie modificata in private sau nu

    @JsonProperty("title")
    public String title;

    @JsonProperty("subTitle")
    public String subTitle;

    @JsonProperty("author")
    public String author;

    @JsonProperty("publish_date")
    public String publish_date;

    @JsonProperty("publisher")
    public String publisher;

    @JsonProperty("pages")
    public Integer pages;

    @JsonProperty("description")
    public String description;

    @JsonProperty("website")
    public String website;

    public String getIsbn() {                    // facem doar getteri . Pe response-uri nu ar trebui cam niciodata sa facem setteri(ca in teorie response-ul este ce ne da serverul)
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public String getPublisher() {
        return publisher;
    }

    public Integer getPages() {
        return pages;
    }

    public String getDescription() {
        return description;
    }

    public String getWebsite() {
        return website;
    }
}