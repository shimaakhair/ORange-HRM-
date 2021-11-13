package Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class PageBase {
    public WebDriver driver;

    //Super constructor
    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void typeInTxt (By webElement , String txtToBeSent){
        if (driver.findElement(webElement).isDisplayed()) {
            driver.findElement(webElement).clear();
            driver.findElement(webElement).sendKeys(txtToBeSent);
            System.out.println(txtToBeSent + " Inserted successfully ");
        }
        else {
            System.out.println("WebElement not displayed");
        }
    }

    public void clickOnWebElement(By webElement){
        if (  driver.findElement(webElement).isDisplayed()){
            System.out.println("clicked successfully on button "+ driver.findElement(webElement).getText());
            driver.findElement(webElement).click();

        }
        else {
            System.out.println("button is not displayed");
        }
    }


}
