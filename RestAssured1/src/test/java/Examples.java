import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Examples {

    //@Test
    public void test_get(){

        baseURI = "http://localhost:3000/";
        given().
            param("name", ("automation")).
            get("/subjects").
        then().
            statusCode(200).
            log().all();
    }
    //@Test
    public void test_post(){

        JSONObject request = new JSONObject();

        request.put("firstName", "Tom");
        request.put("lastName", "Oooz");
        request.put("subjectId", 1);

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
    //@Test
    public void test_patch(){

        JSONObject request = new JSONObject();

        request.put("lastName", "Ooozyyy");


        baseURI = "http://localhost:3000/";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(request.toJSONString()).
        when().
                patch("/users/4").
        then().
                statusCode(200).
                log().all();
    }
    //@Test
    public void test_put(){

        JSONObject request = new JSONObject();

        request.put("firstName", "Michael");
        request.put("lastName", "Ooozeee");
        request.put("subjectId", 1);

        baseURI = "http://localhost:3000/";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(request.toJSONString()).
        when().
                put("/users/4").
        then().
                statusCode(200).
                log().all();
    }
    @Test
    public void test_delete(){
        baseURI = "http://localhost:3000/";

        when().
            delete("/users/4").
        then().
            statusCode(200);
    }
}
