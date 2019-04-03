package core;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private static final int LINK_PRESENSE_TIMEOUT = 10;

	private WebDriver driver;

	@FindBy(id = "mailbox:login")
	private WebElement loginField;

	@FindBy(id = "mailbox:password")
	private WebElement passwordField;

	@FindBy(xpath = "//*[@id='mailbox:submit']/input")
	private WebElement buttonEnter;

	@FindBy(xpath = "//*[@id='PH_logoutLink']")
	private WebElement logoutLink;

	@FindBy(xpath = "//*[@id='mailbox:error']")
	public WebElement logoutLinkError;

	@FindBy(xpath = ".//div[@class=\"js-item-checkbox b-datalist__item__cbx\"]")
	public List<WebElement> countOfEmails;

	@FindBy(xpath = "(.//div[@class=\"js-item-checkbox b-datalist__item__cbx\"])[1]")
	private WebElement selectEmailCheckbox;

	@FindBy(xpath = "(.//div[@data-name=\"spam\"])[1]")
	private WebElement isSpamButton;

	@FindBy(xpath = ".//div[@class=\"b-spam-confirm__title\"]")
	private WebElement conformationMoveToSpamPopUp;

	@FindBy(xpath = ".//button[@data-id=\"approve\"]")
	private WebElement clickConfirmButton;

	@FindBy(xpath = ".//img[@class=\"weather__icon\"]")
	private WebElement emailIcon;

	public LoginPage(WebDriver webdriver) {
		PageFactory.initElements(webdriver, this);
		this.driver = webdriver;
	}

	public void enterLoginAndPass(String login, String password) {
		loginField.clear();
		loginField.sendKeys(login);
		passwordField.clear();
		passwordField.sendKeys(password);

	}

	public void clickEnterButton() {
		buttonEnter.click();
	}

	public boolean logoutLinkPresents() {
		return (new WebDriverWait(driver, LINK_PRESENSE_TIMEOUT)).until(ExpectedConditions.visibilityOf(logoutLink))
				.isDisplayed();
	}

	public boolean logoutLinkErrorPresents() {
		return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(logoutLinkError)).isDisplayed();
	}

	public void clickCheckboxToSelectEmail() throws InterruptedException {
		Thread.sleep(3000);
		selectEmailCheckbox.click();
	}

	public void clickIsSpamButton() throws InterruptedException {
		Thread.sleep(3000);
		isSpamButton.click();
	}

	public void countNumberEmails() throws InterruptedException {
		Thread.sleep(3000);
		List<WebElement> countOfEmails = driver
				.findElements(By.xpath(".//div[@class=\"js-item-checkbox b-datalist__item__cbx\"]"));
	}

	private void enterText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public void enterData(String login, String password) {
		enterText(loginField, login);
		enterText(passwordField, password);
	}

	public boolean isLogoutPresent(WebDriver driver) {
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(logoutLink));
		return logoutLink.isDisplayed();
	}

	public void clickWeatherIcon() {
		emailIcon.click();
	}
}
