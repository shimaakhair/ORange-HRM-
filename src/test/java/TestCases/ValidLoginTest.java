package TestCases;

import Base.TestBase;
import Pages.LoginPage;
import Utilities.LoadProperties;
import org.testng.annotations.Test;

public class ValidLoginTest extends TestBase {

    LoginPage LoginPageObject;

 String validuserName = LoadProperties.userData.getProperty("userName");
 String validpassWord = LoadProperties.userData.getProperty("password");

 @Test

 public void validLoginTest () {
     LoginPageObject = new LoginPage(driver);
     LoginPageObject.Login(validuserName,validpassWord);

 }



}
