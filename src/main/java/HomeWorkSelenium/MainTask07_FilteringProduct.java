package HomeWorkSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.ArrayList;


/**
 Zadanie 7 dodatkowe
 Filtrowanie produktów
 Sprawdź funkcjonalność filtrowania produktów w sklepie https://mystore-testlab.coderslab.pl//index.php.
 Przygotuj skrypt, który zweryfikuje czy po wyborze odpowiedniego filtra wyświetlają się tylko i wyłącznie produkty
 spełniające jego warunki np. czy wyświetlają się tylko produkty w danym przedziale cenowym.

 Wskazówki:

 Pamiętaj, aby sprawdzić parametry każdego z wyświetlonych produktów, nie tylko pierwszego wyświetlonego.
 Do porównywania skorzystaj z instrukcji warunkowych if ... (jeżeli cena jest ok -> wyświetl odpowiedni komunikat).
 */

public class MainTask07_FilteringProduct {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.edge.driver",
                "src/main/resources/drivers/msedgedriver.exe");

        EdgeDriver driver = new EdgeDriver();

        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        driver.findElement(By.xpath("//*[contains(text(),'Accessories')]")).click();
//        driver.findElement(By.xpath("//*[contains(text(),'€18.00 - €19.00')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'€11.00 - €14.00')]")).click();

        Thread.sleep(2000);

        //znalazł liczbę produktów w tej kategorii cenowej
        java.util.List<WebElement> price = driver.findElements(By.xpath("//span[@itemprop='price']"));
        System.out.println(price.size() + " - a number of found items");

        //price.size() to NIE jest numer produktu, tylko ich SUMA !!!

        //lista stringów - ceny produktów
        double newnewPrice = 0;
        ArrayList<Double> priceList = new ArrayList<>();
        for (int i = 0; i < price.size(); i = i + 1) {
            String newPrice = removeChar(price.get(i).getText(), 0);
            newnewPrice = Double.parseDouble(newPrice);
            priceList.add(newnewPrice);

        }
        System.out.println(priceList);


        double min = 11; //trzeba tu dać automat w zależności od min na filtrze
        double max = 14;
        int i = 0;
//        double cena = priceList.get(i);

        for (i = 0; i< priceList.size(); i++) {
//            System.out.println(priceList.get(i));
            if (min <= priceList.get(i) && priceList.get(i) <= max){
                System.out.println(priceList.get(i) + " - OK");
            } else {
                System.out.println(priceList.get(i) + " - NOPE!");
            }
        }


    }

    public static String removeChar (String str, Integer n) {
        String front = str.substring(0, n);
        String back = str.substring(n+1, str.length());
        return front + back;
    }
}
