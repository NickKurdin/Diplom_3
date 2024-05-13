package praktikum;

import drivers.WebDriverConstructor;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.api.API;
import praktikum.pages.Constructor;
import praktikum.pages.LoginAccount;
import static org.junit.Assert.assertTrue;

public class ConstructorTest {

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
    @DisplayName("Переход к ингредиентам \"Булки\" в разделе \"Конструктор\"")
    @Description("В разделе \"Конструктор\" нажимаем на вкладку \"Булки\"")
    public void checkClickOnBuns() {
        LoginAccount loginAccount = new LoginAccount(driver);
        moveToAuthorizationFormForCheckClickOnBuns(loginAccount);
        fillAuthorizationFormForCheckClickOnBuns(loginAccount);
        finalClickToEnterAccountForCheckClickOnBuns(loginAccount);
        finallyCheckClickOnBuns();
    }
    @Step("Переход к форме авторизации")
    public void moveToAuthorizationFormForCheckClickOnBuns(LoginAccount loginAccount){
        loginAccount.moveToAuthorizationFormByEnterAccountButton();
    }
    @Step("Заполнение формы авторизации")
    public void fillAuthorizationFormForCheckClickOnBuns(LoginAccount loginAccount){
        loginAccount.fillAuthorizationForm(email, password);
    }
    @Step("Нажать на кнопку \"Войти в аккаунт\"")
    public void finalClickToEnterAccountForCheckClickOnBuns(LoginAccount loginAccount){
        loginAccount.finalClickToEnterAccount();
    }
    @Step("Проверка перехода на вкладку \"Булки\"")
    public void finallyCheckClickOnBuns(){
        Constructor constructor = new Constructor(driver);
        boolean actualResult = constructor.clickOnBuns();
        assertTrue(actualResult);
    }

   @Test
    @DisplayName("Переход к ингредиентам \"Соусы\" в разделе \"Конструктор\"")
    @Description("В разделе \"Конструктор\" нажимаем на вкладку \"Соусы\"")
    public void checkClickOnSauces() {
        LoginAccount loginAccount = new LoginAccount(driver);
        moveToAuthorizationFormForCheckClickOnSauces(loginAccount);
        fillAuthorizationFormForCheckClickOnSauces(loginAccount);
        finalClickToEnterAccountForCheckClickOnSauces(loginAccount);
        moveToAuthorizationFormForCheckClickOnBuns();
    }
    @Step("Переход к форме авторизации")
    public void moveToAuthorizationFormForCheckClickOnSauces(LoginAccount loginAccount){
        loginAccount.moveToAuthorizationFormByEnterAccountButton();
    }
    @Step("Заполнение формы авторизации")
    public void fillAuthorizationFormForCheckClickOnSauces(LoginAccount loginAccount){
        loginAccount.fillAuthorizationForm(email, password);
    }
    @Step("Нажать на кнопку \"Войти в аккаунт\"")
    public void finalClickToEnterAccountForCheckClickOnSauces(LoginAccount loginAccount){
        loginAccount.finalClickToEnterAccount();
    }
    @Step("Проверка перехода на вкладку \"Соусы\"")
    public void moveToAuthorizationFormForCheckClickOnBuns(){
        Constructor constructor = new Constructor(driver);
        boolean actualResult = constructor.clickOnSauces();
        assertTrue(actualResult);
    }

    @Test
    @DisplayName("Переход к ингредиентам \"Соусы\" в разделе \"Конструктор\"")
    @Description("В разделе \"Конструктор\" нажимаем на вкладку \"Соусы\"")
    public void checkClickOnFillings() {
        LoginAccount loginAccount = new LoginAccount(driver);
        moveToAuthorizationFormForCheckClickOnFillings(loginAccount);
        fillAuthorizationFormForCheckClickOnFillings(loginAccount);
        finalClickToEnterAccountForCheckClickOnFillings(loginAccount);
        moveToAuthorizationFormForCheckClickOnFillings();
    }
    @Step("Переход к форме авторизации")
    public void moveToAuthorizationFormForCheckClickOnFillings(LoginAccount loginAccount){
        loginAccount.moveToAuthorizationFormByEnterAccountButton();
    }
    @Step("Заполнение формы авторизации")
    public void fillAuthorizationFormForCheckClickOnFillings(LoginAccount loginAccount){
        loginAccount.fillAuthorizationForm(email, password);
    }
    @Step("Нажать на кнопку \"Войти в аккаунт\"")
    public void finalClickToEnterAccountForCheckClickOnFillings(LoginAccount loginAccount){
        loginAccount.finalClickToEnterAccount();
    }
    @Step("Проверка перехода на вкладку \"Начинки\"")
    public void moveToAuthorizationFormForCheckClickOnFillings(){
        Constructor constructor = new Constructor(driver);
        boolean actualResult = constructor.clickOnFillings();
        assertTrue(actualResult);
    }

    @After
    public void tearDown() {
        driver.quit();
        API request = new API();
        token = request.loginUser(email, password);
        if (token != null) {
            request.deleteUser(token);
        }
    }

}
