package tests;

import manager.ApplicationManager;
import models.UserDto;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    static ApplicationManager app = new ApplicationManager();

    UserDto user = new UserDto("88tura88@gmail.com", "Tura88@88");

    @BeforeSuite
    public void setup(){
        app.init();
    }

    @AfterSuite
    public void tearDown(){
       // app.stop();
    }

}
