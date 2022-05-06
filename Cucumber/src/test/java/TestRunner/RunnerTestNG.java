package TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (features = "D:\\Work\\Java_Prac\\Cucumber\\src\\resources\\java\\Features\\Loginbak.feature",

glue="StepDefination", monochrome = true)

public class RunnerTestNG extends AbstractTestNGCucumberTests {

}
