package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage {
    //declare variable of Page from Playwright 'Page'
    Page page;

    //constructor of Page
    public HomePage(Page page) {
        this.page = page;
    }

    public void clickPlanAVisit(){
        Locator planAVisitButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Plan a visit"));
        planAVisitButton.click();
    }
}
