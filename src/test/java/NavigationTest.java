import Constants.SiteConstants;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

//'extends' is used to establish an inheritance relationship between classes
public class NavigationTest extends BaseTest {
   //For Soft Assertions. Soft Assertions are when you would like your test to continue even if it fails.
   SoftAssert softAssert = new SoftAssert();

   //Assert Locator Visibility Helpers
   private void assertVisible(Locator locator) {
      try {
         locator.waitFor(new Locator.WaitForOptions()
                 .setState(WaitForSelectorState.VISIBLE)
                 .setTimeout(5000)); // wait up to 5 seconds
         //locator.highlight(); // For debugging. This highlights the element if element is there but playwright is not able to see it.
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


   //set test priority to temporarily set order of test execution. The order can be configured. @Todo set this config.
   @Test(priority = 1)
   public void popUpXButtonTest() {
      navigationPage.clickPopUpXButton();
      assertVisible(page, AriaRole.HEADING, SiteConstants.POPUP_X_HEADING);
   }

   @Test(priority = 2)
   public void homepageLogoTest() {
      navigationPage.clickHomepageLogo();
      navigationPage.forceLoadAllLazyMedia();
      assertThat(page).hasURL(prop.getProperty("homepageLogoUrl"));
   }

   @Test(priority = 3)
   public void membershipLoginTest() {
      Page page1 = page.waitForPopup(() -> {
         navigationPage.clickMembershipLogin();
      });
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page1, AriaRole.BUTTON, SiteConstants.MEMBERSHIP_LOGIN_BUTTON);
      page1.close();
   }

   @Test(priority = 4)
      public void cartButtonTest(){
      navigationPage.clickCartButton();
      navigationPage.forceLoadAllLazyMedia();
      assertThat(page).hasTitle(SiteConstants.CART_PAGE_TITLE);
   }

   @Test(priority = 5)
   public void menuIconTest() {
      navigationPage.clickMenuIcon();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.MENU, SiteConstants.MENU_ARIA_LABEL);
   }

   @Test(priority = 6)
   public void menuFirstVisitTest() {
      navigationPage.clickFirstVisit();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.WHATS_ON_PAGE_HEADING);
   }

   @Test(priority = 7)
   public void menuMustSeesTest() {
      navigationPage.clickMenuIcon();
      navigationPage.clickMustSees();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.REGION, "Must-See Must-Do Panel");
   }

   @Test(priority = 8)
   public void menuMustSeeWhatsOnTest() {
      navigationPage.goToWhatsOn();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.TABPANEL, SiteConstants.TODAY);
   }

   @Test(priority = 9)
   public void menuMustSeeExhibitionTest() {
      navigationPage.goToWhatsOnExhibitions();
      navigationPage.forceLoadAllLazyMedia();
      Locator exhibitionOption = page.locator("div.ss-single", new Page.LocatorOptions().setHasText(SiteConstants.EXHIBITION));
      assertVisible(exhibitionOption);
   }

   @Test(priority = 10)
   public void menuMustSeeToursTest() {
      navigationPage.goToTours();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.TOURS, true);
   }


   @Test(priority = 11)
   public void menuMustSeeOurCollectionsTest() {
      navigationPage.goToMustSeeOurCollections();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.COLLECTIONS_LANDING);
   }

   @Test(priority = 12)
   public void menuMustSeeAGuideForFamiliesTest() {
      navigationPage.goToAGuideForFamilies();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.A_GUIDE_FOR_FAMILIES);
   }

   @Test(priority = 13)
   public void menuMustSeeFeaturedExhibitionTest() {
      navigationPage.goToMustSeeFeaturedExhibition();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.NAVIGATION, "Breadcrumb");
   }

   @Test(priority = 14)
   public void menuOurCollectionsTest() {
      navigationPage.goToOurCollections();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.COLLECTIONS_LANDING);
   }

   @Test(priority = 15)
   public void menuOurArchitectureTest() {
      navigationPage.goToOurArchitecture();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.OUR_ARCHITECTURE_HISTORY);
   }

   @Test(priority = 16)
   public void menuLearnAboutArtTest() {
      navigationPage.goToLearnAboutArt();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.MENU, SiteConstants.MENU_ARIA_LABEL);
   }

   @Test(priority = 17)
   public void menuArtworkOfTheDayTest() {
      navigationPage.goToArtworkOfTheDay();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.ARTWORK_DETAILS);
   }

   @Test(priority = 18)
   public void menuIntroToArtTest() {
      navigationPage.goToIntroToArt();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.INTRO_TO_ART);
   }

   @Test(priority = 19)
   public void menuArtAtHomeTest() {
      navigationPage.goToArtAtHome();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.ART_AT_HOME_FOR_FAMILIES);
   }
