package praktikum;

import drivers.WebDriverConstructor;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.api.API;
import praktikum.pages.Registration;

import static org.junit.Assert.*;

public class RegistrationTest {
    private WebDriver driver;
    private final String url = "https://stellarburgers.nomoreparties.site";
    private String name;
    private String email;
    private String password;
    private String incorrectPassword;
    private String token;


    @Before
    public void initialization() {
        name = "Ник";
        email = "burdinnnnickita@yandex.ru";
        password = "burdinnnnickita";
        incorrectPassword = "bur";
        RestAssured.baseURI = url;
        WebDriverConstructor webDriverConstructor = new WebDriverConstructor();
        driver = webDriverConstructor.getWebDriver();
        driver.get(url);
    }

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Положительная проверка регистрации пользователя")
    public void checkSuccessfulRegistration() {
        Registration registration = new Registration(driver);
        boolean actualResult = registration.createUser(name, email, password);
        assertTrue(actualResult);
    }

    @Test
    @DisplayName("Ошибочная регистрация")
    @Description("Отрицательная проверка регистрации пользователя")
    public void checkUnsuccessfulRegistration() {
        Registration registration = new Registration(driver);
        boolean actualResult = registration.createUser(name, email, incorrectPassword);
        assertFalse(actualResult);
    }

    @After
    public void tearDown(){
        driver.quit();
        API request = new API();
        token = request.loginUser(email, password);
        if(token != null) {
            request.deleteUser(token);
        }
    }
}
