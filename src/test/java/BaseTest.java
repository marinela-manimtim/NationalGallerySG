import Factory.PlaywrightFactory;
import com.microsoft.playwright.Page;
import io.qameta.allure.Attachment;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.DirectPurchasePage;
import pages.HomePage;
import pages.NavigationPage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class BaseTest {
    //declare variable for Playwright Page
    //declare variable for PlaywrightFactory Page to call methods inside the class
    //declare variable for Properties to call prop
    //declare variable for NavigationPage to call methods inside the page class
    protected Page page;
    protected PlaywrightFactory pf;
    Properties prop;

    protected NavigationPage navigationPage;
    protected HomePage homePage;
    protected CartPage cartPage;
    protected DirectPurchasePage directPurchasePage;

    @BeforeClass
    public void launchBrowser() throws IOException {
        pf = new PlaywrightFactory();
        prop = pf.initProp();
        page = pf.initBrowser(prop);
        navigationPage = new NavigationPage(page);
        homePage = new HomePage(page);
        cartPage = new CartPage(page);
        directPurchasePage = new DirectPurchasePage(page);
        System.out.println("NavigationPage initialized: " + navigationPage);
    }

    @Attachment(value = "{0}", type = "image/png")
    public byte[] saveScreenshot(String name) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = name.replace(" ", "_") + "_" + timestamp + ".png";
        Path path = Paths.get("screenshots/" + fileName);

        // Save screenshot to disk
        page.screenshot(new Page.ScreenshotOptions().setPath(path));

        // Return screenshot bytes so Allure attaches it
        try {
            return Files.readAllBytes(path);
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    @AfterTest
    public void closeBrowser() {
        page.context().browser().close();
    }

}
