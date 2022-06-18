package lab2.pageobject_model.pagefactory.test;

import lab1.pageobject_model.pagefactory.page.PasteBinHomePagePF;
import lab2.pageobject_model.pagefactory.page.PasteBinResultPagePF;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverPasteBinCheckResultTest {
    private WebDriver driver;

    static String titleName = "how to gain dominance among developers";

    static String codeStr = "git config --global user.name  \"New Sheriff in Town\"\n" +
                            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                            "git push origin master --force";

    static String bashStr = "bash";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup () {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void createNewPaste () {
        PasteBinResultPagePF resultPage = new PasteBinHomePagePF(driver)
                                                .openPage()
                                                .setupCode(codeStr)
                                                .choseExpTime(2)
                                                .setupSyntax(0)
                                                .setupName(titleName)
                                                .clickSubmit();

        Assert.assertTrue(titleName.equals(resultPage.getTitle()), "Title not correct");

        Assert.assertTrue(bashStr.equals(resultPage.getSyntaxAttrString()), "Syntax not correct");

        Assert.assertTrue(codeStr.equals(resultPage.getCodeText()), "Code not correct");
    }

    @AfterMethod(alwaysRun = true)
    public void browserDown () {
        driver.quit();
        driver = null;
    }
}
