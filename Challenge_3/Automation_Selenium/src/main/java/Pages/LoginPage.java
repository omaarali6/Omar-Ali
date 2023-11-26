package Pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
		driver.navigate().to("https://www.saucedemo.com/");
	}
	
@FindBy(css = "[data-test='username']")
WebElement UsernameTextBox;

@FindBy(id = "password")
WebElement PassTextBox;

@FindBy(css = "input.submit-button.btn_action")
WebElement LoginBtn;

@FindBy(css = "[data-test='error']")
public WebElement LoginErrorMsg;


public void Login(String username, String password)
{
	
	fillTextBox(UsernameTextBox, username);
	fillTextBox(PassTextBox, password);
	clickBtn(LoginBtn);
	
}

}
