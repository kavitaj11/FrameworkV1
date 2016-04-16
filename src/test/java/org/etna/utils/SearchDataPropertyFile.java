package org.etna.utils;

import org.etna.maincontroller.MainController;

public class SearchDataPropertyFile extends MainController{

	private int numberOfCheckboxesToBeClicked;

	private int numberOfItemsPerPage;
	
	private String userName = PropertyFileReader.propertiesReader(searchData, "userName");
	
	private String password = PropertyFileReader.propertiesReader(searchData, "password");
	
	private String searchText = PropertyFileReader.propertiesReader(searchData, "searchText.generalSearch");
	
	private String groupName = PropertyFileReader.propertiesReader(searchData, "groupName");
	
	private String saveCartName = PropertyFileReader.propertiesReader(searchData, "saveCartName");
	
	private String quantityForShoppingCart = PropertyFileReader.propertiesReader(searchData, "quantity.shoppingCartPage");
	
	private String nameOfShoppingCartButtons = PropertyFileReader.propertiesReader(searchData, "nameOfShoppingCartButtons");
	
	private String footerHeadings = PropertyFileReader.propertiesReader(searchData, "footerHeadings");
	
	private String taxonomies = PropertyFileReader.propertiesReader(searchData, "taxonomies");
	
	private String fileUploadPath = PropertyFileReader.propertiesReader(searchData, "fileUploadPath");
	
	private String myAccountTabs = PropertyFileReader.propertiesReader(searchData, "myAccountTabs");
	
	private  String phoneNumber = PropertyFileReader.propertiesReader(searchData, "phoneNumber");
	
	private String mpn = PropertyFileReader.propertiesReader(searchData, "MPN");
	
	private String numberOfRowsToEnter = PropertyFileReader.propertiesReader(searchData, "numberOfRowsToEnter");
	
	private String brandNameForRequestQuote = PropertyFileReader.propertiesReader(searchData, "brandNameRequestQuote");
	
	private String quantityForRequestQuote = PropertyFileReader.propertiesReader(searchData, "quantityRequestQuote");
	
	private String commentForRequestQuote = PropertyFileReader.propertiesReader(searchData, "commentsForRequestQuote");
	
	private String loginPageTitle = PropertyFileReader.propertiesReader(searchData, "loginPageTitle");
	
	private String faviconURL = PropertyFileReader.propertiesReader(searchData, "faviconURL");
	
	private String anotherSearchText =PropertyFileReader.propertiesReader(searchData, "searchText.anotherSearch");
	
	private String expectedAlertMessageForComaringMoreThan3Items =PropertyFileReader.propertiesReader(searchData, "expectedAlertMessageForComaringMoreThan3Items");
	
	private String orderConfirmationText = PropertyFileReader.propertiesReader(searchData, "orderConfirmationText");
	
	private String productDetailsTabs = PropertyFileReader.propertiesReader(searchData, "productDetailsTabs");
	
	private String year = PropertyFileReader.propertiesReader(searchData, "year");
	
	private String month = PropertyFileReader.propertiesReader(searchData, "month");
	
	private String cardNumber = PropertyFileReader.propertiesReader(searchData, "cardNumber");
	
	private String welcomeMessageInAddNewCreditCardPage = PropertyFileReader.propertiesReader(searchData, "welcomeMessageInAddNewCreditCardPage");
	
	private String postalCode = PropertyFileReader.propertiesReader(searchData, "postalCode");
	
	private String streetAddress = PropertyFileReader.propertiesReader(searchData, "streetAddress");
	
	private String shoppingCartInstructions = PropertyFileReader.propertiesReader(searchData, "shoppingCartInstructions");
	
	private String cardHolder = PropertyFileReader.propertiesReader(searchData, "cardHolder");
	
	private String nickName = PropertyFileReader.propertiesReader(searchData, "nickName");
	
	private String sortByShoppingCartDropdownValues = PropertyFileReader.propertiesReader(searchData, "sortByShoppingCartDropdownValues");
	
	private String emptyCartText = PropertyFileReader.propertiesReader(searchData, "emptyCartText");
	
	private String forgotYourPasswordInstructions = PropertyFileReader.propertiesReader(searchData, "forgotYourPasswordInstructions");
	
	private String logo = PropertyFileReader.propertiesReader(searchData, "logo");
	
	private String copyRightsOfUnilog = PropertyFileReader.propertiesReader(searchData, "copyRightsOfUnilogText");

	private String carouselImages = PropertyFileReader.propertiesReader(searchData, "carouselImages");
	
	private String mainSectionOptions = PropertyFileReader.propertiesReader(searchData, "mainSectionOptions");
	
