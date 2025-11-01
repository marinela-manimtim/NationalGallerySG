import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.testng.annotations.*;
import org.testng.Assert;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TicketingTest extends BaseTest{
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
/*
    @Test(priority = 1)

    public void DirectPurchaseTest() throws InterruptedException {
        navigationPage.clickPopUpXButton();
        navigationPage.goToDirectPurchase();
        directPurchasePage.chooseOtherNationalities();
        directPurchasePage.chooseGA();
        directPurchasePage.chooseConcession();

        // Compute expected price before continuing
        String expectedTotalPrice = directPurchasePage.computeTicketPrice();

        directPurchasePage.continueToReview();

        Locator actualTotalPrice = page.locator("div.flex.gap-10.font-size-28.font-size-22-sm.b.justify-between-sm div span");
        String actualTotalPriceText = actualTotalPrice.textContent().trim();
        // Wait for the element to be visible before reading its text
        actualTotalPrice.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE)
                .setTimeout(5000)); // Optional: customize timeout
        Assert.assertEquals(actualTotalPriceText, expectedTotalPrice);
    }

     */
}
