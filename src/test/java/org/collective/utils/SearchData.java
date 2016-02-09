package org.collective.utils;

import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;


@Resource.Classpath("org/collective/utils/SearchData.properties")
public class SearchData {

	public SearchData() {
		PropertyLoader.populate(this);
	}
	
	@Property("logoutMsg")
	private  String logoutMsg;
	
	@Property("signInPhoneNumber")
	private  String signInPhoneNumber;
	
	@Property("signInPassword")
	private  String signInPassword;
	
	@Property("adminSignInPhoneNumber")
	private  String adminSignInPhoneNumber;
	
	@Property("adminSignInPassword")
	private  String adminSignInPassword;
	
	@Property("cartFirstName")
	private  String cartFirstName;
	
	@Property("cartLastName")
	private  String cartLastName;
	
	@Property("cartStreetAddress")
	private  String cartStreetAddress;
	
	@Property("cartPincode")
	private  String cartPincode;
	
	@Property("cartCity")
	private  String cartCity;
	
	@Property("cartState")
	private  String cartState;
	
	@Property("cartCountry")
	private  String cartCountry;
	
	@Property("cartPhoneNumber")
	private  String cartPhoneNumber;
	
	@Property("orderStatus")
	private  String orderStatus;
	
	@Property("signupUsername")
	private  String signupUsername;
	
	@Property("signupEmail")
	private  String signupEmail;
	
	@Property("signupPassword")
	private  String signupPassword;
	
	@Property("adminPageURL")
	private  String adminPageURL;
	
	@Property("pageURLs")
	private String getURL;
	
	@Property("pageURLsStaging")
	private String pageURLsStaging;
	
	@Property("paginationURL")
	private String paginationURL;
	
	@Property("orderCancellationText")
	private String orderCancellationText;
	
	public String getLogoutMsg() {
		return logoutMsg;
	}	
	
	public String getsignInPhoneNumber() {
		return signInPhoneNumber;
	}
	
	public String getsignInPassword() {
		return signInPassword;
	}
	
	public String getadminSignInPhoneNumber() {
		return adminSignInPhoneNumber;
	}
	
	public String getadminadminSignInPassword() {
		return adminSignInPassword;
	}
	
	
	
	public String getcartFirstName() {
		return cartFirstName;
	}
	
	public String getcartLastName() {
		return cartLastName;
	}
	
	public String getcartStreetAddress() {
		return cartStreetAddress;
	}
	
	public String getcartPincode() {
		return cartPincode;
	}
	
	public String getcartCity() {
		return cartCity;
	}
	
	public String getcartState() {
		return cartState;
	}
   
	public String getcartCountry() {
		return cartCountry;
	}
	
	public String getcartPhoneNumber() {
		return cartPhoneNumber;
	}
	
	public String getorderStatus() {
		return orderStatus;
	}
	
	public String getsignupUsername() {
		return signupUsername;
	}
	
	public String getsignupEmail() {
		return signupEmail;
	}
	
	public String getsignupPassword() {
		return signupPassword;
	}
	
	public String getadminPageURL() {
		return adminPageURL;
	}
	
	public String getPageURLs(){
		return getURL;
	}
	
	public String getPageURLsStaging(){
		return pageURLsStaging;
	}

	public String getPaginationURL() {
		// TODO Auto-generated method stub
		return paginationURL;
	}

public String getOrderCancellationText() {
		
		return orderCancellationText;
	}
}
