package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.TimeoutError;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;


public class CartPage{
    Page page;

    //page constructor allows this class to use the Page object for browser interactions.
    public CartPage(Page page){
        this.page = page;
        initLocators();
    }
    private void initLocators(){
    }

    //Object repository
}