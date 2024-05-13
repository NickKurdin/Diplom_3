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
import praktikum.pages.LoginAccount;
import praktikum.pages.PrivateAccount;
import static org.junit.Assert.assertTrue;

public class PrivateAccountTest {
    private WebDriver driver;
    private final String url = "https://stellarburgers.nomoreparties.site";
    private String name;
    private String email;
    private String password;
    private String token;

    @Before
    public void initialization() {
        RestAssured.baseURI = url;
        API request = new API();
        name = "Ник";
        email = "burdin_nickita@yandex.ru";
        password = "burdin_nickita";
        token = request.createUser(email, password, name);
        WebDriverConstructor webDriverConstructor = new WebDriverConstructor();
        driver = webDriverConstructor.getWebDriver();
        driver.get(url);
    }

    @Test
    @DisplayName("Переход из главной страницы в \"Личный кабинет\"")
    @Description("Переход при клике из главной страницы в \"Личный кабинет\"")
    public void checkMoveFromMainPageToPrivateAccount() {
        LoginAccount loginAccount = new LoginAccount(driver);
        moveToAuthorizationFormForCheckMoveFromMainPageToPrivateAccount(loginAccount);
        fillAuthorizationFormForCheckMoveFromMainPageToPrivateAccount(loginAccount);
        finalClickToEnterAccountForCheckMoveFromMainPageToPrivateAccount(loginAccount);
        finallyCheckClickForCheckMoveFromMainPageToPrivateAccount();

    }
    @Step("Переход к форме авторизации")
    public void moveToAuthorizationFormForCheckMoveFromMainPageToPrivateAccount(LoginAccount loginAccount){
        loginAccount.moveToAuthorizationFormByEnterAccountButton();
    }
    @Step("Заполнение формы авторизации")
    public void fillAuthorizationFormForCheckMoveFromMainPageToPrivateAccount(LoginAccount loginAccount){
        loginAccount.fillAuthorizationForm(email, password);
    }
    @Step("Нажать на кнопку \"Войти в аккаунт\"")
    public void finalClickToEnterAccountForCheckMoveFromMainPageToPrivateAccount(LoginAccount loginAccount){
        loginAccount.finalClickToEnterAccount();
    }
    @Step("Проверка перехода в раздел \"Личный кабинет\"")
    public void finallyCheckClickForCheckMoveFromMainPageToPrivateAccount(){
        PrivateAccount privateAccount = new PrivateAccount(driver);
        boolean actualResult = privateAccount.checkMoveToPersonalAccountByClick();
        assertTrue(actualResult);
    }


    @Test
    @DisplayName("Переход из \"Личного кабинета\" в \"Конструктор\"")
    @Description("Переход при клике из главной страницы в \"Личный кабинет\" при нажатии кнопки \"Конструктор\"")
    public void checkMoveFromPrivateAccountToConstructorByClickConstructorButton() {
        LoginAccount loginAccount = new LoginAccount(driver);
        PrivateAccount privateAccount = new PrivateAccount(driver);
        moveToAuthorizationFormForCheckMoveFromPrivateAccountToConstructor(loginAccount);
        fillAuthorizationFormForCheckMoveFromPrivateAccountToConstructor(loginAccount);
        finalClickToEnterAccountForCheckMoveFromPrivateAccountToConstructor(loginAccount);
        moveToPersonalAccountForCheckMoveFromPrivateAccountToConstructor(privateAccount);
        finallyCheckClickForCheckMoveFromPrivateAccountToConstructor(privateAccount);
    }
    @Step("Переход к форме авторизации")
    public void moveToAuthorizationFormForCheckMoveFromPrivateAccountToConstructor(LoginAccount loginAccount){
        loginAccount.moveToAuthorizationFormByEnterAccountButton();
    }
    @Step("Заполнение формы авторизации")
    public void fillAuthorizationFormForCheckMoveFromPrivateAccountToConstructor(LoginAccount loginAccount){
        loginAccount.fillAuthorizationForm(email, password);
    }
    @Step("Нажать на кнопку \"Войти в аккаунт\"")
    public void finalClickToEnterAccountForCheckMoveFromPrivateAccountToConstructor(LoginAccount loginAccount){
        loginAccount.finalClickToEnterAccount();
    }
    @Step("Проверка перехода в раздел \"Личный кабинет\"")
    public void moveToPersonalAccountForCheckMoveFromPrivateAccountToConstructor(PrivateAccount privateAccount){
        privateAccount.moveToPersonalAccountByClick();
    }
    @Step("Клик на по кнопке \"Конструктор\"")
    public void finallyCheckClickForCheckMoveFromPrivateAccountToConstructor(PrivateAccount privateAccount){
        boolean actualResult = privateAccount.moveToConstructorByClickButton();
        assertTrue(actualResult);
    }

