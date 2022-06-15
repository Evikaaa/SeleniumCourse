package TaskCheckConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main02_Navigation {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //wejść na stronę
        driver.get("https://coderslab.pl/pl");
        //metoda sleep rzuca wyjątek, prawy myszy, more actions, pierwsza opcja, interrupted exception
        //sekunda to 1000 milisekund
        Thread.sleep(1500);
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        Thread.sleep(1500);
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        Thread.sleep(1500);
        driver.quit();
    }
}
