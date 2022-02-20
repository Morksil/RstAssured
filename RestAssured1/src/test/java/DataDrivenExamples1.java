import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DataDrivenExamples1 {

    @DataProvider(name = "DataForPost")
    public Object[][] dataForPost(){
        /*Object[][] data = new Object[2][3];

        data[0][0] = "Albert";
        data[0][1] = "Einstein";
        data[0][2] = 1;
        data[1][0] = "Thomas";
        data[1][1] = "Shelby";
        data[1][2] = 2;

        return data;*/

        return new Object[][] {
                {
                    "Graham","Bell",1
                },
                {
                    "Henry","ford",2
                }
        };
    }

    //@Test(dataProvider = "DataForPost")
    public void test_post(String firstName, String lastName, int subjectId){

        JSONObject request = new JSONObject();

        request.put("firstName", firstName);
        request.put("lastName", lastName);
        request.put("subjectId", subjectId);

        baseURI = "http://localhost:3000/";

        given().
            contentType(ContentType.JSON).
            accept(ContentType.JSON).
            header("Content-Type", "application/json").
            body(request.toJSONString()).
        when().
            post("/users").
        then().
            statusCode(201).
            log().all();
    }

    @DataProvider(name = "DeleteData")
    public Object[] dataForDelete(){
        return new Object[] {
                4,5,6,7
        };
    }
    @Test(dataProvider = "DeleteData")
    public void test_delete(int userId){
        baseURI = "http://localhost:3000/";

        when().
                delete("/users/" + userId).
                then().
                statusCode(200);
    }
}
