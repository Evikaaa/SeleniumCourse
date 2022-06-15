package TaskCheckConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 https://www.w3schools.com/cssref/css_selectors.asp
 ściąga selektory CSS


 Zadanie 5 - By.cssSelector
 Wyszukaj elementy przy pomocy lokalizatora By.cssSelector
 Po utworzeniu konta na stronie https://hotel-testlab.coderslab.pl/en zidentyfikuj następujące pola korzystając z lokalizatora By.cssSelector:

 MY PERSONAL INFORMATION
 MY ADDRESSES
 */
public class MainByCssSelector {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/en/");

        driver.findElement(By.className("user_login")).click();
        WebElement accountInput = driver.findElement(By.className("account_input"));
        accountInput.sendKeys(generateEmail());
        driver.findElement(By.id("SubmitCreate")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("John");
        driver.findElement(By.xpath("//input[@name='customer_lastname']")).sendKeys("Doe");
        WebElement emailInput = driver.findElement(By.xpath("//input[@id='email']"));
        driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys("secretpass");

        driver.findElement(By.xpath("//button[@id='submitAccount']")).click();

        driver.findElement(By.cssSelector("a[href$=identity]"));
        driver.findElement(By.cssSelector("a[title=Addresses]"));

        driver.quit();
    }

    public static String generateEmail() {
        return "art" + System.currentTimeMillis() + "@test.com";

    }
}
