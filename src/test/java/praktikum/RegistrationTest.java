package praktikum;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import praktikum.pages.Registration;

import static org.junit.Assert.assertEquals;

public class RegistrationTest {
    private WebDriver driver;
    private final String url = "https://stellarburgers.nomoreparties.site";
    public String name;
    public String email;
    public String password;
    public String incorrectPassword;
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
        incorrectPassword = "bur";;
    }

    @Test
    @DisplayName("Успешная регистрация в Google Chrome")
    public void checkSuccessfulRegistrationInChrome() {
        Registration registration = new Registration(driver);
        boolean actualResult = registration.createUser(name, email, password);
        assertEquals(true, actualResult);
    }

    @Test
    @DisplayName("Ошибочная регистрация в Google Chrome")
    public void checkUnsuccessfulRegistrationInChrome() {
        driver = createDriver("chrome");
        driver.get(url);
        Registration registration = new Registration(driver);
        boolean actualResult = registration.createUser(name, email, incorrectPassword);
        assertEquals(false, actualResult);
    }

    @Test
    @DisplayName("Успешная регистрация в Yandex Browser")
    public void checkSuccessfulRegistrationInYandex() {
        driver = createDriver("yandex");
        driver.get(url);
        Registration registration = new Registration(driver);
        boolean actualResult = registration.createUser(name, email, password);
        assertEquals(true, actualResult);
    }

    @Test
    @DisplayName("Ошибочная регистрация в Yandex Browser")
    public void checkUnsuccessfulRegistrationInYandex() {
        driver = createDriver("yandex");
        driver.get(url);
        Registration registration = new Registration(driver);
        boolean actualResult = registration.createUser(name, email, incorrectPassword);
        assertEquals(false, actualResult);
    }

    @After
    public void tearDown(){
        driver.quit();
        RestAssured.baseURI = url;
        API request = new API();
        token = request.loginUser(email, password);
        if(token != null) {
            request.deleteUser(token);
        }
    }
}
