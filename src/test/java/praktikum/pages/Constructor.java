package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Constructor {
    private final WebDriver driver;

    public Constructor(WebDriver browser){
        driver = browser;
    }

    By ingredientSauces = By.xpath(".//span[text()='Соусы']");
    By ingredientBuns = By.xpath(".//span[text()='Булки']");
    By ingredientFillings = By.xpath(".//span[text()='Начинки']");
    By headerSauces = By.xpath(".//h2[text()='Соусы']");
    By headerBuns = By.xpath(".//h2[text()='Булки']");
    By headerFillings = By.xpath(".//h2[text()='Начинки']");

    public boolean clickOnBuns(){
        driver.findElement(ingredientSauces).click();
        driver.findElement(ingredientBuns).click();
        return driver.findElement(headerBuns).isDisplayed() & driver.findElement(headerSauces).isDisplayed();
    }

    public boolean clickOnSauces(){
        driver.findElement(ingredientSauces).click();
        return driver.findElement(headerSauces).isDisplayed();
    }

    public boolean clickOnFillings(){
        driver.findElement(ingredientFillings).click();
        return driver.findElement(headerFillings).isDisplayed();
    }
}
