package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCategoryPage;
import util.BrowserFactory;

public class AddCategoryTest {

	WebDriver driver;
	String Name = "Swati";


	 @Test
	public void addCategoryTest() {
		driver = BrowserFactory.init();
		AddCategoryPage addCategoryPage = PageFactory.initElements(driver, AddCategoryPage.class);
		addCategoryPage.addCategory(Name + Math.random());
		 BrowserFactory.tearDown();
	}

	@Test
	public void addDuplicagteCategoryTest() {
		driver = BrowserFactory.init();
		AddCategoryPage addCategoryPage = PageFactory.initElements(driver, AddCategoryPage.class);
		addCategoryPage.duplicatedCategory(Name);
		// BrowserFactory.tearDown();
	}

	@Test
	public void checkMonthDropDown() {
		driver = BrowserFactory.init();
		AddCategoryPage addCategoryPage = PageFactory.initElements(driver, AddCategoryPage.class);
        addCategoryPage.monthDropDown(); 
        
	}
}
