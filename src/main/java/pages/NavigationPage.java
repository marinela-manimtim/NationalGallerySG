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


}

