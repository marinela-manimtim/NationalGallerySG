package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.TimeoutError;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;


public class CartPage{
    Page page;
    NavigationPage navigationPage;

    //page constructor allows this class to use the Page object for browser interactions.
    public CartPage(Page page){
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

    public void goToCartPage(){
        navigationPage.clickCartButton();
    }

    public void chooseSGPR(){
        Locator sGPR = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Singaporeans / PRs"));
        safeClick(sGPR, " Singaporeans / PRs");
    }
    public void chooseOtherNationalities(){
        Locator otherNationalities = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Other Nationalities"));
        safeClick(otherNationalities, " Other Nationalities");
    }
    public void chooseGA(){
        Locator gaPassOption = page.getByText("General Admission").nth(1);
        safeClick(gaPassOption, "General Admission");
    }

    public void chooseConcession(){
        Locator concessionOption = page.locator("a").filter(new Locator.FilterOptions().setHasText("Concession")).first();
        safeClick(concessionOption, "Concession");
    }

//    public List<String> getCurrentUnitPricesForGA(){
//        List<String> gaCurrentUnitPrice = new ArrayList<>();
//        Locator allPrices = page.locator(".m-b-0.flex.gap-4.font-size-14");
//        int ticketPriceCount = allPrices.count();
//        System.out.println("\uD83D\uDD04 CHECKING THE CURRENT GENERAL ADMISSION PRICES...");
//
//       for (int i=0; i<ticketPriceCount; i++){
//            Locator container = allPrices.nth(i);
//            Locator priceSpan = container.locator("span:not(.strikethrough)");//to focus on the span element of the locator class defined, choosing the price without strikethrough
//            String priceText = priceSpan.textContent().trim();
//
//            System.out.println("Current GA Unit Price: " + priceText);
//            gaCurrentUnitPrice.add(priceText);
//        }
//       return gaCurrentUnitPrice;
//    }

//    public List<Double> convertPricesToDouble(List<String> priceStrings) {
//        List<Double> numericPrices = new ArrayList<>();
//
//        for (String price : priceStrings) {
//            if (price.equalsIgnoreCase("Free")) {
//                numericPrices.add(0.0); // Treat "Free" as $0.00
//            } else {
//                try {
//                    // Remove currency symbol and convert to double
//                    double value = Double.parseDouble(price.replace("$", "").trim());
//                    numericPrices.add(value);
//                } catch (NumberFormatException e) {
//                    System.err.println("⚠️ Unable to parse price: '" + price + "'");
//                    numericPrices.add(0.0); // Default fallback
//                }
//            }
//        }
//
//        return numericPrices;
//    }

    public String computeTicketPrice() {
        // Correct locator chaining
        Locator allPrices = page.locator(".m-b-0.flex.gap-4.font-size-14");
        Locator gaStandardUnitPriceLocator = allPrices.nth(0).locator("span:not(.strikethrough)");
        Locator gaConcessionKidsUnitPriceLocator = allPrices.nth(1).locator("span:not(.strikethrough)");

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
        String expectedTotalPrice = String.format("$%.2f", totalPrice);
        System.out.println("💰 Total: " + (expectedTotalPrice));
        return expectedTotalPrice;
    }

    public void continueToReview(){
        Locator continueToReviewButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue"));
        safeClick(continueToReviewButton, "Continue");
    }

}