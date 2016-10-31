/**
 * Created by rajivbhati on 10/27/16.
 * @description:
 *      Testcase1:-
 *              - Navigate to google.com
 *              - Search for Kargo
 *              - Locate and click on "Website"
 *              - Navigate to about page
 *      Testcase2:-
 *              - Navigate to google.com
 *              - Go to google.com
 *              - Search for the following keywords (keywords should be in sample.txt file and script should open file and grab each keyword to execute)
 *              example:
 *                          > Mobile ad firm
 *                          > Mobile advertising
 *                          > Mobile marketing
 *                          > Mobile internet
 */

package com.test.testCases;
import com.pageObject.*;
import com.test.testRunner.ResourcePath;
import junit.framework.TestCase;
import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


import java.io.*;

public class WhenAUserSearchesOnGoogle extends TestCase{
    private GoogleSearchPage pageG;
    private KargoMain pageK;
    private Boolean state = true;
    private ResourcePath rp = null;

    public WhenAUserSearchesOnGoogle(String name){
        super(name);
    }

    @Before
    public void setUp() {
        if(state)
        {
            rp = ResourcePath.getInstance();
            if(rp.getPath() == "")
                rp.setPath(System.getProperty("user.dir"));
            System.setProperty("webdriver.chrome.driver", rp.getPath() + "/chromedriver");
            this.state = false;
        }
        pageG = PageFactory.initElements(new ChromeDriver(), GoogleSearchPage.class);
        pageG.open("http://www.google.com/");
    }

    @After
    public void tearDown() {
        try {
            pageG.close();
        }catch(Exception e){}
        try {
            pageK.close();
        }catch(Exception e){}

    }

    /*
    *   Test one to perform following action and corresponding validations:
    *    - Navigate to google.com
    *    - Search for Kargo
    *    - Locate and click on "Website"
    *    - Navigate to about page
    */
    @Test
    public void testSearchKargoAndNavigateToAboutUs() {
        pageG.searchFor("kargo");
        assertThat(pageG.getTitle(), containsString("kargo"));
        pageG.searchAndClickKargoLink();
        assertThat(pageG.getUrl(), containsString("kargo"));
        pageK = PageFactory.initElements(pageG.getDriver(), KargoMain.class);
        pageK.ClickAbout();
        assertThat(pageK.getHeroContent(), containsString("ABOUT US"));
        pageG = PageFactory.initElements(pageK.getDriver(), GoogleSearchPage.class);
    }

    /*
    *   Test one to perform following action and corresponding validations:
    *    - Navigate to google.com
    *    - Go to google.com
    *    - Search for the following keywords (keywords should be in a txt file and script should open file and grab each keyword to execute)
    *    > Mobile ad firm
    *    > Mobile advertising
    *    > Mobile marketing
    *    > Mobile internet
    */
    @Test
    public void testDataDrivenGoogleSearch() {
        try(BufferedReader br = new BufferedReader(new FileReader(rp.getPath() + "/sample.txt"))) {
            for(String line; (line = br.readLine()) != null; ) {
                pageG.searchFor(line);
                assertThat(pageG.getTitle(), containsString(line));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
