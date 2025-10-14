package Factory;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PlaywrightFactory {

    Playwright playwright;

    //declare variable for new browser instance
    Browser browser;
    //declare variable for new browser context
    BrowserContext context;

    //declare variable for new browser page
    Page page;
    //declare variable for Properties from file input stream;
    Properties prop;
    //Initialize or open the browser
    public Page initBrowser(Properties prop){
        String browserName = prop.getProperty("browser").trim();
        System.out.println("Initializing browser: "+ browserName);
        playwright = Playwright.create();

        //Cross-browser testing
        switch (browserName.toLowerCase()){ //implementing toLowerCase to eliminate case sensitivity (e.g., "chrome" vs "Chrome")
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;

            case "firefox":

                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;

            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;

            case "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;

            default:
                System.out.println("Pass a correct browser name.");
                break;
        }

        //create a new browser context
       context = browser.newContext();
        //create a new browser page in the new browser instance
       page = context.newPage();
       page.navigate(prop.getProperty("url").trim());

       return page;
    }

    //this method is used to initialize the properties from config.properties
    public Properties initProp() throws IOException {
        try {
            FileInputStream ip = new FileInputStream("src/test/resources/Config/config.properties");
            prop = new Properties();
            prop.load(ip);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    return prop;
    }
}
