package HomeWorkSelenium;

/**
 Zadanie 1
 Nawigacja
 Na stronie https://mystore-testlab.coderslab.pl/index.php wykonaj następującą sekwencję kroków:

 Wejdź na stronę główną.
 Przejdź do opcji 'Sign in'
 Wybierz opcję 'No account? Create one here'
 Za pomocą metod nawigacyjnych przejdź do strony głównej.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainTask01_CreateAccount {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        driver.findElement(By.className("user-info")).click();
        driver.findElement(By.className("no-account")).click();
        driver.findElement(By.className("radio-inline")).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Jane");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Doe");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(generateEmail());
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("secretpassword123");
        driver.findElement(By.name("submitCreate")).submit();

    }
    public static String generateEmail(){
        return "art" + System.currentTimeMillis() + "@test.com";
    }
}
