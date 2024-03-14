package basePack;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends BaseClass implements ITestListener {

	public Listeners() throws IOException {
		super();
	}
	
	public void onTestFailure(ITestResult result) {
		try {
			 takeScreenShot(result.getName());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	

}
