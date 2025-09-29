package orangeHRM.TestCases;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import orangeHRM.ClickUpHelper.ClickUpTask;
import orangeHRM.Config.OrangeBaseTest;
import orangeHRM.Config.ScreenshotOnFailureWatcher;

@ExtendWith(ScreenshotOnFailureWatcher.class)
public class ParallelTest1 extends OrangeBaseTest{
    
	@Test
	@Tag("p1")
	@ClickUpTask("123456789")
	public void LoginWithSuccess() {
		
	}
	
	@Test
	@Tag("p2")
	public void LoginWithSuccess2() {
		
	}
	
	@Test
	@Tag("p3")
	public void LoginWithSuccess3() {
		
	}
	
	@Test
	@Tag("p4")
	public void LoginWithSuccess4() {
		
	}
}
