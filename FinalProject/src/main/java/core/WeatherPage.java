package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WeatherPage {

	@FindBy(xpath = ".//input[@type=\"text\"]")
	private WebElement searchCityField;

	@FindBy(xpath = ".//button[@type=\"submit\"]")
	private WebElement searchIcon;

	@FindBy(xpath = ".//a[@href=\"/prognoz/brest_belarus/\"]")
	private WebElement brestLink;

	@FindBy(xpath = "(.//a[@href=\"/prognoz/brest_belarus/14dney/\"])[1]")
	private WebElement twoWeekPeriod;

	public WeatherPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public void searchCity(String city) {
		searchCityField.click();
		enterText(searchCityField, city);
		searchIcon.click();
	}

	public void selectBelarusBrest() {
		brestLink.click();
	}

	public void selectTwoWeekPeriod() {
		twoWeekPeriod.click();
	}

}
