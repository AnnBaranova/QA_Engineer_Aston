package org.example;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestPostmanEcho {

    @Test
    public void testGetMethod() {
       given()
              .baseUri("https://postman-echo.com")
              .when()
              .get("/get?foo1=bar1&foo2=bar2")
              .then()
              .assertThat()
              .statusCode(200)
              .body("args.foo1", equalTo("bar1"))
              .body("args.foo2", equalTo("bar2"))
              .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"))
              .log().all();
    }

    @Test
    public void testPostRawTextMethod() {
        HashMap<String, String>  body = new HashMap<>();
        body.put("test","value");
        given()
                .baseUri("https://postman-echo.com")
                .contentType(ContentType.JSON)
                .when()
                .body(body)
                .post("/post")
                .then()
                .statusCode(200)
                .body("data.test", equalTo("value"))
                .body("url", equalTo("https://postman-echo.com/post"))
                .log().all();
    }

    @Test
    public void testPostFormDataMethod() {
        HashMap<String, String>  form = new HashMap<>();
        form.put("foo1","bar1");
        form.put("foo2","bar2");
        given()
                .baseUri("https://postman-echo.com")
                .contentType("application/x-www-form-urlencoded;charset=UTF-8")
                .formParams(form)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/post"))
                .log().all();
    }

    @Test
    public void testPutMethod() {
        HashMap<String, String>  test = new HashMap<>();
        test.put("Name","Ann");
        given()
                .baseUri("https://postman-echo.com")
                .contentType(ContentType.JSON)
                .when()
                .body(test)
                .put("/put")
                .then()
                .statusCode(200)
                .body("data.Name", equalTo("Ann"))
                .body("url", equalTo("https://postman-echo.com/put"))
                .log().all();
    }

    @Test
    public void testPatchMethod() {
        HashMap<String, String>  test = new HashMap<>();
        test.put("Name","Anya");
        given()
                .baseUri("https://postman-echo.com")
                .contentType(ContentType.JSON)
                .when()
                .body(test)
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data.Name", equalTo("Anya"))
                .body("url", equalTo("https://postman-echo.com/patch"))
                .log().all();
    }
    @Test
    public void testDeleteMethod() {
        HashMap<String, String>  test = new HashMap<>();
        test.put("Name","Ann");
        given()
                .baseUri("https://postman-echo.com")
                .contentType(ContentType.JSON)
                .when()
                .body(test)
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("data.Name", equalTo("Ann"))
                .body("url", equalTo("https://postman-echo.com/delete"))
                .log().all();
    }
}


