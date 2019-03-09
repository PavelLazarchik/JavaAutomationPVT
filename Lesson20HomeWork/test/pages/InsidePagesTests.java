package pages;


import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.InsidePages;
import pages.LoginPage;

public class InsidePagesTests {
	private WebDriver driver;
	private InsidePages insidePages;
	private LoginPage loginPage;
	private Robot robot;

	@Before
	public void setUp() throws Exception {
		String exePath = "C:\\1\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		insidePages = new InsidePages(driver);
		loginPage = new LoginPage(driver);
		driver.manage().window().maximize();
		robot = new Robot();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {
		driver.get("https://mail.ru");

		loginPage.enterData("aaa", "aaa");
		loginPage.clickEnterbutton();
		Assert.assertTrue(loginPage.isLogoutPresent(driver));
		List<WebElement> countOfEmails = driver
				.findElements(By.xpath(".//div[@class=\"js-item-checkbox b-datalist__item__cbx\"]"));
		System.out.println(countOfEmails.size());
		insidePages.clickCheckboxToSelectEmail();
		insidePages.clickIsSpamButton();

		Assert.assertEquals(11, countOfEmails.size() - 1);

	}

	@Test
	public void test2() {
		driver.get("https://mail.ru");

		loginPage.enterData("aaa", "aaa");
		loginPage.clickEnterbutton();
		Assert.assertTrue(loginPage.isLogoutPresent(driver));

		insidePages.navigateToSpamFolder();
		insidePages.emailIsNotSpam();
		insidePages.navigateToInboxFolder();
		List<WebElement> countOfEmails = driver
				.findElements(By.xpath(".//div[@class=\"js-item-checkbox b-datalist__item__cbx\"]"));
		Assert.assertEquals(11, countOfEmails.size());
	}

	@Test
	public void test3() {
		driver.get("https://mail.ru");

		loginPage.enterData("aaa", "aaa");
		loginPage.clickEnterbutton();
		Assert.assertTrue(loginPage.isLogoutPresent(driver));

		insidePages.clickNewEmailButton();
		insidePages.sendEmailToUser("aaa@aaa.aa");
		insidePages.clickOutside();
		insidePages.putCursorIntoToField();
		insidePages.sendEmailToUser("bbb@bbb.bb");
		insidePages.clickOutside();
		insidePages.putCursorIntoToField();
		insidePages.sendEmailToUser("ccc@ccc.cc");
		insidePages.clickOutside();
		((JavascriptExecutor) driver).executeScript("tinyMCE.activeEditor.setContent('<p>text</p>')");
		insidePages.clickSendButton();
	}

	@Test
	public void test4() {
		driver.get("https://mail.ru");

		loginPage.enterData("mogilev333", "domain13");
		loginPage.clickEnterbutton();
		Assert.assertTrue(loginPage.isLogoutPresent(driver));

		List<WebElement> countOfEmails = driver
				.findElements(By.xpath(".//div[@class=\"js-item-checkbox b-datalist__item__cbx\"]"));
		System.out.println(countOfEmails.size());
		int numberofEmailsToBeMarked = 3;

		for (int i = 0; i <= numberofEmailsToBeMarked - 1; i++) {
			countOfEmails.get(i).click();
		}

		try {
			robot = new Robot();
			robot.keyPress(73);
			robot.keyRelease(73);
		} catch (AWTException ex) {
			System.out.println("Can't press button 'I' to mark flags");
		}

		System.out.println(countOfEmails.size());
		// Непонятно, почему не работает вариант, который закомментирован ниже
		// robot.keyPress(KeyEvent.VK_I);
		// robot.keyRelease(KeyEvent.VK_I);

	}

	@Test
	public void test5() {
		driver.get("https://mail.ru");

		loginPage.enterData("mogilev333", "domain13");
		loginPage.clickEnterbutton();
		Assert.assertTrue(loginPage.isLogoutPresent(driver));

		List<WebElement> countOfEmails = driver
				.findElements(By.xpath(".//div[@class=\"js-item-checkbox b-datalist__item__cbx\"]"));
		System.out.println(countOfEmails.size());
		int numberofEmailsToBeMarked = 3;

		for (int i = 0; i <= numberofEmailsToBeMarked - 1; i++) {
			countOfEmails.get(i).click();
		}

		try {
			robot = new Robot();
			robot.keyPress(73);
			robot.keyRelease(73);
		} catch (AWTException ex) {
			System.out.println("Can't press button 'I' to mark flags");
		}

		System.out.println(countOfEmails.size());

	}
}