    @Test
    @DisplayName("Переход из \"Личного кабинета\" в \"Конструктор\"")
    @Description("Переход из \"Личного кабинета\" в \"Конструктор\" при нажатии на лого")
    public void checkMoveFromPrivateAccountToConstructorByClickLogoChrome() {
        LoginAccount loginAccount = new LoginAccount(driver);
        PrivateAccount privateAccount = new PrivateAccount(driver);
        moveToAuthorizationFormForCheckMoveFromPrivateAccountToConstructorByClickLogo(loginAccount);
        fillAuthorizationFormForCheckMoveFromPrivateAccountToConstructorByClickLogo(loginAccount);
        finalClickToEnterAccountForCheckMoveFromPrivateAccountToConstructorByClickLogo(loginAccount);
        moveToPersonalAccountForCheckMoveFromPrivateAccountToConstructorByClickLogo(privateAccount);
        finallyCheckClickForCheckMoveFromPrivateAccountToConstructorByClickLogo(privateAccount);
    }
    @Step("Переход к форме авторизации")
    public void moveToAuthorizationFormForCheckMoveFromPrivateAccountToConstructorByClickLogo(LoginAccount loginAccount){
        loginAccount.moveToAuthorizationFormByEnterAccountButton();
    }
    @Step("Заполнение формы авторизации")
    public void fillAuthorizationFormForCheckMoveFromPrivateAccountToConstructorByClickLogo(LoginAccount loginAccount){
        loginAccount.fillAuthorizationForm(email, password);
    }
    @Step("Нажать на кнопку \"Войти в аккаунт\"")
    public void finalClickToEnterAccountForCheckMoveFromPrivateAccountToConstructorByClickLogo(LoginAccount loginAccount){
        loginAccount.finalClickToEnterAccount();
    }
    @Step("Проверка перехода в раздел \"Личный кабинет\"")
    public void moveToPersonalAccountForCheckMoveFromPrivateAccountToConstructorByClickLogo(PrivateAccount privateAccount){
        privateAccount.moveToPersonalAccountByClick();
    }
    @Step("Нажать на лого сайта")
    public void finallyCheckClickForCheckMoveFromPrivateAccountToConstructorByClickLogo(PrivateAccount privateAccount){
        boolean actualResult = privateAccount.moveToConstructorByLogo();
        assertTrue(actualResult);
    }

    @Test
    @DisplayName("Выход из \"Личного кабинета\"")
    @Description("Выход из \"Личного кабинета\" при клике на кнопку \"Выход\" в личном кабинете")
    public void checkExitFromPrivateAccount() {
        LoginAccount loginAccount = new LoginAccount(driver);
        PrivateAccount privateAccount = new PrivateAccount(driver);
        moveToAuthorizationFormForCheckExitFromPrivateAccount(loginAccount);
        fillAuthorizationFormForCheckExitFromPrivateAccount(loginAccount);
        finalClickToEnterAccountForCheckExitFromPrivateAccount(loginAccount);
        moveToPersonalAccountForCheckExitFromPrivateAccount(privateAccount);
        finallyCheckClickForCheckExitFromPrivateAccount(privateAccount);
    }
    @Step("Переход к форме авторизации")
    public void moveToAuthorizationFormForCheckExitFromPrivateAccount(LoginAccount loginAccount){
        loginAccount.moveToAuthorizationFormByEnterAccountButton();
    }
    @Step("Заполнение формы авторизации")
    public void fillAuthorizationFormForCheckExitFromPrivateAccount(LoginAccount loginAccount){
        loginAccount.fillAuthorizationForm(email, password);
    }
    @Step("Нажать на кнопку \"Войти в аккаунт\"")
    public void finalClickToEnterAccountForCheckExitFromPrivateAccount(LoginAccount loginAccount){
        loginAccount.finalClickToEnterAccount();
    }
    @Step("Переход в раздел \"Личный кабинет\"")
    public void moveToPersonalAccountForCheckExitFromPrivateAccount(PrivateAccount privateAccount){
        privateAccount.moveToPersonalAccountByClick();
    }
    @Step("Нажать на кнопку \"Выход\" в личном кабинете")
    public void finallyCheckClickForCheckExitFromPrivateAccount(PrivateAccount privateAccount){
        boolean actualResult = privateAccount.logoutFromPrivateAccount();
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
