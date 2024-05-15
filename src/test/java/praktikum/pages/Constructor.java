package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Constructor {
    private final WebDriver driver;

    public Constructor(WebDriver browser){
        driver = browser;
    }

    private final By assembleBurger = By.xpath(".//h1[text()='Соберите бургер']");

    private final By ingredientSauces = By.xpath(".//div[@class = 'tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text() = 'Соусы']");
    private final By ingredientFillings = By.xpath(".//div[@class = 'tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text() = 'Начинки']");

    private final By checkBuns = By.xpath(".//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text() = 'Булки']");
    private final By checkSauces = By.xpath(".//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text() = 'Соусы']");
    private final By checkFillings = By.xpath(".//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text() = 'Начинки']");
    private final By headerBuns = By.xpath(".//h2[text()='Булки']");

    public boolean clickOnBuns(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(assembleBurger));
        driver.findElement(ingredientSauces).click();
        WebElement element = driver.findElement(headerBuns);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        return driver.findElement(checkBuns).isDisplayed();
    }

    public boolean clickOnSauces(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(ingredientSauces));
        driver.findElement(ingredientSauces).click();
        return driver.findElement(checkSauces).isDisplayed();
    }

    public boolean clickOnFillings(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(ingredientFillings));
        driver.findElement(ingredientFillings).click();
        return driver.findElement(checkFillings).isDisplayed();
    }
}
