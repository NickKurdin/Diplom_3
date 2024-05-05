package praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import praktikum.pages.Registration;

import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class RegistrationTest {
    private WebDriver driver;
    public String name;
    public String email;
    public String password;


    public WebDriver createDriver(String browser) {
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/Caskroom/chromedriver/124.0.6367.91/chromedriver-mac-arm64");
        WebDriver webdriver = null;

        if (browser.equalsIgnoreCase("chrome")) {
            // Создаем экземпляр ChromeDriver
            webdriver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("yandex")) {
            // Создаем экземпляр FirefoxDriver
            webdriver = new OperaDriver();
        } else {
            System.out.println("Неподдерживаемый браузер: " + browser);
        }
        return webdriver;
    }

    @Before
    public void initialization() {
        Random rand = new Random();
        name = "Ник";
        email = String.format("kurdin_nick%d@yandex.ru", rand.nextInt(1000));
        password = String.format("123456Nik%d", rand.nextInt(1000));
    }

    @Test
    public void checkSuccessfulRegistrationInChrome() {
        driver = createDriver("chrome");
        driver.get("https://stellarburgers.nomoreparties.site");
        Registration registration = new Registration(driver);
        boolean actualResult = registration.createUser(name, email, password);
        assertEquals(false, actualResult);
    }

    @Test
    public void checkUnsuccessfulRegistrationInChrome() {
        driver = createDriver("chrome");
        driver.get("https://stellarburgers.nomoreparties.site");
        Registration registration = new Registration(driver);
        boolean actualResult = registration.createUser(name, email, password);
        assertEquals(true, actualResult);
    }

    @Test
    public void checkSuccessfulRegistrationInYandex() {
        driver = createDriver("yandex");
        driver.get("https://stellarburgers.nomoreparties.site");
        Registration registration = new Registration(driver);
        boolean actualResult = registration.createUser(name, email, password);
        assertEquals(false, actualResult);
    }

    @Test
    public void checkUnsuccessfulRegistrationInYandex() {
        driver = createDriver("yandex");
        driver.get("https://stellarburgers.nomoreparties.site");
        Registration registration = new Registration(driver);
        boolean actualResult = registration.createUser(name, email, password);
        assertEquals(true, actualResult);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
