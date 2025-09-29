package orangeHRM.Config;

import java.nio.file.Path;
import java.util.Properties;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

/**
 * Base test environment class for Playwright browser automation.
 * <p>
 * This class initializes and tears down the Playwright engine and the selected browser
 * before and after all JUnit tests that extend it.
 * <p>
 * It reads configuration values such as browser type, headless mode, download directory,
 * environment variables, and tracing options from {@link BrowserConfigurations}.
 * 
 * <p>
 * Supported browsers: Chromium, Chrome variants, Edge variants, Firefox, WebKit (Safari-like), or a custom executable.
 * </p>
 * 
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0.0
 */
public class EnvConfiguration {

	/** ArgsargsManager object containing arguments for browser configurations. */
    ArgsManager argsManager = new ArgsManager();

    /** Properties object containing environment and browser configurations. */
    protected final Properties prop = new Properties();

    /** Playwright engine instance for controlling browsers. */
    public Playwright playwright;

    /** Active browser instance launched by Playwright. */
    public Browser browser;

    /** Launch options that configure how the browser starts. */
    private BrowserType.LaunchOptions options;

    /**
     * Initializes and launches the configured browser engine before any test runs.
     * <p>
     * Reads configuration values from {@link BrowserConfigurations}, builds {@link BrowserType.LaunchOptions},
     * and launches the specified browser channel or engine.
     *
     * @throws IllegalArgumentException if the configured browser engine is invalid.
     */
    @BeforeAll
    public void startTestEngine() {

        playwright = Playwright.create();

        options = new BrowserType.LaunchOptions()
                .setDownloadsPath(Path.of(prop.getProperty("pw.path.download")))
                //.setEnv(argsManager.QLAB01EnvArgs())
                .setHandleSIGHUP(Boolean.getBoolean(prop.getProperty("pw.handleSIGHUP", "false")))
                .setHandleSIGINT(Boolean.getBoolean(prop.getProperty("pw.handleSIGINT", "true")))
                .setHandleSIGTERM(Boolean.getBoolean(prop.getProperty("pw.handleSIGTERM", "true")))
                .setHeadless(Boolean.getBoolean(prop.getProperty("pw.activateHeadless", "false")))
                .setIgnoreAllDefaultArgs(Boolean.getBoolean(prop.getProperty("pw.ignoreAllDefaultArgs", "false")))
                //.setIgnoreDefaultArgs(argsManager.ignoredDefArgs())
                .setSlowMo(Integer.parseInt(prop.getProperty("pw.slowMotionTime")))
                .setTimeout(Integer.parseInt(prop.getProperty("pw.timeout")))
                .setTracesDir(Path.of(prop.getProperty("pw.path.tracer")));

        String browserEngine = prop.getProperty("pw.path.tracer");

        switch (browserEngine) {
            case "chromium" -> {
                options.setArgs(argsManager.getArgsForBrowser(prop.getProperty("pw.browser.name")));
                options.setChromiumSandbox(Boolean.getBoolean(prop.getProperty("pw.activateChromiumSandbox", "false")));
                browser = playwright.chromium().launch(options);
            }
            case "chrome", "chrome-beta", "chrome-dev", "chrome-canary",
                 "msedge", "msedge-beta", "msedge-dev", "msedge-canary" -> {
                options.setArgs(argsManager.getArgsForBrowser(prop.getProperty("pw.browser.name")));
                options.setChannel(browserEngine);
                browser = playwright.chromium().launch(options);
            }
            case "firefox" -> {
                options.setArgs(argsManager.getArgsForBrowser(prop.getProperty("pw.browser.name")));
                options.setFirefoxUserPrefs(argsManager.FirefoxUserPrefs());
                browser = playwright.firefox().launch(options);
            }
            case "webkit" -> {
                options.setArgs(argsManager.getArgsForBrowser(prop.getProperty("pw.browser.name")));
                browser = playwright.webkit().launch(options);
            }
            case "custom" -> {
                options.setArgs(argsManager.getArgsForBrowser(prop.getProperty("pw.browser.name")));
                options.setExecutablePath(Path.of(prop.getProperty("pw.path.customBrowser")));
                browser = playwright.webkit().launch(options);
            }
            default -> throw new IllegalArgumentException(
                    "Browser engine not found: " + browserEngine
            );
        }
    }

    /**
     * Closes the browser and the Playwright engine after all tests are finished.
     * <p>
     * Ensures proper resource cleanup.
     */
    @AfterAll
    public void shutdownTestEngine() {
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
        System.out.println("Test case execution completed....");
    }

}
