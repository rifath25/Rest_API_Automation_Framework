package tweets;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class TweetsClient {
    protected final static String API_KEY ="EDc0iI6EzadQzy9a6HOQy8BKN";
    protected final static String API_SECTRET_KEY ="iKDvyYlQOk1HPaladjvGiVbVEOvrwE33JqbtCbcZah4TcFHft3";
    protected final static String ACCESS_TOKEN ="1182730200691425283-1Ueu1yOEN36x1Ubr4DdXbG3urhlvCS";
    protected final static String ACCESS_TOKEN_SECRET= "EBuemQ0NWeYIcfsdzwa3ASysFnNbabnCmB9Cpr3XV8rXy";

    protected final static String BASE_URI ="https://api.twitter.com/1.1";
    protected final static String TWEET_ENDPOINT ="/statuses/update.json";
    protected final static String SEARCH_ENDPOINT ="/users/search.json";

    public Response sentTweet(String status){
        return given().auth().oauth(API_KEY,API_SECTRET_KEY,ACCESS_TOKEN,ACCESS_TOKEN_SECRET)
            .param("status",status).when().post(BASE_URI + TWEET_ENDPOINT).then()
                .statusCode(200).extract().response();
    }
    public Response searchProfile(String q){
        return given().auth().oauth(API_KEY,API_SECTRET_KEY,ACCESS_TOKEN,ACCESS_TOKEN_SECRET)
                .param("q",q).when().get(BASE_URI + SEARCH_ENDPOINT).then()
                .statusCode(200).extract().response();
    }

}

