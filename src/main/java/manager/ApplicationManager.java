package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
    WebDriver wd;
    HelperUser helperUser;

    public void init(){
      wd = new ChromeDriver();
      wd.navigate().to("https://trello.com/");
      wd.manage().window().maximize();
    }

    public void stop(){
      wd.quit();
    }

    public HelperUser getHelperUser() {
        return helperUser;
    }
}
