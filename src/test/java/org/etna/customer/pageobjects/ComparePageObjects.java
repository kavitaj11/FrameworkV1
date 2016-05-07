package org.etna.customer.pageobjects;
import org.etna.maincontroller.MainController;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/*
 * @author Hemanth.Sridhar
 */
public class ComparePageObjects extends PageFactoryInitializer
{
 
   Actions action = new Actions(driver);

	
	@FindBy(xpath="//table")
	private WebElement compareTable;
	
	@FindBy(xpath="//h2[text()='Compare']")
	private WebElement compareHeader;
	
	@FindBy(xpath="//li[contains(text(),'Compare')]")
	private WebElement compareBreadCrump;

	@FindBy(id="showSimilar")
	private WebElement showSimilar;
	
	@FindBy(xpath="//td[@class='similar active']")
	private WebElement similarAttributeLocator;
	
	@FindBy(id="showDifferent")
	private WebElement showDifferent;
	
	@FindBy(css="td[class='different active']")
	private WebElement differentAttributeLocator;
	
	@FindBy(xpath="(//a[contains(.,'Off')])[2]")
	private WebElement offButton;
	
	@FindBy(xpath="(//td/descendant::a[@class='log-addTocart-btn addToCart'])[1]")
	private WebElement addToCartButtonFirst;
	
	@FindBy(xpath="(//b[contains(.,'Details')]/ancestor::td/following-sibling::td/b/descendant::span)[1]")
	private WebElement getFirstProductName;
	
	@FindBy(xpath="(//span[contains(text(),'Call for Price')]/ancestor::tr[contains(.,'Price')]/following-sibling::tr/descendant::a[contains(.,'Add to Cart')])[1]")
	private WebElement callForPriceAddToCartButton;
	
	public ComparePageObjects verifyDisplayOfCompareTable() {
		Assert.assertTrue(compareTable.isDisplayed(),"compare table is not displayed");
		return this;
	}

	public ComparePageObjects verifyCompareHeaderAndBreampCrumpAndTitle() {
		Assert.assertTrue(compareBreadCrump.isDisplayed(),"compare bread crump is not displayed");
		Assert.assertTrue(compareHeader.isDisplayed(),"compare header is not displayed");
		Assert.assertEquals(driver.getTitle().trim(),"Compare - HGH_HARDWARE");
		return this;
		
	}

	public ComparePageObjects clickOnShowSimilar() {
		
		Waiting.explicitWaitVisibilityOfElement(showSimilar, 20);
		showSimilar.click();
		return this;
}

	public ComparePageObjects verifyColourOfShowSimilarButtonAfterClicking() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		Assert.assertEquals(showSimilar.getCssValue("background-color").trim(),"rgba(121, 0, 15, 1)");
		return this;
	}

	public ComparePageObjects verifyActivationOfSimilarProperties() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		Assert.assertTrue(similarAttributeLocator.isDisplayed(),"similar attribute is not enabled");
		Assert.assertEquals(similarAttributeLocator.getCssValue("background-color").trim(),"rgba(253, 253, 207, 1)");
		return this;
	}

	public ComparePageObjects clickOnShowDifferent() {
		Waiting.explicitWaitVisibilityOfElement(showDifferent, 20);
		showDifferent.click();
		return this;
	}

	public ComparePageObjects verifyColourOfShowDifferentButtonAfterClicking() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		Assert.assertEquals(showDifferent.getCssValue("background-color").trim(),"rgba(121, 0, 15, 1)");
		return this;
	}

	public ComparePageObjects verifyActivationOfDifferentProperties() {
		Waiting.explicitWaitVisibilityOfElement(differentAttributeLocator, 10);
		Assert.assertTrue(differentAttributeLocator.isDisplayed(),"different attribute is not enabled");
		Assert.assertEquals(differentAttributeLocator.getCssValue("background-color").trim(),"rgba(250, 232, 226, 1)");
		return this;
	}

	public ComparePageObjects clickOnOffButton() {
		offButton.click();
		return this;
	}

	public ComparePageObjects verifyColourOfShowSimilarButton() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		Assert.assertEquals(showSimilar.getCssValue("background-color").trim(),"rgba(207, 139, 45, 1)");
		return this;
	}

	public boolean verifyActivationOfSimilarPropertiesIsPresent() {
		try
		{
		Assert.assertTrue(similarAttributeLocator.isDisplayed(),"similar attribute is still enabled");
		return false;
		}
		catch(NoSuchElementException e)
		{
			return true;
		}
	}

	public ComparePageObjects verifyColourOfShowDifferentButton() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		Assert.assertEquals(showDifferent.getCssValue("background-color").trim(),"rgba(207, 139, 45, 1)");
		return this;
	}

	public boolean verifyActivationOfDifferentPropertiesIsPresent() {
		try
		{
		Assert.assertTrue(differentAttributeLocator.isDisplayed(),"different attribute is still enabled");
		return false;
		}
		catch(NoSuchElementException e)
		{
			return true;
		}
		
	}

	public ComparePageObjects clickOnFirstAddToCart() {
		Waiting.explicitWaitVisibilityOfElement(addToCartButtonFirst, 20);
		addToCartButtonFirst.click();
		return this;
		
	}

	public String getFirstProductName() {
		String productName = getFirstProductName.getText().trim();
		return productName;
	}

	public ComparePageObjects checkDisableOfAddToCartButton() {
		Waiting.explicitWaitVisibilityOfElement(callForPriceAddToCartButton, 20);
		Assert.assertEquals(callForPriceAddToCartButton.getAttribute("class"),"log-addTocart-btn btns-disable");
		return this;
	}

	public ComparePageObjects verifyWhetherAllTheProductsAreDisplayed(String productTitle1,String productTitle2, String productTitle3) {
		String productTitle1Name = "//td[contains(.,'Details')]/following-sibling::td/descendant::span[contains(.,'"+productTitle1+"')]";
		String productTitle2Name = "//td[contains(.,'Details')]/following-sibling::td/descendant::span[contains(.,'"+productTitle2+"')]";
		String productTitle3Name = "//td[contains(.,'Details')]/following-sibling::td/descendant::span[contains(.,'"+productTitle3+"')]";
		Assert.assertTrue(driver.findElement(By.xpath(productTitle1Name)).isDisplayed(),"First product is not getting displayed. Getting productTitle : "+productTitle1);
		Assert.assertTrue(driver.findElement(By.xpath(productTitle2Name)).isDisplayed(),"Second product is not getting displayed. Getting productTitle : "+productTitle2);
		Assert.assertTrue(driver.findElement(By.xpath(productTitle3Name)).isDisplayed(),"Third product is not getting displayed. Getting productTitle : "+productTitle3);
	return this;
	}
	
}
	
	
