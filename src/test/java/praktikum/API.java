package praktikum;

import static io.restassured.RestAssured.given;

public class API {
    public String createUser(String email, String password, String name){
        return given()
                .header("Content-type", "application/json")
                .body("{\n\"email\": \"" + email + "\",\n\"password\": \"" + password + "\",\n\"name\": \"" + name + "\"\n}")
                .post("/api/auth/register")
                .then().extract().response().path("accessToken");
    }

    public String loginUser(String email, String password){
        return given()
                .header("Content-type", "application/json")
                .body("{\n\"email\": \"" + email + "\",\n\"password\": \"" + password + "\"\n}")
                .post("/api/auth/login")
                .then().extract().response().path("accessToken");
    }

    public void deleteUser(String token){
        given()
                .header("Authorization", token)
                .delete("/api/auth/user");
    }
}
