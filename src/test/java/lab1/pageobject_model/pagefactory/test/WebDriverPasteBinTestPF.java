package lab1.pageobject_model.pagefactory.test;

import lab1.pageobject_model.pagefactory.page.PasteBinHomePagePF;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverPasteBinTestPF {
    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup () {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void createNewPaste () {
        new PasteBinHomePagePF(driver)
                .openPage()
                .setupCode("Hello from WebDriver")
                .choseExpTime(2)
                .setupName("helloweb")
                .clickSubmit();
    }

    @AfterMethod (alwaysRun = true)
    public void browserDown () {
        driver.quit();
        driver = null;
    }
}
