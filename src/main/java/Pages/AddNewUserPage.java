package Pages;

import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AddNewUserPage extends PageBase {
    public AddNewUserPage(WebDriver driver) {
        super(driver);
    }

    By adminMenu = By.id("menu_admin_viewAdminModule");
    By userManagementMenu = By.id("menu_admin_UserManagement");
    By adduserBtn = By.id("btnAdd");
    By userroleField = By.id("systemUser_userType");
    By employeeName = By.id("systemUser_employeeName_empName");
    By employeeUserName = By.id("systemUser_userName");
    By passwordField = By.id("systemUser_password");
    By confirmPass = By.id("systemUser_confirmPassword");
    By saveBtn = By.id("btnSave");
    By userSearchBar = By.id("searchSystemUser_userName");
    By searchBtn = By.id("searchBtn");
    By resultSearchTxt = By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[2]/a");
   // public By userNameAssertionField = By.id("systemUser_userName");
    public By userNameAssertionField1 = By.xpath("//input[@id='systemUser_userName']");



    public void addNewUser(String registeredUserName){
        clickOnWebElement(adminMenu);
        clickOnWebElement(userManagementMenu);
        clickOnWebElement(adduserBtn);
        Select usertypeSelect = new Select(driver.findElement(userroleField));
        usertypeSelect.selectByValue("2");
        typeInTxt(employeeName,"Aaliyah Haq");
        typeInTxt(employeeUserName,registeredUserName);
        typeInTxt(passwordField,"$S01152$");
        typeInTxt(confirmPass,"$S01152$");
        clickOnWebElement(saveBtn);

        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(userSearchBar));


        typeInTxt(userSearchBar,registeredUserName);
        clickOnWebElement(searchBtn);
        clickOnWebElement(resultSearchTxt);

    }




  // public void getDataFromTable (){
      // WebElement table = driver.findElement(tableOfData);
      //  List<WebElement>rows = table.findElements(By.tagName("tr"));
      //  List<WebElement>columns = table.findElements(By.tagName("td"));
       // WebElement userName = columns.get(1);
       // System.out.println("UserName =" +userName.getText()); }
}










