package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsidePages  {
	
	@FindBy(xpath = "(.//div[@class=\"js-item-checkbox b-datalist__item__cbx\"])[1]")
	private WebElement selectEmailCheckbox;
	

	@FindBy(xpath = "(.//div[@data-name=\"spam\"])[1]")
	private WebElement isSpamButton;
	
	@FindBy(xpath = "(.//a[@class=\"b-nav__link\"])[2]")
	private WebElement spamFolder;
	
	@FindBy(xpath = "(.//div[@data-name=\"noSpam\"])[1]")
	private WebElement isNotSpamButton;
	
	@FindBy(xpath = ".//div[@class=\"b-spam-confirm__title\"]")
	private WebElement conformationMoveToSpamPopUp;
	
	@FindBy(xpath = ".//button[@data-id=\"approve\"]")
	private WebElement clickConfirmButton;
	
	@FindBy(xpath = ".//div[@class=\"b-datalist__empty__icon b-datalist__empty__icon_spam\"]")
	private WebElement emptySpamFolder;
	
	@FindBy(xpath = ".//div[@class=\"b-nav__item js-href b-nav__item_active b-nav__item_unread\"]")
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


	
	public InsidePages(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickCheckboxToSelectEmail() {
		selectEmailCheckbox.click();
	}
	
	public void clickIsSpamButton() {
		isSpamButton.click();
		if(conformationMoveToSpamPopUp.isDisplayed()) {
			clickConfirmButton.click();
		}else {
			
		}
	}
	
	public void navigateToSpamFolder() {
		spamFolder.click();
	}
	
	public void clickIsNotSpamButton() {
		isNotSpamButton.click();
	}
	

	public void emailIsNotSpam() {
		if(!emptySpamFolder.isDisplayed()) {
			selectEmailCheckbox.click();
			clickIsNotSpamButton();
		}else {
			System.out.println("Spam folder is empty");
			
		}
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
		enterText(fieldTo, user);
	}
	
	public void clickOutside() {
		clickOutside.click();
	}
	
	public void putCursorToBodyTable() {
		messageBody.click();
	}
	
	public void fillInBodyMessage() {
		
	}
	
	public void clickSendButton() {
		sendButton.click();
	}
	
	public void putCursorIntoToField() {
		fieldTo.click();
	}
}
