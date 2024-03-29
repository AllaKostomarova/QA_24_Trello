package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.nio.file.WatchEvent;
import java.util.List;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    private WebElement findElementBase(By locator) {
        return wd.findElement(locator);
    }

    private List<WebElement> findElementsBase(By locator){
        return wd.findElements(locator);
    }

    public void clickBase(By locator){
        findElementBase(locator).click();
    }

    public void typeBase(By locator, String text){
        WebElement el = wd.findElement(locator);
        el.click();
        el.clear();
        el.sendKeys(text);
    }

    public boolean isElementPresent(By locator){
        return !findElementsBase(locator).isEmpty();
    }

    public boolean isTextElementEquals(By locator, String text){
        return findElementBase(locator).getText().equals(text);
    }

    public void pause (int sec){
        try {
            Thread.sleep(1000L *sec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}