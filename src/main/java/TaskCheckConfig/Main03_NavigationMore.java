package TaskCheckConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main03_NavigationMore {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        driver.findElement(By.id("L2AGLb")).click();
        Thread.sleep(1500);
        driver.get("https://coderslab.pl/pl");
        Thread.sleep(1500);
        driver.navigate().back();
        Thread.sleep(1500);
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        Thread.sleep(1500);
        driver.navigate().back();
        Thread.sleep(1500);
        driver.navigate().forward();
        Thread.sleep(1500);
        driver.navigate().refresh();
        Thread.sleep(1500);
        driver.quit();
    }
}

