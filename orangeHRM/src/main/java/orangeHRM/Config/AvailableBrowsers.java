package orangeHRM.Config;

/**
 * Enumeration of all supported browser engines and channels for Playwright tests.
 * <p>
 * Each enum constant represents a specific browser or browser channel,
 * with a string value that matches the Playwright API for launching
 * that particular engine.
 * @author Lucas Alexandre Bez Pianoski
 * @since 1.0.0
 */
public enum AvailableBrowsers {

    /** Standard Chromium build provided by Playwright. */
    CHROMIUM("chromium"),

    /** Stable Google Chrome channel. */
    CHROME("chrome"),
    /** Beta channel of Google Chrome. */
    CHROME_BETA("chrome-beta"),
    /** Developer channel of Google Chrome. */
    CHROME_DEV("chrome-dev"),
    /** Canary channel of Google Chrome, updated nightly. */
    CHROME_CANARY("chrome-canary"),

    /** Stable Microsoft Edge channel. */
    EDGE("msedge"),
    /** Beta channel of Microsoft Edge. */
    EDGE_BETA("msedge-beta"),
    /** Developer channel of Microsoft Edge. */
    EDGE_DEV("msedge-dev"),
    /** Canary channel of Microsoft Edge, updated nightly. */
    EDGE_CANARY("msedge-canary"),

    /** Mozilla Firefox browser. */
    FIREFOX("firefox"),
    /** WebKit engine (Safari-like) used by Playwright. */
    SAFARI("webkit"),

    /** A placeholder for a custom or externally managed browser. */
    OTHER("custom");

    /**
     * The string identifier required by Playwright's {@code launch} method
     * to start the corresponding browser engine.
     */
    public String browser;

    /**
     * Constructor that assigns the Playwright engine name to each enum constant.
     *
     * @param engine the exact string used by Playwright to identify the browser.
     */
    AvailableBrowsers(String engine) {
        this.browser = engine;
    }

    /**
     * Returns the Playwright-compatible string name of the browser engine.
     *
     * @return browser engine name as a string.
     */
    public String getBrowser() {
        return browser;
    }
}
