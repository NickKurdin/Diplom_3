package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Registration {
    private final WebDriver driver;

    public Registration (WebDriver browser){
        driver = browser;
    }

    private final By enterAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By registerButton = By.xpath(".//a[text()='Зарегистрироваться']");
    private final By nameRegistrationField = By.xpath(".//div[label[text() = 'Имя']]/input[@name = 'name']");
    private final By emailRegistrationField = By.xpath(".//div[label[text() = 'Email']]/input[@name = 'name']");
    private final By passwordRegistrationField = By.xpath(".//div[label[text() = 'Пароль']]/input[@name = 'Пароль']");
    private final By finalRegistrationButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private final By headerEnter = By.xpath(".//h2[text()='Вход']");

    public boolean createUser(String name, String email, String password){
        driver.findElement(enterAccountButton).click();
        driver.findElement(registerButton).click();
        driver.findElement(nameRegistrationField).sendKeys(name);
        driver.findElement(emailRegistrationField).sendKeys(email);
        driver.findElement(passwordRegistrationField).sendKeys(password);
        driver.findElement(finalRegistrationButton).click();
        try{
            new WebDriverWait(driver, 3)
            .until(ExpectedConditions.presenceOfElementLocated(headerEnter));
        }
        catch(TimeoutException exception) {
            return false;
        }
        return true;
    }

}
