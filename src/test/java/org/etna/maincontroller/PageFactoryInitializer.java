package org.etna.maincontroller;

import org.etna.customer.pageobjects.AddNewCreditCardPageObjects;
import org.etna.customer.pageobjects.AddNewPurchasingAgentPageObjects;
import org.etna.customer.pageobjects.CheckoutPageObjects;
import org.etna.customer.pageobjects.CheckoutWithCreditCardPageObjects;
import org.etna.customer.pageobjects.ComparePageObjects;
import org.etna.customer.pageobjects.ConfirmOrderPageObjects;
import org.etna.customer.pageobjects.DropdownShoppingCartPageObjects;
import org.etna.customer.pageobjects.ForgotPasswordPageObjects;
import org.etna.customer.pageobjects.HomePageObjects;
import org.etna.customer.pageobjects.LoginPopUpPageObjects;
import org.etna.customer.pageobjects.MyAccountsPageObjects;
import org.etna.customer.pageobjects.MyCartPageObjects;
import org.etna.customer.pageobjects.MyProductGroupsPageObjects;
import org.etna.customer.pageobjects.OrderConfirmationPageObjects;
import org.etna.customer.pageobjects.ProductPageObjects;
import org.etna.customer.pageobjects.ProductsDetailsPageObjects;
import org.etna.customer.pageobjects.ProductsListPageObjects;
import org.etna.customer.pageobjects.RegistrationPageObjects;
import org.etna.customer.pageobjects.SaveCartPageObjects;
import org.etna.customer.pageobjects.ShopByBrandsPageObjects;
import org.etna.customer.pageobjects.ShopByManufacturersPageObjects;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryInitializer extends MainController{

	public HomePageObjects homePage()
	{
		HomePageObjects homePage = PageFactory.initElements(driver,HomePageObjects.class);
		return homePage;
	}

	public RegistrationPageObjects registrationPage()
	{
		RegistrationPageObjects registrationPage = PageFactory.initElements(driver,RegistrationPageObjects.class);
		return registrationPage;
	}

	public MyAccountsPageObjects myAccountsPage()
	{
		MyAccountsPageObjects myAccountsPage = PageFactory.initElements(driver,MyAccountsPageObjects.class);
		return myAccountsPage;
	}

	public ProductsDetailsPageObjects productDetailsPage()
	{
		ProductsDetailsPageObjects productDetailsPage = PageFactory.initElements(driver,ProductsDetailsPageObjects.class);
		return productDetailsPage;
	}

	public ProductsListPageObjects productListPage()
	{
		ProductsListPageObjects productListPage = PageFactory.initElements(driver,ProductsListPageObjects.class);
		return productListPage;
	}



	public MyCartPageObjects myCartPage()
	{
		MyCartPageObjects shoppingCartPage = PageFactory.initElements(driver,MyCartPageObjects.class);
		return shoppingCartPage;
	}


	public ForgotPasswordPageObjects forgotPasswordPage()
	{
		ForgotPasswordPageObjects forgotPasswordPage = PageFactory.initElements(driver,ForgotPasswordPageObjects.class);
		return forgotPasswordPage;
	}



	public LoginPopUpPageObjects loginPopUp()
	{
		LoginPopUpPageObjects loginPopUp = PageFactory.initElements(driver,LoginPopUpPageObjects.class);
		return loginPopUp;
	}

	public CheckoutPageObjects checkoutPage()
	{
		CheckoutPageObjects checkoutPage = PageFactory.initElements(driver,CheckoutPageObjects.class);
		return checkoutPage;
	}

	public CheckoutWithCreditCardPageObjects checkoutWithCreditCardPage()
	{
		CheckoutWithCreditCardPageObjects creditCardPage = PageFactory.initElements(driver,CheckoutWithCreditCardPageObjects.class);
		return creditCardPage;
	}

	public AddNewCreditCardPageObjects addNewCreditCardPage()
	{
		AddNewCreditCardPageObjects addNewCreditCardPage = PageFactory.initElements(driver,AddNewCreditCardPageObjects.class);
		return addNewCreditCardPage;
	}

	public ConfirmOrderPageObjects confirmOrderPage()
	{
		ConfirmOrderPageObjects confirmOrderPage = PageFactory.initElements(driver,ConfirmOrderPageObjects.class);
		return confirmOrderPage;
	}

	public OrderConfirmationPageObjects orderConfirmationPage()
	{
		OrderConfirmationPageObjects orderConfirmationPage = PageFactory.initElements(driver,OrderConfirmationPageObjects.class);
		return orderConfirmationPage;
	}


	public ComparePageObjects comparePage()
	{
		ComparePageObjects comparePage = PageFactory.initElements(driver,ComparePageObjects.class);
		return comparePage;
	}


	public DropdownShoppingCartPageObjects dropdownShoppingCart()
	{
		DropdownShoppingCartPageObjects dropdownShoppingCart = PageFactory.initElements(driver,DropdownShoppingCartPageObjects.class);
		return dropdownShoppingCart;
	}

	public MyProductGroupsPageObjects myProductGroupsPage(){
		MyProductGroupsPageObjects myProductGroupsPage = PageFactory.initElements(driver,MyProductGroupsPageObjects.class);
		return myProductGroupsPage;
	}

	public ShopByBrandsPageObjects shopByBrandsPage()
	{
		ShopByBrandsPageObjects shopByBrandsPage = PageFactory.initElements(driver,ShopByBrandsPageObjects.class);
		return shopByBrandsPage;
	}

	public ShopByManufacturersPageObjects shopByManufacturersPage()
	{
		ShopByManufacturersPageObjects shopByManufacturersPage = PageFactory.initElements(driver,ShopByManufacturersPageObjects.class);
		return shopByManufacturersPage;
	}

	public AddNewPurchasingAgentPageObjects addNewPurchasingAgentPage()
	{
		AddNewPurchasingAgentPageObjects addNewPurchasingAgentPage = PageFactory.initElements(driver,AddNewPurchasingAgentPageObjects.class);
		return addNewPurchasingAgentPage;
	}


	public ProductPageObjects productsPage()
	{
		ProductPageObjects productsPage = PageFactory.initElements(driver,ProductPageObjects.class);
		return productsPage;
	}


	public SaveCartPageObjects saveCartPage()
	{
		SaveCartPageObjects saveCartPage = PageFactory.initElements(driver,SaveCartPageObjects.class);
		return saveCartPage;
	}
	
}
