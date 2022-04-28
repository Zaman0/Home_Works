package testscripts;

import org.testng.annotations.Test;

import Browserconfig.BrowserSetup;
import resuablefunctions.Commonfunctions;

public class TC1 extends BrowserSetup{
  @Test
  public void fLoginTC() {
	  Commonfunctions cf=new Commonfunctions();
	  cf.login();
  }
}
