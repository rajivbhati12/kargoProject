/**
 * Created by rajivbhati on 10/27/16.
 */
package com.pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static java.util.concurrent.TimeUnit.SECONDS;


public class KargoMain extends BasePage{

    @FindBy(css ="a[href='#nav-main']")
    private WebElement navBtn;

    @FindBy(css = "a[href='http://www.kargo.com/about/']")
    private WebElement aboutUs;

    @FindBy(css = "div.section--hero__content h1")
    private WebElement heroContent;

    public KargoMain(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().pageLoadTimeout(100, SECONDS);
    }

    public void ClickAbout(){
        navBtn.click();
        aboutUs.click();
    }

    public String getHeroContent(){
        return heroContent.getText();
    }
}

