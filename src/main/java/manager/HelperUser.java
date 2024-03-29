package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    By btnLogin = By.cssSelector("a[data-uuid='MJFtCCgVhXrVl7v9HA7EH_login']");
    By inputLogin = By.id("username");
    By btnContinue = By.id("login-submit");
    By inputPassword = By.id("password");
    By btnSubmit = By.id("login-submit");
    By btnAccount = By.cssSelector("button[data-testid='header-member-menu-button']");

    public void login (String email, String password){
        clickBase(btnLogin);
        typeBase(inputLogin, email);
        clickBase(btnContinue);
        typeBase(inputPassword, password);
        clickBase(btnSubmit);
    }

    public boolean isElementPresent_btnAccount(){
        return isElementPresent(btnAccount);
    }

}
