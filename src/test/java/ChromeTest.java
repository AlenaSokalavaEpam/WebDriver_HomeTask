import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class ChromeTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("http://google.com/");
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("Top Films123321");
        WebElement searchButton = driver.findElement(By.xpath("//*[@value='Пошук Google']"));
        searchButton.click();
        Thread.sleep(2000);
        driver.quit();
    }
}
