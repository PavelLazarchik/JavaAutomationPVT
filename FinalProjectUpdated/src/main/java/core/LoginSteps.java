package core;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import core.LoginPage;

public class LoginSteps {

	private static final String MAIN_URL = "http://mail.ru";
	private static final String LOGIN = "mogilev333@mail.ru";
	private static final String PASSWORD = "domain13";
	private LoginPage loginPage;
	private WebDriver webDriver;

	public LoginSteps() {
		String exePath = "C:\\1\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		webDriver = new ChromeDriver();
		loginPage = new LoginPage(webDriver);
	}

	@Given("^I am on main application page$")
	public void loadMainPage() {
		webDriver.get(MAIN_URL);
	}

	@When("^I login as correct user$")
	public void loginAsCorrectUser() {
		loginPage.enterLoginAndPass(LOGIN, PASSWORD);
		loginPage.clickEnterButton();
	}

	@When("^I login as user with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void loginAsUserWithCredentials(String name, String password) {
		loginPage.enterLoginAndPass(name, password);
		loginPage.clickEnterButton();
	}

	@When("^I mark first email by checkbox$")
	public void clickCheckboxToSelectEmail() throws InterruptedException {
		loginPage.clickCheckboxToSelectEmail();
	}

	@When("^I click on clickIsSpamButton$")
	public void clickIsSpamButton() throws InterruptedException {
		loginPage.clickIsSpamButton();
	}

	@Then("count of emails less for one")
	public void countNumberOfEmails() {
		Assert.assertEquals(14, loginPage.countOfEmails.size() - 1);
	}

	@Then("I see logout link")
	public void seeLogoutLink() {
		Assert.assertTrue(loginPage.logoutLinkPresents());
	}

	@Then("I see error message")
	public void seeErrorMessage() {
		Assert.assertTrue(loginPage.logoutLinkErrorPresents());
	}

	@After
	public void afterClass() {
		webDriver.quit();
	}

}
