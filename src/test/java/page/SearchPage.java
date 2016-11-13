package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage{

	@FindBy(id = "advs")
	private WebElement advancedSearchForm;

	@FindBy(id = "advs-keywords")
	private WebElement keywordsField;

	@FindBy(xpath = "//div[@class='description']")
	private List<WebElement> searchResultDescriptionsList;

	@FindBy(xpath = "//div[@class='search-info']/p[contains(text(),'results for') or contains(text(),'розультатов для')]")
	private WebElement resultsForInfoText;


	public SearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		waitUntilElementDisplayed(advancedSearchForm);
	}

	public void fillKeywordSearchTermAndSubmit(String searchTerm) {
		waitUntilElementDisplayed(keywordsField).sendKeys(searchTerm);
		keywordsField.submit();
		waitUntilElementDisplayed(resultsForInfoText);
	}

	public int getSearchResultsOnPageCount() {
		return searchResultDescriptionsList.size();
	}


	public List<String> getDescriptionStringList() {
		List<String> searchResultDescriptionStringList = new ArrayList<String>();

		for (WebElement searchResultDescriptionElement : searchResultDescriptionsList) {
			System.out.println(searchResultDescriptionElement.getText());
			searchResultDescriptionStringList.add(searchResultDescriptionElement.getText());
		}
		return searchResultDescriptionStringList;
	}






}
