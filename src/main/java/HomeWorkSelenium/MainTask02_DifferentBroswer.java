package HomeWorkSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

/**
 Zadanie 2
 Inna przeglądrka
 Ściągnij inny sterownik przeglądarki i spróbuj uruchomić dowolny test na innej przeglądarce.
 */


public class MainTask02_DifferentBroswer {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.edge.driver",
                "src/main/resources/drivers/msedgedriver.exe");

        EdgeDriver driver = new EdgeDriver();

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
