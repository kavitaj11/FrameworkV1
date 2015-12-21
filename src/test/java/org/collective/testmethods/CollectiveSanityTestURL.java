package org.collective.testmethods;

import org.collective.utils.ApplicationSetUp;
import org.collective.utils.SearchData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;

public class CollectiveSanityTestURL {

	
	@BeforeClass
	public void init(){
		ApplicationSetUp applicationSetUp = new ApplicationSetUp();
		RestAssured.baseURI=applicationSetUp.getURL();
	}
	
	@Test
	public void tc001_TestGetRequest_Men_Clothing_5_Pkt_Non_Denim_Jean()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Men_Clothing_5_Pkt_Non_Denim_Jean())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc002_TestGetRequest_Men_Clothing_5_Pkt_Denim_Jeans()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Men_Clothing_5_Pkt_Denim_Jeans())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc003_TestGetRequest_Men_Clothing_Casual_Jacket()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Men_Clothing_Casual_Jacket())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc004_TestGetRequest_Men_Clothing_Casual_Shirt()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Men_Clothing_Casual_Shirt())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc005_TestGetRequest_Men_Clothing_Dress_Shirts()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Men_Clothing_Dress_Shirts())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc006_TestGetRequest_Men_Clothing_Formal_Trousers()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Men_Clothing_Formal_Trousers())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc007_TestGetRequest_Men_Clothing_Pocket_Squares()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Men_Clothing_Pocket_Squares())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc008_TestGetRequest_Men_Clothing_Rugby()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Men_Clothing_Rugby())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc009_TestGetRequest_Men_Clothing_Semi_Formal_Jacket()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Men_Clothing_Semi_Formal_Jacket())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc010_TestGetRequest_Men_Clothing_Suits()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Men_Clothing_Suits())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc011_TestGetRequest_Men_Clothing_Swimshorts()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Men_Clothing_Swimshorts())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc012_TestGetRequest_Men_Clothing_Tshirt()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Men_Clothing_Tshirt())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc013_TestGetRequest_Men_Clothing_Trackpant()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Men_Clothing_Trackpant())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void testGetRequest_Men_Clothing_Waistcoat()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Men_Clothing_Waistcoat())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc014_TestGetRequest_Men_Clothing_CasualBlazer()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Men_Clothing_CasualBlazer())
		.then()
		.statusCode(200);
	}
	
	
	@Test
	public void tc015_TestGetRequest_Men_Clothing_CasualOutwear()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Men_Clothing_CasualOutwear())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc016_TestGetRequest_Men_Clothing_CasualTrouser()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Men_Clothing_CasualTrouser())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc017_TestGetRequest_Men_Clothing_FormalJacket()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Men_Clothing_FormalJacket())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc018_TestGetRequest_Men_Clothing_Knitwear()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Men_Clothing_Knitwear())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc019_TestGetRequest_Men_Clothing_Polo()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Men_Clothing_Polo())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc020_TestGetRequest_Men_Clothing_Scarves()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Men_Clothing_Scarves())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc021_TestGetRequest_Men_Clothing_Shorts()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Men_Clothing_Shorts())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc022_TestGetRequest_Men_Clothing_Sweatshirt()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Men_Clothing_Sweatshirt())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc023_TestGetRequest_Men_Clothing_Sweater()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Men_Clothing_Sweater())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc024_TestGetRequest_Men_Clothing_Ties()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Men_Clothing_Ties())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc025_TestGetRequest_Men_Clothing_Tracktop()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Men_Clothing_Tracktop())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc025_TestGetRequest_Women_Clothing_5_Pkt_Non_Denim_Jean()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Women_Clothing_5_Pkt_Non_Denim_Jean())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc026_TestGetRequest_Women_Clothing_5_Pkt_Denim_Jeans()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Women_Clothing_5_Pkt_Denim_Jeans())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc027_TestGetRequest_Women_Clothing_Casual_Jacket()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Women_Clothing_Casual_Jacket())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void testGetRequest_Women_Clothing_Casual_Shirt()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Women_Clothing_Casual_Shirt())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc028_TestGetRequest_Women_Clothing_Dresses()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Women_Clothing_Dresses())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc029_TestGetRequest_Women_Clothing_Formal_Trousers()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Women_Clothing_Formal_Trousers())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc030_TestGetRequest_Women_Clothing_CasualOuterWear()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Women_Clothing_CasualOuterWear())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc031_TestGetRequest_Women_Clothing_Skirt()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Women_Clothing_Skirt())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc032_TestGetRequest_Women_Clothing_Jump_Suit()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Women_Clothing_Jump_Suit())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc033_TestGetRequest_Women_Clothing_Tops()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Women_Clothing_Tops())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc034_TestGetRequest_Women_Clothing_Tshirt()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Women_Clothing_Tshirt())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc035_TestGetRequest_Women_Clothing_CasualTrouser()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Women_Clothing_CasualTrouser())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc036_TestGetRequest_Women_Clothing_FormalJacket()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Women_Clothing_FormalJacket())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc037_TestGetRequest_Women_Clothing_Knitwear()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Women_Clothing_Knitwear())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc038_TestGetRequest_Women_Clothing_Polo()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Women_Clothing_Polo())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc039_TestGetRequest_Women_Clothing_Scarves()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Women_Clothing_Scarves())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc040_TestGetRequest_Women_Clothing_Shorts()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Women_Clothing_Shorts())
		.then()
		.statusCode(200);
	}
	
	@Test
	public void tc041_TestGetRequest_Women_Clothing_Sweatshirt()
	{
		SearchData data = new SearchData();
		RestAssured
		.when()
		.get(data.get_Women_Clothing_Sweatshirt())
		.then()
		.statusCode(200);
	}
	
}
