package Pages;

import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {


    public LoginPage(WebDriver driver) { super(driver); }

    By usernameField = By.id("txtUsername");
    By passwordField = By.id("txtPassword");
    By loginBtn = By.id("btnLogin");
    By welcomeTxt = By.id("welcome");


    public void Login (String usernameInput , String passwordInput){
        typeInTxt(usernameField,usernameInput);
        typeInTxt(passwordField, passwordInput);
        clickOnWebElement(loginBtn);

    }









}
