package core;

import java.util.List;

/*
 * 	Part 1 
 * 	1. Перейти на сайт Booking
	2. Ввести в поиск «Москва», выбрать для проживания 2 гостей и 1 номер.
	3. Проверить, что в Москве есть отели на введенные даты
	
	Part 2 
	1. Отфильтровать по рейтингу и выбрать с первым таким и отелем
	2. Проверить, что рейтинг более 9

 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestRoomAvailabilityInMoscow {

	public static void main(String[] args) throws InterruptedException {
		String exePath = "C:\\1\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);

		WebDriver driver = new ChromeDriver();
		// Part 1
		driver.get("https://www.booking.com/");

		// fill in field with city data
		WebElement searchCityField = driver.findElement(By.xpath(".//input[@id=\"ss\"]"));
		searchCityField.clear();
		searchCityField.sendKeys("Moscow");

		WebElement searchButton = driver.findElement(By.xpath(".//button[@class=\"sb-searchbox__button  \"]"));
		searchButton.click();

		WebElement countOfAdults = driver.findElement(By.xpath(".//select[@name=\"group_adults\"]"));
		WebElement countOfRooms = driver.findElement(By.xpath(".//select[@name=\"no_rooms\"]"));

		Select selectCountOfAdult = new Select(countOfAdults);
		selectCountOfAdult.selectByIndex(1);

		Select selectCountOfRooms = new Select(countOfRooms);
		selectCountOfRooms.selectByValue("2");

		// fill in list with number of hotels
		List<WebElement> list = driver.findElements(By.xpath(".//div[@data-et-view=\" eWHJbWPNZWEHXT:5\"]"));

		// check availability of the rooms
		if (list.size() > 0) {
			System.out.println("Rooms are available for  this dates");
		} else if (list.size() == 0) {
			System.out
					.println("There are no rooms for this dates with such parameters. Please try to update parameters");
		}

		// Part 2

		// Filter hotels by 'Top Reviewed' element
		WebElement topReviewed = driver
				.findElement(By.xpath(".//li[@class=\" sort_category   sort_bayesian_review_score \"]"));

		// check the presentation of an element on the page
		if (topReviewed.isDisplayed() == true) {
			topReviewed.click();
		} else {
			// Open more menu to see 'Top Reviewed' element
			WebElement threeDotsMenu = driver.findElement(By.xpath(".//li[@id=\"sortbar_dropdown_container\"]"));
			threeDotsMenu.click();
			topReviewed.click();
		}

		Thread.sleep(3000);

		// Find and open first filtered hotel
		List<WebElement> listOfFilteredHotels = driver
				.findElements(By.xpath(".//a[@class=\" sr_item_photo_link sr_hotel_preview_track  \"]"));
		listOfFilteredHotels.get(0).click();

		// Check hotel rating
		WebElement hotelRating = driver.findElement(By.xpath("(.//div[@class=\"bui-review-score__badge\"])[1]"));
		String rating = hotelRating.getText();
		double ratingDouble = Double.parseDouble(hotelRating.getText());

		if (ratingDouble >= 9) {
			System.out.println("It's a good hotel with rating above 9");
		} else {
			System.out.println("A hotel's rating below 9");
		}

		driver.close();

	}

}
