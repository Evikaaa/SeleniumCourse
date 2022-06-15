package TaskCheckConfig;

/**
 Zadanie 1 - By.id
 Wyszukaj elementy przy pomocy lokalizatora By.id
 Na stronie https://hotel-testlab.coderslab.pl/en/ zidentyfikuj następująca pola/przyciski za pomocą lokalizatora By.id:


 (pole tekstowe) Hotel Location
 (przycisk) Search Now
 (pole tekstowe) Enter your e-mail (pole na dole stron)
 Po zidentyfikowaniu elementów wpisz następujące wartości w pola tekstowe:

 Hotel Location - Warsaw
 Enter your e-mail - test@test.com
 Użyj metody sendKeys np.


 findElement(By.id("q")).sendKeys("Coderslab");
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainById {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/en/");

        //wer bardziej opisowa
        WebElement hotelLocation = driver.findElement(By.id("hotel_location"));
        hotelLocation.sendKeys("Warsaw");

        //wersja skrócona
        driver.findElement(By.id("search_room_submit"));
        driver.findElement(By.id("newsletter-input")).sendKeys("test@test.com");
        driver.quit();
    }
}
