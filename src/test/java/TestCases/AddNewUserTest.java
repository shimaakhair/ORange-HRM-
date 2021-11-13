package TestCases;

import Base.TestBase;
import Pages.LoginPage;
import Pages.AddNewUserPage;
import Utilities.LoadProperties;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewUserTest extends TestBase {

    LoginPage LoginPageObject;
    AddNewUserPage AddNewUserPageObject;

    String validuserName = LoadProperties.userData.getProperty("userName");
    String validpassWord = LoadProperties.userData.getProperty("password");

     static Faker fakeData = new Faker();
     public static String fakeUserName = fakeData.name().username();
    String usernameFake = driver.findElement(AddNewUserPageObject.userNameAssertionField1).getText();


     @Test

    public void addNewUserAndAssert () {
        LoginPageObject = new LoginPage(driver);
        LoginPageObject.Login(validuserName,validpassWord);

        AddNewUserPageObject =new AddNewUserPage(driver);
        AddNewUserPageObject.addNewUser(fakeUserName);


         System.out.println(usernameFake);

        //System.out.println(driver.findElement(AddNewUserPageObject.userNameAssertionField1).getText());



       Assert.assertEquals(usernameFake,driver.findElement(AddNewUserPageObject.userNameAssertionField1).getText());

        //Assert.assertTrue(driver.findElement(AddNewUserPageObject.userNameAssertionField).getText().contains(fakeUserName));



    }



}
