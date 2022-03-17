package login;

import base.CommonApi;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignInPage;

import java.util.concurrent.TimeUnit;

public class TestLogin extends CommonApi {
    String titleHomePage=prop.getProperty("titleHomePage");
    String titleSignInPage=prop.getProperty("titleSignInPage");
    String username=prop.getProperty("username");
    String password=prop.getProperty("password");




    @Test
    public void testLogin(){
                HomePage home=new HomePage(driver);
                SignInPage signInPage=new SignInPage(driver);
                Assert.assertEquals(getTitle(),titleHomePage);
                home.clickOnAccountBtn();
                home.checkIfDropDownIsDisplayed();
                home.clickOnSignInBtn();
                Assert.assertEquals(getTitle(),titleSignInPage);
        //        driver.navigate().back();
        //        driver.navigate().forward();
        //        driver.navigate().to("https://photo.walgreens.com/store/home");
                signInPage.typeOnUsername();
                Assert.assertEquals(signInPage.getUserName(),username);
                signInPage.typeOnPassword();
                Assert.assertEquals(signInPage.getPassword(),password);
                signInPage.clickOnSignInBtn();
                waitFor(5);
                //Assert.assertEquals(getTitle(),titleHomePage);

    }
  // @Test
    public void testLoginWithInvalidCredentials(){
        Assert.assertEquals(driver.getTitle(),"Walgreens: Pharmacy, Health & Wellness, Photo & More for You");
        driver.findElement(By.xpath("//strong[text()='Account']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='default-dropdown account-dropdown show']")).isDisplayed());
        driver.findElement(By.cssSelector("#pf-dropdown-signin")).click();
        Assert.assertEquals(driver.getTitle(),"Sign In or Register to Get Started Using Walgreens.com");
        driver.findElement(By.cssSelector("#user_name")).sendKeys("john1899@gmail.com");
        Assert.assertEquals(driver.findElement(By.cssSelector("#user_name")).getAttribute("value"),"john1899@gmail.com");
        driver.findElement(By.cssSelector("#user_password")).sendKeys("John1899test");
        Assert.assertEquals(driver.findElement(By.cssSelector("#user_password")).getAttribute("value"),"John1899test");
        driver.findElement(By.cssSelector("#submit_btn")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(driver.getTitle(),"Walgreens: Pharmacy, Health & Wellness, Photo & More for You");

    }

}
