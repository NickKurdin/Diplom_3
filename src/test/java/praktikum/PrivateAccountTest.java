package praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import praktikum.pages.LoginAccount;
import praktikum.pages.PrivateAccount;

import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PrivateAccountTest {
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
        token = given()
                .header("Content-type", "application/json")
                .body("{\n\"email\": \"" + email + "\",\n\"password\": \"" + password + "\",\n\"name\": \"" + name + "\"\n}")
                .post("/api/auth/register")
                .then().extract().response().path("accessToken");
    }

    @Test
    public void checkMoveFromMainPageToPrivateAccountChrome() {
        driver = createDriver("chrome");
        driver.get(url);
        LoginAccount loginAccount = new LoginAccount(driver);
        loginAccount.moveToAuthorizationFormByEnterAccountButton();
        loginAccount.fillAuthorizationForm(name, email);
        loginAccount.finalClickToEnterAccount();
        PrivateAccount privateAccount = new PrivateAccount(driver);
        boolean actualResult = privateAccount.checkMoveToPersonalAccountByClick();
        assertEquals(true, actualResult);
    }

    @Test
    public void checkMoveFromPrivateAccountToConstructorByClickConstructorButtonChrome() {
        driver = createDriver("chrome");
        driver.get(url);
        LoginAccount loginAccount = new LoginAccount(driver);
        loginAccount.moveToAuthorizationFormByEnterAccountButton();
        loginAccount.fillAuthorizationForm(name, email);
        loginAccount.finalClickToEnterAccount();
        PrivateAccount privateAccount = new PrivateAccount(driver);
        privateAccount.moveToPersonalAccountByClick();
        boolean actualResult = privateAccount.moveToConstructorByClickButton();
        assertEquals(true, actualResult);
    }

    @Test
    public void checkMoveFromPrivateAccountToConstructorByClickLogoChrome() {
        driver = createDriver("chrome");
        driver.get(url);
        LoginAccount loginAccount = new LoginAccount(driver);
        loginAccount.moveToAuthorizationFormByEnterAccountButton();
        loginAccount.fillAuthorizationForm(name, email);
        loginAccount.finalClickToEnterAccount();
        PrivateAccount privateAccount = new PrivateAccount(driver);
        privateAccount.moveToPersonalAccountByClick();
        boolean actualResult = privateAccount.moveToConstructorByLogo();
        assertEquals(true, actualResult);
    }

    @Test
    public void checkExitFromPrivateAccountChrome() {
        driver = createDriver("chrome");
        driver.get(url);
        LoginAccount loginAccount = new LoginAccount(driver);
        loginAccount.moveToAuthorizationFormByEnterAccountButton();
        loginAccount.fillAuthorizationForm(name, email);
        loginAccount.finalClickToEnterAccount();
        PrivateAccount privateAccount = new PrivateAccount(driver);
        privateAccount.moveToPersonalAccountByClick();
        boolean actualResult = privateAccount.logoutFromPrivateAccount();
        assertEquals(true, actualResult);
    }

    @Test
    public void checkMoveFromMainPageToPrivateAccountYandex() {
        driver = createDriver("yandex");
        driver.get(url);
        LoginAccount loginAccount = new LoginAccount(driver);
        loginAccount.moveToAuthorizationFormByEnterAccountButton();
        loginAccount.fillAuthorizationForm(name, email);
        loginAccount.finalClickToEnterAccount();
        PrivateAccount privateAccount = new PrivateAccount(driver);
        boolean actualResult = privateAccount.checkMoveToPersonalAccountByClick();
        assertEquals(true, actualResult);
    }

    @Test
    public void checkMoveFromPrivateAccountToConstructorByClickConstructorButtonYandex() {
        driver = createDriver("yandex");
        driver.get(url);
        LoginAccount loginAccount = new LoginAccount(driver);
        loginAccount.moveToAuthorizationFormByEnterAccountButton();
        loginAccount.fillAuthorizationForm(name, email);
        loginAccount.finalClickToEnterAccount();
        PrivateAccount privateAccount = new PrivateAccount(driver);
        privateAccount.moveToPersonalAccountByClick();
        boolean actualResult = privateAccount.moveToConstructorByClickButton();
        assertEquals(true, actualResult);
    }

    @Test
    public void checkMoveFromPrivateAccountToConstructorByClickLogoYandex() {
        driver = createDriver("yandex");
        driver.get(url);
        LoginAccount loginAccount = new LoginAccount(driver);
        loginAccount.moveToAuthorizationFormByEnterAccountButton();
        loginAccount.fillAuthorizationForm(name, email);
        loginAccount.finalClickToEnterAccount();
        PrivateAccount privateAccount = new PrivateAccount(driver);
        privateAccount.moveToPersonalAccountByClick();
        boolean actualResult = privateAccount.moveToConstructorByLogo();
        assertEquals(true, actualResult);
    }

    @Test
    public void checkExitFromPrivateAccountYandex() {
        driver = createDriver("yandex");
        driver.get(url);
        LoginAccount loginAccount = new LoginAccount(driver);
        loginAccount.moveToAuthorizationFormByEnterAccountButton();
        loginAccount.fillAuthorizationForm(name, email);
        loginAccount.finalClickToEnterAccount();
        PrivateAccount privateAccount = new PrivateAccount(driver);
        privateAccount.moveToPersonalAccountByClick();
        boolean actualResult = privateAccount.logoutFromPrivateAccount();
        assertEquals(true, actualResult);
    }

    @After
    public void tearDown(){
        driver.quit();
        given()
                .header("Authorization", token)
                .delete("/api/auth/user");
    }
}