/*
   @Test(priority = 20)
   public void lazyLoadArtAtHomeTest(){
      navigationPage.goToArtAtHome();
      assertVisible(page, AriaRole.HEADING, "Art at Home for Families");
      checkAllImgDataSrcInThePageTest();
   }

   public void checkAllImgDataSrcInThePageTest(){ //@ToDo This method currently only tests the images on the Art At Home For Families - Slider Component. Implement this method to check for the whole page.
      navigationPage.goToArtAtHome();

      // Now collect all images with data-src
      List<ElementHandle> lazyImages = page.querySelectorAll("img[data-src]");
      System.out.println("Found " + lazyImages.size() + " images with data-src");

      Locator nextArrow = page.locator("section")
              .filter(new Locator.FilterOptions().setHasText("Watch & learn Art Stories"))
              .getByLabel("Next slide");

      Set<String> seenDataSrc = new HashSet<>();
      boolean newImageFound = false;

      while (true) {
         // Collect all visible images in the current slide
         List<ElementHandle> currentImages = page.querySelectorAll("section img[data-src]");
         for (ElementHandle img : currentImages) {
            String dataSrc = img.getAttribute("data-src");
            if (seenDataSrc.add(dataSrc)) {
               String initialSrc = img.getAttribute("src");
            /*
               // Force lazy load by simulating intersection observer trigger
               page.evaluate("img => img.setAttribute('src', img.getAttribute('data-src'))", img);

               // Wait for src to update
               page.waitForCondition(() -> {
                  String currentSrc = img.getAttribute("src");
                  return currentSrc != null && !currentSrc.isEmpty() && !currentSrc.equals(initialSrc);
               });

               String newSrc = img.getAttribute("src");
               System.out.println("After trigger: src=" + newSrc);

               softAssert.assertNotNull(initialSrc, "Img src is NULL. Please manually check the image for: " + dataSrc);

            }

            // Break if no new images AND next arrow is disabled
            if (!newImageFound && !nextArrow.isEnabled()) {
               break;
            }

            // If next arrow is enabled, click to load next slide
            if (nextArrow.isEnabled()) {
               nextArrow.click();
               page.waitForTimeout(500);
            } else {
               break;
            }

         }
         System.out.println("Total unique images checked: " + seenDataSrc.size());
         softAssert.assertAll();
      }
   }
 */

   @Test(priority = 21)
   public void menuAudioToursTest() {
      navigationPage.goToAudioTours();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.AUDIO_TOURS_AND_GUIDES);
   }

   @Test(priority = 22)
   public void menuArtConservationTest() {
      navigationPage.goToArtConservation();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.ART_CONSERVATION);
   }

   @Test(priority = 22)
   public void menuPublicationsTest() {
      navigationPage.goToPublications();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.PUBLICATIONS, true);
   }

   @Test(priority = 23)
   public void menuPerspectivesMagazineTest() {
      navigationPage.goToPerspectivesMagazine();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.PERSPECTIVES_MAGAZINE);
   }

   @Test(priority = 24)
   public void menuOnlineArtCoursesTest() {
      navigationPage.goToOnlineArtCourses();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.ONLINE_ART_COURSES);
   }

   @Test(priority = 25)
   public void menuCuratorialResearchTest() {
      navigationPage.goToCuratorialResearch();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.CURATORIAL_RESEARCH);
   }

   @Test(priority = 26)
   public void menuVisitWhatsOnTest() {
      navigationPage.goToVisitWhatsOn();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.WHATS_ON_PAGE_HEADING);
   }

   @Test(priority = 27)
   public void menuVisitViewAllExhibitionsTest() {
      navigationPage.goToVisitViewAllExhibitions();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page.locator("#whatsOnFilter").getByLabel(SiteConstants.WHATS_ON_SELECT_AN_OPTION).getByText(SiteConstants.EXHIBITION));
   }

   @Test(priority = 28)
   public void menuVisitGuidedToursTest() {
      navigationPage.goToVisitGuidedTours();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.GUIDED_TOURS, true);
   }

   @Test(priority = 29)
   public void menuVisitSelfGuidedToursTest() {
      navigationPage.goToVisitSelfGuidedTours();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.SELF_GUIDED_TOURS);
   }

   @Test(priority = 30)
   public void menuVisitAudioToursTest() {
      navigationPage.goToVisitAudioTours();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.AUDIO_TOURS_AND_GUIDES);
   }

   @Test(priority = 31)
   public void menuVisitViewAllToursTest() {
      navigationPage.goToVisitViewAllTours();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.TOURS, true);
   }

   @Test(priority = 32)
   public void menuVisitFamilyGuideTest() {
      navigationPage.goToVisitFamilyGuide();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.A_GUIDE_FOR_FAMILIES);
   }

   @Test(priority = 33)
   public void menuVisitAccessibilityTest() {
      navigationPage.goToVisitAccessibility();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.ACCESSIBILITY_AT_THE_GALLERY);
   }

   @Test(priority = 34)
   public void menuVisitGalleryGuideMapTest() {
      Page guideMapPdf = page.waitForPopup(navigationPage::goToVisitGalleryGuideMap);
      navigationPage.forceLoadAllLazyMedia();
      assertThat(guideMapPdf).hasURL(prop.getProperty("galleryGuideMapUrl"));
      guideMapPdf.close();
   }

   @Test(priority = 35)
   public void menuVisitOpeningHoursTest() {
      navigationPage.goToVisitOpeningHours();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.OPENING_HOURS_HEADING);
   }

   @Test(priority = 36)
   public void menuVisitAdmissionTicketingTest() {
      navigationPage.goToVisitAdmissionTicketing();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.ADMISSION_AND_TICKETING);
   }

   @Test(priority = 37)
   public void menuVisitDineShopTest() {
      navigationPage.goToVisitDineShop();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.DINE_AND_SHOP);
   }

   @Test(priority = 38)
   public void menuVisitRotundaLibraryTest() {
      navigationPage.goToVisitRotundaLibrary();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.ROTUNDA_LIBRARY, true);
   }

   @Test(priority = 39)
   public void menuVisitKeppelCentreTest() {
      navigationPage.goToVisitKeppelCentre();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page.getByText(SiteConstants.KEPPEL_CENTRE, new Page.GetByTextOptions().setExact(true)).nth(3));
   }

   @Test(priority = 40)
   public void menuVisitMoreVisitorInformationTest() {
      navigationPage.goToVisitMoreVisitorInformation();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.VISITOR_INFORMATION_HEADING);
   }

   @Test(priority = 41)
   public void menuVisitSchoolVisitTest() {
      navigationPage.goToVisitSchoolVisit();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.SCHOOL_VISIT);
   }

   @Test(priority = 42)
   public void menuVisitBecomeAMemberTest() {
      navigationPage.goToVisitBecomeAMember();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.BECOME_A_MEMBER);
   }

   @Test(priority = 43)
   public void menuVisitSGCulturePassTest() {
      navigationPage.goToVisitSGCulturePass();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.SG_CULTURE_PASS, true);
   }

   @Test(priority = 44)
   public void menuAboutOurStoryTest() {
      navigationPage.goToAboutOurStory();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.OUR_STORY);
   }

   @Test(priority = 45)
   public void menuAboutLeadershipTest() {
      navigationPage.goToAboutLeadership();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.LEADERSHIP);
   }

   @Test(priority = 46)
   public void menuAboutOurAwardsTest() {
      navigationPage.goToAboutOurAwards();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.OUR_AWARDS);
   }

   @Test(priority = 47)
   public void menuAboutMediaCentreTest() {
      navigationPage.goToAboutMediaCentre();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.MEDIA_CENTRE);
   }

   @Test(priority = 48)
   public void menuAboutAnnualReportsTest() {
      navigationPage.goToAboutAnnualReports();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.ANNUAL_REPORTS);
   }

   @Test(priority = 49)
   public void menuAboutSustainabilityTest() {
      navigationPage.goToAboutSustainability();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.SUSTAINABILITY, true);
   }

   @Test(priority = 50)
   public void menuAboutOurInitiativesTest() {
      navigationPage.goToAboutOurInitiatives();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.OUR_INITIATIVES);
   }

   @Test(priority = 51)
   public void menuAboutCommunityGroupVisitsTest() {
      navigationPage.goToAboutCommunityGroupVisits();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.COMMUNITY_GROUP_VISITS);
   }

   @Test(priority = 52)
   public void menuAboutCareersTest() {
      navigationPage.goToAboutCareers();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.CAREERS_AND_INTERNSHIPS);
   }

   @Test(priority = 53)
   public void menuAboutVenueRentalTest() {
      navigationPage.goToAboutVenueRental();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.VENUE_RENTAL);
   }

   @Test(priority = 54)
   public void menuAboutPhotoshootsTest() {
      navigationPage.goToAboutPhotoshoots();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page.getByLabel("Breadcrumb").getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText(SiteConstants.PHOTOSHOOTS)));
   }

   @Test(priority = 55)
   public void menuAboutBusinessOpportunitiesTest() {
      navigationPage.goToAboutBusinessOpportunities();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.BUSINESS_OPPORTUNITIES);
   }

   @Test(priority = 56)
   public void menuAboutEnquiriesTest() {
      navigationPage.goToAboutEnquiries();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.CONTACT);
   }

   @Test(priority = 57)
   public void menuAboutWhistleblowingTest() {
      navigationPage.goToAboutWhistleblowing();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.WHISTLEBLOWING);
   }

   @Test(priority = 58)
   public void menuDonateVolunteerTest() {
      navigationPage.goToMenuDonateVolunteer();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.DONATE_AND_VOLUNTEER);
   }

   @Test(priority = 59)
   public void menuMemberSignUpLoginTest() {
      Page page3 = page.waitForPopup(navigationPage::goToMenuMemberSignUpLogin);
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page3, AriaRole.BUTTON, SiteConstants.MEMBERSHIP_LOGIN_BUTTON);
      page3.close();
   }

   @Test(priority = 60)
   public void menuVenueRentalTest() {
      navigationPage.goToMenuVenueRental();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.VENUE_RENTAL);
   }

   @Test(priority = 61)
   public void menuIAmADropdownTest() {
      navigationPage.goToMenuDonorPatronVolunteer();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.DONOR_PATRON_VOLUNTEER);

      navigationPage.goToMenuVendorBusinessPartner();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.BUSINESS_OPPORTUNITIES);

      navigationPage.goToMenuMediaProfessional();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText(SiteConstants.MEDIA_PROFESSIONAL)));

      navigationPage.goToMenuEventOrganiser();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.HEADING, SiteConstants.EVENT_ORGANISER);
   }

   @Test(priority = 62)
   public void closeMainNavigationTest() {
      navigationPage.goToCloseMainNavigation();
      navigationPage.forceLoadAllLazyMedia();
      assertVisible(page, AriaRole.LINK, "Home", true);
   }

}