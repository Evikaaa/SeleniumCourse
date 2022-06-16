package HomeWorkSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.ArrayList;


/**
 Zadanie 7 dodatkowe
 Filtrowanie produktów
 Sprawdź funkcjonalność filtrowania produktów w sklepie https://mystore-testlab.coderslab.pl//index.php. Przygotuj skrypt, który zweryfikuje czy po wyborze odpowiedniego filtra wyświetlają się tylko i wyłącznie produkty spełniające jego warunki np. czy wyświetlają się tylko produkty w danym przedziale cenowym.

 ð‍♂️ Wskazówki:

 Pamiętaj, aby sprawdzić parametry każdego z wyświetlonych produktów, nie tylko pierwszego wyświetlonego.
 Do porównywania skorzystaj z instrukcji warunkowych if ... (jeżeli cena jest ok -> wyświetl odpowiedni komunikat).
 */

public class MainTask07_roboczy {

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
        System.out.println(price.size() + " - liczba znelezionych produktów");

        //price.size() to NIE jest numer produktu, tylko ich SUMA !!!

        //lista stringów - ceny produktów
        for (int i = 0; i < price.size(); i = i + 1) {
            new String(price.get(i).getText());
            System.out.println(removeChar((price.get(i).getText()), 0));
        }


//        wrzuca wyniki do tabeli - DZIAŁA
//        removeChar usuwa znaczek euro z przodu - DZIAŁA
//        ArrayList<String> priceList = new ArrayList<>();
//        for (int i = 0; i<price.size(); i=i+1) {
//            new String (price.get(i).getText());
//            priceList.add(removeChar((price.get(i).getText()),0));
//        }
//
//        wyświetla całą ArrayList oraz niektóre elementy
//        jak to zamienić na doubla??????
//        System.out.println(priceList);
//        System.out.println(Double.parseDouble(priceList.get(0)));
//        System.out.println(priceList.get(3));
//        System.out.println(priceList.get(6));
//    }

    }



//konwersja formatu liczby do 2 po przecinku - DZIAŁA
//        DecimalFormat df = new DecimalFormat("0.00");
//        System.out.println(df.format(3.1415927)); // 3.14


//        usuwa ze stringa wskazany znak - DZIAŁA
//        System.out.println(new String ("Eewa"));
//        System.out.println(removeChar("Eewa", 1));


    public static String removeChar (String str, Integer n) {
        String front = str.substring(0, n);
        String back = str.substring(n+1, str.length());
        return front + back;
    }
}