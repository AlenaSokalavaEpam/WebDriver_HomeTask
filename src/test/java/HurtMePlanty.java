import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HurtMePlanty {
    // String manualPrice = "USD 1,081.20";

    @Test
    public void HurtMePlantyTest() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://cloud.google.com/");

        String searchBtnPass = "//div[@class='devsite-search-container']";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(searchBtnPass)));

        WebElement searchBtn = driver.findElement(By.xpath(searchBtnPass));
        searchBtn.click();

        String searchFieldPass = "//input[@class='devsite-search-field devsite-search-query']";
        WebElement searchField = driver.findElement(By.xpath(searchFieldPass));
        searchField.sendKeys("Google Cloud Platform Pricing Calculator");
        searchField.submit();

        WebDriverWait waitLink = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitLink.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Google Cloud Platform Pricing Calculator")));
        WebElement calcLink = driver.findElement(By.linkText("Google Cloud Platform Pricing Calculator"));
        calcLink.click();


        WebDriverWait waitFrame = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitFrame.until(ExpectedConditions.presenceOfElementLocated(By.id("cloud-site")));

        WebElement articleCloudSite = driver.findElement(By.id("cloud-site"));

        List<WebElement> frames = articleCloudSite.findElements(By.tagName("iframe"));

        driver.switchTo().frame(frames.get(0));

        WebElement myFrame = driver.findElement(By.id("myFrame"));

        driver.switchTo().frame(myFrame);

        WebElement tabItem = driver.findElement(By.xpath("//md-tab-item[@aria-controls='tab-content-1']"));
        tabItem.click();

        WebElement instNumber = driver.findElement(By.id("input_85"));
        instNumber.sendKeys("4");

        WebDriverWait waitInstFor = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitInstFor.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@ng-model='listingCtrl.computeServer.label']")));

        WebElement whatInstFor = driver.findElement(By.xpath("//*[@ng-model='listingCtrl.computeServer.label']"));
        whatInstFor.sendKeys("");

        WebElement operSystem = driver.findElement(By.id("select_value_label_77"));
        operSystem.click();
        WebElement freeSoft = driver.findElement(By.id("select_option_87"));
        freeSoft.click();

        WebElement vmClass = driver.findElement(By.id("select_value_label_78"));
        vmClass.click();
        WebElement selectVmClass = driver.findElement(By.id("select_option_100"));
        selectVmClass.click();

        WebDriverWait waitSeries = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitSeries.until(ExpectedConditions.presenceOfElementLocated(By.id("select_value_label_80")));
        WebElement series = driver.findElement(By.id("select_value_label_80"));
        series.click();

        WebDriverWait waitSelectSeariesOpt = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitSelectSeariesOpt.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@value='n1']")));
        WebElement selectSeriesOpt = driver.findElement(By.xpath("//*[@value='n1']"));
        selectSeriesOpt.click();



        WebElement machineType = driver.findElement(By.id("select_value_label_81"));
        machineType.click();


        WebDriverWait waitSelectMachineType = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitSelectMachineType.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")));
        WebElement selectMachineType = driver.findElement(By.xpath("//*[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']"));
        selectMachineType.click();

        WebDriverWait waitAddGpu = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitAddGpu.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label='Add GPUs']")));
        WebElement addGpu = driver.findElement(By.xpath("//*[@aria-label='Add GPUs']"));
        addGpu.click();


        WebDriverWait waitGpuType = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitGpuType.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@placeholder='GPU type']")));
        WebElement gpuType = driver.findElement(By.xpath("//*[@placeholder='GPU type']"));
        gpuType.click();
        WebElement selectGpuType = driver.findElement(By.xpath("//*[@value='NVIDIA_TESLA_V100']"));
        selectGpuType.click();

        WebElement numberGpus = driver.findElement(By.xpath("//*[@placeholder='Number of GPUs']"));
        numberGpus.click();
        WebElement searchNumberGpus = driver.findElement(By.xpath("//*[@ng-repeat='item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]'][@value='1']"));
        searchNumberGpus.click();

        WebElement localSsd = driver.findElement(By.id("select_410"));
        localSsd.click();
        WebElement selectLocalSsd = driver.findElement(By.xpath("//*[@ng-repeat='item in listingCtrl.dynamicSsd.computeServer'][@value='2']"));
        selectLocalSsd.click();

        WebDriverWait waitDataCenterLocate = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitDataCenterLocate.until(ExpectedConditions.presenceOfElementLocated(By.id("select_value_label_83")));
        WebElement dataCenterLocate = driver.findElement(By.id("select_value_label_83"));
        dataCenterLocate.click();

        WebDriverWait waitSearchDataCenter = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitSearchDataCenter.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@ng-repeat='item in listingCtrl.fullRegionList | filter:listingCtrl.inputRegionText.computeServer'][@value='europe-west3']")));
        WebElement searchdataCenterLocate = driver.findElement(By.xpath("//*[@ng-repeat='item in listingCtrl.fullRegionList | filter:listingCtrl.inputRegionText.computeServer'][@value='europe-west3']"));
        searchdataCenterLocate.click();

        WebElement estimate = driver.findElement(By.xpath("//*[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']"));
        estimate.click();

        driver.quit();
    }
}
