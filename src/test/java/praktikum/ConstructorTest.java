package praktikum;

import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import praktikum.pages.Constructor;
import praktikum.pages.LoginAccount;
import static org.junit.Assert.assertEquals;

public class ConstructorTest {

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
        token = request.createUser(email, password, name);    }

    @Test
    public void checkClickOnBunsChrome() {
        driver = createDriver("chrome");
        driver.get(url);
        LoginAccount loginAccount = new LoginAccount(driver);
        loginAccount.moveToAuthorizationFormByEnterAccountButton();
        loginAccount.fillAuthorizationForm(name, email);
        loginAccount.finalClickToEnterAccount();
        Constructor constructor = new Constructor(driver);
        boolean actualResult = constructor.clickOnBuns();
        assertEquals(true, actualResult);
    }

    @Test
    public void checkClickOnSaucesChrome() {
        driver = createDriver("chrome");
        driver.get(url);
        LoginAccount loginAccount = new LoginAccount(driver);
        loginAccount.moveToAuthorizationFormByEnterAccountButton();
        loginAccount.fillAuthorizationForm(name, email);
        loginAccount.finalClickToEnterAccount();
        Constructor constructor = new Constructor(driver);
        boolean actualResult = constructor.clickOnSauces();
        assertEquals(true, actualResult);
    }

    @Test
    public void checkClickOnFillingsChrome() {
        driver = createDriver("chrome");
        driver.get(url);
        LoginAccount loginAccount = new LoginAccount(driver);
        loginAccount.moveToAuthorizationFormByEnterAccountButton();
        loginAccount.fillAuthorizationForm(name, email);
        loginAccount.finalClickToEnterAccount();
        Constructor constructor = new Constructor(driver);
        boolean actualResult = constructor.clickOnFillings();
        assertEquals(true, actualResult);
    }

    @Test
    public void checkClickOnBunsYandex() {
        driver = createDriver("yandex");
        driver.get(url);
        LoginAccount loginAccount = new LoginAccount(driver);
        loginAccount.moveToAuthorizationFormByEnterAccountButton();
        loginAccount.fillAuthorizationForm(name, email);
        loginAccount.finalClickToEnterAccount();
        Constructor constructor = new Constructor(driver);
        boolean actualResult = constructor.clickOnBuns();
        assertEquals(true, actualResult);
    }

    @Test
    public void checkClickOnSaucesYandex() {
        driver = createDriver("yandex");
        driver.get(url);
        LoginAccount loginAccount = new LoginAccount(driver);
        loginAccount.moveToAuthorizationFormByEnterAccountButton();
        loginAccount.fillAuthorizationForm(name, email);
        loginAccount.finalClickToEnterAccount();
        Constructor constructor = new Constructor(driver);
        boolean actualResult = constructor.clickOnSauces();
        assertEquals(true, actualResult);
    }

    @Test
    public void checkClickOnFillingsYandex() {
        driver = createDriver("yandex");
        driver.get(url);
        LoginAccount loginAccount = new LoginAccount(driver);
        loginAccount.moveToAuthorizationFormByEnterAccountButton();
        loginAccount.fillAuthorizationForm(name, email);
        loginAccount.finalClickToEnterAccount();
        Constructor constructor = new Constructor(driver);
        boolean actualResult = constructor.clickOnFillings();
        assertEquals(true, actualResult);
    }

    @After
    public void tearDown() {
        driver.quit();
        RestAssured.baseURI = url;
        API request = new API();
        token = request.loginUser(email, password);
        if (token != null) {
            request.deleteUser(token);
        }
    }

}
