import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloWebDriver {
    public static void main(String[] args) throws InterruptedException {
  //      WebDriver driver = new ChromeDriver();
  //      driver.get("http://seleniumhq.org");
  //      Thread.sleep(2000);
  //      driver.quit();

        WebDriver driver = new EdgeDriver();
        driver.get("http://seleniumhq.org");
       Thread.sleep(2000);
       driver.quit();

        driver = new FirefoxDriver();
        driver.get("http://seleniumhq.org");
        Thread.sleep(2000);
        driver.quit();
    }
}
