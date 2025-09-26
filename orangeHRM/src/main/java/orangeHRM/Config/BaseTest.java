package orangeHRM.Config;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

public class BaseTest extends EnvBase{

    protected String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    protected BrowserContext context;
    protected Page page;

    @BeforeEach
    void setup() {
        context = browser.newContext();
        page = context.newPage();
        page.navigate(baseUrl);
    }

    @AfterEach
    void cleanup() {
        if (context != null) context.close();
    }
}
