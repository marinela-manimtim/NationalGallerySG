//This is the Object Repository of Navigation
package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class NavigationPage {
    //declare variable for Playwright Page
    Page page;

    //page constructor
    public NavigationPage (Page page){
        this.page = page;
    }
    //<----------------------------------------------------------------------------------->
    //page GET methods. This is not the assertion yet.
   /* public String getHomepageUrl(){
        return page.url();
    }*/

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
        Locator menuArtAtHomeTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Art at Home for Families"));
        menuArtAtHomeTextLink.click();
    }
    public void goToArtAtHome(){
        goToLearnAboutArt();
        clickArtAtHome();
    }
    public void clickAudioTours(){
        Locator menuAudioToursTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Audio Tours"));
        menuAudioToursTextLink.click();
    }
    public void goToAudioTours(){
        goToLearnAboutArt();
        clickAudioTours();
    }
    public void clickArtConservation(){
        Locator menuArtConservationTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Art Conservation"));
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
        Locator menuVisitTextLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Visit"));
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
}

