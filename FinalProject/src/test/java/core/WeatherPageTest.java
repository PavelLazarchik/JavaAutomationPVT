package core;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import core.LoginPage;
import core.WeatherPage;

public class WeatherPageTest {
	private WebDriver driver;
	private LoginPage loginPage;
	private WeatherPage weatherPage;

	@Before
	public void setUp() throws Exception {
		String exePath = "C:\\1\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		loginPage = new LoginPage(driver);
		weatherPage = new WeatherPage(driver);
		driver.manage().window().maximize();

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void checkWeatherInBrestforTwoWeeks() {
		driver.get("https://mail.ru");

		loginPage.clickWeatherIcon();
		weatherPage.searchCity("Брест");
		weatherPage.selectBelarusBrest();
		weatherPage.selectTwoWeekPeriod();
	}
}
