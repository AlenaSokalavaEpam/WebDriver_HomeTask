package lab1;

import io.netty.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class iCanWin {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://pastebin.com");

        setupCode(driver);

        chooseExpirationTime(driver);

        setupName(driver);

        clickSubmit(driver);

        driver.quit();
    }

    private static void clickSubmit(WebDriver driver) {
        WebElement submit = driver.findElement(By.xpath ("//button[@type = 'submit']"));
        submit.click();
    }

    private static void setupName(WebDriver driver) {
        WebElement searchTitle = driver.findElement(By.id("postform-name"));
        searchTitle.sendKeys("helloweb");
    }

    private static void chooseExpirationTime(WebDriver driver) {
        String searchXPath = "//*[@id='select2-postform-expiration-container']";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(searchXPath))));

        WebElement epirationField = driver.findElement(By.xpath(searchXPath));
        epirationField.click();

        List<WebElement> els = driver.findElements(By.xpath("//ul[@role = 'listbox']/li"));
        els.get(2).click();
    }

    private static void setupCode(WebDriver driver) {
        WebElement searchInput = driver.findElement(By.id("postform-text"));
        searchInput.sendKeys("Hello from WebDriver");
    }
}