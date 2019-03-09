package pages;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.LoginPage;

public class MailRuTestsClassWork {
	private WebDriver driver;
	private LoginPage loginPage;

	@Before
	public void setUp() throws Exception {
	
			String exePath = "C:\\1\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath);
			driver = new ChromeDriver();	
			loginPage = new LoginPage(driver);
			driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {
		
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://mail.ru");
		
		loginPage.enterData("mogilev333", "domain13");
		loginPage.clickEnterbutton();
		new WebDriverWait(driver, 5).until(ExpectedConditions.titleContains("Входящие"));
		Assert.assertTrue(loginPage.isLogoutPresent(driver));
		
		/*WebElement loginField = driver.findElement(By.xpath(".//input[@id=\"mailbox:login\"]"));
		loginField.clear();
		loginField.sendKeys("mogilev333");
		
		WebElement passwordField = driver.findElement(By.xpath(".//input[@id=\"mailbox:password\"]"));
		passwordField.clear();
		passwordField.sendKeys("domain13");
		
		WebElement loginButton = driver.findElement(By.xpath(".//input[@class=\"o-control\"]"));
		loginButton.click();
		
		new WebDriverWait(driver, 5).until(ExpectedConditions.titleContains("Вход�?щие"));
		
		WebElement logoutLink = driver.findElement(By.xpath(".//a[@id=\"PH_logoutLink\"]"));
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(logoutLink));
		Assert.assertTrue(logoutLink.isDisplayed());*/
	}

}
