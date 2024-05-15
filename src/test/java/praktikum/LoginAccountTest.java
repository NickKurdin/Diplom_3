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
import praktikum.pages.LoginAccount;
import static org.junit.Assert.assertTrue;

public class LoginAccountTest {
    private WebDriver driver;
    private final String url = "https://stellarburgers.nomoreparties.site";
    private String name;
    private String email;
    private String password;
    private String token;

    @Before
    public void initialization() {
        name = "Ник";
        email = "burdin_nickita@yandex.ru";
        password = "burdin_nickita";
        RestAssured.baseURI = url;
        API request = new API();
        token = request.createUser(email, password, name);
        WebDriverConstructor webDriverConstructor = new WebDriverConstructor();
        driver = webDriverConstructor.getWebDriver();
        driver.get(url);
    }

    @Test
    @DisplayName("Авторизация через кнопку \"Войти в аккаунт\"")
    @Description("Авторизуемся на сайте после нажатия на кнопку \"Войти в аккаунт\"")
    public void checkLoginByEnterAccountButtonOnMainPage() {
        LoginAccount loginAccount = new LoginAccount(driver);
        boolean actualResult = loginAccount.loginByEnterAccountButtonOnMainPage(email, password);
        assertTrue(actualResult);
    }

    @Test
    @DisplayName("Авторизация через кнопку \"Личный кабинет\"")
    @Description("Авторизуемся на сайте после нажатия на кнопку \"Личный кабинет\"")
    public void checkLoginByPersonalAccountButton() {
        LoginAccount loginAccount = new LoginAccount(driver);
        boolean actualResult = loginAccount.loginByPersonalAccountButton(email, password);
        assertTrue(actualResult);
    }

    @Test
    @DisplayName("Авторизация через кнопку \"Зарегистрироваться\"")
    @Description("Авторизуемся на сайте после нажатия на кнопку \"Зарегистрироваться\"")
    public void checkLoginByRegisterButton() {
        LoginAccount loginAccount = new LoginAccount(driver);
        boolean actualResult = loginAccount.loginByRegisterButton(email, password);
        assertTrue(actualResult);
    }

    @Test
    @DisplayName("Авторизация через кнопку \"Восстановить пароль\"")
    @Description("Авторизуемся на сайте после нажатия на кнопку \"Восстановить пароль\"")
    public void checkLoginByRecoveryButton() {
        LoginAccount loginAccount = new LoginAccount(driver);
        boolean actualResult = loginAccount.loginByRecoveryButton(email, password);
        assertTrue(actualResult);
    }

    @After
    public void tearDown() {
        driver.quit();
        API request = new API();
        token = request.loginUser(email, password);
        if(token != null) {
            request.deleteUser(token);
        }
    }
}
