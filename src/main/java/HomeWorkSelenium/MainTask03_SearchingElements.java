package HomeWorkSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class MainTask03_SearchingElements {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.edge.driver",
                "src/main/resources/drivers/msedgedriver.exe");

        EdgeDriver driver = new EdgeDriver();

        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");

        driver.findElement(By.name("firstName")).sendKeys("Karol");
        driver.findElement(By.name("lastName")).sendKeys("Kowalski");
        //there are three radio by gender, 2nd is female, 3rd is between
        //driver.findElement(By.xpath("(//input[@name='gender'])[2]")).click();
        driver.findElement(By.xpath("(//input[@name='gender'])[1]")).click();
        driver.findElement(By.xpath("//input[@id='dob']")).sendKeys("05/22/2010");
        driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Prosta 51");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("karol.kowalski@mailinator.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Pass123");
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Coders Lab");

        Select se = new Select(driver.findElement(By.xpath("(//select[@id='expectation'])")));
        se.selectByIndex(3);

        driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
        driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
        driver.findElement(By.xpath("(//input[@type='checkbox'])[6]")).click();

        driver.findElement(By.xpath("//textarea[@id='comment']")).sendKeys("To jest mój pierwszy automat testowy");
        driver.findElement(By.xpath("//button[@id='submit']")).submit();
    }
}
