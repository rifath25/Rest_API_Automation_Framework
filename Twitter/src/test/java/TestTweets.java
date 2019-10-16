import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tweets.TweetsClient;

import java.util.UUID;

public class TestTweets {

    protected TweetsClient tweetsClient;
    @BeforeClass
    public  void setUp(){
        this.tweetsClient = new TweetsClient();
    }
    @Test
    public void testUserCanTweetSuccessfully(){
        Response respone = tweetsClient.sentTweet("Tweeting from Queen,newyork");
        respone.getBody().prettyPrint();
        int statusCode = respone.getStatusCode();
        String statusLine=respone.getStatusLine();
        Assert.assertEquals(statusCode,200);
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");

    }
    @Test
    public void testUserCannnotTweetDuplicateTweet(){
        Response respone = tweetsClient.sentTweet("Hey!This is Rifath" + UUID.randomUUID());
        respone.getBody().prettyPrint();
        int statusCode = respone.getStatusCode();
        String statusLine=respone.getStatusLine();
        Assert.assertEquals(statusCode,200);
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
    }
    @Test
    public void testUserCanSearchProfileSuccessfully(){
        Response response= tweetsClient.searchProfile("tsbristy111");
        response.getBody().prettyPrint();
        int statusCode= response.getStatusCode();
        String statusLine=response.getStatusLine();
        Assert.assertEquals(statusCode,200);
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
    }
    @Test
    public void testUser2CanSearchProfileSuccessfully(){
        Response response= tweetsClient.searchProfile("rkraihan_");
        response.getBody().prettyPrint();
        int statusCode= response.getStatusCode();
        String statusLine=response.getStatusLine();
        Assert.assertEquals(statusCode,200);
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
    }

}
