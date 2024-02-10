package vjPractise.tests;

import org.testng.annotations.Test;

import vjPractise.Testcomponents.BaseTest;
import vjPractise.pageObjects.Register;

public class RegisteringNewUser extends BaseTest {

	@Test
	public void registerUser() {
		lp.goTo();
		Register r=lp.RegisterUser();
		r.Registerationdetails("vinoth", "Jawan", "v@test.com", "123455767", "Engineer","confirm", "confirm");
		
	}
}
