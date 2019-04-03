package core;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import core.InsidePage;
import core.LoginPage;

public class InsidePageTest {

	private WebDriver driver;
	private InsidePage insidePage;
	private LoginPage loginPage;

	@Before
	public void setUp() throws Exception {
		String exePath = "C:\\1\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		insidePage = new InsidePage(driver);
		loginPage = new LoginPage(driver);
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void moveEmailFromSpam() {
		driver.get("https://mail.ru");

		loginPage.enterData("mogilev333@mail.ru", "domain13");
		loginPage.clickEnterButton();
		Assert.assertTrue(loginPage.isLogoutPresent(driver));

		insidePage.navigateToSpamFolder();
		insidePage.emailIsNotSpam();
		insidePage.navigateToInboxFolder();
		List<WebElement> countOfEmails = driver
				.findElements(By.xpath(".//div[@class=\"js-item-checkbox b-datalist__item__cbx\"]"));
		Assert.assertEquals(15, countOfEmails.size());
	}

	@Test
	public void sendEmailToSeveralUsers() {
		driver.get("https://mail.ru");

		loginPage.enterData("mogilev333@mail.ru", "domain13");
		loginPage.clickEnterButton();
		Assert.assertTrue(loginPage.isLogoutPresent(driver));

		insidePage.clickNewEmailButton();
		insidePage.sendEmailToUser("aaa@aaa.aa");
		insidePage.sendEmailToUser("bbb@bbb.aa");
		insidePage.sendEmailToUser("ccc@ccc.aa");

		((JavascriptExecutor) driver)
				.executeScript("tinyMCE.activeEditor.setContent('<p>Hello World, Final project!</p>')");
		insidePage.clickSendButton();
	}

	@Test
	public void markEmailsByFlag() {
		driver.get("https://mail.ru");

		loginPage.enterData("mogilev333@mail.ru", "domain13");
		loginPage.clickEnterButton();
		Assert.assertTrue(loginPage.isLogoutPresent(driver));

		List<WebElement> countOfEmails = driver
				.findElements(By.xpath(".//div[@class=\"js-item-checkbox b-datalist__item__cbx\"]"));
		int numberMarked = 3;
		insidePage.markFlagOfFirst(numberMarked);
	}

	@Test
	public void unmarkEmailsByFlag() {
		driver.get("https://mail.ru");

		loginPage.enterData("mogilev333@mail.ru", "domain13");
		loginPage.clickEnterButton();
		Assert.assertTrue(loginPage.isLogoutPresent(driver));
		insidePage.removeAllFlag();
	}

	@Test
	public void logoutFromMail() {
		driver.get("https://mail.ru");

		loginPage.enterData("mogilev333@mail.ru", "domain13");
		loginPage.clickEnterButton();
		Assert.assertTrue(loginPage.isLogoutPresent(driver));
		insidePage.logOutMail();
	}

	@Test
	public void showEmailsMarkedByFlagOnly() throws InterruptedException {
		driver.get("https://mail.ru");

		loginPage.enterData("mogilev333@mail.ru", "domain13");
		loginPage.clickEnterButton();
		Assert.assertTrue(loginPage.isLogoutPresent(driver));

		List<WebElement> countOfEmails = driver
				.findElements(By.xpath(".//div[@class=\"js-item-checkbox b-datalist__item__cbx\"]"));
		int numberMarked = 3;
		insidePage.markFlagOfFirst(numberMarked);
		insidePage.clickFlagIconToShowOnlyMarkedEmails();
	}
}
