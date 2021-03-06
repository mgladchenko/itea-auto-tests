package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

	@FindBy(xpath = "//div[@id='main-site-nav']//a[@class='nav-link' and @href='/home?trk=nav_responsive_tab_home']")
	private WebElement homeMenuLink;

	@FindBy(id = "advanced-search")
	private WebElement advancedSearchLink;

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		waitUntilElementDisplayed(homeMenuLink);
	}

	public boolean isPageLoaded() {
		return waitUntilElementDisplayed(homeMenuLink, 5).isDisplayed();
	}

	public SearchPage clickAdvancedSearchLink() {
		waitUntilElementDisplayed(advancedSearchLink).click();
		return new SearchPage(driver);
	}

}
