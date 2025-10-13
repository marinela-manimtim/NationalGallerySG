import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CartTest extends BaseTest{

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


}
