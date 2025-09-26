package orangeHRM.PageObjects;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

/**
 * Page Object representing the Login page of OrangeHRM.
 * Encapsulates selectors and user interactions for the login workflow.
 */
public class LoginPage {

    private final Page page;

    // Element locators
    private final Locator usernameInput;
    private final Locator passwordInput;
    private final Locator loginButton;

    /**
     * Constructor takes a Playwright Page object (already created in the test).
     * @param page Playwright Page instance from your test
     */
    public LoginPage(Page page) {
        this.page = page;
        // Initialize common locators
        usernameInput = page.locator("#username"); 
        passwordInput = page.locator("#password");
        loginButton = page.locator("button[type=submit]");
    }

    /**
     * Fills username and password and clicks login.
     */
    public void login(String user, String pass) {
        usernameInput.fill(user);
        passwordInput.fill(pass);
        loginButton.click();
    }

}
