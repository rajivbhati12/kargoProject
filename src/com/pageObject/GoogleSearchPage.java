/**
 * Created by rajivbhati on 10/27/16.
 * @description: Page Obejct class extended from BasePage for Google.com
 */
package com.pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static java.util.concurrent.TimeUnit.SECONDS;


public class GoogleSearchPage extends BasePage{

    @FindBy(name = "q")
    private WebElement q;

    @FindBy(name = "btnG")
    private WebElement btn;

    @FindBy(id = "hdtb-msb")
    private WebElement all;

    @FindBy(css = "a[href='http://www.kargo.com/']")
    private WebElement kargoLink;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().pageLoadTimeout(100, SECONDS);
    }
    public void searchFor(String searchTerm) {
        typeSearchTerm(searchTerm);
        clickOnSearch();
    }
    public void typeSearchTerm(String searchTerm) {
        q.clear();
        q.sendKeys(searchTerm);
    }
    public void clickOnSearch() {
        btn.click();
        waitForMe(all);
    }
    public void searchAndClickKargoLink(){
        kargoLink.click();
    }

}
