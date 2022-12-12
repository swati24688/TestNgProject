package page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import util.PropertyLoader;

public class AddCategoryPage {

	WebDriver driver;

	public void addCategory(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(how = How.CSS, using = "input[value*='Add category']")
	WebElement addCategoryElemenet;

	@FindBy(how = How.CSS, using = "input[name*='categorydata']")
	WebElement addCategoryField;

	@FindBy(how = How.CSS, using = "select[name*='due_month']")
	WebElement monthDropDownElement;

	@FindBy(how = How.TAG_NAME, tagName = "body")
	WebElement bodyContent;

	public void addCategory(String Name) {
		addCategoryField.sendKeys(Name);
		addCategoryElemenet.click();

	}

	public void duplicatedCategory(String name) {
		addCategory(name);
		Assert.assertTrue(bodyContent.getText().contains("The category you want to add already exists: " + name));
	}

	public void monthDropDown() {

		monthDropDownElement.click();

		// get the select dropdown element
		Select dropDown = new Select(monthDropDownElement);
		
		// read all the otions from select element
		List<WebElement> options = dropDown.getOptions();

		// add all months from dropdown to a list
		List<String> monthsdropdown = new ArrayList();

		for (int i = 0; i < options.size(); i++) {
			monthsdropdown.add(options.get(i).getText());
		}

		// assert true if dropdown contains all months from MONTHS_LIST list
		PropertyLoader prop = new PropertyLoader();
		List<String> MONTHS_LIST = prop.getMonthsList();

		Assert.assertTrue(monthsdropdown.containsAll(MONTHS_LIST), "Month check");
	}

}
