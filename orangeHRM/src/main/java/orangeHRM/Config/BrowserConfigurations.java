package orangeHRM.Config;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.microsoft.playwright.options.Proxy;

/**
 * Central configuration class for Playwright browser tests.
 * <p>
 * This class defines default settings and utility methods that can be
 * extended or overridden by test classes. It provides configuration for
 * download directories, browser-specific arguments, environment variables,
 * proxy settings, and other runtime options.
 * 
 * @author Lucas Alexandre Bez Piancoski
 * @since 1.0.0
 */
public class BrowserConfigurations {

    /** 
     * List of additional command-line arguments to launch Chrome-based browsers.
     * Default is an empty list but can be overridden to include custom flags.
     */
    protected final List<String> args = ChromeArgs();

    /**
     * Absolute path (as a string) to the default downloads directory
     * where Playwright will store downloaded files.
     */
    protected final String downloadsPath =
        "C:/Users/Lucas/OneDrive/Área de Trabalho/Selenium/orangeHRM/src/main/resources/Downloads";

    /**
     * {@link Path} object representing the downloads directory.
     * If {@code downloadsPath} is blank, this will be {@code null}.
     */
    protected final Path downloadDir = (downloadsPath != null && !downloadsPath.isBlank()) ? Path.of(downloadsPath) : null;

    /**
     * Map of environment variables to be passed to the browser process
     * at launch. Defaults to an empty map.
     */
    protected final Map<String, String> env = new HashMap<>();

    /**
     * Absolute path (as a string) to a custom browser executable.
     * Leave empty to use the default bundled browser.
     */
    protected final String browserPath = "";

    /**
     * {@link Path} to the custom browser executable if specified.
     * {@code null} when {@code browserPath} is blank.
     */
    protected final Path browserDir = (browserPath != null && !browserPath.isBlank()) ? Path.of(browserPath) : null;

    /**
     * Firefox-specific user preferences.
     * Can be populated with key–value pairs to tweak Firefox behavior.
     */
    protected final Map<String, Object> firefoxUserPrefs = new HashMap<>();

    /**
     * Whether the browser process should handle a SIGHUP signal.
     * Useful when running in Unix-like environments. Defaults to false.
     */
    protected final boolean handleSIGHUP = false;

    /**
     * Whether the browser process should handle a SIGINT signal
     * (triggered for example by Ctrl+C). Defaults to true.
     */
    protected final boolean handleSIGINT = true;

    /**
     * Whether the browser process should handle a SIGTERM signal.
     * Defaults to true.
     */
    protected final boolean handleSIGTERM = true;

    /**
     * When true, runs the browser in headless mode (no visible UI).
     * Default is false to allow debugging with a visible browser window.
     */
    protected final boolean activateHeadless = true;

    /**
     * When true, ignores all of Playwright's default launch arguments
     * and uses only the custom ones supplied in {@link #args}.
     */
    protected final boolean ignoreAllDefaultArgs = false;

    /**
     * Proxy configuration for routing browser traffic.
     * Created by {@link #configProxy()} and may be {@code null} if
     * no proxy server is defined.
     */
    protected final Proxy proxy = configProxy();

    /**
     * Delay in milliseconds to slow down Playwright actions
     * for easier debugging. Default is 500 ms.
     */
    protected final double slowMotionTime = 500;

    /**
     * Default timeout (in milliseconds) applied to operations such as
     * page navigation or element waiting. Default is 1500 ms.
     */
    protected final double timeout = 1500;

    /**
     * Absolute path (as a string) to the directory where Playwright
     * will store trace files for debugging and analysis.
     */
    protected final String tracerPath = "C:/Users/Lucas/OneDrive/Área de Trabalho/Selenium/orangeHRM/src/main/resources/Tracer";

    /**
     * {@link Path} object for the tracer directory, or {@code null}
     * if {@code tracerPath} is blank.
     */
    protected final Path tracerDir = (tracerPath != null && !tracerPath.isBlank()) ? Path.of(tracerPath) : null;

    /**
     * Name of the browser engine to launch.
     * Typically one of the values defined in {@link AvailableBrowsers}.
     * Default is the Chrome engine.
     */
    protected final String browserEngine = AvailableBrowsers.CHROME.getBrowser();

    /**
     * Whether to enable or disable the Chromium sandbox security feature.
     * Defaults to false.
     */
    protected final boolean activateChromiumSandbox = false;

    /**
     * Creates and returns a configured {@link Proxy} instance if a proxy
     * server address is provided via an environment variable.
     * <p>
     * Returns {@code null} when no proxy server is set, meaning no proxy
     * will be used during browser execution.
     *
     * @return a configured Proxy instance or {@code null} if no server is defined.
     */
    protected final Proxy configProxy() {
        String setServer = System.getenv("");
        if (setServer == null || setServer.isBlank()) {
            return null;
        }
        return new Proxy(setServer)
                .setBypass("")
                .setUsername("")
                .setPassword("");
    }

    /**
     * Returns a list of additional command-line arguments for launching Chrome.
     * Override this method to add custom flags.
     *
     * @return list of Chrome launch arguments
     */
    protected final ArrayList<String> ChromeArgs() {
        return new ArrayList<>();
    }

    /**
     * Returns additional launch arguments specific to Chromium.
     *
     * @return list of Chromium launch arguments
     */
    protected final ArrayList<String> ChromiumArgs() {
        return new ArrayList<>();
    }

    /**
     * Returns additional launch arguments specific to Microsoft Edge.
     *
     * @return list of Edge launch arguments
     */
    protected final ArrayList<String> EdgeArgs() {
        return new ArrayList<>();
    }

    /**
     * Returns additional launch arguments specific to Firefox.
     *
     * @return list of Firefox launch arguments
     */
    protected final ArrayList<String> FirefoxArgs() {
        return new ArrayList<>();
    }

    /**
     * Returns additional launch arguments specific to WebKit browsers (Safari).
     *
     * @return list of WebKit launch arguments
     */
    protected final ArrayList<String> WebkitArgs() {
        return new ArrayList<>();
    }

    /**
     * Returns additional launch arguments for a custom browser engine.
     *
     * @return list of custom browser launch arguments
     */
    protected final ArrayList<String> CustomBrowserArgs() {
        return new ArrayList<>();
    }
}
