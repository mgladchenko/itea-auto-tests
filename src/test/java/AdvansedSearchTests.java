import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginRegistrationPage;
import page.SearchPage;

public class AdvansedSearchTests extends BaseTest{

	public HomePage homePage;

	@BeforeClass
	public void beforeTest() {
		LoginRegistrationPage registrationPage = new LoginRegistrationPage(getDriver());
		homePage = registrationPage.loginFormFillAndSubmit("dem.iuliia.p@gmail.com","dem.iuliia.p.password");
		Assert.assertTrue(homePage.isPageLoaded());
	}

	@DataProvider(name = "searchTerms")
	public Object[][] searchTermsData() {
		return new Object[][] {
				{ "HR", "HR" },
				{ "hr", "hr" }
		};
	}

	@Test(dataProvider = "searchTerms")
	public void advancedSearchTest(String searchTerm, String expectedContainedTerm) {
		SearchPage searchPage = homePage.clickAdvancedSearchLink();
		searchPage.fillKeywordSearchTermAndSubmit(searchTerm);
		Assert.assertEquals(searchPage.getSearchResultsOnPageCount(), 10, "Actual results on page number is wrong.");
		Assert.assertTrue(searchPage.getDescriptionStringList().get(0).contains(expectedContainedTerm) , "Expected search term is not found in results linst");
	}
}
