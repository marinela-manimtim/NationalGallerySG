import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DirectPurchaseTest extends BaseTest{
    //Assert Locator Visibility Helpers
    private void assertVisible(Locator locator) {
        try {
            locator.waitFor(new Locator.WaitForOptions()
                    .setState(WaitForSelectorState.VISIBLE)
                    .setTimeout(5000)); // wait up to 5 seconds
            assertThat(locator).isVisible();
        } catch (TimeoutError e) {
            throw new AssertionError("Element was not visible within timeout.");
        }
    }

    private void assertVisible(Page page, AriaRole role, String name) {
        Locator locator = page.getByRole(role, new Page.GetByRoleOptions().setName(name));
        assertVisible(locator);
    }

    private void assertVisible(Page page, AriaRole role, String name, boolean exact) {
        Locator locator = page.getByRole(role, new Page.GetByRoleOptions().setName(name).setExact(exact));
        assertVisible(locator);
    }

    //Stable Text Element Helper
    public void waitForStableText(Locator locator, int timeoutMillis) {
        ElementHandle elementHandle = locator.elementHandle();
        page.waitForFunction(
                "element => element && element.textContent.trim() !== '' && !element.textContent.includes('loading')",
                elementHandle,
                new Page.WaitForFunctionOptions().setTimeout(timeoutMillis)
        );
    }

    //Element Enabled Helper
    public boolean isElementEnabled(Locator locator) {
        locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        return locator.isEnabled();
    }

    //Element Disabled Helper
    public boolean isElementDisabled(Locator locator) {
        locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        return locator.isDisabled();
    }

    //Wait Until Locator Is Enabled Helper
    public boolean waitUntilEnabled(Locator locator, int timeoutMillis) {
        try {
            locator.waitFor(new Locator.WaitForOptions()
                    .setState(WaitForSelectorState.VISIBLE)
                    .setTimeout(timeoutMillis));

            page.waitForFunction(
                    "element => !element.disabled",
                    locator.elementHandle(),
                    new Page.WaitForFunctionOptions().setTimeout(timeoutMillis)
            );
            return true;
        } catch (PlaywrightException e) {
            return false;
        }
    }



    @Test(priority = 1)
    public void directPurchaseTest() {
        navigationPage.clickPopUpXButton();
        navigationPage.clickSidePopUpXButton();

        directPurchasePage = navigationPage
                .goToDirectPurchase()
                .chooseOtherNationalities()
                .chooseGA()
                .chooseConcession()
                .computeTicketPrice()
                .continueToReview();

        Locator actualTotalPrice = page.locator("div.flex.gap-10.font-size-28.font-size-22-sm.b.justify-between-sm div span");
        Locator checkoutButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue"));

        //waitForStableText(actualTotalPrice, 2000); // Use the helper method

        String expectedTotalPrice = directPurchasePage.getComputedPrice();
        page.waitForTimeout(3000); //Waiting for calculationAPI to load
            if(isElementDisabled(checkoutButton)) {
                checkoutButton.getByText("Please wait");
                System.out.println("Button state: Please wait");
                page.waitForTimeout(2000); //This is needed because there's a delay in calculationAPI. When Review Step is loaded, Checkout button is already enabled and Price is set as $0.00.

            }else if(waitUntilEnabled(checkoutButton,3000)){
                System.out.println("Button state: Check out");
            }

            String actualTotalPriceText = actualTotalPrice.textContent().trim();
            System.out.println("Actual Total Price: " + actualTotalPriceText);

            Assert.assertEquals(actualTotalPriceText, expectedTotalPrice);
    }

}
