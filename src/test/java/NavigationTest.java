import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

//'extends' is used to establish an inheritance relationship between classes
public class NavigationTest extends BaseTest{

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

   //set test priority to temporarily set order of test execution. The order can be configured. @Todo set this config.
   @Test(priority = 1)
   public void popUpXButtonTest() {
      navigationPage.clickPopUpXButton();
      assertVisible(page, AriaRole.HEADING, ("Singapore Stories: Pathways"));
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
       assertVisible(page1, AriaRole.BUTTON, ("Log in"));
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
       assertVisible(page, AriaRole.MENU, ("Main navigation"));
   }

   @Test(priority = 6)
   public void menuFirstVisitTest() {
      navigationPage.clickFirstVisit();
      assertVisible(page, AriaRole.HEADING, "What’s On");
   }

   @Test(priority = 7)
   public void menuMustSeesTest() {
      navigationPage.clickMenuIcon();
      navigationPage.clickMustSees();
      assertVisible(page, AriaRole.REGION, "Must-See Must-Do Panel");
   }

   @Test(priority = 8)
   public void menuMustSeeWhatsOnTest() {
      navigationPage.goToWhatsOn();
      assertVisible(page, AriaRole.TABPANEL, "Today");
   }

   @Test(priority = 9)
   public void menuMustSeeExhibitionTest() {
      navigationPage.goToWhatsOnExhibitions();
      assertVisible(page.locator("#whatsOnFilter").getByLabel("Select an option").getByText("Exhibition"));
   }

   @Test(priority = 10)
   public void menuMustSeeToursTest() {
      navigationPage.goToTours();
      assertVisible(page, AriaRole.HEADING, "Tours", true);
   }


   @Test(priority = 11)
   public void menuMustSeeOurCollectionsTest() {
      navigationPage.goToMustSeeOurCollections();
      assertVisible(page, AriaRole.HEADING, "The World’s Largest");
   }

   @Test(priority = 12)
   public void menuMustSeeAGuideForFamiliesTest() {
      navigationPage.goToAGuideForFamilies();
      assertVisible(page, AriaRole.HEADING, "A Guide for Families Visiting");
   }

   @Test(priority = 13)
   public void menuMustSeeFeaturedExhibitionTest() {
      navigationPage.goToMustSeeFeaturedExhibition();
      assertVisible(page, AriaRole.NAVIGATION, "Breadcrumb");
   }

   @Test(priority = 14)
   public void menuOurCollectionsTest() {
      navigationPage.goToOurCollections();
      assertVisible(page, AriaRole.HEADING, "The World’s Largest");
   }

   @Test(priority = 15)
   public void menuOurArchitectureTest() {
      navigationPage.goToOurArchitecture();
      assertVisible(page, AriaRole.HEADING, "Our Architecture & History");
   }

   @Test(priority = 16)
   public void menuLearnAboutArtTest() {
      navigationPage.goToLearnAboutArt();
      assertVisible(page, AriaRole.MENU, "Main navigation");
   }

   @Test(priority = 17)
   public void menuArtworkOfTheDayTest() {
      navigationPage.goToArtworkOfTheDay();
      assertVisible(page, AriaRole.HEADING, "Artwork Details");
   }

   @Test(priority = 18)
   public void menuIntroToArtTest() {
      navigationPage.goToIntroToArt();
      assertVisible(page, AriaRole.HEADING, "Intro to Art");
   }

   @Test(priority = 19)
   public void menuArtAtHomeTest() {
      navigationPage.goToArtAtHome();
      assertVisible(page, AriaRole.HEADING, "Art at Home for Families");
   }

   @Test(priority = 20)
   public void menuAudioToursTest() {
      navigationPage.goToAudioTours();
      assertVisible(page, AriaRole.HEADING, "Audio Tours & Guides");
   }

   @Test(priority = 21)
   public void menuArtConservationTest() {
      navigationPage.goToArtConservation();
      assertVisible(page, AriaRole.HEADING, "Art Conservation");
   }

   @Test(priority = 22)
   public void menuPublicationsTest() {
      navigationPage.goToPublications();
      assertVisible(page, AriaRole.HEADING, "Publications", true);
   }

   @Test(priority = 23)
   public void menuPerspectivesMagazineTest() {
      navigationPage.goToPerspectivesMagazine();
      assertVisible(page, AriaRole.HEADING, "Perspectives Magazine");
   }

   @Test(priority = 24)
   public void menuOnlineArtCoursesTest() {
      navigationPage.goToOnlineArtCourses();
      assertVisible(page, AriaRole.HEADING, "Online Art Courses");
   }

