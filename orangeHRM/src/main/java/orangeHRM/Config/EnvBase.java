package orangeHRM.Config;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

/**
 * Base test environment class for Playwright browser automation.
 * <p>
 * This class sets up and tears down the Playwright engine and the selected browser
 * before and after the execution of all JUnit tests that extend it.
 * <p>
 * It inherits configuration values (such as browser type, headless mode,
 * download directory, environment variables, and tracing options)
 * from {@link BrowserConfigurations}.
 * 
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0.0
 */
public class EnvBase extends BrowserConfigurations {

    /** Playwright engine instance for controlling browsers. */
    public Playwright playwright;

    /** Active browser instance launched by Playwright. */
    public Browser browser;

    /** Launch options that configure how the browser starts. */
    private BrowserType.LaunchOptions options;

    /**
     * Initializes and launches the chosen browser engine before any test is executed.
     * <p>
     * Reads configuration values from {@link BrowserConfigurations}, builds the
     * {@link BrowserType.LaunchOptions}, and launches the specified browser
     * channel or engine. Supported browsers include Chromium, Chrome variants,
     * Edge variants, Firefox, WebKit (Safari-like), or a custom executable.
     *
     * @throws IllegalArgumentException if the provided {@code browserEngine} is invalid.
     */
    @BeforeAll
    public void StartTestEngine() {
        // Create the Playwright engine.
        playwright = Playwright.create();

        // Configure launch options using inherited settings.
        options = new BrowserType.LaunchOptions()
                .setArgs(args)
                .setDownloadsPath(downloadDir)
                .setEnv(env)
                .setHandleSIGHUP(handleSIGHUP)
                .setHandleSIGINT(handleSIGINT)
                .setHandleSIGTERM(handleSIGTERM)
                .setHeadless(activateHeadless)
                .setIgnoreAllDefaultArgs(ignoreAllDefaultArgs)
                .setProxy(proxy)
                .setSlowMo(slowMotionTime)
                .setTimeout(timeout)
                .setTracesDir(tracerDir);

        // Launch the appropriate browser based on the configured engine name.
        switch (browserEngine) {
            case "chromium" -> {
                options.setChromiumSandbox(activateChromiumSandbox);
                browser = playwright.chromium().launch(options);
            }
            case "chrome", "chrome-beta", "chrome-dev", "chrome-canary",
                 "msedge", "msedge-beta", "msedge-dev", "msedge-canary" -> {
                // Chrome and Edge variants are launched through the Chromium engine.
                options.setChannel(browserEngine);
                browser = playwright.chromium().launch(options);
            }
            case "firefox" -> {
                // Applies custom Firefox user preferences if configured.
                options.setFirefoxUserPrefs(firefoxUserPrefs);
                browser = playwright.firefox().launch(options);
            }
            case "webkit" -> {
                // WebKit engine simulates Safari-like behavior.
                browser = playwright.webkit().launch(options);
            }
            case "custom" -> {
                // Launches a custom browser executable from a given path.
                options.setExecutablePath(browserDir);
                browser = playwright.webkit().launch(options);
            }
            default -> throw new IllegalArgumentException(
                    "Browser engine not found: " + browserEngine
            );
        }
    }

    /**
     * Closes the browser and Playwright engine after all tests have finished.
     * <p>
     * Ensures that system resources are released properly.
     */
    @AfterAll
    public void shutdownTestEngine() {
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}
