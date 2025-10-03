import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

//'extends' is used to establish an inheritance relationship between classes
public class NavigationTest extends BaseTest{

   //set test priority to temporarily set order of test execution. The order can be configured. @Todo set this config.
   @Test(priority = 1)
   public void popUpXButtonTest(){
       navigationPage.clickPopUpXButton();
       assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Singapore Stories: Pathways"))).isVisible();
   }

   @Test(priority = 2)
    public void homepageLogoTest(){
       navigationPage.clickHomepageLogo();
       assertThat(page).hasTitle("National Gallery Singapore | Leading Art Museum in SEA | National Gallery Singapore");
   }

   @Test(priority = 3)
    public void membershipLoginTest(){
       Page page1 = page.waitForPopup(() -> {
           navigationPage.clickMembershipLogin();
       });
       assertThat(page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log In"))).isVisible();
       page1.close();
   }

   @Test(priority = 4)
    public void cartButtonTest(){
       navigationPage.clickCartButton();
       assertThat(page).hasTitle("Cart | National Gallery Singapore");
   }

   @Test(priority = 5)
    public void menuIconTest(){
       navigationPage.clickMenuIcon();
       assertThat(page.getByRole(AriaRole.MENU, new Page.GetByRoleOptions().setName("Main navigation"))).isVisible();
   }

   @Test(priority = 6)
    public void menuFirstVisitTest(){
       navigationPage.clickFirstVisit();
       assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("What’s On"))).isVisible();
   }

   @Test(priority = 7)
    public void menuMustSeesTest(){
       navigationPage.clickMenuIcon();
       navigationPage.clickMustSees();
       assertThat(page.getByRole(AriaRole.REGION, new Page.GetByRoleOptions().setName("Must-See Must-Do Panel"))).isVisible();
   }

   @Test(priority = 8)
    public void menuMustSeeWhatsOnTest(){
       navigationPage.goToWhatsOn();
       assertThat(page.getByRole(AriaRole.TABPANEL, new Page.GetByRoleOptions().setName("Today"))).isVisible();
   }

   @Test(priority = 9)
    public void menuMustSeeExhibitionTest(){
       navigationPage.goToWhatsOnExhibitions();
       assertThat(page.locator("#whatsOnFilter").getByLabel("Select an option").getByText("Exhibition")).isVisible();
   }

   @Test(priority = 10)
    public void menuMustSeeToursTest(){
       navigationPage.goToTours();
       assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Tours").setExact(true))).isVisible();
   }

   @Test(priority = 11)
    public void menuMustSeeOurCollectionsTest(){
       navigationPage.goToMustSeeOurCollections();
       assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("The World’s Largest"))).isVisible();
   }

   @Test(priority = 12)
    public void menuMustSeeAGuideForFamiliesTest(){
       navigationPage.goToAGuideForFamilies();
       assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("A Guide for Families Visiting"))).isVisible();
   }

   @Test(priority = 13)
    public void menuMustSeeFeaturedExhibitionTest(){
       navigationPage.goToMustSeeFeaturedExhibition();
       assertThat(page.getByRole(AriaRole.NAVIGATION, new Page.GetByRoleOptions().setName("Breadcrumb"))).isVisible();
   }

   @Test(priority = 14)
   public void menuOUrCollectionsTest(){
      navigationPage.goToOurCollections();
      assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("The World’s Largest"))).isVisible();
   }

   @Test(priority = 15)
   public void menuOurArchitecture(){
      navigationPage.goToOurArchitecture();
      assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Our Architecture & History"))).isVisible();
   }

   @Test(priority = 16)
   public void menuLearnAboutArt(){
      navigationPage.goToLearnAboutArt();
      assertThat(page.getByRole(AriaRole.MENU, new Page.GetByRoleOptions().setName("Main navigation"))).isVisible();
   }

   @Test(priority = 17)
   public void menuArtworkOfTheDay(){
      navigationPage.goToArtworkOfTheDay();
      assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Artwork Details"))).isVisible();
   }

   @Test(priority = 18)
   public void menuIntroToArt(){
      navigationPage.goToIntroToArt();
      assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Intro to Art"))).isVisible();
   }
}