   @Test(priority = 25)
   public void menuCuratorialResearchTest() {
      navigationPage.goToCuratorialResearch();
      assertVisible(page, AriaRole.HEADING, "Curatorial Research");
   }

   @Test(priority = 26)
   public void menuVisitWhatsOnTest() {
      navigationPage.goToVisitWhatsOn();
      assertVisible(page, AriaRole.HEADING, "What’s On");
   }

   @Test(priority = 27)
   public void menuVisitViewAllExhibitionsTest() {
      navigationPage.goToVisitViewAllExhibitions();
      assertVisible(page.locator("#whatsOnFilter").getByLabel("Select an option").getByText("Exhibition"));
   }

   @Test(priority = 28)
   public void menuVisitGuidedToursTest() {
      navigationPage.goToVisitGuidedTours();
      assertVisible(page, AriaRole.HEADING, "Guided tours", true);
   }

   @Test(priority = 29)
   public void menuVisitSelfGuidedToursTest() {
      navigationPage.goToVisitSelfGuidedTours();
      assertVisible(page, AriaRole.HEADING, "Self-guided tours");
   }

   @Test(priority = 30)
   public void menuVisitAudioToursTest() {
      navigationPage.goToVisitAudioTours();
      assertVisible(page, AriaRole.HEADING, "Audio Tours & Guides");
   }

   @Test(priority = 31)
   public void menuVisitViewAllToursTest() {
      navigationPage.goToVisitViewAllTours();
      assertVisible(page, AriaRole.HEADING, "Tours", true);
   }

   @Test(priority = 32)
   public void menuVisitFamilyGuideTest() {
      navigationPage.goToVisitFamilyGuide();
      assertVisible(page, AriaRole.HEADING, "A Guide for Families Visiting");
   }

   @Test(priority = 33)
   public void menuVisitAccessibilityTest() {
      navigationPage.goToVisitAccessibility();
      assertVisible(page, AriaRole.HEADING, "Accessibility at the Gallery");
   }

   @Test(priority = 34)
   public void menuVisitGalleryGuideMapTest() {
      Page guideMapPdf = page.waitForPopup(navigationPage::goToVisitGalleryGuideMap);
      assertThat(guideMapPdf).hasURL("https://www.nationalgallery.sg/content/dam/visit/guides/Gallery-Guide-Map-2025-Q4-Web-20250915.pdf");
      guideMapPdf.close();
   }

   @Test(priority = 35)
   public void menuVisitOpeningHoursTest() {
      navigationPage.goToVisitOpeningHours();
      assertVisible(page, AriaRole.HEADING, "Opening hours");
   }

   @Test(priority = 36)
   public void menuVisitAdmissionTicketingTest() {
      navigationPage.goToVisitAdmissionTicketing();
      assertVisible(page, AriaRole.HEADING, "Admission & ticketing");
   }

   @Test(priority = 37)
   public void menuVisitDineShopTest() {
      navigationPage.goToVisitDineShop();
      assertVisible(page, AriaRole.HEADING, "Dine & Shop");
   }

   @Test(priority = 38)
   public void menuVisitRotundaLibraryTest() {
      navigationPage.goToVisitRotundaLibrary();
      assertVisible(page, AriaRole.HEADING, "Rotunda Library & Archive", true);
   }

   @Test(priority = 39)
   public void menuVisitKeppelCentreTest() {
      navigationPage.goToVisitKeppelCentre();
      assertVisible(page.getByText("Keppel Centre for Art Education", new Page.GetByTextOptions().setExact(true)).nth(3));
   }

   @Test(priority = 40)
   public void menuVisitMoreVisitorInformationTest() {
      navigationPage.goToVisitMoreVisitorInformation();
      assertVisible(page, AriaRole.HEADING, "Visitor Information");
   }

   @Test(priority = 41)
   public void menuVisitSchoolVisitTest() {
      navigationPage.goToVisitSchoolVisit();
      assertVisible(page, AriaRole.HEADING, "School Group Visits at the");
   }

   @Test(priority = 42)
   public void menuVisitBecomeAMemberTest() {
      navigationPage.goToVisitBecomeAMember();
      assertVisible(page, AriaRole.HEADING, "Become a Gallery Member");
   }

   @Test(priority = 43)
   public void menuVisitSGCulturePassTest() {
      navigationPage.goToVisitSGCulturePass();
      assertVisible(page, AriaRole.HEADING, "SG Culture Pass", true);
   }

