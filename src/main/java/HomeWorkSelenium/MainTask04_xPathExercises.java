package HomeWorkSelenium;

import org.openqa.selenium.edge.EdgeDriver;

/**
 * Zadanie 4 - xPath
 * Ćwiczenia z wyszukiwania xPath
 * Na portalu sklepu internetowego https://mystore-testlab.coderslab.pl/index.php?controller=authentication&create_account=1
 * wyszukaj następujące elementy:
 * <p>
 * social title
 * First name
 * Last name
 * Email
 * Password
 * Show
 * Birthdate
 */

public class MainTask04_xPathExercises {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.edge.driver",
                "src/main/resources/drivers/msedgedriver.exe");

        EdgeDriver driver = new EdgeDriver();

        driver.get("https://mystore-testlab.coderslab.pl//index.php?controller=authentication&create_account=1");

        //*[contains(text(),'Social title')]
        //label[@class='radio-inline'][1]
        //label[@class='radio-inline'][2]
        //input[@name='firstname']
        //input[@name='lastname']
        //input[@class='form-control' and @name='email'] //because exist 2 input email
        //input[@name='password']
        //button[@class='btn']
        //input[@name='birthday']
    }
}
