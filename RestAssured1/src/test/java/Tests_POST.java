import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Tests_POST {
    //@Test
    public void test_1post(){
        Map<String, Object> map = new HashMap<>();

        map.put("name", "Bartosz");
        map.put("job", "Tester");

        System.out.println(map);

        JSONObject request = new JSONObject(map);

        System.out.println(request);
        System.out.println(request.toJSONString());

        JSONObject request2 = new JSONObject();
        request2.put("name","Klaudia");
        request2.put("job","Mediator");

        System.out.println(request2);

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                post("https://reqres.in/api/users").
        then().
                statusCode(201);
    }

    //@Test
    public void test_1put(){

        JSONObject request = new JSONObject();

        request.put("name","Klaudia");
        request.put("job","Mediator");

        System.out.println(request);

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                put("https://reqres.in/api/users/2").
        then().
                statusCode(200).
                log().all();
    }

    //@Test
    public void test_1patch(){

        JSONObject request = new JSONObject();

        request.put("name","Klaudia");
        request.put("job","Mediator");

        System.out.println(request);

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                patch("https://reqres.in/api/users/2").
        then().
                statusCode(200).
                log().all();
    }
    @Test
    public void test_1_delete(){

        when().
                delete("https://reqres.in/api/users/2").
        then().
                statusCode(204).
                log().all();
    }
}
