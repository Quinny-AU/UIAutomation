package CucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

//This file is a Runner file responsible for running the Feature: Shop online using registered account
//Runs scenarios for testing general browsing, item viewing and selection
@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/FeatureFiles/onlineShopping.feature",
		glue="StepDefinitions"
		)
public class TestRunnerShopping{
	
}
