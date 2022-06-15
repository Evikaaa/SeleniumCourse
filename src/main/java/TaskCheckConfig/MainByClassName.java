package TaskCheckConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainByClassName {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/en/");

        //ten przycisk ma dwie nazwy class, szukamy ctrl+f która występuje raz, raz wuystępuje .user_login
        driver.findElement(By.className("user_login")).click();
        //.account_input występuje 3 razy, ale nasz jest pierwszy
        WebElement accountInput = driver.findElement(By.className("account_input"));
        accountInput.sendKeys(generateEmail());
        driver.findElement(By.id("SubmitCreate")).click();
        driver.quit();
    }
    //wpisywany mail musi być unikalny i nie może już być zarejestrowany
    //random w javie jest generowany przewidywalnie, jest tam zależość
    //czas uniksowy jest zawsze inikalny, płynie od początku uniksa
    public static String generateEmail(){
        return "art" + System.currentTimeMillis() + "@test.com";
    }
}
