import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
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
    public void popUpXButtonTest() {
        navigationPage.clickPopUpXButton();
        assertVisible(page, AriaRole.HEADING, ("Singapore Stories: Pathways"));
    }

    @Test(priority = 2)
    public void mastheadImageTest(){
        navigationPage.clickHomepageLogo();
        assertVisible(page, AriaRole.HEADING, "EXPERIENCE ART  YOUR  WAY");
    }

    @Test(priority = 3)
    public void openingHoursTest(){
        assertVisible(page.getByText("Open daily, 10am – 7pm").first());
    }

    @Test(priority = 4)
    public void planAVisitTest(){
        homePage.clickPlanAVisit();
        assertVisible(page, AriaRole.HEADING, "Visitor Information");
        navigationPage.clickHomepageLogo();
    }

    @Test(priority = 5)
    public void mastheadTest(){
        homePage.checkMastheadImagesHealth();
        homePage.checkMastheadVideosHealth();
    }

    @Test(priority = 6)
    public void callOutTest(){
        homePage.clickCallOut();
        assertThat(page).hasURL("https://www.nationalgallery.sg/sg/en/exhibitions/Into-the-Modern--Impressionism-from-the-Museum-of-Fine-Arts-Boston.html");
    }


}
