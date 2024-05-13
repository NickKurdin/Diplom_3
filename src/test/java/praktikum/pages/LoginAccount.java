package praktikum.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class LoginAccount {
    private final WebDriver driver;

    public LoginAccount (WebDriver browser){
        driver = browser;
    }

    private final By enterAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By enterPersonalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
    private final By enterInRegistrationForm = By.xpath(".//a[text()='Войти']");
    private final By enterInRecoveryPasswordForm = By.xpath(".//p[text()='Вспомнили пароль?']/a[text()='Войти']");
    private final By registerButton = By.xpath(".//a[text()='Зарегистрироваться']");
    private final By recoveryPasswordButton = By.xpath(".//a[text()='Восстановить пароль']");
    private final By emailRegistrationField = By.xpath(".//div[label[text() = 'Email']]/input[@name = 'name']");
    private final By passwordRegistrationField = By.xpath(".//div[label[text() = 'Пароль']]/input[@name = 'Пароль']");
    private final By finalEnterAccountButton = By.xpath(".//button[text() = 'Войти']");
    private final By headerAssembleBurger = By.xpath(".//h1[text() = 'Соберите бургер']");

    public void moveToAuthorizationFormByEnterAccountButton(){
        driver.findElement(enterAccountButton).click();
    }

    public void moveToRegistrationForm(){
        driver.findElement(registerButton).click();
    }

    public void moveToPersonalAccount(){
        driver.findElement(enterPersonalAccountButton).click();
    }

    public void loginFromRegistrationFormEnterButton(){
        driver.findElement(enterInRegistrationForm).click();
    }

    public void fillAuthorizationForm(String email, String password){
        driver.findElement(emailRegistrationField).sendKeys(email);
        driver.findElement(passwordRegistrationField).sendKeys(password);
    }

    public boolean checkLogin(){
        driver.findElement(finalEnterAccountButton).click();
        try{
            new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.presenceOfElementLocated(headerAssembleBurger));
        }
        catch(TimeoutException exception) {
            return false;
        }
        return true;
    }

    public void finalClickToEnterAccount(){
        WebElement element = driver.findElement(finalEnterAccountButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(finalEnterAccountButton).click();
    }

    public void moveToRecoveryPasswordForm(){
        WebElement element = driver.findElement(recoveryPasswordButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(recoveryPasswordButton).click();
    }

    public void moveToAuthorizationFormFromRecoveryPasswordForm(){
        driver.findElement(enterInRecoveryPasswordForm).click();
    }

    public boolean loginByEnterAccountButtonOnMainPage(String email, String password){
        moveToAuthorizationFormByEnterAccountButton();
        fillAuthorizationForm(email, password);
        return checkLogin();
    }

    public boolean loginByPersonalAccountButton(String email, String password){
        moveToPersonalAccount();
        fillAuthorizationForm(email, password);
        return checkLogin();
    }

    public boolean loginByRegisterButton(String email, String password){
        moveToPersonalAccount();
        moveToRegistrationForm();
        loginFromRegistrationFormEnterButton();
        fillAuthorizationForm(email, password);
        return checkLogin();
    }

    public boolean loginByRecoveryButton(String email, String password){
        moveToAuthorizationFormByEnterAccountButton();
        moveToRecoveryPasswordForm();
        moveToAuthorizationFormFromRecoveryPasswordForm();
        fillAuthorizationForm(email, password);
        return checkLogin();
    }


}
