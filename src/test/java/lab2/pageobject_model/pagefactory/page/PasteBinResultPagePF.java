package lab2.pageobject_model.pagefactory.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PasteBinResultPagePF {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='info-top']/h1")
    WebElement title;

    @FindBy(xpath = "//div[@class='source']/ol")
    WebElement bashClass;

    @FindBy(xpath = "//textarea[@class='textarea -raw js-paste-raw']")
    WebElement bashRaw;

    public PasteBinResultPagePF (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(title));

        return title.getText();
    }

    public String getSyntaxAttrString() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(bashClass));

        return bashClass.getAttribute("class");
    }

    public String getCodeText() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(bashRaw));

        return bashRaw.getText();
    }
}
