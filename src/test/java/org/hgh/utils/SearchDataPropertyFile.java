package org.hgh.utils;

import org.hgh.maincontroller.MainController;

public class SearchDataPropertyFile extends MainController{

	private int numberOfCheckboxesToBeClicked;

	public int getNumberOfCheckboxesToBeClicked() {
		return numberOfCheckboxesToBeClicked;
	}

	public void setNumberOfCheckboxesToBeClicked(int numberOfCheckboxesToBeClicked) {
		this.numberOfCheckboxesToBeClicked = numberOfCheckboxesToBeClicked;
	}

	
	public String getUserName() throws Exception{
		String userName = PropertyFileReader.propertiesReader(searchData, "userName");
		return userName;
	}

	public String getPassword() throws Exception {
		String password = PropertyFileReader.propertiesReader(searchData, "password");
		return password;
	}

	public String getSearchText() throws Exception {
		String searchText = PropertyFileReader.propertiesReader(searchData, "searchText.generalSearch");
		return searchText;
	}

	public String getGroupName() throws Exception {
		String groupName = PropertyFileReader.propertiesReader(searchData, "groupName");
		return groupName;
	}
	
	public String getSaveCartName() throws Exception{
		String saveCartName = PropertyFileReader.propertiesReader(searchData, "saveCartName");
		return saveCartName;
	}
	
	public String getQuantityForShoppingCartPageVerification() throws Exception{
		String quantityForShoppingCart = PropertyFileReader.propertiesReader(searchData, "quantity.shoppingCartPage");
		return quantityForShoppingCart;
	}
	
	public String getNameOfShoppingCartButtons() throws Exception{
		String nameOfShoppingCartButtons = PropertyFileReader.propertiesReader(searchData, "nameOfShoppingCartButtons");
		return nameOfShoppingCartButtons;
	}
	
	public String getFooterHeadings() throws Exception{
		String footerHeadings = PropertyFileReader.propertiesReader(searchData, "footerHeadings");
		return footerHeadings;
	}

	public String getTaxonomies() throws Exception {
		String taxonomies = PropertyFileReader.propertiesReader(searchData, "taxonomies");
		return taxonomies;
	}

	public String getFileUploadPath() throws Exception {
		String fileUploadPath = PropertyFileReader.propertiesReader(searchData, "fileUploadPath");
		return fileUploadPath;
	}
	
	public String getMyAccountTabs() throws Exception
	{
		String myAccountTabs = PropertyFileReader.propertiesReader(searchData, "myAccountTabs");
		return myAccountTabs;
	}

	public String getPhoneNumber() throws Exception {
		 String phoneNumber = PropertyFileReader.propertiesReader(searchData, "phoneNumber");
		return phoneNumber;
	}

	public String getMPN() throws Exception {
		String mpn = PropertyFileReader.propertiesReader(searchData, "MPN");
		return mpn;
	}

	public String getNumberOfRowsToEnter() throws Exception {
		String numberOfRowsToEnter = PropertyFileReader.propertiesReader(searchData, "numberOfRowsToEnter");
		return numberOfRowsToEnter;
	}

	public String getBrandNameForRequestQuote() throws Exception {
		String brandNameForRequestQuote = PropertyFileReader.propertiesReader(searchData, "brandNameRequestQuote");
		return brandNameForRequestQuote;
	}

	public String getQunatityForRequestQuote() throws Exception {
		String quantityForRequestQuote = PropertyFileReader.propertiesReader(searchData, "quantityRequestQuote");
		return quantityForRequestQuote;
	}

	public String getCommentForRequestQuote() throws Exception {
		String commentForRequestQuote = PropertyFileReader.propertiesReader(searchData, "commentsForRequestQuote");
		return commentForRequestQuote;
	}

	public String getLoginPageTitle() throws Exception {
		String loginPageTitle = PropertyFileReader.propertiesReader(searchData, "loginPageTitle");
		return loginPageTitle;
	}

	public String faviconURL() throws Exception {
		String faviconURL = PropertyFileReader.propertiesReader(searchData, "faviconURL");
		return faviconURL;
	}

	public String getShoppingCartInstructions() throws Exception {
		String shoppingCartInstructions = PropertyFileReader.propertiesReader(searchData, "shoppingCartInstructions");
		return shoppingCartInstructions;
	}

	public String getEmptyCartText() throws Exception {
		String emptyCartText = PropertyFileReader.propertiesReader(searchData, "emptyCartText");
		return emptyCartText;
	}

	public String getSortByShoppingCartDropdownValues() throws Exception {
		String sortByShoppingCartDropdownValues = PropertyFileReader.propertiesReader(searchData, "sortByShoppingCartDropdownValues");
		return sortByShoppingCartDropdownValues;
	}

	public String getNickName() throws Exception {
		String nickName = PropertyFileReader.propertiesReader(searchData, "nickName");
		return nickName;
		
	}

	public String getCardHolder() throws Exception {
		String cardHolder = PropertyFileReader.propertiesReader(searchData, "cardHolder");
		return cardHolder;
	}

	public String getStreetAddress() throws Exception {
		String streetAddress = PropertyFileReader.propertiesReader(searchData, "streetAddress");
		return streetAddress;
	}

	public String getPostalCode() throws Exception {
		String postalCode = PropertyFileReader.propertiesReader(searchData, "postalCode");
		return postalCode;
	}

	public String welcomeMessageInAddNewCreditCardPage() throws Exception {
		String welcomeMessageInAddNewCreditCardPage = PropertyFileReader.propertiesReader(searchData, "welcomeMessageInAddNewCreditCardPage");
		return welcomeMessageInAddNewCreditCardPage;
	}

	public String getCardNumber() throws Exception {
		String cardNumber = PropertyFileReader.propertiesReader(searchData, "cardNumber");
		return cardNumber;
	}

	public String getMonth() throws Exception {
		String month = PropertyFileReader.propertiesReader(searchData, "month");
		return month;
	}

	public String getYear() throws Exception {
		String year = PropertyFileReader.propertiesReader(searchData, "year");
		return year;
	}

	public String getProductDetailsTabs() throws Exception {
		String productDetailsTabs = PropertyFileReader.propertiesReader(searchData, "productDetailsTabs");
		return productDetailsTabs;
	}

	public String getOrderConfirmationText() throws Exception {
		String orderConfirmationText = PropertyFileReader.propertiesReader(searchData, "orderConfirmationText");
		return orderConfirmationText;
	}
	
	public String expectedAlertMessageForComaringMoreThan3Items() throws Exception {
		String expectedAlertMessageForComaringMoreThan3Items =PropertyFileReader.propertiesReader(searchData, "expectedAlertMessageForComaringMoreThan3Items");
		return expectedAlertMessageForComaringMoreThan3Items;
	}
	
	
	public String getAnotherSearchText() throws Exception {
		String anotherSearchText =PropertyFileReader.propertiesReader(searchData, "searchText.anotherSearch");
		return anotherSearchText;
	}
	
	
}
