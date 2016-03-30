package org.hgh.modules;

import org.hgh.maincontroller.MainController;
import org.hgh.utils.SearchDataPropertyFile;
import org.testng.annotations.Test;

public class HGHHomePageModule extends MainController{

	/*
	 * @author Hemanth.Sridhar
	 */
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();

	HGHLoginModule loginModule = new HGHLoginModule();
	
	
	
	@Test(groups={"smoke","regression"})
	  public void tc008_verifyHeaderAndFooter() throws Exception
	  {
				homePage()
				.verifyDisplayOfLoginLink()
				.verifyDisplayOfMyAccountsInHeader()
				.verifyDisplayOfOrderStatusInHeader()
				.verifyDisplayOfOrderPadInHeader()
				.verifyResourcesLinkInHeader()
				.verifyHelpLinkHeader()
				.verifyHeadingOfEverySectionInFooter()
				.verifyCustomerServiceLinkInFooter()
				.verifyHelpCenterInFooter()
				.verifyHelpContactUsInFooter()
				.verifyReturnsInFooter()
				.verifyShippingPolicyInFooter()
				.verifyMyAccountInFooter()
				.verifyOrderStatusInFooter()
				.verifyQuickOrderpadInFooter()
				.verifyMyCartInFooter()
				.verifyTradePartnersInFooter()
				.verifyLearningCenterInFooter()
				.verifyManufacturersInFooter()
				.verifyBlogInFooter()
				.verifySecurityAndPrivacyInFooter()
				.verifyTermsOfUseInFooter()
				.verifyAboutUsInFooter()
				.verifyEventsInFooter()
				.verifyBranchLocationInFooter()
				.verifyCareersInFooter()
				.verifySiteMapInFooter()
				.verifyTaxonomies();
	  } 
}
