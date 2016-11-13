import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginRegistrationPage;

/**
 * Class with all Login and Registration tests
 */
public class LoginRegistrationTests extends BaseTest{

	@Test
	public void errorMessageOnEmptyFormSubmit() {
		LoginRegistrationPage registrationPage = new LoginRegistrationPage(getDriver());
		registrationPage.registrationFormFillAndSubmit("","","","");
		Assert.assertEquals(registrationPage.getErrorMessageText(), "Please enter your first name", "Expected error message was not found on page");
	}

	@Test
	public void successfulLoginTest() {
		LoginRegistrationPage registrationPage = new LoginRegistrationPage(getDriver());
		HomePage homePage = registrationPage.loginFormFillAndSubmit("dem.iuliia.p@gmail.com","dem.iuliia.p.password");
		Assert.assertTrue(homePage.isPageLoaded());
	}

}
