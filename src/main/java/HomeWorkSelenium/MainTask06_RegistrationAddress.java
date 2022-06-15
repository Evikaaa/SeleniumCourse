package HomeWorkSelenium;

/**
 Zadanie 6 dodatkowe
 Rejestracja użytkownika
 Ważną funkcjonalnością sklepu jest możliwość zarejestrowania nowego użytkownika. W tym celu przygotuj skrypt,
 który będzie miał możliwość tworzenie dowolnej liczby użytkowników
 w sklepie https://mystore-testlab.coderslab.pl/index.php.

 Po stworzeniu użytkownika uzupełnij również jego dane adresowe (Your Account / Addresses).
 Postaraj się, aby dane były w jak największym stopniu losowe.

 Wskazówki:

 ???  Skrypt powinien mieć możliwość zdefiniowania dowolnej liczby użytkowników, którą chcemy utworzyć. ????
 Zwróć uwagę na komunikat: "The email is already used, please choose another one or sign in."
 Stwórz kilka tablic, które będą zawierały poszczególne dane wymagane do wypełnienia adresu, a następnie dla każdego
 z użytkowników losuj dowolny element z danej tablicy.
 Wykorzystaj losowanie liczb i dodawaj losowe liczby do adresów e-mail.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Random;

public class MainTask06_RegistrationAddress {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.edge.driver",
                "src/main/resources/drivers/msedgedriver.exe");

        EdgeDriver driver = new EdgeDriver();

        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        driver.findElement(By.className("user-info")).click();
        driver.findElement(By.className("no-account")).click();
        driver.findElement(By.className("radio-inline")).click();
        //uzupełnianie danymi usera
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(generateFirstName());
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(generateLastName());
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(generateEmail());
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("secretpassword123");
        driver.findElement(By.name("submitCreate")).submit();

        //wejście w profil usera
        driver.findElement(By.xpath("//a[@title='View my customer account']")).click();
        driver.findElement(By.xpath("//a[@id='address-link']")).click();

        //dane adresowe
        driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(generateAddress());
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys(generateCity());
        driver.findElement(By.xpath("//option[@value='17']")).click();
        driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys(generatePostalcode());

        //zapisanie danych
        driver.findElement(By.xpath("//*[contains(text(),'Save')]")).submit();

    }
    //METHODS
    public static String generateEmail() {
        return "mail" + System.currentTimeMillis() + "@mail.com";
    }

    public static String generatePostalcode() {
        Random random = new Random();
        int postal = random.nextInt(100000);
//        char c = (char) postal;
        return Integer.toString(postal);
    }
    public static String generateAddress() {
        Random random = new Random();
        String[] address = {"Bay View Avenue", "Middle Boulevard", "Marine Passage", "Middle Boulevard",
                "Hind Lane", "Gold Route", "Feathers Row", "Princess Lane", "Water Boulevard", "Gold Route",
                "Lavender Street", "Beaver Lane"};
        for (int i = 0; i < 1; i++) {
        }
        return address[random.nextInt(address.length)];
    }

    public static String generateCity() {
        Random random = new Random();
        String[] city = {"Blaachester", "Trares", "Ylogow", "Yarsey", "Khonio", "Eywood", "Eyhokbus",
                "Blans", "Khohgate", "Vaxby", "Yrathe", "Okfield"};
        for (int i = 0; i < 1; i++) {
        }
        return city[random.nextInt(city.length)];
    }
    public static String generateFirstName() {
        Random random = new Random();
        String[] firstName = {"Thorelf", "Ulfeid", "Thorljot", "Groa", "Ljufu", "Torunn", "Mœid", "Matilda", "Sigvor",
                "Thorfrid", "Thorgunna", "Ketiloy"};
        for (int i = 0; i < 1; i++) {
        }
        return firstName[random.nextInt(firstName.length)];
    }

    public static String generateLastName() {
        Random random = new Random();
        String[] lastName = {"Steinketilldottir", "Arnketilldottir", "Jarlabankidottir",
                "Hjalkardottir", "Rodmardottir", "Thormardottir",
                "Ingvardottir", "Frodidottir", "Samdottir", "Guthrothdottir",
                "Gislidottir", "Naddodottir"};
        for (int i = 0; i < 1; i++) {
        }
        return lastName[random.nextInt(lastName.length)];
    }



}
