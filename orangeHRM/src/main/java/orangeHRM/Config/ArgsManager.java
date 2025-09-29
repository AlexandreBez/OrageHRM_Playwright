package orangeHRM.Config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.microsoft.playwright.options.ClientCertificate;

/**
 * ArgsManager class for managing browser-specific launch arguments and Firefox user preferences.
 * <p>
 * Provides centralized configuration for different browser engines, including:
 * Chromium, Chrome (and variants), Edge (and variants), Firefox, WebKit, and custom browsers.
 * <p>
 * This class allows test environments to retrieve command-line arguments and
 * Firefox preferences in a structured way, making it easier to maintain
 * performance optimizations, UI settings, security options, proxy settings,
 * and developer tools configurations.
 * 
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0.0
 */
public class ArgsManager {

    /** Chromium args
     * Returns launch arguments for Chromium browser.
     * <p>
     * Includes general performance optimizations, headless/UI settings, and optional debugging flags.
     *
     * @return List of command-line arguments for Chromium
     */
    protected final ArrayList<String> ChromiumArgs() {
        ArrayList<String> args = new ArrayList<>();
        args.add("--disable-extensions");
        args.add("--disable-popup-blocking");
        args.add("--start-maximized");
        // Optional flags commented out can be enabled if needed
        //args.add("--disable-infobars");
        //args.add("--disable-background-timer-throttling");
        //args.add("--disable-backgrounding-occluded-windows");
        //args.add("--no-sandbox");
        //args.add("--disable-setuid-sandbox");
        //args.add("--disable-gpu");
        //args.add("--disable-software-rasterizer");
        //args.add("--remote-debugging-port=9222");
        return args;
    }

    /** Chrome stable args
     * Returns launch arguments for Chrome browser.
     * <p>
     * Includes general performance optimizations, headless/UI settings, and optional debugging flags.
     *
     * @return List of command-line arguments for Chrome
     */
    protected final ArrayList<String> ChromeArgs() { 
        ArrayList<String> args = new ArrayList<>();
        args.add("--disable-extensions");
        args.add("--disable-popup-blocking");
        args.add("--start-maximized");
        // Optional flags commented out can be enabled if needed
        //args.add("--disable-infobars");
        //args.add("--disable-background-timer-throttling");
        //args.add("--disable-backgrounding-occluded-windows");
        //args.add("--no-sandbox");
        //args.add("--disable-setuid-sandbox");
        //args.add("--disable-gpu");
        //args.add("--disable-software-rasterizer");
        //args.add("--remote-debugging-port=9222");
        return args;
    }

    /** Chrome Beta args 
     * Returns launch arguments for Chrome Beta browser.
     * <p>
     * Includes general performance optimizations, headless/UI settings, and optional debugging flags.
     *
     * @return List of command-line arguments for Chrome Beta
     */
    protected final ArrayList<String> ChromeBetaArgs() { 
        ArrayList<String> args = new ArrayList<>();
        args.add("--disable-extensions");
        args.add("--disable-popup-blocking");
        args.add("--start-maximized");
        // Optional flags commented out can be enabled if needed
        //args.add("--disable-infobars");
        //args.add("--disable-background-timer-throttling");
        //args.add("--disable-backgrounding-occluded-windows");
        //args.add("--no-sandbox");
        //args.add("--disable-setuid-sandbox");
        //args.add("--disable-gpu");
        //args.add("--disable-software-rasterizer");
        //args.add("--remote-debugging-port=9222");
        return args;
    }

    /** Chrome Dev args
     * Returns launch arguments for Chrome Dev browser.
     * <p>
     * Includes general performance optimizations, headless/UI settings, and optional debugging flags.
     *
     * @return List of command-line arguments for Chrome Dev
     */
    protected final ArrayList<String> ChromeDevArgs() { 
        ArrayList<String> args = new ArrayList<>();
        args.add("--disable-extensions");
        args.add("--disable-popup-blocking");
        args.add("--start-maximized");
        // Optional flags commented out can be enabled if needed
        //args.add("--disable-infobars");
        //args.add("--disable-background-timer-throttling");
        //args.add("--disable-backgrounding-occluded-windows");
        //args.add("--no-sandbox");
        //args.add("--disable-setuid-sandbox");
        //args.add("--disable-gpu");
        //args.add("--disable-software-rasterizer");
        //args.add("--remote-debugging-port=9222");
        return args;
    }

