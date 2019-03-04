

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BookingParisTests {

	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		String exePath = "C:\\1\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}


	@Test
	/*
	 * 1. Париж, текущая дата + 3 дня, на 7 дней. 2 взрослых. 2. Отфильтровать самые
	 * дешевые, проверить, что такие отели есть. 3. Выбрать с самым высоким
	 * рейтингом 4. Проверить, что цена не превышает заданный диапазон.
	 */
	public void test1() throws InterruptedException {
		driver.get("https://www.booking.com/");
		// fill in field with city data
		WebElement searchCityField = driver.findElement(By.xpath(".//input[@id=\"ss\"]"));
		searchCityField.clear();
		searchCityField.sendKeys("Paris");

		WebElement searchButton = driver.findElement(By.xpath(".//button[@class=\"sb-searchbox__button  \"]"));
		searchButton.submit();

		Thread.sleep(1500);

		// click on the header to close all datepickers
		WebElement closeAllDatePickers = driver
				.findElement(By.xpath(".//div[@class=\"sr_header  sr_header--reduced\"]"));
		closeAllDatePickers.click();

		Thread.sleep(1500);

		WebElement checkInPresent = driver.findElement(By.xpath(".//div[@data-calendar2-type=\"checkin\"]"));
		checkInPresent.click();

		Thread.sleep(3000);
		WebElement arrivalDate = driver.findElement(By.xpath("(.//td[@data-id=\"1553385600000\"])[1]"));
		arrivalDate.click();

		closeAllDatePickers.click();

		Thread.sleep(1500);
		WebElement checkOutPresent = driver.findElement(By.xpath(".//div[@data-calendar2-type=\"checkout\"]"));
		checkOutPresent.click();

		Thread.sleep(1500);

		WebElement departureDate = driver.findElement(By.xpath("(.//td[@data-id=\"1553990400000\"])[2]"));
		departureDate.click();
		Thread.sleep(1500);

		WebElement countOfAdults = driver.findElement(By.xpath(".//select[@name=\"group_adults\"]"));
		Select selectCountOfAdult = new Select(countOfAdults);
		selectCountOfAdult.selectByIndex(1);

		// click Search button
		WebElement searchButtonCl = driver.findElement(By.xpath(".//button[@data-sb-id=\"main\"]"));
		searchButtonCl.click();

		// select 0 - 120 BYN
		WebElement cheapestHotels = driver
				.findElement(By.xpath("(.//div[@class=\"bui-checkbox__label filter_item css-checkbox\"])[1]"));
		cheapestHotels.click();

		Thread.sleep(1500);
		// 3 dots menu + Top Reviewed
		WebElement select8AndAboveScore = driver.findElement(By.xpath("(.//a[@data-id=\"review_score-80\"])[2]"));
		Actions action = new Actions(driver);
		action.moveToElement(select8AndAboveScore).build().perform();
		Thread.sleep(1500);
		select8AndAboveScore.click();

		// fill in list with number of hotels
		List<WebElement> list = driver.findElements(By.xpath(".//div[@data-et-view=\" eWHJbWPNZWEHXT:5\"]"));

		// check availability of the rooms
		if (list.size() > 0) {
			System.out.println("Rooms are available for  this dates");
		} else if (list.size() == 0) {
			System.out
					.println("There are no rooms for this dates with such parameters. Please try to update parameters");
		}

		Thread.sleep(3000);
		ArrayList<String> ratingValues = new ArrayList<>();
		List<WebElement> scoreValues = driver.findElements(By.xpath(".//div[@class='bui-review-score__badge']"));
		for (WebElement ratings : scoreValues) {
			String abc = ratings.getAttribute("aria-label");
			ratingValues.add(abc);
		}

		Collections.sort(ratingValues);

		WebElement selectTopHotel = driver
				.findElement(By.xpath(".//div[@aria-label='" + ratingValues.get(ratingValues.size() - 1) + "']"));
		selectTopHotel.click();

	}

	@Test
	/*
	 * Париж, текущая дата + 3 дня, на 7 дней. 4 взрослых, 2 номера. Выбрать самый
	 * дешевый из самых дорогих, и проверить, что цена не ниже заданного диапазона.
	 */
	public void test2() throws InterruptedException {
		driver.get("https://www.booking.com/");
		// fill in field with city data
		WebElement searchCityField = driver.findElement(By.xpath(".//input[@id=\"ss\"]"));
		searchCityField.clear();
		searchCityField.sendKeys("Paris");

		WebElement searchButton = driver.findElement(By.xpath(".//button[@class=\"sb-searchbox__button  \"]"));
		searchButton.submit();

		Thread.sleep(1500);

		// click on the header to close all datepickers
		WebElement closeAllDatePickers = driver
				.findElement(By.xpath(".//div[@class=\"sr_header  sr_header--reduced\"]"));
		closeAllDatePickers.click();

		Thread.sleep(1500);

		WebElement checkInPresent = driver.findElement(By.xpath(".//div[@data-calendar2-type=\"checkin\"]"));
		checkInPresent.click();

		Thread.sleep(3000);
		WebElement arrivalDate = driver.findElement(By.xpath("(.//td[@data-id=\"1553385600000\"])[1]"));
		arrivalDate.click();

		closeAllDatePickers.click();

		Thread.sleep(1500);
		WebElement checkOutPresent = driver.findElement(By.xpath(".//div[@data-calendar2-type=\"checkout\"]"));
		checkOutPresent.click();

		Thread.sleep(1500);

		WebElement departureDate = driver.findElement(By.xpath("(.//td[@data-id=\"1553990400000\"])[2]"));
		departureDate.click();
		Thread.sleep(1500);

		// Select count of adults
		WebElement countOfAdults = driver.findElement(By.xpath(".//select[@name=\"group_adults\"]"));
		Select selectCountOfAdult = new Select(countOfAdults);
		selectCountOfAdult.selectByIndex(3);

		Thread.sleep(1500);

		// select count of rooms
		WebElement countOfRooms = driver.findElement(By.xpath(".//select[@name=\"no_rooms\"]"));
		Select selectCountOfRooms = new Select(countOfRooms);
		selectCountOfRooms.selectByIndex(1);

		// click Search button
		WebElement searchButtonCl = driver.findElement(By.xpath(".//button[@data-sb-id=\"main\"]"));
		searchButtonCl.click();

		Thread.sleep(1500);

		// select 480 + BYN
		WebElement expensiveHotels = driver
				.findElement(By.xpath("(.//div[@class=\"bui-checkbox__label filter_item css-checkbox\"])[5]"));
		expensiveHotels.click();

		Thread.sleep(1500);

		// На отеле из предыдущего кейса забронировать номер, ввести все поля, ввести
		// неверный номер карты и проверить, что появилось сообщение об ошибке. Номер
		// карты – 4242 4242 4242 4242, остальные данные любые.

		// filter the lowest first
		WebElement lowestFirst = driver
				.findElement(By.xpath(".//li[@class=\" sort_category  selected  sort_price \"]"));
		lowestFirst.click();

		Thread.sleep(1500);

		// select the lowest hotel
		WebElement selectLowestHotel = driver.findElement(By.xpath("(.//div[@data-et-view=\" eWHJbWPNZWEHXT:5\"])[1]"));
		selectLowestHotel.click();

		Thread.sleep(1500);

		Set<String> windows = driver.getWindowHandles();
		for (String winHandle : windows) {
			driver.switchTo().window(winHandle);
		}

		Thread.sleep(1500);
		// select a room
		WebElement selectARoom = driver.findElement(By.xpath("(.//select[@class=\"hprt-nos-select\"])[1]"));
		Select selectRoom = new Select(selectARoom);
		selectRoom.selectByIndex(0);

		Thread.sleep(1500);
		// click I will reserve button
		WebElement clickReserveButton = driver.findElement(By.xpath(".//div[@class=\"hprt-reservation-cta\"]"));
		clickReserveButton.click();

		// Close popup
		WebElement closePopup = driver
				.findElement(By.xpath(".//span[@class=\"modal-mask-closeBtn bp_rlu_footer_close\"]"));
		closePopup.click();

		// fill in Last Name field
		WebElement lastName = driver.findElement(By.xpath(".//input[@name=\"lastname\"]"));
		lastName.clear();
		lastName.sendKeys("Ivanov");

		// fill in Email field
		WebElement email = driver.findElement(By.xpath(".//input[@id = \"email\"]"));
		email.clear();
		email.sendKeys("ivanov@tut.by");

		// confirm email
		WebElement emailConfirm = driver.findElement(By.xpath(".//input[@id = \"email_confirm\"]"));
		emailConfirm.clear();
		emailConfirm.sendKeys("ivanov@tut.by");

		// click Next Final Details button
		WebElement clicknextButton = driver
				.findElement(By.xpath(".//div[@data-tooltip-class=\"submit_holder_button_tooltip\"]"));
		clicknextButton.click();

	}

}
