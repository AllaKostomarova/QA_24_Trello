package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    HelperUser helperUser;
    HelperBoards helperBoards;

    public void init(){
      wd = new ChromeDriver();
      wd.navigate().to("https://trello.com/");
      wd.manage().window().maximize();
      wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      helperUser= new HelperUser(wd);
      helperBoards = new HelperBoards(wd);
    }

    public void stop(){
      wd.quit();
    }

    public HelperUser getHelperUser() {
        return helperUser;
    }

    public HelperBoards getHelperBoards() {
        return helperBoards;
    }
}
