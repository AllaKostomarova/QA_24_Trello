import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Selectors {

    WebDriver driver;
    @Test
    public void startTrello(){
        driver = new ChromeDriver();
        driver.get("https://trello.com/");

        WebElement titleLogin = driver.findElement(By.xpath("//a[@data-uuid='MJFtCCgVhXrVl7v9HA7EH_login']"));
        System.out.println("--> " + titleLogin.getText());

        WebElement btnGetTrelloForFree = driver.findElement(By.xpath("//a[text()='Get Trello for free']"));
        System.out.println("attribute --> " + btnGetTrelloForFree.getAttribute("href"));

        WebElement btnSignUpItsFree =driver.findElement(By.xpath("//form[@data-testid='ui-email-signup-form']/div/button"));
        System.out.println("attribute --> " + btnSignUpItsFree.getAttribute("aria-label"));

        WebElement btnSignUpItsFree2 =driver.findElement(By.xpath("//form[@data-testid='ui-email-signup-form']//button"));
        System.out.println("attribute2 --> " + btnSignUpItsFree2.getAttribute("aria-label"));


        driver.quit();
    }
}
