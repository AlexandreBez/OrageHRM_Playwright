import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class ScreenshotOnFailureWatcher implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        BaseTest testInstance = (BaseTest) context.getRequiredTestInstance();
        testInstance.setTestPassed(false);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        BaseTest testInstance = (BaseTest) context.getRequiredTestInstance();
        testInstance.setTestPassed(true);
    }
}
