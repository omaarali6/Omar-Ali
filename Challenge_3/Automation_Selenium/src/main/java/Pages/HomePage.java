package Pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
@FindBy(css = "[data-test='add-to-cart-sauce-labs-bolt-t-shirt']")
public WebElement AddToCart2Btn;

@FindBy(css = "span.title")
public WebElement ProductText;




}
