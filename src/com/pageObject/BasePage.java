/**
 * Created by rajivbhati on 10/28/16.
 */

package com.pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.util.concurrent.TimeUnit.SECONDS;


public class BasePage {
    public WebDriver driver;

    public BasePage(){}

    public BasePage(WebDriver driver) {

        this.driver = driver;
        this.driver.manage().timeouts().pageLoadTimeout(100, SECONDS);
    }

    public WebDriver getDriver(){
        return(this.driver);
    }

    public void waitForMe(WebElement obj){
        WebDriverWait wait = new WebDriverWait(this.driver, 20);
        wait.until(ExpectedConditions.visibilityOf(obj));
    }

    public void open(String url) {
        this.driver.get(url);
    }
    public void close() {
        this.driver.quit();
    }
    public String getTitle() {
        return this.driver.getTitle();
    }
    public String getUrl(){
        return this.driver.getCurrentUrl();
    }
}
