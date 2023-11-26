package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {


public PageBase(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public static void clickBtn(WebElement button)
{
	button.click();
}

public static void fillTextBox(WebElement TextBox, String text)
{
	TextBox.sendKeys(text);
}




}
