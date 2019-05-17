package CucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

//This file is a Runner file responsible for running the Feature: Login and Registration functionality
//Runs scenarios for testing login and registration success/rejection
@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/FeatureFiles/login.feature",
		glue="StepDefinitions"
		)
public class TestRunnerLogin{

}
