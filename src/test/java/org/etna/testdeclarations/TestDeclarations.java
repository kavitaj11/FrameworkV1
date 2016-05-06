package org.etna.testdeclarations;
import org.etna.dataprovider.SearchData;
import org.etna.maincontroller.MainController;
import org.etna.testdefinitions.APAModuleTest;
import org.etna.testdefinitions.CategoryModuleTest;
import org.etna.testdefinitions.GeneralSearchModuleTest;
import org.etna.testdefinitions.HomePageModuleTest;
import org.etna.testdefinitions.LoginModuleTest;
import org.etna.testdefinitions.MyCartModuleTest;
import org.etna.testdefinitions.PDPModuleTest;
import org.etna.testdefinitions.ShopByBrandsModuleTest;
import org.etna.testdefinitions.ShopByManufacturersModuleTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class TestDeclarations extends MainController{

	APAModuleTest apaModule = new APAModuleTest();
	CategoryModuleTest categoryModule = new CategoryModuleTest();
	GeneralSearchModuleTest generalSearchModule = new GeneralSearchModuleTest();
	HomePageModuleTest homePageModule = new HomePageModuleTest();
	LoginModuleTest loginModule = new LoginModuleTest();
	MyCartModuleTest mycartModule = new MyCartModuleTest();
	PDPModuleTest pdpModule = new PDPModuleTest();
	ShopByBrandsModuleTest shopByBrandsModule = new ShopByBrandsModuleTest();
	ShopByManufacturersModuleTest shopByManufacturersModule = new ShopByManufacturersModuleTest();

	@Test(groups={"APAModule","regression"},alwaysRun=true)
	 public void TC_APA_001_verifyDisplayOfManageAddDisablePAafterSuperUserLogin() throws Exception{
		apaModule.TC_APA_001_verifyDisplayOfManageAddDisablePAafterSuperUserLogin();
		
	}
	
	@Test(groups={"APAModule","regression"},alwaysRun=true)
	 public void TC_APA_002_TC_APA_050_verifyAddNewPA_afterSuperUserLogin_VerifyBreadcrumpOfAddNewPurchasingAgent() throws Exception{
		apaModule.TC_APA_002_TC_APA_050_verifyAddNewPA_afterSuperUserLogin_VerifyBreadcrumpOfAddNewPurchasingAgent();
	}
	
	@Test(groups={"APAModule","regression"},enabled=false)
	 public void TC_APA_003_addNewPurchasingAgent_GeneralUser() throws Exception{
		
		apaModule.TC_APA_003_addNewPurchasingAgent_GeneralUser();
	}
	
	
	@Test(groups={"APAModule","regression"},enabled=false)
	 public void TC_APA_004_generalUserLoginCheckoutButtonNotDisplayedInCart() throws Exception{
		
		apaModule.TC_APA_004_generalUserLoginCheckoutButtonNotDisplayedInCart();
	}
	
	@Test(groups={"APAModule","regression"},enabled=false)
	 public void TC_APA_005_addNewPurchasingAgent_APA() throws Exception{
		
		apaModule.TC_APA_005_addNewPurchasingAgent_APA();
	}
	
	@Test(groups={"APAModule","regression"},enabled=false)
	 public void TC_APA_006() throws Exception{
		
		apaModule.TC_APA_006();
	}
	
	@Test(groups={"APAModule","regression"},enabled=false)
	 public void TC_APA_007() throws Exception{
		apaModule.TC_APA_007();
	}
	
	
	@Test(alwaysRun=true,groups={"APAModule","regression"},dataProvider="excelSheetDataRead",dataProviderClass=SearchData.class)
	public void TC_PA_008_To_TC_PA_022_errorScenarios(String emailId,String firstName, String lastName, String password, String confirmPassword,String address1, String address2, String city, String state, String zipCode,String phoneNumber,String roleAssignment,String faxNumber,String website,String expectedErrorMsg) throws Exception
	{
	apaModule.TC_PA_008_To_TC_PA_022_errorScenarios(emailId, firstName, lastName, password, confirmPassword, address1, address2, city, state, zipCode, phoneNumber, roleAssignment, faxNumber, website, expectedErrorMsg);
	}
	
	@Test(alwaysRun=true,groups={"CategoryModule","regression"})
	@Description("Verification of breadcrumbs, Verification of Page Title, Verification of Page Name, Verification of categories in filter is displayed "
			+ "in the page ")
	  public void TC_categories_001_TC_categories_006_TC_categories_007_TC_categories_008() throws Exception
	  {
		  	categoryModule.TC_categories_001_TC_categories_006_TC_categories_007_TC_categories_008();
				
	}
	
	@Test(alwaysRun=true,groups={"CategoryModule","regression"})
	@Description("Verification of level 1 category link.")
	  public void TC_categories_002() throws Exception
	  {
		categoryModule.TC_categories_002();
	}
	
		@Test(groups={"CategoryModule","regression"})
		@Description("Verification of last level category link for Product List Page.")
		public void TC_categories_003_navigateProductListPage() throws Exception
		{
		  		categoryModule.TC_categories_003_navigateProductListPage();
	  }
		
		@Test(alwaysRun=true,groups={"CategoryModule","regression"})
		@Description("Verification of last level category link for Product Details Page.")
		public void TC_categories_003_navigateProductDetailsPage() throws Exception
		{
		  		categoryModule.TC_categories_003_navigateProductDetailsPage();
	  }
		
		@Test(alwaysRun=true,groups={"CategoryModule","regression"})
		@Description("Verification of description and banners.")
		public void TC_categories_004_verifyBanners() throws Exception
			{
		  		categoryModule.TC_categories_004_verifyBanners();
			}
		
		
			@Test(alwaysRun=true,groups={"CategoryModule","regression"})
			@Description("Verification of image link of any category")
			public void TC_categories_005_ClickingOnImages() throws Exception
				{
			  		categoryModule.TC_categories_005_ClickingOnImages();
				}
			
	@Test(alwaysRun=true,groups={"GeneralSearchModule","smoke","regression"})
	 public void tc004_generalSearch() throws Exception
			{
					generalSearchModule.tc004_generalSearch();
			}
	
	@Test(alwaysRun=true,groups={"HomePageModule","smoke","regression"},enabled=false)
	  public void tc008_verifyHomePage() throws Exception
	  {
		homePageModule.tc008_verifyHomePage();
	  } 
	
	@Test(alwaysRun=true,groups={"HomePageModule","regression"})
	  public void tc009_verifyAllSectionOptionPages() throws Exception
	  {
		homePageModule.tc009_verifyAllSectionOptionPages();
	  } 	
	
	@Test(alwaysRun=true,groups={"HomePageModule","regression"})
	  public void tc010_verifyAllFooterSectionPages() throws Exception
	  {
		homePageModule.tc010_verifyAllFooterSectionPages();
	  } 
	
	
	@Test(alwaysRun=true,groups={"HomePageModule","regression"})
	  public void tc011_clickOnLogoNavigateBackToHomePage() throws Exception
	  {
		homePageModule.tc011_clickOnLogoNavigateBackToHomePage();
	  } 
	
	 @Test(alwaysRun=true,groups={"LoginModule","smoke","regression"})
		public void TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027() throws Exception
		{
		   loginModule.TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
		}
	  
	  
	 @Test(alwaysRun=true,groups={"LoginModule","regression"},dataProvider="excelSheetDataRead", dataProviderClass=SearchData.class)
			public void TC_Login_001_AsASuperUser_PurchaseAgent_GeneralUser(String userName,String password,String expectedMsg) throws Exception
			{
		 loginModule.TC_Login_001_AsASuperUser_PurchaseAgent_GeneralUser(userName,password,expectedMsg);
			}

	  @Test(alwaysRun=true,groups={"LoginModule","regression"},dataProvider="excelSheetDataRead", dataProviderClass=SearchData.class)
	  public void TC_Login_004_TC_Login_005_TC_Login_006_TC_Login_007_ErrorScenarios(String userName, String password,String expectedMsg) throws Exception
	  {
		  loginModule.TC_Login_004_TC_Login_005_TC_Login_006_TC_Login_007_ErrorScenarios(userName,password,expectedMsg);
	  }
	  
	  
	  @Test(groups={"LoginModule","regression"},enabled=false)
	  public void TS_Login_001_TC_Login_008_Verify_Tab_focus() throws Exception
	  {
		  
		  loginModule.TS_Login_001_TC_Login_008_Verify_Tab_focus();
		}
	  
	  @Test(alwaysRun=true,groups={"LoginModule","regression"})
	  public void TC_Login_009_010_RememberPassword_UserNameAndPasswordRefill() throws Exception
	  {
		loginModule.TC_Login_009_010_RememberPassword_UserNameAndPasswordRefill();
		}
	  
	  @Test(alwaysRun=true,groups={"LoginModule","regression"})
	  public void TC_Login_011_AutofillLogin() throws Exception
	  {
		  loginModule.TC_Login_011_AutofillLogin();
		}
	  
	  @Test(alwaysRun=true,groups={"LoginModule","regression"})
	  public void TC_Login_012_uncheckRememberMeWhenInAutoFillForm() throws Exception
	  {
		 loginModule.TC_Login_012_uncheckRememberMeWhenInAutoFillForm();
		}
	  
	  @Test(alwaysRun=true,groups={"LoginModule","regression"})
	  public void TC_Login_013_myProductGroupLoginPopupRememberMeClickUncheck() throws Exception
	  {
		  loginModule.TC_Login_013_myProductGroupLoginPopupRememberMeClickUncheck();
	  }
	  
	  
	  @Test(alwaysRun=true,groups={"LoginModule","regression"})
	  public void TC_Login_015_rememberMeAsALink() throws Exception
	  {
		  loginModule.TC_Login_015_rememberMeAsALink();
		}
	  
	  @Test(alwaysRun=true,groups={"LoginModule","regression"})
	  public void TC_Login_016_TC_Login_017_TC_Login_018_rememberMeCheckboxTest() throws Exception
	  {
		 loginModule.TC_Login_016_TC_Login_017_TC_Login_018_rememberMeCheckboxTest();
	}

	 @Test(alwaysRun=true,groups={"LoginModule","regression"})
	  public void TC_Login_014_myProductGroupLoginPopupRememberMeClickCheck() throws Exception
	  {  
		loginModule.TC_Login_014_myProductGroupLoginPopupRememberMeClickCheck();
	  }
	  
	  @Test(groups={"LoginModule","regression"},enabled=false)
	  public void TC_Login_021_loginVerifyOrderTopToBottom() throws Exception
	  {
		loginModule.TC_Login_021_loginVerifyOrderTopToBottom();
		  
		}
	
	  
	  @Test(alwaysRun=true,groups={"LoginModule","regression"})
	  public void TC_Login_020_verifyForgotPasswordPage() throws Exception
	  {
		  loginModule.TC_Login_020_verifyForgotPasswordPage();
		}
	  
	  @Test(groups={"LoginModule","regression"},enabled=false)
	  public void TC_Login_019_verifyRegisterPage() throws Exception
	  {
		  loginModule.TC_Login_019_verifyRegisterPage();
		
	  }
	  

		@Test(alwaysRun=true,groups={"MyCartModule","smoke","regression"})
		public void TC_MyCart_001() throws Exception{
			mycartModule.TC_MyCart_001();
		}
		
		
		@Test(groups={"MyCartModule","smoke","regression"},enabled=false)
		  public void TC_ShoppingCart_011_CreateAndDeleteSaveCart() throws Exception
		  {
			mycartModule.TC_ShoppingCart_011_CreateAndDeleteSaveCart();
				
		  }
		  
		  
		  @Test(groups={"MyCartModule","regression"},enabled=false)
		  public void TC_ShoppingCart_012_saveCart_ClickOnCofirmationPopup() throws Exception
		  {
			  mycartModule.TC_ShoppingCart_012_saveCart_ClickOnCofirmationPopup();
		  }
		  
//		  @Test(groups={"regression"})
//		  public void TS_ShoppingCart_001_TC_ShoppingCart_013_HGH_shipViaMethodModication() throws Exception
//		  {
//			  	
//			 throw new SkipException("this feature is not present in the application");
//		  }
//		  
		  
		  @Test(alwaysRun=true,groups={"MyCartModule","regression"})
		  public void TC_ShoppingCart_014_signedUser_ShoppingCartUpdateToolTip() throws Exception
		  {
			  mycartModule.TC_ShoppingCart_014_signedUser_ShoppingCartUpdateToolTip();
		  }
		  
		  @Test(alwaysRun=true,groups={"MyCartModule","regression"})
		  public void TC_ShoppingCart_015_updateLinkFunctionality() throws Exception
		  {
			  mycartModule.TC_ShoppingCart_015_updateLinkFunctionality();
		  }
	  
		  @Test(alwaysRun=true,groups={"MyCartModule","regression"})
		  public void TC_ShoppingCart_016_emptyCartFunctionality() throws Exception
		  {
			  		
			  mycartModule.TC_ShoppingCart_016_emptyCartFunctionality();
		  }
		  
		  
//		  @Test(groups={"regression"})
//		  public void TS_ShoppingCart_001_TC_ShoppingCart_017_HGH_collapseViewAndExpandView() throws Exception
//		  {
//			  throw new SkipException("this feature is not present in the application");
//		  }
		  
		  
		  @Test(alwaysRun=true,groups={"MyCartModule","regression"},enabled=false)
		  public void TC_ShoppingCart_018_sortByDropdownListValues() throws Exception
		  {
			  mycartModule.TC_ShoppingCart_018_sortByDropdownListValues();
		  }
		  
		  @Test(alwaysRun=true,groups={"MyCartModule","smoke","regression"})
		  public void TC_ShoppingCart_002_TC_ShoppingCart_019_TC_ShoppingCart_020_TC_ShoppingCart_021_signedUserAddingItemToCart() throws Exception
		  {
			  mycartModule.TC_ShoppingCart_002_TC_ShoppingCart_019_TC_ShoppingCart_020_TC_ShoppingCart_021_signedUserAddingItemToCart();
		}
		  
		  @Test(alwaysRun=true,groups={"MyCartModule","regression"})
		  public void TS_ShoppingCart_001_TC_ShoppingCart_001_guestUserAddingItemToCart() throws Exception
		  {
			  mycartModule.TS_ShoppingCart_001_TC_ShoppingCart_001_guestUserAddingItemToCart();
		  }
		  
		  @Test(alwaysRun=true,groups={"MyCartModule","regression"})
		  public void TC_ShoppingCart_003_signedUser_ShoppingCartQuanitityUpdateCartButton() throws Exception
		  {

			  mycartModule.TC_ShoppingCart_003_signedUser_ShoppingCartQuanitityUpdateCartButton();
		  }
		  
		  @Test(alwaysRun=true,groups={"MyCartModule","regression"},enabled = false)
		  public void TC_ShoppingCart_004_signedUser_ShoppingCartQuanitityUpdateWithZero() throws Exception
		  {
			  mycartModule.TC_ShoppingCart_004_signedUser_ShoppingCartQuanitityUpdateWithZero();
		  }
		  
		  
		  @Test(alwaysRun=true,groups={"MyCartModule","regression"})
		  public void TC_ShoppingCart_005_signedUser_ShoppingCartDeleteToolTip() throws Exception
		  {
			  mycartModule.TC_ShoppingCart_005_signedUser_ShoppingCartDeleteToolTip();
		  }
		  
		  @Test(alwaysRun=true,groups={"MyCartModule","regression"})
		  public void TC_ShoppingCart_006_signedUser_DeleteLinkForDeletingTheItem() throws Exception
		  {
			  mycartModule.TC_ShoppingCart_006_signedUser_DeleteLinkForDeletingTheItem();
		  }
		  
		  
		  @Test(alwaysRun=true,groups={"MyCartModule","regression"})
		  public void TC_ShoppingCart_007_signedUser_CancellingOfDeletingTheItemThroughDeleteLink() throws Exception
		  {
			  mycartModule.TC_ShoppingCart_007_signedUser_CancellingOfDeletingTheItemThroughDeleteLink();
		  }
		  
		  @Test(alwaysRun=true,groups={"MyCartModule","regression"})
		  public void TC_ShoppingCart_008_signedUser_clickOnImageNavigateBackToPDP() throws Exception
		  {
			  mycartModule.TC_ShoppingCart_008_signedUser_clickOnImageNavigateBackToPDP();
		  }
		  
		  
		  @Test(alwaysRun=true,groups={"MyCartModule","regression"})
		  public void TC_ShoppingCart_010_signedUser_verifyContinueShoppingButton() throws Exception
		  {
			  mycartModule.TC_ShoppingCart_010_signedUser_verifyContinueShoppingButton();

		  }
		  
		  @Test(alwaysRun=true,groups={"MyCartModule","regression"})
		  public void TC_ShoppingCart_008_signedUser_clickOnProductName() throws Exception
		  {
			  mycartModule.TC_ShoppingCart_008_signedUser_clickOnProductName();
		  }


			 @Test(alwaysRun=true,groups={"PDPModule","regression"})
			  public void TC_PDP_001_TC_PDP_003_TC_PDP_013_TC_PDP_014_unsignedUser_verifyProductDetailsPageTest() throws Exception
			  {
			  	pdpModule.TC_PDP_001_TC_PDP_003_TC_PDP_013_TC_PDP_014_unsignedUser_verifyProductDetailsPageTest();
			  }

			  @Test(alwaysRun=true,groups={"smoke","regression"})
			  public void TC_PD_002_TC_PD_004_signedUser_verifyProductDetailsPageTest() throws Exception
			  {
			  	pdpModule.TC_PD_002_TC_PD_004_signedUser_verifyProductDetailsPageTest();
			  }


			  @Test(alwaysRun=true,groups={"PDPModule","regression"})
			  public void TC_PDP_006_enlargeImageFunctionalityTest() throws Exception
			  	{
			  	pdpModule.TC_PDP_006_enlargeImageFunctionalityTest();
			  	}


			  @Test(enabled=false,groups={"PDPModule","regression"})
			  public void TC_PDP_008_PrintFunctionalityTest(){
				  pdpModule.TC_PDP_008_PrintFunctionalityTest();
			  }


			  @Test(enabled=false,groups={"PDPModule","regression"})
			  public void TC_PDP_009_TC_PDP_010_ShareFunctionalityTest(){
			  	pdpModule.TC_PDP_009_TC_PDP_010_ShareFunctionalityTest();
			  }

			  @Test(alwaysRun=true,groups={"PDPModule","smoke","regression"})
			  public void TC_PDP_012_signedUser_createAndDeleteCPNInProductDetailsPageTest() throws Exception{
			  	pdpModule.TC_PDP_012_signedUser_createAndDeleteCPNInProductDetailsPageTest();
			  	}


			  @Test(groups={"PDPModule","smoke","regression"},enabled=false)
			  public void TC_PDP_013_signedUser_tryingToCreateCPNInProductDetailsPage_ErrorScenariosTest() throws Exception{
			  	pdpModule.TC_PDP_013_signedUser_tryingToCreateCPNInProductDetailsPage_ErrorScenariosTest();
			  	}
			  
			  @Test(alwaysRun=true,groups={"PDPModule","smoke","regression"})
				public void TC_PDP_011_signedUser_createAndDeleteMyProductGroupInProductDetailsPage() throws Exception{
				pdpModule.TC_PDP_011_signedUser_createAndDeleteMyProductGroupInProductDetailsPage();
				}
				
			  
			  @Test(alwaysRun=true,groups={"PDPModule","smoke","regression"})
			  public void tc005_ListViewGridView() throws Exception
			  {
				 pdpModule.tc005_ListViewGridView();
			  }
			
			  
			  @Test(alwaysRun=true,groups={"PDPModule","smoke","regression"})
			  public void tc006_verifyProductListPage() throws Exception
			  {
				  pdpModule.tc006_verifyProductListPage();
			  }
			  
			  @Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
			  public void TC_Brand_001_unsignedUser_hoverOverBrandsLinkInTopNavigationMenu() throws Exception
			  {
				  	shopByBrandsModule.TC_Brand_001_unsignedUser_hoverOverBrandsLinkInTopNavigationMenu();
						
			}
			
			@Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
			  public void TC_Brand_001_signedUser_hoverOverBrandsLinkInTopNavigationMenu() throws Exception
			  {
				  		
				shopByBrandsModule.TC_Brand_001_signedUser_hoverOverBrandsLinkInTopNavigationMenu();
						
			}
			
			@Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
			  public void TC_Brand_002_TC_Brand_010_unsignedUser_clickOnOneOfTheBrandLinksAndVerifyAssertThePageForTheParticularBrand() throws Exception
			  {
				shopByBrandsModule.TC_Brand_002_TC_Brand_010_unsignedUser_clickOnOneOfTheBrandLinksAndVerifyAssertThePageForTheParticularBrand();
						
			}
			
			@Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
			  public void TC_Brand_002_TC_Brand_010_signedUser_hoverOverBrandsLinkInTopNavigationMenu_clickOnOneOfTheBrandLinksAndVerifyAssertThePageForTheParticularBrand() throws Exception
			  {
				
				shopByBrandsModule.TC_Brand_002_TC_Brand_010_signedUser_hoverOverBrandsLinkInTopNavigationMenu_clickOnOneOfTheBrandLinksAndVerifyAssertThePageForTheParticularBrand();
			}
			
			@Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
			  public void TC_Brand_003_unsignedUser_clickingViewAllBrandsLinkShouldNavigateToShopByBrandsPage() throws Exception
			  {
				
				shopByBrandsModule.TC_Brand_003_unsignedUser_clickingViewAllBrandsLinkShouldNavigateToShopByBrandsPage();
			}
			
			@Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
			  public void TC_Brand_003_signedUser_clickingViewAllBrandsLinkShouldNavigateToShopByBrandsPage() throws Exception
			  {
				shopByBrandsModule.TC_Brand_003_signedUser_clickingViewAllBrandsLinkShouldNavigateToShopByBrandsPage();
			}
			
			@Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
			  public void TC_Brand_004_TC_Brand_007_TC_Brand_008_TC_Brand_009_unsignedUser_clickingBrandsLinkShouldNavigateToShopByBrandsPage() throws Exception
			  {
				
				shopByBrandsModule.TC_Brand_004_TC_Brand_007_TC_Brand_008_TC_Brand_009_unsignedUser_clickingBrandsLinkShouldNavigateToShopByBrandsPage();
			}
			
			
			@Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
			  public void TC_Brand_004_TC_Brand_007_TC_Brand_008_TC_Brand_009_signedUser_clickingBrandsLinkShouldNavigateToShopByBrandsPage() throws Exception
			  {
				
				shopByBrandsModule.TC_Brand_004_TC_Brand_007_TC_Brand_008_TC_Brand_009_signedUser_clickingBrandsLinkShouldNavigateToShopByBrandsPage();
			}
			
			@Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
			  public void TC_Brand_005_unsignedUser_verificationOfBrandsFirstLetterLink() throws Exception
			  {
				shopByBrandsModule.TC_Brand_005_unsignedUser_verificationOfBrandsFirstLetterLink();
			}
			
			@Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
			  public void TC_Brand_005_signedUser_verificationOfBrandsFirstLetterLink() throws Exception
			  {
				shopByBrandsModule.TC_Brand_005_signedUser_verificationOfBrandsFirstLetterLink();
			}
			
			@Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
			  public void TC_Brand_006_unsignedUser_verificationOfBrandAfterClickingOnAnyBrandNameDisplayedInList_OnlyOneProduct() throws Exception
			  {
				shopByBrandsModule.TC_Brand_006_unsignedUser_verificationOfBrandAfterClickingOnAnyBrandNameDisplayedInList_OnlyOneProduct();
			
			}
			
			@Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
			  public void TC_Brand_006_signedUser_verificationOfBrandAfterClickingOnAnyBrandNameDisplayedInList_OnlyOneProduct() throws Exception
			  {
				shopByBrandsModule.TC_Brand_006_signedUser_verificationOfBrandAfterClickingOnAnyBrandNameDisplayedInList_OnlyOneProduct();
			}
			
			@Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
			  public void TC_Brand_006_unsignedUser_verificationOfBrandAfterClickingOnAnyBrandNameDisplayedInList_MultipleProducts() throws Exception
			  {
				shopByBrandsModule.TC_Brand_006_unsignedUser_verificationOfBrandAfterClickingOnAnyBrandNameDisplayedInList_MultipleProducts();
			}
			
			@Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
			  public void TC_Brand_006_signedUser_verificationOfBrandAfterClickingOnAnyBrandNameDisplayedInList_MultipleProducts() throws Exception
			  {
				shopByBrandsModule.TC_Brand_006_signedUser_verificationOfBrandAfterClickingOnAnyBrandNameDisplayedInList_MultipleProducts();
			}
			

			@Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
			  public void TC_Manufacturers_001_unsignedUser_hoverOverManufacturersLinkInTopNavigationMenu() throws Exception
			  {
				shopByManufacturersModule.TC_Manufacturers_001_unsignedUser_hoverOverManufacturersLinkInTopNavigationMenu();
			}
			
			@Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
			  public void TC_Manufacturers_001_signedUser_hoverOverManufacturersLinkInTopNavigationMenu() throws Exception
			  {
				shopByManufacturersModule.TC_Manufacturers_001_signedUser_hoverOverManufacturersLinkInTopNavigationMenu();
			}
			
			@Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
			  public void TC_Manufacturers_002_TC_Manufacturers_010_unsignedUser_hoverOverManufacturersLinkInTopNavigationMenu_clickOnOneOfTheBrandLinksAndVerifyAssertThePage() throws Exception
			  {
				shopByManufacturersModule.TC_Manufacturers_002_TC_Manufacturers_010_unsignedUser_hoverOverManufacturersLinkInTopNavigationMenu_clickOnOneOfTheBrandLinksAndVerifyAssertThePage();
						
			}
			
			@Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
			  public void TC_Manufacturers_002_TC_Manufacturers_010_signedUser_hoverOverManufacturersLinkInTopNavigationMenu_clickOnOneOfTheBrandLinksAndVerifyAssertThePage() throws Exception
			  {
				shopByManufacturersModule.TC_Manufacturers_002_TC_Manufacturers_010_signedUser_hoverOverManufacturersLinkInTopNavigationMenu_clickOnOneOfTheBrandLinksAndVerifyAssertThePage();
						
			}
			
			@Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
			  public void TC_Manufacturers_003_unsignedUser_clickingViewAllManufacturersLinkShouldNavigateToShopByBrandsPage() throws Exception
			  {
				
				shopByManufacturersModule.TC_Manufacturers_003_unsignedUser_clickingViewAllManufacturersLinkShouldNavigateToShopByBrandsPage();
			}
			
			@Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
			  public void TC_Manufacturers_003_signedUser_clickingViewAllManufacturersLinkShouldNavigateToShopByBrandsPage() throws Exception
			  {
				shopByManufacturersModule.TC_Manufacturers_003_signedUser_clickingViewAllManufacturersLinkShouldNavigateToShopByBrandsPage();
			}
			
			@Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
			  public void TC_Manufacturers_004_TC_Manufacturers_007_TC_Manufacturers_008_TC_Manufacturers_009_unsignedUser_clickingManufacturersLinkShouldNavigateToShopByBrandsPage() throws Exception
			  {
				
				shopByManufacturersModule.TC_Manufacturers_004_TC_Manufacturers_007_TC_Manufacturers_008_TC_Manufacturers_009_unsignedUser_clickingManufacturersLinkShouldNavigateToShopByBrandsPage();
			}
			
			
			@Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
			  public void TC_Manufacturers_004_TC_Manufacturers_007_TC_Manufacturers_008_TC_Manufacturers_009_signedUser_clickingManufacturersLinkShouldNavigateToShopByBrandsPage() throws Exception
			  {
			
				shopByManufacturersModule.TC_Manufacturers_004_TC_Manufacturers_007_TC_Manufacturers_008_TC_Manufacturers_009_signedUser_clickingManufacturersLinkShouldNavigateToShopByBrandsPage();
			}
			
			@Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
			  public void TC_Manufacturers_005_unsignedUser_verificationOfManufacturersFirstLetterLink() throws Exception
			  {
				shopByManufacturersModule.TC_Manufacturers_005_unsignedUser_verificationOfManufacturersFirstLetterLink();
			}
			
			@Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
			  public void TC_Manufacturers_005_signedUser_verificationOfManufacturersFirstLetterLink() throws Exception
			  {
				shopByManufacturersModule.TC_Manufacturers_005_signedUser_verificationOfManufacturersFirstLetterLink();
			}
			
			
			@Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
			  public void TC_Manufacturers_006_unsignedUser_verificationOfManufacturersAfterClickingOnAnyManufacturersNameDisplayedInList_onlyOneProduct() throws Exception
			  {
				shopByManufacturersModule.TC_Manufacturers_005_signedUser_verificationOfManufacturersFirstLetterLink();
				
			}
			
			
			@Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
			  public void TC_Manufacturers_006_signedUser_verificationOfManufacturersAfterClickingOnAnyManufacturersNameDisplayedInList_onlyOneProduct() throws Exception
			  {
				shopByManufacturersModule.TC_Manufacturers_005_signedUser_verificationOfManufacturersFirstLetterLink();
			  }
			
			@Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
			  public void TC_Manufacturers_006_unsignedUser_verificationOfManufacturersAfterClickingOnAnyManufacturersNameDisplayedInList_ThatHaveMultipleProducts() throws Exception
			  {
				shopByManufacturersModule.TC_Manufacturers_006_unsignedUser_verificationOfManufacturersAfterClickingOnAnyManufacturersNameDisplayedInList_ThatHaveMultipleProducts();
			}
			
			@Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
			  public void TC_Manufacturers_006_signedUser_verificationOfManufacturersAfterClickingOnAnyManufacturersNameDisplayedInList_ThatHaveMultipleProducts() throws Exception
			  {
				shopByManufacturersModule.TC_Manufacturers_006_signedUser_verificationOfManufacturersAfterClickingOnAnyManufacturersNameDisplayedInList_ThatHaveMultipleProducts();
			}
}
