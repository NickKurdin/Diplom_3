package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrivateAccount {
    private final WebDriver driver;
    public LoginAccount loginAccount;

    public PrivateAccount(WebDriver browser){
        driver = browser;
    }

    By enterPersonalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
    By headerProfile = By.xpath(".//a[text() = 'Профиль']");
    By constructorButton = By.xpath(".//p[text() = 'Конструктор']");
    By headerAssembleBurger = By.xpath(".//h1[text() = 'Соберите бургер']");
    By logoStellarBurgers = By.xpath(".//a[@class='active']");
    By exitFromPrivateAccount = By.xpath(".//button[text()='Выход']");
    By headerEnter = By.xpath(".//h2[text()='Вход']");

    public boolean checkMoveToPersonalAccountByClick(){
        new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.presenceOfElementLocated(headerAssembleBurger));
        moveToPersonalAccountByClick();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(headerProfile));
        return true;
    }

    public void moveToPersonalAccountByClick(){
        driver.findElement(enterPersonalAccountButton).click();
    }

    public boolean moveToConstructorByClickButton(){
        driver.findElement(constructorButton).click();
        return driver.findElement(headerAssembleBurger).isDisplayed();
    }

    public boolean moveToConstructorByLogo(){
        driver.findElement(logoStellarBurgers).click();
        return driver.findElement(headerAssembleBurger).isDisplayed();
    }

    public boolean logoutFromPrivateAccount(){
        driver.findElement(exitFromPrivateAccount).click();
        return driver.findElement(headerEnter).isDisplayed();
    }

}
