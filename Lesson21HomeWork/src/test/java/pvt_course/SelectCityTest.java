package pvt_course;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pvt_course.SelectCity;
import pvt_course.SelectHotel;

public class SelectCityTest {
	private WebDriver driver;
	private SelectCity selectCity;
	private SelectHotel selectHotel;

	@Before
	public void setUp() throws Exception {

		String exePath = "C:\\1\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();
		selectCity = new SelectCity(driver);
		selectHotel = new SelectHotel(driver);
		driver.manage().window().maximize();

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test 
	public void test1() {
		driver.get("https://booking.com");
		selectCity.fillInCity("Moscow");
		selectCity.clickSearchButton();
		selectHotel.selectNumberOfAdult();
		selectHotel.selectNumberOfRooms();
		selectHotel.checkIsAnyHotelAvailable();
	}

	@Test
	public void test2() throws InterruptedException {
		driver.get("https://booking.com");
		selectCity.fillInCity("Moscow");
		selectCity.clickSearchButton();
		selectHotel.filterByTopReviewed();
		Thread.sleep(3000);
		selectHotel.clickToCloseDatePickers();
		selectHotel.clickFirstFilteredHotel();
		selectHotel.checkHotelRating();
	}
}