	private String allSectionsText = PropertyFileReader.propertiesReader(searchData, "allSectionsText");
	
	private String footerLinksText = PropertyFileReader.propertiesReader(searchData, "allFooterLinksText");
	
	private String expectedSortByOptions = PropertyFileReader.propertiesReader(searchData, "expectedSortByOptions");
	
	private String expectedResultsPerPageOptions = PropertyFileReader.propertiesReader(searchData, "expectedResultsPerPageOptions");
	
	public String getCopyRightsOfUnilogText() {
		return copyRightsOfUnilog;
	}
	
	public int getNumberOfCheckboxesToBeClicked() {
		return numberOfCheckboxesToBeClicked;
	}

	public void setNumberOfCheckboxesToBeClicked(int numberOfCheckboxesToBeClicked) {
		this.numberOfCheckboxesToBeClicked = numberOfCheckboxesToBeClicked;
	}

	
	public String getUserName()    {
		
		return userName;
	}

	public String getPassword()     {
		
		return password;
	}

	public String getSearchText()     {
		
		return searchText;
	}

	public String getGroupName()     {
		
		return groupName;
	}
	
	public String getSaveCartName()    {
		
		return saveCartName;
	}
	
	public String getQuantityForShoppingCartPageVerification()    {
		
		return quantityForShoppingCart;
	}
	
	public String getNameOfShoppingCartButtons()    {
		
		return nameOfShoppingCartButtons;
	}
	
	public String getFooterHeadings()    {
		
		return footerHeadings;
	}

	public String getTaxonomies()     {
		
		return taxonomies;
	}

	public String getFileUploadPath()     {
		
		return fileUploadPath;
	}
	
	public String getMyAccountTabs()    
	{
		
		return myAccountTabs;
	}

	public String getPhoneNumber()     {
		
		return phoneNumber;
	}

	public String getMPN()     {
		
		return mpn;
	}

	public String getNumberOfRowsToEnter()     {
		
		return numberOfRowsToEnter;
	}

	public String getBrandNameForRequestQuote()     {
		
		return brandNameForRequestQuote;
	}

	public String getQunatityForRequestQuote()     {
		
		return quantityForRequestQuote;
	}

	public String getCommentForRequestQuote()  {
		
		return commentForRequestQuote;
	}

	public String getLoginPageTitle(){
		
		return loginPageTitle;
	}

	public String getFaviconURL()  {
		
		return faviconURL;
	}

	public String getShoppingCartInstructions()     {
		
		return shoppingCartInstructions;
	}

	public String getEmptyCartText()     {
		
		return emptyCartText;
	}

	public String getSortByShoppingCartDropdownValues()     {
	
		return sortByShoppingCartDropdownValues;
	}

	public String getNickName()     {
		
		return nickName;
		
	}

	public String getCardHolder()     {
		
		return cardHolder;
	}

	public String getStreetAddress()     {
		
		return streetAddress;
	}

	public String getPostalCode()     {
	
		return postalCode;
	}

	public String welcomeMessageInAddNewCreditCardPage()     {
		
		return welcomeMessageInAddNewCreditCardPage;
	}

	public String getCardNumber()     {
		
		return cardNumber;
	}

	public String getMonth()     {
		
		return month;
	}

	public String getYear()     {
	
		return year;
	}

	public String getProductDetailsTabs()     {
		
		return productDetailsTabs;
	}

	public String getOrderConfirmationText()     {
		
		return orderConfirmationText;
	}
	
	public String expectedAlertMessageForComaringMoreThan3Items()     {
		
		return expectedAlertMessageForComaringMoreThan3Items;
	}
	
	
	public String getAnotherSearchText()     {
		
		return anotherSearchText;
	}

	public String getForgotYourPasswordInstructions() {
		
		return forgotYourPasswordInstructions;
	}

	public String getLogo() {
		
		return logo;
	}

	public String getCarouselImages() {

		return carouselImages;
	}

	public String getMainSectionOptions() {
	
		return mainSectionOptions;
	}

	public String getAllSectionsText() {
		// TODO Auto-generated method stub
		return allSectionsText;
	}

	public String getFooterLinksText() {
		
		return footerLinksText;
	}

	public String getExpectedSortByOptions() {
		
		return expectedSortByOptions;
	}

	public String getExpectedResultsPerPageOptions() {
		
		return expectedResultsPerPageOptions;
	}

	public void setShowItemsPerPage(int numberOfItemsPerPage) {
		
		this.numberOfItemsPerPage = numberOfItemsPerPage;
	}

	public int getShowItemsPerPage() {
		
		return numberOfItemsPerPage;
	}
	
	
}
