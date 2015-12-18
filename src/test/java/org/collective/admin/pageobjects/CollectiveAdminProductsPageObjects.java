package org.collective.admin.pageobjects;
import org.collective.maincontroller.MainController;
import org.collective.utils.SearchData;
import org.collective.utils.Waiting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
/*
 * @author Hemanth.Sridhar
 */
public class CollectiveAdminProductsPageObjects extends MainController{
	
   SearchData data = new SearchData();
   
	public CollectiveAdminProductsPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@id='admin_new_product']")
	private WebElement newProductButton;
	
	@FindBy(xpath="//h1[contains(text(),'Listing Products')]")
	private WebElement productsHeader;
	
	@FindBy(xpath="//label[text()='Name']")
	private WebElement nameLabel;
	
	@FindBy(xpath="//input[@id='q_name_cont']")
	private WebElement nameTextBox;
	
	@FindBy(xpath="//input[@id='q_variants_including_master_sku_cont']")
	private WebElement skuTextBox;
	
	@FindBy(xpath="//label[text()='SKU']")
	private WebElement SKUlabel;
	
	@FindBy(xpath="//input[@id='q_deleted_at_null']/ancestor::label")
	private WebElement showDeletedLabel;
	
	@FindBy(xpath="//button[text()='Search']")
	private WebElement searchButton;
	
	public void verifyProductsPage() {
		Waiting.explicitWaitVisibilityOfElement(productsHeader, 6);
		Assert.assertTrue(productsHeader.isDisplayed());
		Assert.assertTrue(newProductButton.isDisplayed());
		Assert.assertTrue(nameLabel.isDisplayed());
		Assert.assertTrue(nameTextBox.isDisplayed());
		Assert.assertTrue(skuTextBox.isDisplayed());
		Assert.assertTrue(SKUlabel.isDisplayed());
		Assert.assertTrue(showDeletedLabel.isDisplayed());
		Assert.assertTrue(searchButton.isDisplayed());
	}
	}

	
