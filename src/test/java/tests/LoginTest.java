package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @Test
    public void loginPositiveTest(){
//        String email ="88tura88@gmail.com";
//        String password = "Tura88@88";
        app.getHelperUser().login(user.getEmail(), user.getPassword());
        Assert.assertTrue(app.getHelperUser().isElementPresent_btnAccount());

    }
}
