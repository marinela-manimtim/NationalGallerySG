import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomepageTest extends BaseTest{
    @Test(priority = 6)
    public void mastheadImageTest(){
        navigationPage.clickHomepageLogo();
        Locator mastheadImage = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("EXPERIENCE ART  YOUR  WAY")).locator("div");
        assertThat(mastheadImage).isVisible();
    }

    @Test(priority = 7)
    public void openingHoursTest(){
        Locator openingHoursText = page.getByText("Open daily, 10am – 7pm").first();
        assertThat(openingHoursText).isVisible();
    }

    @Test(priority = 8)
    public void planAVisitTest(){
        homePage.clickPlanAVisit();
        assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Visitor Information"))).isVisible();
        navigationPage.clickHomepageLogo();
    }
}
