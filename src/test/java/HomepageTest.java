import Constants.SiteConstants;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomepageTest extends BaseTest{
    //Assert Locator Visibility Helpers
    private void assertVisible(Locator locator) {
        assertThat(locator).isVisible();
    }
    private void assertVisible(Page page, AriaRole role, String name) {
        assertVisible(page.getByRole(role, new Page.GetByRoleOptions().setName(name)));
    }
    private void assertVisible(Page page, AriaRole role, String name, boolean exact) {
        assertVisible(page.getByRole(role, new Page.GetByRoleOptions().setName(name).setExact(exact)));
    }

    @Test(priority = 1)
    public void disableLazyLoadTest(){
        System.out.println("Sanity test running");
        //Force load all media (src, data-src) for optimized testing
        navigationPage.forceLoadAllLazyMedia();
        System.out.println("Lazy loading is now disabled.");
    }

    @Test(priority = 2)
    public void consentPopUpTest() {
        navigationPage.clickPopUpXButton();
        navigationPage.clickSidePopUpXButton();
        assertVisible(page, AriaRole.HEADING, SiteConstants.POPUP_X_HEADING);
    }

    @Test(priority = 3)
    public void mastheadImageTest(){
        navigationPage.clickHomepageLogo();
        assertVisible(page, AriaRole.HEADING, SiteConstants.MASTHEAD_HEADING);
    }

    @Test(priority = 4)
    public void openingHoursTest(){
        assertVisible(page.getByText(SiteConstants.OPENING_HOURS).first());
    }

    @Test(priority = 5)
    public void planAVisitTest(){
        homePage.clickPlanAVisit();
        assertVisible(page, AriaRole.HEADING, SiteConstants.VISITOR_INFORMATION_HEADING);
        navigationPage.clickHomepageLogo();
    }

    @Test(priority = 6)
    public void mastheadTest(){
        navigationPage.clickPopUpXButton();
        navigationPage.clickHomepageLogo(); //Before executing a method(s) with loop, make sure that the page is in a fresh state or the DOM is registered and ready for validation.
        homePage.checkMastheadVideosHealth();
        boolean hasVideoErrors = homePage.hasVideoErrors();
        Assert.assertFalse(hasVideoErrors, "Please check the masthead videos manually. One or more videos failed to load properly.");

        homePage.checkMastheadImagesHealth();
        boolean hasImageErrors = homePage.hasImageErrors();
        Assert.assertFalse(hasImageErrors,"Please check the masthead images manually. One or more videos failed to load properly.");
    }

    @Test(priority = 6)
    public void callOutTest(){
        homePage.clickCallOut();
        assertThat(page).hasURL(prop.getProperty("callOutUrl")); //@ToDo refactor this.
    }


}
