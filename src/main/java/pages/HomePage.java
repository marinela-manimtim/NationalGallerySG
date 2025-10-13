package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.TimeoutError;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    //declare variable of Page from Playwright 'Page'
    Page page;

    //page constructor allows this class to use the Page object for browser interactions.
    public HomePage(Page page) {
        this.page = page;
    }

    //Safe click helper
    private void safeClick(Locator locator, String elementName) {
        //Wait for the page to load before executing the try-catch method
        page.waitForLoadState(LoadState.LOAD);

        //try catch method to check if element is VISIBLE before clicking
        try {
            locator.waitFor(new Locator.WaitForOptions()
                    .setState(WaitForSelectorState.VISIBLE)
                    .setTimeout(5000));

            if (!locator.isEnabled()) {
                System.err.println("'" + elementName + "' is visible but not enabled.");
                return;
            }

            if (!locator.isVisible()) {
                System.err.println("'" + elementName + "' is not visible.");
                return;
            }
            locator.click();
        } catch (TimeoutError e) {
            System.err.println("Timeout waiting for '" + elementName + "' to become visible.");
        } catch (PlaywrightException e) {
            System.err.println("Error clicking '" + elementName + "': " + e.getMessage());
        }
    }

    public void clickPlanAVisit(){
        Locator planAVisitButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Plan a visit"));
        safeClick(planAVisitButton, "Plan a visit");
    }

    public List<Locator> checkMastheadImagesHealth(){
        List<Locator> healthyImages = new ArrayList<>();
        Locator allContainers = page.locator(".banner-legend-thumbnail > div");
        int containerCount = allContainers.count();
        System.out.println("\uD83D\uDD04 CHECKING MASTHEAD IMAGES...");

        for (int i = 0; i < containerCount; i++){
            Locator container = allContainers.nth(i);
            Locator image = container.locator("img");

            //Skip if no <img> element is found
            if(image.count() == 0){
                System.out.println("Container " + i + ": No image element found. Skipping.");
                continue;
            }

            Boolean hasError = (Boolean) image.evaluate( "el => el instanceof HTMLImageElement && (!el.complete || el.naturalWidth === 0)");
            System.out.println("Container " + i + ": Image found.");
            System.out.println("Has Error: " + hasError);

            if (Boolean.TRUE.equals(hasError)) {
                System.out.println("  ❌ Broken or not loaded properly.");
            } else {
                System.out.println("  ✅ Image appears healthy.");
                healthyImages.add(image);
            }
        }
        return healthyImages;
    }

    public List<Locator> checkMastheadVideosHealth() {
        List<Locator> healthyVideos = new ArrayList<>();
        Locator allContainers = page.locator(".banner-legend-thumbnail > div");
        int containerCount = allContainers.count();
        System.out.println("\uD83D\uDD04 CHECKING MASTHEAD VIDEOS...");

        for (int i = 0; i < containerCount; i++) {
            Locator container = allContainers.nth(i);
            Locator video = container.locator("video");

            // Skip if no <video> element is found
            if (video.count() == 0) {
                System.out.println("Container " + i + ": No video element found. Skipping.");
                continue;
            }

            // Check if video has error
            Boolean hasError = (Boolean) video.evaluate(
                    "el => el instanceof HTMLVideoElement && el.error !== null && el.error.code !== 0"
            );

            System.out.println("Container " + i + ": Video found.");
            System.out.println("Has Error: " + hasError);

            if (Boolean.TRUE.equals(hasError)) {
                System.out.println("  ❌ Broken or not loaded properly.");
            } else {
                System.out.println("  ✅ Video appears healthy.");
                healthyVideos.add(video);
            }
        }

        return healthyVideos;
    }

    public void clickCallOut(){
        Locator callOutLink = page.locator("section").filter(new Locator.FilterOptions().setHasText("Into the Modern: Impressionism from the Museum of Fine Arts, Boston Get ready")).getByRole(AriaRole.LINK);
        safeClick(callOutLink, "section");
    }


}
