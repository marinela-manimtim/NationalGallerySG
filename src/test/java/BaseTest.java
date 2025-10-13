import Factory.PlaywrightFactory;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.CartPage;
import pages.HomePage;
import pages.NavigationPage;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    //declare variable for Playwright Page
    //declare variable for PlaywrightFactory Page to call methods inside the class
    //declare variable for NavigationPage to call methods inside the page class
    Page page;
    PlaywrightFactory pf;
    Properties prop;
    protected NavigationPage navigationPage;
    protected HomePage homePage;
    protected CartPage cartPage;

    @BeforeTest
    public void launchBrowser() throws IOException {
        pf = new PlaywrightFactory();
        prop = pf.initProp();
        page = pf.initBrowser(prop);
        navigationPage = new NavigationPage(page);
        homePage = new HomePage(page);
        cartPage = new CartPage(page);
    }

    @AfterTest
    public void closeBrowser() {
        page.context().browser().close();
    }

}
