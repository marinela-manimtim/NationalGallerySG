package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.TimeoutError;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

public class DirectPurchasePage {
    Page page;

    public DirectPurchasePage(Page page){
        this.page = page;
        initLocators();
    }

    private void initLocators(){
        sGPR = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Singaporeans / PRs"));
        otherNationalities = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Other Nationalities"));
        gaPassOption = page.getByText("General Admission").nth(1);
        concessionOption = page.locator("a").filter(new Locator.FilterOptions().setHasText("Concession")).first();

        // Locator chaining --->
        allPrices = page.locator(".m-b-0.flex.gap-4.font-size-14");
        gaStandardUnitPriceLocator = allPrices.nth(0).locator("span:not(.strikethrough)");
        gaConcessionKidsUnitPriceLocator = allPrices.nth(1).locator("span:not(.strikethrough)");
        // <---

        continueToReviewButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue"));
    }

    //Object repository
    Locator sGPR;
    Locator otherNationalities;
    Locator gaPassOption;
    Locator concessionOption;
    Locator allPrices;
    Locator gaStandardUnitPriceLocator;
    Locator gaConcessionKidsUnitPriceLocator;
    Locator continueToReviewButton;
    String expectedTotalPrice;

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

    public void chooseSGPR(){
        safeClick(sGPR, " Singaporeans / PRs");
    }
    public DirectPurchasePage chooseOtherNationalities(){
        safeClick(otherNationalities, " Other Nationalities");
        return this;
    }
    public DirectPurchasePage chooseGA(){
        safeClick(gaPassOption, "General Admission");
        return this;
    }

    public DirectPurchasePage chooseConcession(){
        safeClick(concessionOption, "Concession");
        return this;
    }

    public DirectPurchasePage computeTicketPrice() {
        // Extract and clean text
        String gaStandardUnitPrice = gaStandardUnitPriceLocator.textContent().trim();
        double gaStandardNumericPrice = 0.0;
        String gaConcessionKidsUnitPrice = gaConcessionKidsUnitPriceLocator.textContent().trim();
        double gaConcessionKidsNumericPrice = 0.0;

        if (gaStandardUnitPrice.equalsIgnoreCase("Free")) {
            gaStandardNumericPrice = 0.0;
        } else {
            try {
                gaStandardNumericPrice = Double.parseDouble(gaStandardUnitPrice.replace("$", "").trim());
            } catch (NumberFormatException e) {
                System.err.println("⚠️ Unable to parse price: '" + gaStandardUnitPrice + "'");
                gaStandardNumericPrice = 0.0; // Safe fallback
            }
        }

        if (gaConcessionKidsUnitPrice.equalsIgnoreCase("Free")) {
            gaConcessionKidsNumericPrice = 0.0;
        } else {
            try {
                gaConcessionKidsNumericPrice = Double.parseDouble(gaConcessionKidsUnitPrice.replace("$", "").trim());
            } catch (NumberFormatException e) {
                System.err.println("⚠️ Unable to parse price: '" + gaStandardUnitPrice + "'");
                gaConcessionKidsNumericPrice = 0.0; // Safe fallback
            }
        }

        // Fill ticket quantities
        page.locator("input[name=\"418036\"]").fill("1"); // Standard
        page.locator("input[name=\"418044\"]").fill("1"); // Concession Kids
        Double totalPrice = gaStandardNumericPrice + gaConcessionKidsNumericPrice;

        // Format as a currency string with 2 decimal places and a dollar sign
        expectedTotalPrice = String.format("$%.2f", totalPrice);
        System.out.println("💰 Total: " + (expectedTotalPrice));
        return this;
    }

    public String getComputedPrice(){
        return expectedTotalPrice;
    }

    public DirectPurchasePage continueToReview(){
        safeClick(continueToReviewButton, "Continue");
        page.waitForLoadState(LoadState.LOAD);
        return this;
    }

}
