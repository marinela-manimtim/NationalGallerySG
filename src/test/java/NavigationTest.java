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
   public void menuOurArchitectureTest(){
      navigationPage.goToOurArchitecture();
      assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Our Architecture & History"))).isVisible();
   }

   @Test(priority = 16)
   public void menuLearnAboutArtTest(){
      navigationPage.goToLearnAboutArt();
      assertThat(page.getByRole(AriaRole.MENU, new Page.GetByRoleOptions().setName("Main navigation"))).isVisible();
   }

   @Test(priority = 17)
   public void menuArtworkOfTheDayTest(){
      navigationPage.goToArtworkOfTheDay();
      assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Artwork Details"))).isVisible();
   }

   @Test(priority = 18)
   public void menuIntroToArtTest(){
      navigationPage.goToIntroToArt();
      assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Intro to Art"))).isVisible();
   }

   @Test(priority = 19)
   public void menuArtAtHomeTest(){
      navigationPage.goToArtAtHome();
      assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Art at Home for Families"))).isVisible();
   }

   @Test(priority = 20)
   public void menuAudioToursTest(){
      navigationPage.goToAudioTours();
      assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Audio Tours & Guides"))).isVisible();
   }

   @Test(priority = 21)
   public void menuArtConservationTest(){
      navigationPage.goToArtConservation();
      assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Art Conservation"))).isVisible();
   }

   @Test(priority = 22)
   public void menuPublicationsTest(){
      navigationPage.goToPublications();
      assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Publications").setExact(true))).isVisible();
   }

   @Test(priority = 23)
   public void menuPerspectivesMagazineTest(){
      navigationPage.goToPerspectivesMagazine();
      assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Perspectives Magazine"))).isVisible();
   }

   @Test(priority = 24)
   public void menuOnlineArtCoursesTest(){
      navigationPage.goToOnlineArtCourses();
      assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Online Art Courses"))).isVisible();
   }

   @Test(priority = 25)
   public void menuCuratorialResearchTest(){
      navigationPage.goToCuratorialResearch();
      assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Curatorial Research"))).isVisible();
   }

   @Test(priority = 26)
   public void menuVisitWhatsOnTest(){
      navigationPage.goToVisitWhatsOn();
      assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("What’s On"))).isVisible();
   }

   @Test(priority = 27)
   public void menuVisitViewAllExhibitionsTest(){
      navigationPage.goToVisitViewAllExhibitions();
      assertThat(page.locator("#whatsOnFilter").getByLabel("Select an option").getByText("Exhibition")).isVisible();
   }

   @Test(priority = 28)
   public void menuVisitGuidedToursTest(){
      navigationPage.goToVisitGuidedTours();
      assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Guided tours").setExact(true))).isVisible();
   }

   @Test(priority = 29)
   public void menuVisitSelfGuidedToursTest(){
      navigationPage.goToVisitSelfGuidedTours();
      assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Self-guided tours"))).isVisible();
   }

   @Test(priority = 30)
   public void menuVisitAudioToursTest(){
      navigationPage.goToVisitAudioTours();
      assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Audio Tours & Guides"))).isVisible();
   }

   @Test(priority = 31)
   public void menuVisitViewAllToursTest(){
      navigationPage.goToVisitViewAllTours();
      assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Tours").setExact(true))).isVisible();
   }

   @Test(priority = 32)
   public void menuVisitFamilyGuideTest(){
      navigationPage.goToVisitFamilyGuide();
      assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("A Guide for Families Visiting"))).isVisible();
   }

   @Test(priority = 33)
   public void menuVisitAccessibilityTest(){
      navigationPage.goToVisitAccessibility();
      assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Accessibility at the Gallery"))).isVisible();
   }

   //@Todo implement TimeoutError https://playwright.dev/docs/api/class-timeouterror
   @Test(priority = 34)
   public void menuVisitGalleryGuideMapTest(){
      navigationPage.clickPopUpXButton();
      navigationPage.clickPopUpXButton();
      navigationPage.goToVisitGalleryGuideMap();
      Page page1 = page.waitForPopup(() -> {
         navigationPage.clickVisitGalleryGuideMap();
      });
      assertThat(page1).hasURL("https://www.nationalgallery.sg/content/dam/visit/guides/Gallery-Guide-Map-2025-Q4-Web-20250915.pdf");
      page1.close();
   }

   @Test(priority = 35)
   public void menuVisitOpeningHoursTest(){
      navigationPage.goToVisitOpeningHours();
      assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Opening hours"))).isVisible();
   }

   @Test(priority = 36)
   public void menuVisitAdmissionTicketingTest(){
      navigationPage.goToVisitAdmissionTicketing();
      assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Admission & ticketing"))).isVisible();
   }

}
