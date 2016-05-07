package org.etna.customer.pageobjects;
import org.etna.maincontroller.MainController;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SaveCartPageObjects extends PageFactoryInitializer{

	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	
	@FindBy(xpath="//h2")
	private WebElement pageName;
	
	@FindBy(xpath="//button[@id='groupNameSaveBtn']")
	private WebElement deleteSaveCartButton;
	

	
	public SaveCartPageObjects clickOnTheCreatedSaveCart(String saveCartName) {
		
	driver.findElement(By.xpath("//a[contains(text(),'"+saveCartName+"')]")).click();
	return this;
	}
	
	public SaveCartPageObjects verifyBreadCrumps(String saveCartBreadcrump) {
		Waiting.explicitWaitVisibilityOfElements(productDetailsPage().breadCrumps, 10);
		Assert.assertTrue(productDetailsPage().breadCrumps.get(productDetailsPage().breadCrumps.size()-1).getText().replace("/", "").trim().equalsIgnoreCase(saveCartBreadcrump.trim()),"Breadcrump is not "+saveCartBreadcrump+". It is :"+productDetailsPage().breadCrumps.get(productDetailsPage().breadCrumps.size()-1).getText().replace("/", "").trim());
		return this;
	}
	
	public SaveCartPageObjects verifyPageName(String saveCartBreadcrump) {
		Assert.assertTrue(pageName.getText().equalsIgnoreCase(saveCartBreadcrump),"Breadcrump is not "+saveCartBreadcrump);
		return this;
	}
	
	public SaveCartPageObjects verifySaveCartTitle() throws Exception {
		Assert.assertEquals(driver.getTitle().trim(),"Saved Groups" +" | "+setUp.getProductName().toUpperCase().trim());
		return this;
	}


	public SaveCartPageObjects deleteSaveCart() {
		Waiting.explicitWaitVisibilityOfElement(deleteSaveCartButton, 15);
		deleteSaveCartButton.click();
		return this;
	}


	public SaveCartPageObjects verifyDeletionOfSaveCart(String saveCartName)
	{
		Assert.assertTrue(assertDeletionOfSaveCart(saveCartName),"Cart is not deleted yet.");
		return this;
	}
	public boolean  assertDeletionOfSaveCart(String saveCartName) {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try
		{
		Assert.assertFalse(driver.findElement(By.xpath("//a[contains(text(),'"+saveCartName+"')])")).isDisplayed());
		}
		catch(Exception e)
		{
			return true;
		}
		return false;
	}

	public SaveCartPageObjects verifyTitleAfterClickingOnTheCartCreated() throws Exception {
		Assert.assertEquals(driver.getTitle().trim(),"Saved Cart" +" | "+setUp.getProductName().toUpperCase().trim());
		return this;
	}
	
	

}