   @Test(priority = 44)
   public void menuAboutOurStoryTest() {
      navigationPage.goToAboutOurStory();
      assertVisible(page, AriaRole.HEADING, "Our Story");
   }

   @Test(priority = 45)
   public void menuAboutLeadershipTest() {
      navigationPage.goToAboutLeadership();
      assertVisible(page, AriaRole.HEADING, "Leadership");
   }

   @Test(priority = 46)
   public void menuAboutOurAwardsTest() {
      navigationPage.goToAboutOurAwards();
      assertVisible(page, AriaRole.HEADING, "Our Awards");
   }

   @Test(priority = 47)
   public void menuAboutMediaCentreTest() {
      navigationPage.goToAboutMediaCentre();
      assertVisible(page, AriaRole.HEADING, "Media Centre");
   }

   @Test(priority = 48)
   public void menuAboutAnnualReportsTest() {
      navigationPage.goToAboutAnnualReports();
      assertVisible(page, AriaRole.HEADING, "Annual Reports");
   }

   @Test(priority = 49)
   public void menuAboutSustainabilityTest() {
      navigationPage.goToAboutSustainability();
      assertVisible(page, AriaRole.HEADING, "Sustainability", true);
   }

   @Test(priority = 50)
   public void menuAboutOurInitiativesTest() {
      navigationPage.goToAboutOurInitiatives();
      assertVisible(page, AriaRole.HEADING, "Our Initiatives &");
   }

   @Test(priority = 51)
   public void menuAboutCommunityGroupVisitsTest() {
      navigationPage.goToAboutCommunityGroupVisits();
      assertVisible(page, AriaRole.HEADING, "Community Group Visits");
   }

   @Test(priority = 52)
   public void menuAboutCareersTest() {
      navigationPage.goToAboutCareers();
      assertVisible(page, AriaRole.HEADING, "Careers & Internships");
   }

   @Test(priority = 53)
   public void menuAboutVenueRentalTest() {
      navigationPage.goToAboutVenueRental();
      assertVisible(page, AriaRole.HEADING, "Venue Rental");
   }

   @Test(priority = 54)
   public void menuAboutPhotoshootsTest() {
      navigationPage.goToAboutPhotoshoots();
      assertVisible(page.getByLabel("Breadcrumb").getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Photoshoots & Filming")));
   }

   @Test(priority = 55)
   public void menuAboutBusinessOpportunitiesTest() {
      navigationPage.goToAboutBusinessOpportunities();
      assertVisible(page, AriaRole.HEADING, "Business Opportunities");
   }

   @Test(priority = 56)
   public void menuAboutEnquiriesTest() {
      navigationPage.goToAboutEnquiries();
      assertVisible(page, AriaRole.HEADING, "Contact");
   }

   @Test(priority = 57)
   public void menuAboutWhistleblowingTest() {
      navigationPage.goToAboutWhistleblowing();
      assertVisible(page, AriaRole.HEADING, "Whistleblowing");
   }

   @Test(priority = 58)
   public void menuDonateVolunteerTest() {
      navigationPage.goToMenuDonateVolunteer();
      assertVisible(page, AriaRole.HEADING, "Donate & Volunteer");
   }

   @Test(priority = 59)
   public void menuMemberSignUpLoginTest() {
      Page page3 = page.waitForPopup(navigationPage::goToMenuMemberSignUpLogin);
      assertVisible(page3, AriaRole.BUTTON, "Log In");
      page3.close();
   }

   @Test(priority = 60)
   public void menuVenueRentalTest() {
      navigationPage.goToMenuVenueRental();
      assertVisible(page, AriaRole.HEADING, "Venue Rental");
   }

   @Test(priority = 61)
   public void menuIAmADropdownTest() {
      navigationPage.goToMenuDonorPatronVolunteer();
      assertVisible(page, AriaRole.HEADING, "Donor, Patron, or Volunteer");

      navigationPage.goToMenuVendorBusinessPartner();
      assertVisible(page, AriaRole.HEADING, "Business Opportunities");

      navigationPage.goToMenuMediaProfessional();
      assertVisible(page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Media Professional")));

      navigationPage.goToMenuEventOrganiser();
      assertVisible(page, AriaRole.HEADING, "Event Organiser");
   }

   @Test(priority = 62)
   public void closeMainNavigationTest() {
      navigationPage.goToCloseMainNavigation();
      assertVisible(page, AriaRole.LINK, "Home", true);
   }

}
