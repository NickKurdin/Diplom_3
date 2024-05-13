package praktikum.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrivateAccount {
    private final WebDriver driver;

    public PrivateAccount(WebDriver browser){
        driver = browser;
    }

    private final By enterPersonalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
    private final By headerProfile = By.xpath(".//a[text() = 'Профиль']");
    private final By constructorButton = By.xpath(".//p[text() = 'Конструктор']");
    private final By headerAssembleBurger = By.xpath(".//h1[text() = 'Соберите бургер']");
    private final By logoStellarBurgers = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']/a");
    private final By exitFromPrivateAccount = By.xpath(".//button[text()='Выход']");
    private final By headerEnter = By.xpath(".//h2[text()='Вход']");

    public boolean checkMoveToPersonalAccountByClick(){
        WebElement element = driver.findElement(enterPersonalAccountButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(enterPersonalAccountButton).click();
        try{
            new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.presenceOfElementLocated(headerProfile));
        }
        catch(TimeoutException exception) {
            return false;
        }
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
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(headerProfile));
        WebElement element = driver.findElement(exitFromPrivateAccount);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(exitFromPrivateAccount).click();
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
