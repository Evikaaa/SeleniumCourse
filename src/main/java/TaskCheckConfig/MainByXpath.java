package TaskCheckConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 Zadanie 4 - By.xpath
 Wyszukaj elementy przy pomocy lokalizatora By.xpath
 Będąc na stronie rejestracji nowego użytkownika (patrz zadanie 3), wyszukaj za pomocą lokalizatorów xpath
 wszystkie wymagane pola tekstowe oraz wypełnij je dowolnymi danymi:

 First Name
 Last Name
 Email
 Password
 Kliknij przycisk Register, który również wyszukaj przy pomocy lokalizatora By.xpath.
 */
public class MainByXpath {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/en/");

        driver.findElement(By.className("user_login")).click();
        WebElement accountInput = driver.findElement(By.className("account_input"));
        //email można zapisać do zmiennej i przywołać ponownie do wstawienia w polu email
        //String randomEmail = generateEmail();
        accountInput.sendKeys(generateEmail());
        driver.findElement(By.id("SubmitCreate")).click();
        Thread.sleep(2000);

        // szukamy //input[@id='customer_firstname']
        driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("John");
        driver.findElement(By.xpath("//input[@name='customer_lastname']")).sendKeys("Doe");
        WebElement emailInput = driver.findElement(By.xpath("//input[@id='email']"));
        //szukamu buttona, nie inputa
        driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys("secretpass");

        driver.findElement(By.xpath("//button[@id='submitAccount']")).click();

        //nie będzie działać, bo strona się odświeży i nie wszystkie dane są dostępne od razu,
        //trzeba go sztucznie opóźnić, na tym etapie nauki sleepem
//        driver.quit();
    }

    public static String generateEmail() {
        return "art" + System.currentTimeMillis() + "@test.com";

    }
}
