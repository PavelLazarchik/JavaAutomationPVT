package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage {

	@FindBy(xpath = ".//span[@class=\"button_create-event__text\"]")
	private WebElement createEventLink;

	@FindBy(xpath = "(.//input[@class=\"textbox-control__input  textbox_default__input \"])[2]")
	private WebElement eventNameField;

	@FindBy(xpath = ".//a[@class=\"button button_size_default button_color_primary event-new__button_submit\"]")
	private WebElement saveButton;

	@FindBy(xpath = ".//input[@name=\"dateStart\"]")
	private WebElement eventDateField;

	public CalendarPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickCreateEventLink() {
		createEventLink.click();
	}

	public void enterText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public void nameEvent(String eventName) {
		eventNameField.click();
		enterText(eventNameField, eventName);
		eventNameField.click();
	}

	public void enterEventDate(String eventDate) {
		eventDateField.click();
		eventDateField.clear();
		enterText(eventDateField, eventDate);
		eventDateField.click();
	}

	public void saveChangesForNewEvent() {
		saveButton.click();
	}

}
