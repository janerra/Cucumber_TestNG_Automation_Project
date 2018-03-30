package com.app.step_definitions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.app.utilities.Driver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import cucumber.api.Scenario;

public class Hooks {

	// private WebDriver driver;

	@Before
	public void beforeScenario() {
		WebDriver driver = Driver.getDriver();
		// driver.get(ConfigurationReader.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// System.out.println("Before the Scenario started");
	}

	@After
	public void tearDown(Scenario scenario) {
		// System.out.println("before the Scenario started");
		if (scenario.isFailed()) {
		
				
		final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES); scenario.embed(screenshot, "image/png");


		}
		//Driver.closeDriver();
	}
}
