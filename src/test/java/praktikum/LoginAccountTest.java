package praktikum;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import praktikum.pages.LoginAccount;
import static org.junit.Assert.assertEquals;

public class LoginAccountTest {
    private WebDriver driver;
    private final String url = "https://stellarburgers.nomoreparties.site";
    public String name;
    public String email;
    public String password;
    public String token;


    public WebDriver createDriver(String browser) {
        WebDriver webdriver = null;

        if (browser.equalsIgnoreCase("chrome")) {
            // Создаем экземпляр ChromeDriver
            webdriver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("yandex")) {
            // Создаем экземпляр YandexDriver
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\nickex\\WebDriver\\bin\\yandexdriver.exe");
            webdriver = new ChromeDriver();
        } else {
            System.out.println("Неподдерживаемый браузер: " + browser);
        }
        return webdriver;
    }

    @Before
    public void initialization() {
        name = "Ник";
        email = "burdin_nickita@yandex.ru";
        password = "burdin_nickita";
        RestAssured.baseURI = url;
        API request = new API();
        token = request.createUser(email, password, name);
    }

    @Test
    @DisplayName("Авторизация через кнопку \"Войти в аккаунт\" в Google Chrome")
    public void checkLoginByEnterAccountButtonOnMainPageChrome() {
        driver = createDriver("chrome");
        driver.get(url);
        LoginAccount loginAccount = new LoginAccount(driver);
        boolean actualResult = loginAccount.loginByEnterAccountButtonOnMainPage(email, password);
        assertEquals(true, actualResult);
    }

    @Test
    @DisplayName("Авторизация через кнопку \"Личный кабинет\" в Google Chrome")
    public void checkLoginByPersonalAccountButtonChrome() {
        driver = createDriver("chrome");
        driver.get(url);
        LoginAccount loginAccount = new LoginAccount(driver);
        boolean actualResult = loginAccount.loginByPersonalAccountButton(email, password);
        assertEquals(true, actualResult);
    }

    @Test
    @DisplayName("Авторизация через кнопку \"Зарегистрироваться\" в Google Chrome")
    public void checkLoginByRegisterButtonChrome() {
        driver = createDriver("chrome");
        driver.get(url);
        LoginAccount loginAccount = new LoginAccount(driver);
        boolean actualResult = loginAccount.loginByRegisterButton(email, password);
        assertEquals(true, actualResult);
    }

    @Test
    @DisplayName("Авторизация через кнопку \"Восстановить пароль\" в Google Chrome")
    public void checkLoginByRecoveryButtonChrome() {
        driver = createDriver("chrome");
        driver.get(url);
        LoginAccount loginAccount = new LoginAccount(driver);
        boolean actualResult = loginAccount.loginByRecoveryButton(email, password);
        assertEquals(true, actualResult);
    }

    @Test
    @DisplayName("Авторизация через кнопку \"Войти в аккаунт\" в Google Chrome")
    public void checkLoginByEnterAccountButtonOnMainPageYandex() {
        driver = createDriver("yandex");
        driver.get(url);
        LoginAccount loginAccount = new LoginAccount(driver);
        boolean actualResult = loginAccount.loginByEnterAccountButtonOnMainPage(email, password);
        assertEquals(true, actualResult);
    }

    @Test
    @DisplayName("Авторизация через кнопку \"Личный кабинет\" в Yandex Browser")
    public void checkLoginByPersonalAccountButtonYandex() {
        driver = createDriver("yandex");
        driver.get(url);
        LoginAccount loginAccount = new LoginAccount(driver);
        boolean actualResult = loginAccount.loginByPersonalAccountButton(email, password);
        assertEquals(true, actualResult);
    }

    @Test
    @DisplayName("Авторизация через кнопку \"Зарегистрироваться\" в Yandex Browser")
    public void checkLoginByRegisterButtonYandex() {
        driver = createDriver("yandex");
        driver.get(url);
        LoginAccount loginAccount = new LoginAccount(driver);
        boolean actualResult = loginAccount.loginByRegisterButton(email, password);
        assertEquals(true, actualResult);
    }

    @Test
    @DisplayName("Авторизация через кнопку \"Восстановить пароль\" в Yandex Browser")
    public void checkLoginByRecoveryButtonYandex() {
        driver = createDriver("yandex");
        driver.get(url);
        LoginAccount loginAccount = new LoginAccount(driver);
        boolean actualResult = loginAccount.loginByRecoveryButton(email, password);
        assertEquals(true, actualResult);
    }

    @After
    public void tearDown() {
        driver.quit();
        RestAssured.baseURI = url;
        API request = new API();
        token = request.loginUser(email, password);
        if(token != null) {
            request.deleteUser(token);
        }
    }
}
