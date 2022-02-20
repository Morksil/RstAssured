import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Tests_GET {

    @Test
    public void test_1(){
        given().
                get("https://reqres.in/api/users?page=2").
        then().
                statusCode(200);
    }
}
