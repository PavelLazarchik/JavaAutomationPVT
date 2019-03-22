package pvt_course;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectCity 
{
	@FindBy(xpath = ".//input[@id=\"ss\"]")
	private WebElement selectCityField;
	
	@FindBy(xpath = ".//button[@class=\"sb-searchbox__button  \"]")
	private WebElement searchButton;
	
	public SelectCity(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void fillInCity(String city) {
		enterText(selectCityField, city);
	}
	
	public void enterText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}
	
	public void clickSearchButton() {
		searchButton.click();
	}
	
	
}
