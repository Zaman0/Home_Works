package TestRunnerJunit;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;


@RunWith (Cucumber.class)
@CucumberOptions (features = "D:\\Work\\Java_Prac\\Cucumber\\src\\resources\\java\\Features\\Login.feature",
glue="StepDefination") // Package Name
public class RuunerJunit {


	
	
}
