package Tests;




import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import data.ExcelReader;

public class LoginTest extends TestBase {

LoginPage LoginPage1;
HomePage HomePage1;
	
@DataProvider(name="ExceldataReader")
public Object[][] getUserData() throws IOException
{
	ExcelReader er = new ExcelReader();
	return er.getExcelData();
}


@Test(priority=1,dataProvider = "ExceldataReader")
public void loginTest(String username, String password)
{
	LoginPage1 = new LoginPage(driver);
	LoginPage1.Login(username, password);
	HomePage1 = new HomePage(driver);
	switch(username) {
	case "standard_user":
		assertTrue(HomePage1.ProductText.isDisplayed());
		break;
	case "Omar":
		assertTrue(LoginPage1.LoginErrorMsg.getText().toString().contains("Username and password do not match any user in this service"));
		break;
	case "visual_user":
		assertTrue(HomePage1.ProductText.isDisplayed());
		break;
	case "performance_glitch_user":
		assertTrue(HomePage1.ProductText.isDisplayed());
		break;
	case "locked_out_user":
		assertTrue(LoginPage1.LoginErrorMsg.getText().toString().contains("Sorry, this user has been locked out."));
		break;
	case "problem_user":
		HomePage1.AddToCart2Btn.click();
		assertTrue(HomePage1.AddToCart2Btn.getText().toString().contains("Add to cart"));
		break;
	case "error_user":
		HomePage1.AddToCart2Btn.click();
		assertTrue(HomePage1.AddToCart2Btn.getText().toString().contains("Add to cart"));
		break;
	default:
	}
}

@Test(priority=2)
public void loginEmpty()
{
	LoginPage1 = new LoginPage(driver);
	LoginPage1.Login("", "");
	assertTrue(LoginPage1.LoginErrorMsg.getText().toString().contains("Username is required"));
}

	
}
