package orangeHRM.Config;

import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.ColorScheme;
import com.microsoft.playwright.options.Contrast;
import com.microsoft.playwright.options.ForcedColors;
//import com.microsoft.playwright.options.HarContentPolicy;
//import com.microsoft.playwright.options.HarMode;
//import com.microsoft.playwright.options.HttpCredentials;
import com.microsoft.playwright.options.Proxy;

import orangeHRM.ClickUpHelper.ClickUpTask;
//import com.microsoft.playwright.options.ReducedMotion;
//import com.microsoft.playwright.options.ServiceWorkerPolicy;

public class OrangeBaseTest extends EnvConfiguration {
	
    protected BrowserContext context;
    
    protected Page page;
    
    /** Properties object containing environment and browser configurations. */
    protected final Properties prop = new Properties();
    
    /**
     * Builds a Proxy object based on configuration properties.
     *
     * @return {@link Proxy} instance if a proxy server is configured, or {@code null} if no proxy is used.
     */
    protected final Proxy proxyConfig() {
        return new Proxy(prop.getProperty("orangeHRM.proxy.server"))
                    .setUsername(prop.getProperty("orangeHRM.proxy.username"))
                    .setPassword(prop.getProperty("orangeHRM.proxy.password"))
                    .setBypass(prop.getProperty("orangeHRM.proxy.bypass"));
    }

    @BeforeEach
    protected void setup(TestInfo testInfo) {
    	
    	Browser.NewContextOptions opts = new Browser.NewContextOptions()
        		.setAcceptDownloads(Boolean.getBoolean(prop.getProperty("orangeHRM.acceptDownloads", "true")))
        		//.setBypassCSP(Boolean.getBoolean(prop.getProperty("orangeHRM.bypassCSP", "false")))
    	        //.setClientCertificates(argsManager.clientCertificates())
    	        .setColorScheme(ColorScheme.DARK)
    	        .setContrast(Contrast.NO_PREFERENCE)
    	        //.setDeviceScaleFactor(Double.parseDouble(prop.getProperty("orangeHRM.deviceScaleFactor")))
    	        //.setExtraHTTPHeaders(argsManager.extraHTTPHeaders())
    	        .setForcedColors(ForcedColors.NONE)
    	        .setGeolocation(GeolocationManager.get("brazil_sao_paulo"))
    	        .setHasTouch(Boolean.getBoolean(prop.getProperty("orangeHRM.hasTouch", "false")))
    	        //.setHttpCredentials(new HttpCredentials(prop.getProperty("orangeHRM.httpCredentials.username"), prop.getProperty("orangeHRM.httpCredentials.password")))
    	        //.setIgnoreHTTPSErrors(Boolean.getBoolean(prop.getProperty("orangeHRM.ignoreHTTPSErrors", "false")))
    	        .setIsMobile(Boolean.getBoolean(prop.getProperty("orangeHRM.ignoreHTTPSErrors", "false")))
    	        .setJavaScriptEnabled(Boolean.getBoolean(prop.getProperty("orangeHRM.javaScriptEnabled", "true")))
    	        .setLocale(prop.getProperty("orangeHRM.locale", "en-US"))
    	        .setOffline(Boolean.getBoolean(prop.getProperty("orangeHRM.offline", "false")))
    	        //.setPermissions(argsManager.permissions())
    	        //.setProxy(proxyConfig())
    	        //.setRecordHarContent(HarContentPolicy.EMBED)
    	        //.setRecordHarMode(HarMode.FULL)
    	        //.setRecordHarOmitContent(Boolean.getBoolean(prop.getProperty("orangeHRM.recordHarOmitContent", "false")))
    	        //.setRecordHarPath(Path.of(prop.getProperty("orangeHRM.path.recordHar")))
    	        //.setRecordHarUrlFilter(prop.getProperty("orangeHRM.recordHarUrlFilter"))
    	        //.setReducedMotion(ReducedMotion.NO_PREFERENCE)
    	        //.setScreenSize(ScreenSizeManager.get("desktop"))
    	        //.setServiceWorkers(ServiceWorkerPolicy.ALLOW)
    	        //.setStorageState(prop.getProperty("orangeHRM.storageState"))
    	        //.setStorageStatePath(Path.of(prop.getProperty("orangeHRM.path.storageState")))
    	        //.setStrictSelectors(Boolean.getBoolean(prop.getProperty("orangeHRM.strictSelectors", "false")))
    	        .setTimezoneId(prop.getProperty("orangeHRM.timezoneId", "America/New_York"));
    	        //.setUserAgent(prop.getProperty("orangeHRM.userAgent"));

 
        if (Boolean.getBoolean(prop.getProperty("pw.test.results.video", "false"))) {
            String suiteName = testInfo.getTestClass().map(Class::getSimpleName).orElse("DefaultSuite");
            String testName = testInfo.getDisplayName();
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
            Path suiteDir = Path.of("videos", suiteName);
            Path videoPath = suiteDir.resolve(testName + "_" + timestamp);

            opts.setRecordVideoDir(videoPath);
            opts.setRecordVideoSize(1280, 720);
        }
        
        context = browser.newContext();
        page = context.newPage();
        page.navigate(prop.getProperty("orangeHRM.url"));
        
    }

    @AfterEach
    protected void cleanup(TestInfo info) {
    	
        String testName = info.getDisplayName().replaceAll("[^a-zA-Z0-9-_]", "_");
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        Path screenshotPath = Path.of("screenshots", testName + "_" + timestamp + ".png");

        page.screenshot(new Page.ScreenshotOptions().setPath(screenshotPath));
    	
    	Method testMethod = info.getTestMethod().orElse(null);
    	if (testMethod != null && testMethod.isAnnotationPresent(ClickUpTask.class)) {
    	    String taskId = testMethod.getAnnotation(ClickUpTask.class).value();
    	    ClickUpHelper.uploadScreenshot(screenshotPath, taskId);
    	}
    	
        if (context != null) context.close();
    }
}

