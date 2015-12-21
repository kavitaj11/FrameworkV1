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
	
	@Property("Men_Clothing_5_Pkt_Non_Denim_Jean")
	private String Men_Clothing_5_Pkt_Non_Denim_Jean;
	
	@Property("Men_Clothing_5_Pkt_Denim_Jeans")
	private String Men_Clothing_5_Pkt_Denim_Jeans;
	
	@Property("Men_Clothing_Casual_Jacket")
	private String Men_Clothing_Casual_Jacket;
	
	@Property("Men_Clothing_Casual_Shirt")
	private String Men_Clothing_Casual_Shirt;
	
	@Property("Men_Clothing_Dress_Shirts")
	private String Men_Clothing_Dress_Shirts;
	
	@Property("Men_Clothing_Formal_Trousers")
	private String Men_Clothing_Formal_Trousers;
	
	@Property("Men_Clothing_Pocket_Squares")
	private String Men_Clothing_Pocket_Squares;
	
	@Property("Men_Clothing_Rugby")
	private String Men_Clothing_Rugby;
	
	@Property("Men_Clothing_Semi_Formal_Jacket")
	private String Men_Clothing_Semi_Formal_Jacket;
	
	@Property("Men_Clothing_Suits")
	private String Men_Clothing_Suits;
	
	@Property("Men_Clothing_Swimshorts")
	private String Men_Clothing_Swimshorts;
	
	@Property("Men_Clothing_Tshirt")
	private String Men_Clothing_Tshirt;
	
	@Property("Men_Clothing_Trackpant")
	private String Men_Clothing_Trackpant;
	
	@Property("Men_Clothing_Waistcoat")
	private String Men_Clothing_Waistcoat;
	
	@Property("Men_Clothing_CasualBlazer")
	private String Men_Clothing_CasualBlazer;
	
	@Property("Men_Clothing_CasualOutwear")
	private String Men_Clothing_CasualOutwear;
	
	@Property("Men_Clothing_CasualTrouser")
	private String Men_Clothing_CasualTrouser;
	
	@Property("Men_Clothing_FormalJacket")
	private String Men_Clothing_FormalJacket;
	
	@Property("Men_Clothing_Knitwear")
	private String Men_Clothing_Knitwear;
	
	@Property("Men_Clothing_Polo")
	private String Men_Clothing_Polo;
	
	@Property("Men_Clothing_Scarves")
	private String Men_Clothing_Scarves;
	
	@Property("Men_Clothing_Shorts")
	private String Men_Clothing_Shorts;
	
	@Property("Men_Clothing_Sweatshirt")
	private String Men_Clothing_Sweatshirt;
	
	@Property("Men_Clothing_Sweater")
	private String Men_Clothing_Sweater;
	
	@Property("Men_Clothing_Ties")
	private String Men_Clothing_Ties;
	
	@Property("Men_Clothing_Tracktop")
	private String Men_Clothing_Tracktop;
	
	@Property("Women_Clothing_5_Pkt_Denim_Jeans")
	private String Women_Clothing_5_Pkt_Denim_Jeans;
	
	@Property("Women_Clothing_5_Pkt_Non_Denim_Jean")
	private String Women_Clothing_5_Pkt_Non_Denim_Jean;
	
	@Property("Women_Clothing_Casual_Jacket")
	private String Women_Clothing_Casual_Jacket;
	
	@Property("Women_Clothing_Casual_Shirt")
	private String Women_Clothing_Casual_Shirt;
	
	@Property("Women_Clothing_Dresses")
	private String Women_Clothing_Dresses;
	
	@Property("Women_Clothing_Formal_Trousers")
	private String Women_Clothing_Formal_Trousers;
	
	@Property("Women_Clothing_CasualOuterWear")
	private String Women_Clothing_CasualOuterWear;
	
	@Property("Women_Clothing_Skirt")
	private String Women_Clothing_Skirt;
	
	@Property("Women_Clothing_Jump_Suit")
	private String Women_Clothing_Jump_Suit;
	
	@Property("Women_Clothing_Tops")
	private String Women_Clothing_Tops;
	
	@Property("Women_Clothing_Tshirt")
	private String Women_Clothing_Tshirt;
	
	@Property("Women_Clothing_CasualTrouser")
	private String Women_Clothing_CasualTrouser;
	
	@Property("Women_Clothing_FormalJacket")
	private String Women_Clothing_FormalJacket;
	
	@Property("Women_Clothing_Knitwear")
	private String Women_Clothing_Knitwear;
	
	@Property("Women_Clothing_Polo")
	private String Women_Clothing_Polo;
	
	@Property("Women_Clothing_Scarves")
	private String Women_Clothing_Scarves;
	
	@Property("Women_Clothing_Shorts")
	private String Women_Clothing_Shorts;
	
	@Property("Women_Clothing_Sweatshirt")
	private String Women_Clothing_Sweatshirt;
	
	
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
	
	public String get_Men_Clothing_5_Pkt_Non_Denim_Jean() {
		return Men_Clothing_5_Pkt_Non_Denim_Jean;
	}
	
	public String get_Men_Clothing_5_Pkt_Denim_Jeans() {
		return Men_Clothing_5_Pkt_Denim_Jeans;
	}
	
	public String get_Men_Clothing_Casual_Jacket() {
		return Men_Clothing_Casual_Jacket;
	}
	
	public String get_Men_Clothing_Casual_Shirt() {
		return Men_Clothing_Casual_Shirt;
	}
	
	public String get_Men_Clothing_Dress_Shirts() {
		return Men_Clothing_Dress_Shirts;
	}
	
	public String get_Men_Clothing_Formal_Trousers() {
		return Men_Clothing_Formal_Trousers;
	}
	
	public String get_Men_Clothing_Pocket_Squares() {
		return Men_Clothing_Pocket_Squares;
	}
	
	
	public String get_Men_Clothing_Rugby() {
		return Men_Clothing_Rugby;
	}
	
	public String get_Men_Clothing_Semi_Formal_Jacket() {
		return Men_Clothing_Semi_Formal_Jacket;
	}
	
	public String get_Men_Clothing_Suits() {
		return Men_Clothing_Suits;
	}
	
	public String get_Men_Clothing_Swimshorts() {
		return Men_Clothing_Swimshorts;
	}
	
	public String get_Men_Clothing_Tshirt() {
		return Men_Clothing_Tshirt;
	}
	
	public String get_Men_Clothing_Trackpant() {
		return Men_Clothing_Trackpant;
	}
	
	public String get_Men_Clothing_Waistcoat() {
		return Men_Clothing_Waistcoat;
	}
	
	public String get_Men_Clothing_CasualBlazer() {
		return Men_Clothing_CasualBlazer;
	}
	
	public String get_Men_Clothing_CasualOutwear() {
		return Men_Clothing_CasualOutwear;
	}
	
	public String get_Men_Clothing_CasualTrouser() {
		return Men_Clothing_CasualTrouser;
	}
	
	public String get_Men_Clothing_FormalJacket() {
		return Men_Clothing_FormalJacket;
	}
	
	public String get_Men_Clothing_Knitwear() {
		return Men_Clothing_Knitwear;
	}
	
	public String get_Men_Clothing_Polo() {
		return Men_Clothing_Polo;
	}
	
	public String get_Men_Clothing_Scarves() {
		return Men_Clothing_Scarves;
	}
	
	public String get_Men_Clothing_Shorts() {
		return Men_Clothing_Shorts;
	}
	
	public String get_Men_Clothing_Sweatshirt() {
		return Men_Clothing_Sweatshirt;
	}
	
	public String get_Men_Clothing_Sweater() {
		return Men_Clothing_Sweater;
	}
	
	public String get_Men_Clothing_Ties() {
		return Men_Clothing_Ties;
	}
	
	
	public String get_Men_Clothing_Tracktop() {
		return Men_Clothing_Tracktop;
	}
	
	public String get_Women_Clothing_5_Pkt_Denim_Jeans() {
		return Women_Clothing_5_Pkt_Denim_Jeans;
	}
	
	public String get_Women_Clothing_5_Pkt_Non_Denim_Jean() {
		return Women_Clothing_5_Pkt_Non_Denim_Jean;
	}
	
	public String get_Women_Clothing_Casual_Jacket() {
		return Women_Clothing_Casual_Jacket;
	}
	
	public String get_Women_Clothing_Casual_Shirt() {
		return Women_Clothing_Casual_Shirt;
	}
	
	public String get_Women_Clothing_Dresses() {
		return Women_Clothing_Dresses;
	}
	
	public String get_Women_Clothing_Formal_Trousers() {
		return Women_Clothing_Formal_Trousers;
	}
	
	public String get_Women_Clothing_CasualOuterWear() {
		return Women_Clothing_CasualOuterWear;
	}
	
	public String get_Women_Clothing_Skirt() {
		return Women_Clothing_Skirt;
	}
	
	public String get_Women_Clothing_Jump_Suit() {
		return Women_Clothing_Jump_Suit;
	}
	
	public String get_Women_Clothing_Tops() {
		return Women_Clothing_Tops;
	}
	
	public String get_Women_Clothing_Tshirt() {
		return Women_Clothing_Tshirt;
	}
	
	public String get_Women_Clothing_CasualTrouser() {
		return Women_Clothing_CasualTrouser;
	}
	
	public String get_Women_Clothing_FormalJacket() {
		return Women_Clothing_FormalJacket;
	}
	
	public String get_Women_Clothing_Knitwear() {
		return Women_Clothing_Knitwear;
	}
	
	public String get_Women_Clothing_Polo() {
		return Women_Clothing_Polo;
	}
	
	public String get_Women_Clothing_Scarves() {
		return Women_Clothing_Scarves;
	}
	
	public String get_Women_Clothing_Shorts() {
		return Women_Clothing_Shorts;
	}
	
	public String get_Women_Clothing_Sweatshirt() {
		return Women_Clothing_Sweatshirt;
	}	
}