    /** Chrome Canary args
     * Returns launch arguments for Chrome Canary browser.
     * <p>
     * Includes general performance optimizations, headless/UI settings, and optional debugging flags.
     *
     * @return List of command-line arguments for Chrome Canary
     */
    protected final ArrayList<String> ChromeCanaryArgs() { 
        ArrayList<String> args = new ArrayList<>();
        args.add("--disable-extensions");
        args.add("--disable-popup-blocking");
        args.add("--start-maximized");
        // Optional flags commented out can be enabled if needed
        //args.add("--disable-infobars");
        //args.add("--disable-background-timer-throttling");
        //args.add("--disable-backgrounding-occluded-windows");
        //args.add("--no-sandbox");
        //args.add("--disable-setuid-sandbox");
        //args.add("--disable-gpu");
        //args.add("--disable-software-rasterizer");
        //args.add("--remote-debugging-port=9222");
        return args;
    }

    /** Edge stable args 
     * Returns launch arguments for Edge browser.
     * <p>
     * Includes general performance optimizations, headless/UI settings, and optional debugging flags.
     *
     * @return List of command-line arguments for Edge
     */
    protected final ArrayList<String> MsEdgeArgs() { 
        ArrayList<String> args = new ArrayList<>();
        args.add("--disable-extensions");
        args.add("--disable-popup-blocking");
        args.add("--start-maximized");
        // Optional flags commented out can be enabled if needed
        //args.add("--disable-infobars");
        //args.add("--disable-background-timer-throttling");
        //args.add("--disable-backgrounding-occluded-windows");
        //args.add("--no-sandbox");
        //args.add("--disable-setuid-sandbox");
        //args.add("--disable-gpu");
        //args.add("--disable-software-rasterizer");
        //args.add("--remote-debugging-port=9222");
        return args;
    }

    /** Edge Beta args
    * Returns launch arguments for Edge Beta browser.
    * <p>
    * Includes general performance optimizations, headless/UI settings, and optional debugging flags.
    *
    * @return List of command-line arguments for Edge Beta
    */
    protected final ArrayList<String> MsEdgeBetaArgs() { 
        ArrayList<String> args = new ArrayList<>();
        args.add("--disable-extensions");
        args.add("--disable-popup-blocking");
        args.add("--start-maximized");
        // Optional flags commented out can be enabled if needed
        //args.add("--disable-infobars");
        //args.add("--disable-background-timer-throttling");
        //args.add("--disable-backgrounding-occluded-windows");
        //args.add("--no-sandbox");
        //args.add("--disable-setuid-sandbox");
        //args.add("--disable-gpu");
        //args.add("--disable-software-rasterizer");
        //args.add("--remote-debugging-port=9222");
        return args;
    }

    /** Edge Dev args
    * Returns launch arguments for Edge Dev browser.
    * <p>
    * Includes general performance optimizations, headless/UI settings, and optional debugging flags.
    *
    * @return List of command-line arguments for Dev Beta
    */
    protected final ArrayList<String> MsEdgeDevArgs() { 
        ArrayList<String> args = new ArrayList<>();
        args.add("--disable-extensions");
        args.add("--disable-popup-blocking");
        args.add("--start-maximized");
        // Optional flags commented out can be enabled if needed
        //args.add("--disable-infobars");
        //args.add("--disable-background-timer-throttling");
        //args.add("--disable-backgrounding-occluded-windows");
        //args.add("--no-sandbox");
        //args.add("--disable-setuid-sandbox");
        //args.add("--disable-gpu");
        //args.add("--disable-software-rasterizer");
        //args.add("--remote-debugging-port=9222");
        return args;
    }

    /** Edge Canary args 
    * Returns launch arguments for Edge Canary browser.
    * <p>
    * Includes general performance optimizations, headless/UI settings, and optional debugging flags.
    *
    * @return List of command-line arguments for Canary Beta
    */
    protected final ArrayList<String> MsEdgeCanaryArgs() { 
        ArrayList<String> args = new ArrayList<>();
        args.add("--disable-extensions");
        args.add("--disable-popup-blocking");
        args.add("--start-maximized");
        // Optional flags commented out can be enabled if needed
        //args.add("--disable-infobars");
        //args.add("--disable-background-timer-throttling");
        //args.add("--disable-backgrounding-occluded-windows");
        //args.add("--no-sandbox");
        //args.add("--disable-setuid-sandbox");
        //args.add("--disable-gpu");
        //args.add("--disable-software-rasterizer");
        //args.add("--remote-debugging-port=9222");
        return args;
    }

    /** Firefox args (empty by default, command-line args usually not required)
    * Returns launch arguments for Firefox browser.
    * <p>
    * Includes general performance optimizations, headless/UI settings, and optional debugging flags.
    *
    * @return List of command-line arguments for Firefox
    */
    protected final ArrayList<String> FirefoxArgs() { return null; }

