import Factory.PlaywrightFactory;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Attachment;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
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

        // Start tracing right after context is created
        page.context().tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true));

        navigationPage = new NavigationPage(page);
        homePage = new HomePage(page);
        cartPage = new CartPage(page);
        directPurchasePage = new DirectPurchasePage(page);
        System.out.println("NavigationPage initialized: " + navigationPage);
        ensureAuthenticated();
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
        // Stop tracing before closing
        page.context().tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace-" + System.currentTimeMillis() + ".zip")));

        page.context().browser().close();
    }

    private void ensureAuthenticated() {
        Path authPath = Paths.get("auth.json");
        BrowserContext currentContext = page.context();
        Browser browser = currentContext.browser();

        try {
            if (!Files.exists(authPath)) {
                System.out.println("auth.json not found; creating by performing login flow...");
                saveAuthState();

                // re-create context that loads the freshly saved storage state
                currentContext.close();
                BrowserContext newContext = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(authPath));
                page = newContext.newPage();
                navigationPage.clickMembershipLogin();

                return;
            }

            // Try to navigate using existing context
            //page.navigate("https://example.com/dashboard");

            if (isSessionExpired(page)) {
                System.out.println("Session expired, refreshing auth.json...");
                try {
                    currentContext.close();
                } catch (Exception ignored) {}
                saveAuthState();
                BrowserContext newContext = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(authPath));
                page = newContext.newPage();
                page.navigate("https://example.com/dashboard");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isSessionExpired(Page page) {
        String url = page.url();
        if (url.contains("/login")) {
            return true;
        }
        if (page.locator("#login-button").count() > 0) {
            return true;
        }
        return false;
    }

    private void saveAuthState() {
        // Create a temporary context to perform the login and write storage state to auth.json
        Browser browser = page.context().browser();
        BrowserContext tempContext = browser.newContext();
        Page tempPage = tempContext.newPage();

        navigationPage.clickMembershipLogin();

        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email")).fill("melissaaw@convertium.com");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("Gallery2024%");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log In")).click();
        page.navigate("https://www.nationalgallery.sg/sg/en/cart.html");

        tempContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("auth.json")));
        tempContext.close();
    }

}
