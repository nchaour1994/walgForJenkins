package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {


    public SignInPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "user_name")
    WebElement username;
    @FindBy(id = "user_password")
    WebElement password;
    @FindBy(id = "submit_btn")
    WebElement signInBtn;

    public void typeOnUsername(){
        username.sendKeys("john1899@gmail.com");
    }
    public void typeOnPassword(){
        password.sendKeys("John1899test");
    }
    public void clickOnSignInBtn(){
        signInBtn.click();
    }
    public String getUserName(){
        return username.getAttribute("value");
    }
    public String getPassword(){
        return password.getAttribute("value");
    }
}
