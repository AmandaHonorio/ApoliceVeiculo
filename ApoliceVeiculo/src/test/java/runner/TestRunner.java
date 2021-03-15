package runner;

import org.junit.runner.RunWith;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.sql.Driver;

import org.junit.AfterClass;
import com.vimalselvam.cucumber.listener.Reporter;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = { "steps" })

public class TestRunner {
	@Before
	public void setUp() {
	}

	@AfterClass
	public static void writeExtentReport() {
	}
}
