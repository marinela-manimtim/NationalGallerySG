//This is the Object Repository of Navigation
package pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;


public class NavigationPage {
    //declare variable for Playwright Page
    Page page;

    //page constructor allows this class to use the Page object for browser interactions.
    public NavigationPage (Page page){
        this.page = page;
        initLocators();
    }

    private void initLocators() {
        popUpXButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Close consent popup"));
        homepageLogo = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("National Gallery Singapore –"));
        membershipLogin = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Membership Login"));
        cartButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Cart"));
        menuIcon = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Menu"));
        menuXButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Menu"));
        menuFirstVisitImage = page.getByRole(AriaRole.BANNER).getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("What’s On"));
        menuMustSeeTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Must-Sees & Must-Dos"));
        menuMustSeeWhatsOnTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("What's On").setExact(true));
        menuMustSeeExhibitionTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Exhibitions").setExact(true));
        menuMustSeeToursTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Tours").setExact(true));
        menuMustSeeOurCollectionsTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Our Collections"));
        menuMustSeeAGuideForFamiliesTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("A Guide for Families"));
        menuMustSeeFeaturedExhibitionTextLink = page.locator(" #must-see-must-do-panel > .cards > div:nth-child(5)");
        menuOurCollectionsTextLink = page.getByLabel("Main navigation").locator("a").filter(new Locator.FilterOptions().setHasText("Our Collections"));
        menuOurArchitectureTextLink = page.getByLabel("Main navigation").locator("li").filter(new Locator.FilterOptions().setHasText("Our Architecture & History"));
        menuLearnAboutArtTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Learn About Art"));
        menuArtworkOfTheDayImage = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Artwork of the day"));
        menuIntroToArtTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Intro to Art"));
        menuArtAtHomeTextLink = page.getByLabel("Learn About Art Panel").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Art at Home for Families"));
        menuAudioToursTextLink = page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Audio Tours")).nth(1);
        menuArtConservationTextLink = page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Art Conservation")).nth(1);
        menuPublicationsTextLink = page.getByLabel("Learn About Art Panel").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Publications"));
        menuPerspectivesMagazineTextLink = page.getByLabel("Learn About Art Panel").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Perspectives Magazine"));
        menuOnlineArtCoursesTextLink = page.getByLabel("Learn About Art Panel").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Online Art Courses"));
        menuCuratorialResearchTextLink = page.getByLabel("Learn About Art Panel").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Curatorial Research"));
        menuVisitTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Visit").setExact(true));
        menuVisitWhatsOnTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("What’s On "));
        menuVisitViewAllExhibitionsTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("View all Exhibitions "));
        menuVisitGuidedToursTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Guided Tours").setExact(true));
        menuVisitSelfGuidedToursTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Self-Guided Tours"));
        menuVisitAudioToursTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Audio Tours").setExact(true));
        menuVisitViewAllToursTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("View All Tours"));
        menuVisitFamilyGuideTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Family Guide"));
        menuVisitAccessibilityTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Accessibility at the Gallery"));
        menuVisitGalleryGuideMapTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Gallery Guide + Map"));
        menuVisitOpeningHoursTextLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Opening Hours & Getting Here"));
        menuVisitAdmissionTicketingTextLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Admission & Ticketing"));
        menuVisitDineShopTextLink = page.getByRole(AriaRole.REGION, new Page.GetByRoleOptions().setName("Visit")).getByLabel("Dine & Shop");
        menuVisitRotundaLibraryTextLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Rotunda Library & Archive"));
        menuVisitKeppelCentreTextLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Keppel Centre for Art"));
        menuVisitVisitInformationTextLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("More Visitor Information"));
        menuVisitSchoolVisitTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("School Visit "));
        menuVisitBecomeAMemberTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Become a Member "));
        menuVisitSGCulturePassTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("SG Culture Pass Programmes "));
        menuAboutTextLink = page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("About").setExact(true));
        menuOurStoryTextLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Our Story"));
        menuAboutLeadershipTextLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Leadership"));
        menuAboutOurAwardsTextLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Our Awards"));
        menuAboutMediaCentreTextLink = page.getByRole(AriaRole.REGION, new Page.GetByRoleOptions().setName("About Panel")).getByLabel("Media Centre");
        menuAboutAnnualReportsTextLink = page.getByRole(AriaRole.REGION, new Page.GetByRoleOptions().setName("About Panel")).getByLabel("Annual Reports");
        menuAboutSustainabilityTextLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sustainability"));
        menuAboutOurInitiativesTextLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Our Initiatives &"));
        menuAboutCommunityGroupVisitsTextLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Community Group Visits"));
        menuAboutCareersTextLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Careers & Internships"));
        menuAboutVenueRentalTextLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Venue Rental"));
        menuAboutPhotoshootsTextLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Photoshoots & Filming"));
        menuAboutBusinessOpportunitiesTextLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Business Opportunities"));
        menuAboutEnquiriesTextLink =page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Enquiries"));
        menuAboutWhistleblowingTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Whistleblowing"));
        menuDonateVolunteerTextLink = page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Donate & Volunteer"));
        menuMemberSignUpLoginTextLink = page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Member Sign Up/Login"));
        menuVenueRentalTextLink = page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Venue Rental"));
        menuIAmDropdown = page.getByText("I am a...Donor, Patron or");
        menuDonorPatronVolunteerOption = page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Donor, Patron or Volunteer"));
        menuVendorBusinessPartnerOption = page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Vendor/Business Partner"));
        menuMediaProfessionalOption = page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Media Professional"));
        menuEventOrganiserOption = page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Venue Hirer/Event Organiser"));
        menuMainNavigationXButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Menu"));
        getATicketOnItsOwnTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("get a ticket on its own"));
    }

    //Locators - Object Repository
    Locator popUpXButton;
    Locator homepageLogo;
    Locator membershipLogin;
    Locator cartButton;
    Locator menuIcon;
    Locator menuXButton;
    Locator menuFirstVisitImage;
    Locator menuMustSeeTextLink;
    Locator menuMustSeeWhatsOnTextLink;
    Locator menuMustSeeExhibitionTextLink;
    Locator menuMustSeeToursTextLink;
    Locator menuMustSeeOurCollectionsTextLink;
    Locator menuMustSeeAGuideForFamiliesTextLink;
    Locator menuMustSeeFeaturedExhibitionTextLink;
    Locator menuOurCollectionsTextLink;
    Locator menuOurArchitectureTextLink;
    Locator menuLearnAboutArtTextLink;
    Locator menuArtworkOfTheDayImage;
    Locator menuIntroToArtTextLink;
    Locator menuArtAtHomeTextLink;
    Locator menuAudioToursTextLink;
    Locator menuArtConservationTextLink;
    Locator menuPublicationsTextLink;
    Locator menuPerspectivesMagazineTextLink;
    Locator menuOnlineArtCoursesTextLink;
    Locator menuCuratorialResearchTextLink;
    Locator menuVisitTextLink;
    Locator menuVisitWhatsOnTextLink;
    Locator menuVisitViewAllExhibitionsTextLink;
    Locator menuVisitGuidedToursTextLink;
    Locator menuVisitSelfGuidedToursTextLink;
    Locator menuVisitAudioToursTextLink;
    Locator menuVisitViewAllToursTextLink;
    Locator menuVisitFamilyGuideTextLink;
    Locator menuVisitAccessibilityTextLink;
    Locator menuVisitGalleryGuideMapTextLink;
    Locator menuVisitOpeningHoursTextLink;
    Locator menuVisitAdmissionTicketingTextLink;
    Locator menuVisitDineShopTextLink;
    Locator menuVisitRotundaLibraryTextLink;
    Locator menuVisitKeppelCentreTextLink;
    Locator menuVisitVisitInformationTextLink;
    Locator menuVisitSchoolVisitTextLink;
    Locator menuVisitBecomeAMemberTextLink;
    Locator menuVisitSGCulturePassTextLink;
    Locator menuAboutTextLink;
    Locator menuOurStoryTextLink;
    Locator menuAboutLeadershipTextLink;
    Locator menuAboutOurAwardsTextLink;
    Locator menuAboutMediaCentreTextLink;
    Locator menuAboutAnnualReportsTextLink;
    Locator menuAboutSustainabilityTextLink;
    Locator menuAboutOurInitiativesTextLink;
    Locator menuAboutCommunityGroupVisitsTextLink;
    Locator menuAboutCareersTextLink;
    Locator menuAboutVenueRentalTextLink;
    Locator menuAboutPhotoshootsTextLink;
    Locator menuAboutBusinessOpportunitiesTextLink;
    Locator menuAboutEnquiriesTextLink;
    Locator menuAboutWhistleblowingTextLink;
    Locator menuDonateVolunteerTextLink;
    Locator menuMemberSignUpLoginTextLink;
    Locator menuVenueRentalTextLink;
    Locator menuIAmDropdown;
    Locator menuDonorPatronVolunteerOption;
    Locator menuVendorBusinessPartnerOption;
    Locator menuMediaProfessionalOption;
    Locator menuEventOrganiserOption;
    Locator menuMainNavigationXButton;
    Locator getATicketOnItsOwnTextLink;


    //Safe click helper
    private void safeClick(Locator locator, String elementName) {
        //Wait for the page to load before executing the try-catch method
        page.waitForLoadState(LoadState.LOAD);

        //try catch method to check if element is VISIBLE before clicking
        try {
            locator.waitFor(new Locator.WaitForOptions()
                    .setState(WaitForSelectorState.VISIBLE)
                    .setTimeout(5000));

            if (!locator.isEnabled()) {
                System.err.println("'" + elementName + "' is visible but not enabled.");
                return;
            }

            if (!locator.isVisible()) {
                System.err.println("'" + elementName + "' is not visible.");
                return;
            }
            locator.click();
        } catch (TimeoutError e) {
            System.err.println("Timeout waiting for '" + elementName + "' to become visible.");
        } catch (PlaywrightException e) {
            System.err.println("Error clicking '" + elementName + "': " + e.getMessage());
        }
    }

    //Disabling lazy loading helper to optimize automation testing and avoid flaky tests
    public void forceLoadAllLazyMedia() {
        page.evaluate("() => {" +
                "document.querySelectorAll('img[data-src]').forEach(img => {" +
                "   img.setAttribute('src', img.getAttribute('data-src'));" +
                "});" +
                "document.querySelectorAll('video[data-src]').forEach(video => {" +
                "   video.setAttribute('src', video.getAttribute('data-src'));" +
                "});" +
                "document.querySelectorAll('[loading=\"lazy\"]').forEach(el => {" +
                "   el.removeAttribute('loading');" +
                "});" +
                "}");
        page.waitForLoadState(LoadState.LOAD);
    }

    //page ACTION methods
    public void clickPopUpXButton(){
        safeClick(popUpXButton, "Close consent popup");
    }
    public void clickHomepageLogo(){
        safeClick(homepageLogo, "National Gallery Singapore –");
    }

    public void clickMembershipLogin(){

        safeClick(membershipLogin, "Membership Login");
    }

    //Page chaining
    public CartPage clickCartButton(){
        safeClick(cartButton, "Cart");
        return new CartPage(page);
    }

    public void clickMenuIcon(){
        safeClick(menuIcon, "Menu");
    }

    public void clickMenuXButton(){
        menuXButton.click();
    }

    public void clickFirstVisit(){

        menuFirstVisitImage.click();
    }

    public void clickMustSees(){
        safeClick(menuMustSeeTextLink, "Must-Sees & Must-Dos");
    }

    public void goToMustSee(){
        clickMenuIcon();
        clickMustSees();
    }

    public void clickMustSeeWhatsOn(){
        menuMustSeeWhatsOnTextLink.click();
    }

    public void goToWhatsOn(){
        goToMustSee();
        clickMustSeeWhatsOn();
    }

    public void clickMustSeeExhibition(){
        safeClick(menuMustSeeExhibitionTextLink, "Exhibitions");
    }

    public void goToWhatsOnExhibitions(){
        goToMustSee();
        clickMustSeeExhibition();
    }

    public void clickMustSeeTours(){
        safeClick(menuMustSeeToursTextLink, "Tours");
    }

    public void goToTours(){
        goToMustSee();
        clickMustSeeTours();
    }

    public void clickMustSeeOurCollections(){
        menuMustSeeOurCollectionsTextLink.click();
    }

    public void goToMustSeeOurCollections(){
        goToMustSee();
        clickMustSeeOurCollections();
    }

    public void clickMustSeeAGuideForFamilies(){
        menuMustSeeAGuideForFamiliesTextLink.click();
    }

    public void goToAGuideForFamilies(){
        goToMustSee();
        clickMustSeeAGuideForFamilies();
    }

    //for locators, '#' represents the id while '.' represents the className
    public void clickMustSeeFeaturedExhibition(){
        menuMustSeeFeaturedExhibitionTextLink.click();
    }

    public void goToMustSeeFeaturedExhibition(){
        goToMustSee();
        clickMustSeeFeaturedExhibition();
    }

    public void clickOurCollections(){
        menuOurCollectionsTextLink.click();
    }

    public void goToOurCollections(){
        clickMenuIcon();
        clickOurCollections();
    }

    public void clickOurArchitecture(){
        menuOurArchitectureTextLink.click();
    }

    public void goToOurArchitecture(){
        clickMenuIcon();
        clickOurArchitecture();
    }

    public void clickLearnAboutArt(){
        safeClick(menuLearnAboutArtTextLink, "Learn About Art");
    }

    public void goToLearnAboutArt(){
        clickMenuIcon();
        clickLearnAboutArt();
    }

    public void clickArtworkOfTheDay(){
        menuArtworkOfTheDayImage.click();
    }

    public void goToArtworkOfTheDay(){
        goToLearnAboutArt();
        clickArtworkOfTheDay();
    }

    public void clickIntroToArt(){
        menuIntroToArtTextLink.click();
    }

    public void goToIntroToArt(){
        goToLearnAboutArt();
        clickIntroToArt();
    }
    public void clickArtAtHome(){
        safeClick(menuArtAtHomeTextLink, "Art at Home for Families");
    }
    public void goToArtAtHome(){
        goToLearnAboutArt();
        clickArtAtHome();
    }

    public void clickAudioTours(){
        menuAudioToursTextLink.click();
    }
    public void goToAudioTours(){
        goToLearnAboutArt();
        clickAudioTours();
    }
    public void clickArtConservation(){
        menuArtConservationTextLink.click();
    }
    public void goToArtConservation(){
        goToLearnAboutArt();
        clickArtConservation();
    }
    public void clickPublications(){
        menuPublicationsTextLink.click();
    }
    public void goToPublications(){
        goToLearnAboutArt();
        clickPublications();
    }
    public void clickPerspectivesMagazine(){
        menuPerspectivesMagazineTextLink.click();
    }
    public void goToPerspectivesMagazine(){
        goToLearnAboutArt();
        clickPerspectivesMagazine();
    }
    public void clickOnlineArtCourses(){
        menuOnlineArtCoursesTextLink.click();
    }
    public void goToOnlineArtCourses(){
        goToLearnAboutArt();
        clickOnlineArtCourses();
    }
    public void clickCuratorialResearch(){
        menuCuratorialResearchTextLink.click();
    }
    public void goToCuratorialResearch(){
        goToLearnAboutArt();
        clickCuratorialResearch();
    }
    public void clickVisit() {
        safeClick(menuVisitTextLink, "Visit");
    }

    public void goToVisit(){
        clickMenuIcon();
        clickVisit();
    }
    public void clickVisitWhatsOn(){
        menuVisitWhatsOnTextLink.click();
    }
    public void goToVisitWhatsOn(){
        goToVisit();
        clickVisitWhatsOn();
    }
    public void clickVisitViewAllExhibitions(){
        safeClick( menuVisitViewAllExhibitionsTextLink, "View all Exhibitions ");
    }
    public void goToVisitViewAllExhibitions(){
        goToVisit();
        clickVisitViewAllExhibitions();
    }
    public void clickVisitGuidedTours(){
        safeClick(menuVisitGuidedToursTextLink, "Guided Tours");
    }
    public void goToVisitGuidedTours(){
        goToVisit();
        clickVisitGuidedTours();
    }
    public void clickVisitSelfGuidedTours(){
        safeClick(menuVisitSelfGuidedToursTextLink, "Self-Guided Tours");
    }
    public void goToVisitSelfGuidedTours(){
        goToVisit();
        clickVisitSelfGuidedTours();
    }
    public void clickVisitAudioTours(){
        menuVisitAudioToursTextLink.click();
    }
    public void goToVisitAudioTours(){
        goToVisit();
        clickVisitAudioTours();
    }
    public void clickVisitViewAllTours(){
        menuVisitViewAllToursTextLink.click();
    }
    public void goToVisitViewAllTours(){
        goToVisit();
        clickVisitViewAllTours();
    }
    public void clickVisitFamilyGuide(){
        menuVisitFamilyGuideTextLink.click();
    }
    public void goToVisitFamilyGuide(){
        goToVisit();
        clickVisitFamilyGuide();
    }
    public void clickVisitAccessibility(){
        menuVisitAccessibilityTextLink.click();
    }
    public void goToVisitAccessibility(){
        goToVisit();
        clickVisitAccessibility();
    }
    public void clickVisitGalleryGuideMap(){
        menuVisitGalleryGuideMapTextLink.click();
    }
    public void goToVisitGalleryGuideMap(){
        goToVisit();
        clickVisitGalleryGuideMap();
    }
    public void clickVisitOpeningHours(){
        safeClick(menuVisitOpeningHoursTextLink, "Opening Hours & Getting Here");
        /*
        try {
            // Wait until the element is visible and enabled before clicking
            menuVisitOpeningHoursTextLink.waitFor(new Locator.WaitForOptions()
                    .setState(WaitForSelectorState.VISIBLE)
                    .setTimeout(5000)); // timeout in milliseconds

            menuVisitOpeningHoursTextLink.click();
        } catch (TimeoutError e) {
            System.err.println("Timeout waiting for 'Opening Hours' link to become visible.");
            // Optional: retry logic or fallback
        } catch (PlaywrightException e) {
            System.err.println("Error clicking 'Opening Hours' link: " + e.getMessage());
        }

         */
    }
    public void goToVisitOpeningHours(){
        goToVisit();
        clickVisitOpeningHours();
    }
    public void clickVisitAdmissionTicketing(){
        menuVisitAdmissionTicketingTextLink.click();
    }
    public void goToVisitAdmissionTicketing(){
        goToVisit();
        clickVisitAdmissionTicketing();
    }
    public void clickVisitDineShop(){
        menuVisitDineShopTextLink.click();
    }
    public void goToVisitDineShop(){
        goToVisit();
        clickVisitDineShop();
    }
    public void clickVisitRotundaLibrary(){
        menuVisitRotundaLibraryTextLink.click();
    }
    public void goToVisitRotundaLibrary(){
        goToVisit();
        clickVisitRotundaLibrary();
    }
    public void clickVisitKeppelCentre(){
        menuVisitKeppelCentreTextLink.click();
    }
    public void goToVisitKeppelCentre(){
        goToVisit();
        clickVisitKeppelCentre();
    }
    public void clickVisitMoreVisitorInformation(){
        menuVisitVisitInformationTextLink.click();
    }
    public void goToVisitMoreVisitorInformation(){
        goToVisit();
        clickVisitMoreVisitorInformation();
    }
    public void clickVisitSchoolVisit(){
        menuVisitSchoolVisitTextLink.click();
    }
    public void goToVisitSchoolVisit(){
        goToVisit();
        clickVisitSchoolVisit();
    }
    public void clickVisitBecomeAMember(){
        menuVisitBecomeAMemberTextLink.click();
    }
    public void goToVisitBecomeAMember(){
        goToVisit();
        clickVisitBecomeAMember();
    }
    public void clickVisitSGCulturePass(){
        menuVisitSGCulturePassTextLink.click();
    }
    public void goToVisitSGCulturePass(){
        goToVisit();
        clickVisitSGCulturePass();
    }
    public void clickAbout(){
        menuAboutTextLink.click();
    }
    public void goToAbout(){
        clickMenuIcon();
        clickAbout();
    }
    public void clickAboutOurStory(){
        menuOurStoryTextLink.click();
    }
    public void goToAboutOurStory(){
        goToAbout();
        clickAboutOurStory();
    }
    public void clickAboutLeadership(){
        menuAboutLeadershipTextLink.click();
    }
    public void goToAboutLeadership(){
        goToAbout();
        clickAboutLeadership();
    }
    public void clickAboutOurAwards(){
        menuAboutOurAwardsTextLink.click();
    }
    public void goToAboutOurAwards(){
        goToAbout();
        clickAboutOurAwards();
    }
    public void clickAboutMediaCentre(){
        menuAboutMediaCentreTextLink.click();
    }
    public void goToAboutMediaCentre(){
        goToAbout();
        clickAboutMediaCentre();
    }
    public void clickAboutAnnualReports(){
        menuAboutAnnualReportsTextLink.click();
    }
    public void goToAboutAnnualReports(){
        goToAbout();
        clickAboutAnnualReports();
    }
    public void clickAboutSustainability(){
        menuAboutSustainabilityTextLink.click();
    }
    public void goToAboutSustainability(){
        goToAbout();
        clickAboutSustainability();
    }
    public void clickAboutOurInitiatives(){
        menuAboutOurInitiativesTextLink.click();
    }
    public void goToAboutOurInitiatives() {
        goToAbout();
        clickAboutOurInitiatives();
    }
    public void clickAboutCommunityGroupVisits(){
        menuAboutCommunityGroupVisitsTextLink.click();
    }
    public void goToAboutCommunityGroupVisits(){
        goToAbout();
        clickAboutCommunityGroupVisits();
    }
    public void clickAboutCareers() {
        menuAboutCareersTextLink.click();
    }
    public void goToAboutCareers(){
        goToAbout();
        clickAboutCareers();
    }
    public void clickAboutVenueRental(){
        menuAboutVenueRentalTextLink.click();
    }
    public void goToAboutVenueRental(){
        goToAbout();
        clickAboutVenueRental();
    }
    public void clickAboutPhotoshoots(){
        menuAboutPhotoshootsTextLink.click();
    }
    public void goToAboutPhotoshoots(){
        goToAbout();
        clickAboutPhotoshoots();
    }
    public void clickAboutBusinessOpportunities(){
        menuAboutBusinessOpportunitiesTextLink.click();
    }
    public void goToAboutBusinessOpportunities(){
        goToAbout();
        clickAboutBusinessOpportunities();
    }
    public void clickAboutEnquiries(){
        menuAboutEnquiriesTextLink.click();
    }
    public void goToAboutEnquiries(){
        goToAbout();
        clickAboutEnquiries();
    }
    public void clickAboutWhistleblowing(){
        menuAboutWhistleblowingTextLink.click();
    }
    public void goToAboutWhistleblowing(){
        goToAbout();
        clickAboutWhistleblowing();
    }
    public void clickMenuDonateVolunteer(){
        menuDonateVolunteerTextLink.click();
    }
    public void goToMenuDonateVolunteer(){
        clickMenuIcon();
        clickMenuDonateVolunteer();
    }
    public void clickMemberSignUpLogin(){
        menuMemberSignUpLoginTextLink.click();
    }
    public void goToMenuMemberSignUpLogin(){
        clickMenuIcon();
        clickMemberSignUpLogin();
    }
    public void clickVenueRental(){
        menuVenueRentalTextLink.click();
    }
    public void goToMenuVenueRental(){
        clickMenuIcon();
        clickVenueRental();
    }
    public void clickMenuIAm(){
        menuIAmDropdown.click();
    }
    public void clickDonorPatronVolunteer(){
        menuDonorPatronVolunteerOption.click();
    }
    public void goToMenuDonorPatronVolunteer(){
        clickMenuIcon();
        clickMenuIAm();
        clickDonorPatronVolunteer();
    }
    public void clickVendorBusinessPartner(){
        menuVendorBusinessPartnerOption.click();
    }
    public void goToMenuVendorBusinessPartner(){
        clickMenuIcon();
        clickMenuIAm();
        clickVendorBusinessPartner();
    }
    public void clickMediaProfessional(){
        menuMediaProfessionalOption.click();
    }
    public void goToMenuMediaProfessional(){
        clickMenuIcon();
        clickMenuIAm();
        clickMediaProfessional();
    }
    public void clickEventOrganiser(){
        menuEventOrganiserOption.click();
    }
    public void goToMenuEventOrganiser(){
        clickMenuIcon();
        clickMenuIAm();
        clickEventOrganiser();
    }
    public void clickMainNavigationXButton(){
        menuMainNavigationXButton.click();
    }
    public void goToCloseMainNavigation(){
        clickMainNavigationXButton();
    }

    public CartPage clickGetATicketOnItsOwn(){
        safeClick(getATicketOnItsOwnTextLink, "get a ticket on its own");
        return new CartPage(page);
    }

    public DirectPurchasePage goToDirectPurchase(){
        clickCartButton();
        clickGetATicketOnItsOwn();
        return new DirectPurchasePage(page);
    }
}
