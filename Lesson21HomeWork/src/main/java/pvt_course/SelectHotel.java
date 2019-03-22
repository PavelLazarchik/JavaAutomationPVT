package pvt_course;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SelectHotel {

	// Do not forger
	public SelectHotel(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = ".//select[@name=\"group_adults\"]")
	private WebElement countOfAdults;

	@FindBy(xpath = ".//select[@name=\"no_rooms\"]")
	private WebElement countOfRooms;

	@FindBy(xpath = ".//div[@data-et-view=\" eWHJbWPNZWEHXT:5\"]")
	private WebElement listOFHotels;

	@FindBy(xpath = ".//li[@class=\" sort_category   sort_bayesian_review_score \"]")
	private WebElement topReviewed;

	@FindBy(xpath = ".//li[@id=\"sortbar_dropdown_container\"]")
	private WebElement threeDotsMenu;

	@FindBy(xpath = ".//a[@class=\" sr_item_photo_link sr_hotel_preview_track  \"]")
	private List<WebElement> listOfFilteredHotels;

	@FindBy(xpath = "(.//div[@class=\"bui-review-score__badge\"])[1]")
	private WebElement hotelRating;

	@FindBy(xpath = ".//div[@id=\"bodyconstraint\"]")
	private WebElement areaToClickToCloseDatePickers;

	@FindBy(xpath = ".//div[@data-et-view=\"cJaQWPWNEQEDSVWe:1\"]")
	private List<WebElement> listofHotels;

	public void selectNumberOfAdult() {
		Select selectCountOfAdult = new Select(countOfAdults);
		selectCountOfAdult.selectByIndex(1);
	}

	public void selectNumberOfRooms() {
		Select selectCountOfRooms = new Select(countOfRooms);
		selectCountOfRooms.selectByValue("2");
	}

	public void clickToCloseDatePickers() {
		areaToClickToCloseDatePickers.click();
	}

	public void checkIsAnyHotelAvailable() {
		List<WebElement> list = listofHotels;
		if (list.size() > 0) {
			System.out.println("Rooms are available for  this dates");
		} else if (list.size() == 0) {
			System.out
					.println("There are no rooms for this dates with such parameters. Please try to update parameters");
		}
	}

	public void filterByTopReviewed() {
		if (topReviewed.isDisplayed() == true) {
			topReviewed.click();
		} else {
			// Open more menu to see 'Top Reviewed' element
			threeDotsMenu.click();
			topReviewed.click();
		}
	}

	public void clickFirstFilteredHotel() {
		listOfFilteredHotels.get(0).click();
	}

	public void checkHotelRating() {
		double ratingDouble = Double.parseDouble(hotelRating.getText());

		if (ratingDouble >= 9) {
			System.out.println("It's a good hotel with rating above 9");
		} else {
			System.out.println("A hotel's rating below 9");
		}
	}
}
