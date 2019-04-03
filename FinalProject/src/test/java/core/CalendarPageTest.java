package core;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import core.InsidePage;
import core.LoginPage;
import core.CalendarPage;

public class CalendarPageTest {

	private WebDriver driver;
	private InsidePage insidePage;
	private LoginPage loginPage;

	private CalendarPage calendarPage;

	@Before
	public void setUp() throws Exception {
		String exePath = "C:\\1\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		insidePage = new InsidePage(driver);
		loginPage = new LoginPage(driver);
		calendarPage = new CalendarPage(driver);
		driver.manage().window().maximize();

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void createNewEventTest() {
		driver.get("https://mail.ru");

		loginPage.enterData("mogilev333@mail.ru", "domain13");
		loginPage.clickEnterButton();
		Assert.assertTrue(loginPage.isLogoutPresent(driver));

		insidePage.clickCalendarLink();

		Set<String> windows = driver.getWindowHandles();
		for (String winHandle : windows) {
			driver.switchTo().window(winHandle);
		}

		calendarPage.clickCreateEventLink();
		calendarPage.nameEvent("Last day of the course");
		calendarPage.enterEventDate("06.04.2019");
		calendarPage.saveChangesForNewEvent();
	}

}