    /** WebKit (Safari-like) browser args 
    * Returns launch arguments for Safari-like browser.
    * <p>
    * Includes general performance optimizations, headless/UI settings, and optional debugging flags.
    *
    * @return List of command-line arguments for WebKit (Safari-like) 
    */
    protected final ArrayList<String> WebkitArgs() {
        ArrayList<String> args = new ArrayList<>();
        args.add("--no-sandbox");
        args.add("--disable-gpu");
        return args;
    }

    /** Custom browser args (can be extended for specific use cases) */
    protected final ArrayList<String> CustomBrowserArgs() {
        return new ArrayList<>();
    }
    
    /**
     * Retrieves arguments for a given browser.
     *
     * @param browser The browser name (e.g., "chrome", "firefox", "msedge")
     * @return List of arguments for the requested browser, empty if unknown
     */
    public ArrayList<String> getArgsForBrowser(String browser) {
        return switch (browser.toLowerCase()) {
            case "chromium" -> ChromiumArgs();
            case "chrome" -> ChromeArgs();
            case "chrome-beta" -> ChromeBetaArgs();
            case "chrome-dev" -> ChromeDevArgs();
            case "chrome-canary" -> ChromeCanaryArgs();
            case "msedge" -> MsEdgeArgs();
            case "msedge-beta" -> MsEdgeBetaArgs();
            case "msedge-dev" -> MsEdgeDevArgs();
            case "msedge-canary" -> MsEdgeCanaryArgs();
            case "firefox" -> FirefoxArgs();
            case "webkit" -> WebkitArgs();
            case "custom" -> CustomBrowserArgs();
            default -> new ArrayList<>();
        };
    }


    // --- Firefox user preferences ---

    /**
     * Returns a map of Firefox user preferences.
     * <p>
     * Configurable settings include homepage, downloads, notifications, media autoplay,
     * UI appearance, proxy configuration, and developer tools options.
     *
     * @return Map where keys are preference names and values are corresponding settings
     */
    public Map<String, Object> FirefoxUserPrefs() {
        Map<String, Object> prefs = new HashMap<>();

        // Homepage & initialization
        prefs.put("browser.startup.homepage", "https://opensource-demo.orangehrmlive.com");
        prefs.put("browser.startup.page", 0);

        // Downloads
        prefs.put("browser.download.folderList", 2);
        prefs.put("browser.download.dir", "C:/path/para/downloads");
        prefs.put("browser.download.useDownloadDir", true);
        prefs.put("browser.helperApps.neverAsk.saveToDisk", "application/pdf,application/octet-stream");

        // Performance / media / notifications
        prefs.put("dom.webnotifications.enabled", false);
        prefs.put("media.autoplay.default", 0);
        prefs.put("media.navigator.permission.disabled", true);
        prefs.put("permissions.default.image", 2);

        // UI / visual
        prefs.put("privacy.donottrackheader.enabled", true);
        prefs.put("signon.rememberSignons", false);
        prefs.put("layout.css.devPixelsPerPx", 1.0);
        prefs.put("ui.systemUsesDarkTheme", 0);

        // Proxy
        prefs.put("network.proxy.type", 1);
        prefs.put("network.proxy.http", "proxy.example.com");
        prefs.put("network.proxy.http_port", 8080);
        prefs.put("network.proxy.ssl", "proxy.example.com");
        prefs.put("network.proxy.ssl_port", 8080);
        prefs.put("network.proxy.no_proxies_on", "localhost,127.0.0.1");

        // Developer tools
        prefs.put("devtools.chrome.enabled", true);
        prefs.put("devtools.debugger.remote-enabled", false);
        prefs.put("devtools.console.stdout.content", true);

        return prefs;
    }
    
    protected final List<ClientCertificate> clientCertificates() { return new ArrayList<>(); }
    
    protected final Map<String, String> extraHTTPHeaders() { return new HashMap<>(); }
    
    protected final List<String> permissions() { return new ArrayList<>(); } 
    
    
    
    
    
    /** Placeholder for ignored default arguments (can be overridden) */
    protected final ArrayList<String> ignoredDefArgs() { return new ArrayList<>(); }
    
    /** Placeholder for production environment variables (can be extended) */
    protected final Map<String, String> PRODEnvArgs() { return new HashMap<>(); }

    /** Placeholder for QLAB01 environment variables (can be extended) */
    protected final Map<String, String> QLAB01EnvArgs() { return new HashMap<>(); }
    
    
}
