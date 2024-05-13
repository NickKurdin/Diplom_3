package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverConstructor {
    private String browserName;

    public WebDriverConstructor() {
        this.browserName = System.getProperty("browser");
    }

    public WebDriver getWebDriver() {
        if (browserName == null) {
            browserName = "chrome";
        }
        WebDriver driver;
        switch (browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/yandexdriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            default:
                throw new RuntimeException("Некорректный браузер");
        }
        return driver;
    }
}