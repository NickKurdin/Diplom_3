package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registration {
    private final WebDriver driver;

    public Registration (WebDriver browser){
        driver = browser;
    }

    By enterAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    By registerButton = By.xpath(".//a[text()='Зарегистрироваться']");
    By nameRegistrationField = By.xpath(".//div[label[text() = 'Имя']]/input[@name = 'name']");
    By emailRegistrationField = By.xpath(".//div[label[text() = 'Email']]/input[@name = 'name']");
    By passwordRegistrationField = By.xpath(".//div[label[text() = 'Пароль']]/input[@name = 'Пароль']");
    By finalRegistrationButton = By.xpath(".//button[text() = 'Зарегистрироваться']");
    By registrationError = By.xpath("//p[text()='Некорректный пароль']");

    public boolean createUser(String name, String email, String password){
        driver.findElement(enterAccountButton).click();
        driver.findElement(registerButton).click();
        driver.findElement(nameRegistrationField).sendKeys(name);
        driver.findElement(emailRegistrationField).sendKeys(email);
        driver.findElement(passwordRegistrationField).sendKeys(password);
        driver.findElement(finalRegistrationButton).click();
        return driver.findElement(registrationError).isDisplayed();
    }

}
