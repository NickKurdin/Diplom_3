package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginAccount {
    private final WebDriver driver;

    public LoginAccount (WebDriver browser){
        driver = browser;
    }

    By enterAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    By enterPersonalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
    By enterInRegistrationForm = By.xpath(".//a[text()='Войти']");
    By enterInRecoveryPasswordForm = By.xpath(".//p[text()='Вспомнили пароль?']/a[text()='Войти']");
    By registerButton = By.xpath(".//a[text()='Зарегистрироваться']");
    By recoveryPasswordButton = By.xpath(".//a[text()='Восстановить пароль']");
    By emailRegistrationField = By.xpath(".//div[label[text() = 'Email']]/input[@name = 'name']");
    By passwordRegistrationField = By.xpath(".//div[label[text() = 'Пароль']]/input[@name = 'Пароль']");
    By finalEnterAccountButton = By.xpath(".//button[text() = 'Войти']");
    By headerAssembleBurger = By.xpath(".//h1[text() = 'Соберите бургер']");

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
        return driver.findElement(headerAssembleBurger).isDisplayed();
    }

    public void finalClickToEnterAccount(){
        driver.findElement(finalEnterAccountButton).click();
    }

    public void moveToRecoveryPasswordForm(){
        driver.findElement(recoveryPasswordButton).click();
    }

    public void moveToAuthorizationFormFromRecoveryPasswordForm(){
        driver.findElement(enterInRecoveryPasswordForm).click();
    }

}
