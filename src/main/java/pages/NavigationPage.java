//This is the Object Repository of Navigation
package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NavigationPage {
    //declare variable for Playwright Page
    Page page;

    //page constructor
    public NavigationPage (Page page){
        this.page = page;
    }
    //<----------------------------------------------------------------------------------->

    //page ACTION methods
    public void clickPopUpXButton(){
        Locator popUpXButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Close consent popup"));
        popUpXButton.click();
    }
    public void clickHomepageLogo(){
        Locator homepageLogo = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("National Gallery Singapore –"));
        homepageLogo.click();
    }

    public void clickMembershipLogin(){
        Locator membershipLogin = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Membership Login"));
        membershipLogin.click();
    }

    public void clickCartButton(){
        Locator cartButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Cart"));
        cartButton.click();
    }

    public void clickMenuIcon(){
        Locator menuIcon = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Menu"));
        menuIcon.click();
    }

    public void clickMenuXButton(){
        Locator menuXButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Menu"));
        menuXButton.click();
    }

    public void clickFirstVisit(){
        Locator menuFirstVisitImage = page.getByRole(AriaRole.BANNER).getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("What’s On"));
        menuFirstVisitImage.click();
    }

    public void clickMustSees(){
        Locator menuMustSeeTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Must-Sees & Must-Dos"));
        menuMustSeeTextLink.click();
    }

    public void goToMustSee(){
        clickMenuIcon();
        clickMustSees();
    }

    public void clickMustSeeWhatsOn(){
        Locator menuMustSeeWhatsOnTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("What's On"));
        menuMustSeeWhatsOnTextLink.click();
    }

    public void goToWhatsOn(){
        goToMustSee();
        clickMustSeeWhatsOn();
    }

    public void clickMustSeeExhibition(){
        Locator menuMustSeeExhibitionTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Exhibitions").setExact(true));
        menuMustSeeExhibitionTextLink.click();
    }

    public void goToWhatsOnExhibitions(){
        goToMustSee();
        clickMustSeeExhibition();
    }

    public void clickMustSeeTours(){
        Locator menuMustSeeToursTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Tours").setExact(true));
        menuMustSeeToursTextLink.click();
    }

    public void goToTours(){
        goToMustSee();
        clickMustSeeTours();
    }

    public void clickMustSeeOurCollections(){
        Locator menuMustSeeOurCollectionsTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Our Collections"));
        menuMustSeeOurCollectionsTextLink.click();
    }

    public void goToMustSeeOurCollections(){
        goToMustSee();
        clickMustSeeOurCollections();
    }

    public void clickMustSeeAGuideForFamilies(){
        Locator menuMustSeeAGuideForFamiliesTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("A Guide for Families"));
        menuMustSeeAGuideForFamiliesTextLink.click();
    }

    public void goToAGuideForFamilies(){
        goToMustSee();
        clickMustSeeAGuideForFamilies();
    }

    //for locators, '#' represents the id while '.' represents the className
    public void clickMustSeeFeaturedExhibition(){
        Locator menuMustSeeFeaturedExhibitionTextLink = page.locator(" #must-see-must-do-panel > .cards > div:nth-child(5)");
        menuMustSeeFeaturedExhibitionTextLink.click();
    }

    public void goToMustSeeFeaturedExhibition(){
        goToMustSee();
        clickMustSeeFeaturedExhibition();
    }

    public void clickOurCollections(){
        Locator menuOurCollectionsTextLink = page.getByLabel("Main navigation").locator("a").filter(new Locator.FilterOptions().setHasText("Our Collections"));
        menuOurCollectionsTextLink.click();
    }

    public void goToOurCollections(){
        clickMenuIcon();
        clickOurCollections();
    }

    public void clickOurArchitecture(){
        Locator menuOurArchitectureTextLink = page.getByLabel("Main navigation").locator("li").filter(new Locator.FilterOptions().setHasText("Our Architecture & History"));
        menuOurArchitectureTextLink.click();
    }

    public void goToOurArchitecture(){
        clickMenuIcon();
        clickOurArchitecture();
    }

    public void clickLearnAboutArt(){
        Locator menuLearnAboutArtTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Learn About Art"));
        menuLearnAboutArtTextLink.click();
    }

    public void goToLearnAboutArt(){
        clickMenuIcon();
        clickLearnAboutArt();
    }

    public void clickArtworkOfTheDay(){
        Locator menuArtworkOfTheDayImage = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Artwork of the day"));
        menuArtworkOfTheDayImage.click();
    }

    public void goToArtworkOfTheDay(){
        goToLearnAboutArt();
        clickArtworkOfTheDay();
    }

    public void clickIntroToArt(){
        Locator menuIntroToArtTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Intro to Art"));
        menuIntroToArtTextLink.click();
    }

    public void goToIntroToArt(){
        goToLearnAboutArt();
        clickIntroToArt();
    }
    public void clickArtAtHome(){
        Locator menuArtAtHomeTextLink = page.getByLabel("Learn About Art Panel").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Art at Home for Families"));
        menuArtAtHomeTextLink.click();
    }
    public void goToArtAtHome(){
        goToLearnAboutArt();
        clickArtAtHome();
    }
    public void clickAudioTours(){
        Locator menuAudioToursTextLink = page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Audio Tours")).nth(1);
        menuAudioToursTextLink.click();
    }
    public void goToAudioTours(){
        goToLearnAboutArt();
        clickAudioTours();
    }
    public void clickArtConservation(){
        Locator menuArtConservationTextLink = page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Art Conservation")).nth(1);
        menuArtConservationTextLink.click();
    }
    public void goToArtConservation(){
        goToLearnAboutArt();
        clickArtConservation();
    }
    public void clickPublications(){
        Locator menuPublicationsTextLink = page.getByLabel("Learn About Art Panel").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Publications"));
        menuPublicationsTextLink.click();
    }
    public void goToPublications(){
        goToLearnAboutArt();
        clickPublications();
    }
    public void clickPerspectivesMagazine(){
        Locator menuPerspectivesMagazineTextLink = page.getByLabel("Learn About Art Panel").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Perspectives Magazine"));
        menuPerspectivesMagazineTextLink.click();
    }
    public void goToPerspectivesMagazine(){
        goToLearnAboutArt();
        clickPerspectivesMagazine();
    }
    public void clickOnlineArtCourses(){
        Locator menuOnlineArtCoursesTextLink = page.getByLabel("Learn About Art Panel").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Online Art Courses"));
        menuOnlineArtCoursesTextLink.click();
    }
    public void goToOnlineArtCourses(){
        goToLearnAboutArt();
        clickOnlineArtCourses();
    }
    public void clickCuratorialResearch(){
        Locator menuCuratorialResearchTextLink = page.getByLabel("Learn About Art Panel").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Curatorial Research"));
        menuCuratorialResearchTextLink.click();
    }
    public void goToCuratorialResearch(){
        goToLearnAboutArt();
        clickCuratorialResearch();
    }
    public void clickVisit(){
        Locator menuVisitTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Visit").setExact(true));
        menuVisitTextLink.click();
    }
    public void goToVisit(){
        clickMenuIcon();
        clickVisit();
    }
    public void clickVisitWhatsOn(){
        Locator menuVisitWhatsOnTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("What’s On "));
        menuVisitWhatsOnTextLink.click();
    }
    public void goToVisitWhatsOn(){
        goToVisit();
        clickVisitWhatsOn();
    }
    public void clickVisitViewAllExhibitions(){
        Locator menuVisitViewAllExhibitionsTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("View all Exhibitions "));
        menuVisitViewAllExhibitionsTextLink.click();
    }
    public void goToVisitViewAllExhibitions(){
        goToVisit();
        clickVisitViewAllExhibitions();
    }
    public void clickVisitGuidedTours(){
        Locator menuVisitGuidedToursTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Guided Tours").setExact(true));
        menuVisitGuidedToursTextLink.click();
    }
    public void goToVisitGuidedTours(){
        goToVisit();
        clickVisitGuidedTours();
    }
    public void clickVisitSelfGuidedTours(){
        Locator menuVisitSelfGuidedToursTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Self-Guided Tours"));
        menuVisitSelfGuidedToursTextLink.click();
    }
    public void goToVisitSelfGuidedTours(){
        goToVisit();
        clickVisitSelfGuidedTours();
    }
    public void clickVisitAudioTours(){
        Locator menuVisitAudioToursTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Audio Tours").setExact(true));
        menuVisitAudioToursTextLink.click();
    }
    public void goToVisitAudioTours(){
        goToVisit();
        clickVisitAudioTours();
    }
    public void clickVisitViewAllTours(){
        Locator menuVisitViewAllToursTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("View All Tours"));
        menuVisitViewAllToursTextLink.click();
    }
    public void goToVisitViewAllTours(){
        goToVisit();
        clickVisitViewAllTours();
    }
    public void clickVisitFamilyGuide(){
        Locator menuVisitFamilyGuideTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Family Guide"));
        menuVisitFamilyGuideTextLink.click();
    }
    public void goToVisitFamilyGuide(){
        goToVisit();
        clickVisitFamilyGuide();
    }
    public void clickVisitAccessibility(){
        Locator menuVisitAccessibilityTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Accessibility at the Gallery"));
        menuVisitAccessibilityTextLink.click();
    }
    public void goToVisitAccessibility(){
        goToVisit();
        clickVisitAccessibility();
    }
    public void clickVisitGalleryGuideMap(){
        Locator menuVisitGalleryGuideMapTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Gallery Guide + Map"));
        menuVisitGalleryGuideMapTextLink.click();
    }
    public void goToVisitGalleryGuideMap(){
        goToVisit();
        clickVisitGalleryGuideMap();
    }
    public void clickVisitOpeningHours(){
        Locator menuVisitOpeningHoursTextLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Opening Hours & Getting Here"));
        menuVisitOpeningHoursTextLink.click();
    }
    public void goToVisitOpeningHours(){
        goToVisit();
        clickVisitOpeningHours();
    }
    public void clickVisitAdmissionTicketing(){
        Locator menuVisitAdmissionTicketingTextLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Admission & Ticketing"));
        menuVisitAdmissionTicketingTextLink.click();
    }
    public void goToVisitAdmissionTicketing(){
        goToVisit();
        clickVisitAdmissionTicketing();
    }
    public void clickVisitDineShop(){
        Locator menuVisitDineShopTextLink = page.getByRole(AriaRole.REGION, new Page.GetByRoleOptions().setName("Visit")).getByLabel("Dine & Shop");
        menuVisitDineShopTextLink.click();
    }
    public void goToVisitDineShop(){
        goToVisit();
        clickVisitDineShop();
    }
    public void clickVisitRotundaLibrary(){
        Locator menuVisitRotundaLibraryTextLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Rotunda Library & Archive"));
        menuVisitRotundaLibraryTextLink.click();
    }
    public void goToVisitRotundaLibrary(){
        goToVisit();
        clickVisitRotundaLibrary();
    }
    public void clickVisitKeppelCentre(){
        Locator menuVisitKeppelCentreTextLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Keppel Centre for Art"));
        menuVisitKeppelCentreTextLink.click();
    }
    public void goToVisitKeppelCentre(){
        goToVisit();
        clickVisitKeppelCentre();
    }
    public void clickVisitMoreVisitorInformation(){
        Locator menuVisitVisitInformationTextLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("More Visitor Information"));
                menuVisitVisitInformationTextLink.click();
    }
    public void goToVisitMoreVisitorInformation(){
        goToVisit();
        clickVisitMoreVisitorInformation();
    }
    public void clickVisitSchoolVisit(){
        Locator menuVisitSchoolVisitTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("School Visit "));
        menuVisitSchoolVisitTextLink.click();
    }
    public void goToVisitSchoolVisit(){
        goToVisit();
        clickVisitSchoolVisit();
    }
    public void clickVisitBecomeAMember(){
        Locator menuVisitBecomeAMemberTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Become a Member "));
        menuVisitBecomeAMemberTextLink.click();
    }
    public void goToVisitBecomeAMember(){
        goToVisit();
        clickVisitBecomeAMember();
    }
    public void clickVisitSGCulturePass(){
        Locator menuVisitSGCulturePassTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("SG Culture Pass Programmes "));
        menuVisitSGCulturePassTextLink.click();
    }
    public void goToVisitSGCulturePass(){
        goToVisit();
        clickVisitSGCulturePass();
    }
    public void clickAbout(){
        Locator menuAboutTextLink = page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("About").setExact(true));
        menuAboutTextLink.click();
    }
    public void goToAbout(){
        clickMenuIcon();
        clickAbout();
    }
    public void clickAboutOurStory(){
        Locator menuOurStoryTextLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Our Story"));
        menuOurStoryTextLink.click();
    }
    public void goToAboutOurStory(){
        goToAbout();
        clickAboutOurStory();
    }
    public void clickAboutLeadership(){
        Locator menuAboutLeadershipTextLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Leadership"));
        menuAboutLeadershipTextLink.click();
    }
    public void goToAboutLeadership(){
        goToAbout();
        clickAboutLeadership();
    }
    public void clickAboutOurAwards(){
        Locator menuAboutOurAwardsTextLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Our Awards"));
        menuAboutOurAwardsTextLink.click();
    }
    public void goToAboutOurAwards(){
        goToAbout();
        clickAboutOurAwards();
    }
    public void clickAboutMediaCentre(){
        Locator menuAboutMediaCentreTextLink = page.getByRole(AriaRole.REGION, new Page.GetByRoleOptions().setName("About Panel")).getByLabel("Media Centre");
        menuAboutMediaCentreTextLink.click();
    }
    public void goToAboutMediaCentre(){
        goToAbout();
        clickAboutMediaCentre();
    }
    public void clickAboutAnnualReports(){
        Locator menuAboutAnnualReportsTextLink = page.getByRole(AriaRole.REGION, new Page.GetByRoleOptions().setName("About Panel")).getByLabel("Annual Reports");
        menuAboutAnnualReportsTextLink.click();
    }
    public void goToAboutAnnualReports(){
        goToAbout();
        clickAboutAnnualReports();
    }
    public void clickAboutSustainability(){
        Locator menuAboutSustainabilityTextLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sustainability"));
        menuAboutSustainabilityTextLink.click();
    }
    public void goToAboutSustainability(){
        goToAbout();
        clickAboutSustainability();
    }
    public void clickAboutOurInitiatives(){
        Locator menuAboutOurInitiativesTextLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Our Initiatives &"));
        menuAboutOurInitiativesTextLink.click();
    }
    public void goToAboutOurInitiatives() {
        goToAbout();
        clickAboutOurInitiatives();
    }
    public void clickAboutCommunityGroupVisits(){
        Locator menuAboutCommunityGroupVisitsTextLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Community Group Visits"));
        menuAboutCommunityGroupVisitsTextLink.click();
    }
    public void goToAboutCommunityGroupVisits(){
        goToAbout();
        clickAboutCommunityGroupVisits();
    }
    public void clickAboutCareers() {
        Locator menuAboutCareersTextLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Careers & Internships"));
        menuAboutCareersTextLink.click();
    }
    public void goToAboutCareers(){
        goToAbout();
        clickAboutCareers();
    }
    public void clickAboutVenueRental(){
        Locator menuAboutVenueRentalTextLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Venue Rental"));
        menuAboutVenueRentalTextLink.click();
    }
    public void goToAboutVenueRental(){
        goToAbout();
        clickAboutVenueRental();
    }
    public void clickAboutPhotoshoots(){
        Locator menuAboutPhotoshootsTextLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Photoshoots & Filming"));
        menuAboutPhotoshootsTextLink.click();
    }
    public void goToAboutPhotoshoots(){
        goToAbout();
        clickAboutPhotoshoots();
    }
    public void clickAboutBusinessOpportunities(){
        Locator menuAboutBusinessOpportunitiesTextLink = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Business Opportunities"));
        menuAboutBusinessOpportunitiesTextLink.click();
    }
    public void goToAboutBusinessOpportunities(){
        goToAbout();
        clickAboutBusinessOpportunities();
    }
    public void clickAboutEnquiries(){
        Locator menuAboutEnquiriesTextLink =page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Enquiries"));
        menuAboutEnquiriesTextLink.click();
    }
    public void goToAboutEnquiries(){
        goToAbout();
        clickAboutEnquiries();
    }
    public void clickAboutWhistleblowing(){
        Locator menuAboutWhistleblowingTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Whistleblowing"));
        menuAboutWhistleblowingTextLink.click();
    }
    public void goToAboutWhistleblowing(){
        goToAbout();
        clickAboutWhistleblowing();
    }
    public void clickMenuDonateVolunteer(){
        Locator menuDonateVolunteerTextLink = page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Donate & Volunteer"));
        menuDonateVolunteerTextLink.click();
    }
    public void goToMenuDonateVolunteer(){
        clickMenuIcon();
        clickMenuDonateVolunteer();
    }
    public void clickMemberSignUpLogin(){
        Locator menuMemberSignUpLoginTextLink = page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Member Sign Up/Login"));
        menuMemberSignUpLoginTextLink.click();
    }
    public void goToMenuMemberSignUpLogin(){
        clickMenuIcon();
        clickMemberSignUpLogin();
    }
    public void clickVenueRental(){
        Locator menuVenueRentalTextLink = page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Venue Rental"));
        menuVenueRentalTextLink.click();
    }
    public void goToMenuVenueRental(){
        clickMenuIcon();
        clickVenueRental();
    }
    public void clickMenuIAm(){
        Locator menuIAmDropdown = page.getByText("I am a...Donor, Patron or");
        menuIAmDropdown.click();
    }
    public void clickDonorPatronVolunteer(){
        Locator menuDonorPatronVolunteerOption = page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Donor, Patron or Volunteer"));
        menuDonorPatronVolunteerOption.click();
    }
    public void goToMenuDonorPatronVolunteer(){
        clickMenuIcon();
        clickMenuIAm();
        clickDonorPatronVolunteer();
    }
    public void clickVendorBusinessPartner(){
        Locator menuVendorBusinessPartnerOption = page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Vendor/Business Partner"));
        menuVendorBusinessPartnerOption.click();
    }
    public void goToMenuVendorBusinessPartner(){
        clickMenuIcon();
        clickMenuIAm();
        clickVendorBusinessPartner();
    }
    public void clickMediaProfessional(){
        Locator menuMediaProfessionalOption = page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Media Professional"));
        menuMediaProfessionalOption.click();
    }
    public void goToMenuMediaProfessional(){
        clickMenuIcon();
        clickMenuIAm();
        clickMediaProfessional();
    }
    public void clickEventOrganiser(){
        Locator menuEventOrganiserOption = page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Venue Hirer/Event Organiser"));
        menuEventOrganiserOption.click();
    }
    public void goToMenuEventOrganiser(){
        clickMenuIcon();
        clickMenuIAm();
        clickEventOrganiser();
    }
    public void clickMainNavigationXButton(){
        Locator menuMainNavigationXButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Menu"));
        menuMainNavigationXButton.click();
    }
    public void goToCloseMainNavigation(){
        clickMainNavigationXButton();
    }
}

