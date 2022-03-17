package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//strong[text()='Account']")
    WebElement accountBtn;
    @FindBy(id = "pf-dropdown-signin")
    WebElement signInBtn;
    @FindBy(xpath = "//*[@class='default-dropdown account-dropdown show']")
    WebElement accountDropDown;
    public void clickOnAccountBtn(){
        accountBtn.click();
    }
    public void clickOnSignInBtn(){
        signInBtn.click();
    }
    public boolean checkIfDropDownIsDisplayed(){
        return accountDropDown.isDisplayed();
    }

}
