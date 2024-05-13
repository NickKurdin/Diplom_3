package praktikum.api;

import static io.restassured.RestAssured.given;

public class API {
    private User fullUser;
    private final String register = "/api/auth/register";
    private final String login = "/api/auth/login";
    private final String delete = "/api/auth/user";

    public String createUser(String email, String password, String name){
        fullUser = new User(email, password, name);
        return given()
                .header("Content-type", "application/json")
                .body(fullUser)
                .post(register)
                .then().extract().response().path("accessToken");
    }

    public String loginUser(String email, String password){
        fullUser = new User(email, password);
        return given()
                .header("Content-type", "application/json")
                .body(fullUser)
                .post(login)
                .then().extract().response().path("accessToken");
    }

    public void deleteUser(String token){
        given()
                .header("Authorization", token)
                .delete(delete);
    }
}
