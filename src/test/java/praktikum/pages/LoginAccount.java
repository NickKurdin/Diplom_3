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

    public boolean loginEnterAccountButton(){}

    public boolean loginEnterPersonalAccountButton(){}

    public boolean loginEnterInRegistrationForm(){}

    public boolean loginEnterInRecoveryPasswordForm(){}


}
