package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	@FindBy(xpath = ".//input[@id=\"mailbox:password\"]")
	private WebElement passwordField;
	
	@FindBy(xpath = ".//input[@id=\"mailbox:login\"]")
	private WebElement loginField;
	
	@FindBy(xpath = ".//input[@class=\"o-control\"]")
	private WebElement loginButton;
	
	@FindBy (xpath = ".//a[@id=\"PH_logoutLink\"]")
	private WebElement logoutLink;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterData(String login, String password) {
		enterText(loginField, login);
		enterText(passwordField, password);
	}
	
	private void enterText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}
	
	public void clickEnterbutton() {
		loginButton.click();
	}
	
	public boolean isLogoutPresent(WebDriver driver) {
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(logoutLink));
		return logoutLink.isDisplayed();
	}

}
