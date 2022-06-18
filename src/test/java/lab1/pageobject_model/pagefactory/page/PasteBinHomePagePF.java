package lab1.pageobject_model.pagefactory.page;

import lab2.pageobject_model.pagefactory.page.PasteBinResultPagePF;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PasteBinHomePagePF {
    private static final String HOMEPAGE_URL = "https://pastebin.com";
    private WebDriver driver;

    @FindBy(id = "postform-text")
    @CacheLookup
    WebElement searchInput;

    @FindBy(xpath = "//*[@id='select2-postform-expiration-container']")
    WebElement expirationField;

    @FindBy(id = "postform-name")
    WebElement nameField;

    @FindBy(xpath = "//ul[@class='select2-results__options select2-results__options--nested']")
    WebElement syntaxNameList;

    @FindBy(xpath = "//ul[@class='select2-results__options select2-results__options--nested']/li")
    List<WebElement> syntaxNameVariants;

    @FindBy(xpath = "//*[@id='select2-postform-format-container']")
    WebElement syntaxField;

    @FindBy(xpath = "//button[@type = 'submit']")
    WebElement submitBtn;

    public PasteBinHomePagePF (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PasteBinHomePagePF openPage () {
        driver.get(HOMEPAGE_URL);

        return this;
    }

    public PasteBinHomePagePF setupCode (String codeStr) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(searchInput));

        searchInput.sendKeys(codeStr);

        return this;
    }

    public PasteBinHomePagePF choseExpTime (int order) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(expirationField));

        expirationField.click();

        List<WebElement> els = driver.findElements(By.xpath("//ul[@role = 'listbox']/li"));
        els.get(order).click();

        return this;
    }

    public PasteBinHomePagePF setupName (String name) {
        nameField.sendKeys(name);

        return this;
    }

    public PasteBinHomePagePF setupSyntax (int syntax) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(syntaxField));

        syntaxField.click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(syntaxNameList));

        syntaxNameVariants.get(syntax).click();

        return this;
    }

    public PasteBinResultPagePF clickSubmit () {
        submitBtn.click();

        return new PasteBinResultPagePF(driver);
    }
}
