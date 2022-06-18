package lab2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.time.Duration;
import java.util.List;

public class BringItOn {

    static String titleName = "how to gain dominance among developers";
    static String codeStr = "git config --global user.name  \"New Sheriff in Town\"\n" +
                            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                            "git push origin master --force";

    static String bashStr = "bash";

    @Test
    public void bringItOnTest() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://pastebin.com");

        setupCode(driver);

        chooseExpirationTime(driver);

        selectSyntax(driver);

        setupName(driver);

        clickSubmit(driver);

        checkConditions(driver);

        driver.quit();
    }

    private void selectSyntax(WebDriver driver) {
        String searchXPath = "//*[@id='select2-postform-format-container']";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(searchXPath)));

        WebElement syntaxField = driver.findElement(By.xpath(searchXPath));
        syntaxField.click();
        List<WebElement> syntaxEls = driver.findElements(By.xpath("//ul[@class='select2-results__options select2-results__options--nested']/li"));
        syntaxEls.get(0).click();
    }

    private static void clickSubmit(WebDriver driver) {
        WebElement submit = driver.findElement(By.xpath ("//button[@type = 'submit']"));
        submit.click();
    }

    private static void setupName(WebDriver driver) {
        WebElement searchTitle = driver.findElement(By.id("postform-name"));
        searchTitle.sendKeys(titleName);
    }

    private static void chooseExpirationTime(WebDriver driver) {
        String searchXPath = "//*[@id='select2-postform-expiration-container']";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(searchXPath)));

        WebElement epirationField = driver.findElement(By.xpath(searchXPath));
        epirationField.click();

        List<WebElement> els = driver.findElements(By.xpath("//ul[@role = 'listbox']/li"));
        els.get(2).click();
    }

    private static void setupCode(WebDriver driver) {
        WebElement searchInput = driver.findElement(By.id("postform-text"));
        searchInput.sendKeys(codeStr);
    }

    private static void checkConditions(WebDriver driver) {
        // 1
        String titleBin = "//div[@class='info-top']/h1";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(titleBin)));

        WebElement checkTitle = driver.findElement(By.xpath(titleBin));
        Assert.assertTrue(titleName.equals(checkTitle.getText()), "Title not correct");

        // 2
        WebElement bashClass = driver.findElement(By.xpath("//div[@class='source']/ol"));
        Assert.assertTrue(bashStr.equals(bashClass.getAttribute("class")), "Not bash syntax");

        // 3
        WebElement bashRaw = driver.findElement(By.xpath("//textarea[@class='textarea -raw js-paste-raw']"));
        Assert.assertTrue(codeStr.equals(bashRaw.getText()), "Code is not correct");
    }
}