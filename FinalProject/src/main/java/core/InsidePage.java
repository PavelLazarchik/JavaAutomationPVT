package core;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsidePage {

	@FindBy(xpath = "((//div[contains(@class,'checkbox__box') and ancestor::div[@id='b-letters']and not(ancestor::div[contains(@style, 'display: none;')])]))[1]")
	private WebElement selectEmailCheckbox;

	@FindBy(xpath = "(.//a[@class=\"b-nav__link\"])[3]")
	private WebElement spamFolder;

	@FindBy(xpath = "(.//div[@data-name='noSpam'])[1]")
	private WebElement isNotSpamButton;

	@FindBy(xpath = ".//div[@class=\"b-spam-confirm__title\"]")
	private WebElement conformationMoveToSpamPopUp;

	@FindBy(xpath = ".//button[@data-id=\"approve\"]")
	private WebElement clickConfirmButton;

	@FindBy(xpath = ".//div[@class=\"b-datalist__empty__icon b-datalist__empty__icon_spam\"]")
	private WebElement emptySpamFolder;

	@FindBy(xpath = ".//span[@class=\"b-nav__item__text b-nav__item__text_unread\"]")
	private WebElement inboxFolder;

	@FindBy(xpath = "(.//a[@class=\"b-toolbar__btn js-shortcut\"])[1]")
	private WebElement newEmailButton;

	@FindBy(xpath = ".//textarea[@data-original-name=\"To\"]")
	private WebElement fieldTo;

	@FindBy(xpath = ".//span[@data-config-id=\"3\"]")
	private WebElement clickOutside;

	@FindBy(xpath = ".//body[@id=\"tinymce\"]")
	private WebElement messageBody;

	@FindBy(xpath = "(.//div[@data-name=\"send\"])[1]")
	private WebElement sendButton;

	@FindBy(xpath = ".//a[@data-name='link' and not(ancestor::div[contains(@style, 'display: none;')])]")
	private List<WebElement> lettersList;

	@FindBy(xpath = "(.//div[@data-name=\"flagged\"])[1]")
	public WebElement allFlagedLettersButton;

	@FindBy(xpath = "(.//div[contains(@class, 'b-checkbox__box')])[1]")
	public WebElement checkAll;

	@FindBy(xpath = "(.//div[contains(@class, 'b-dropdown_more')])[1]")
	public WebElement moreButtons;

	@FindBy(xpath = "(.//a[@data-name='flag_no'])[1]")
	public WebElement removeFlags;

	@FindBy(id = "PH_logoutLink")
	private WebElement logoutButton;

	@FindBy(xpath = ".//i[@class=\"ico ico_folder_important\"]")
	private WebElement flagIcon;

	@FindBy(xpath = ".//a[@href=\"//calendar.mail.ru\"]")
	private WebElement calendarLink;

	public InsidePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void navigateToSpamFolder() {
		spamFolder.click();
	}

	public void clickIsNotSpamButton() {
		isNotSpamButton.click();
	}

	public void emailIsNotSpam() {
		selectEmailCheckbox.click();
		isNotSpamButton.click();

	}

	public void navigateToInboxFolder() {
		inboxFolder.click();
	}

	public void clickNewEmailButton() {
		newEmailButton.click();
	}

	public void enterText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public void sendEmailToUser(String user) {
		fieldTo.click();
		enterText(fieldTo, user);
		clickOutside.click();

	}

	public void clickSendButton() {
		sendButton.click();
	}

	public void markFlagOfFirst(int count) {
		List<WebElement> letters = lettersList;
		for (int row = 0; row < count; row++) {
			(letters.get(row)).findElement(By.xpath(".//div[@data-act='flag']")).click();
		}
	}

	public void removeAllFlag() {
		allFlagedLettersButton.click();
		checkAll.click();
		moreButtons.click();
		removeFlags.click();
	}

	public void logOutMail() {
		logoutButton.click();
	}

	public void clickFlagIconToShowOnlyMarkedEmails() throws InterruptedException {
		Thread.sleep(3000);
		flagIcon.click();
	}

	public void clickCalendarLink() {
		calendarLink.click();
	}

}
