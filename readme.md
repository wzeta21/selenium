user: bootcamp@mojix44.com
pwd: 12345

click Login -->  //img[contains(@src,'pagelogin')]
email txtbox ---> ctl00_MainContent_LoginControl1_TextBoxEmail
pwd txtbox ---> ctl00_MainContent_LoginControl1_TextBoxPassword
login button ---> ctl00_MainContent_LoginControl1_ButtonLogin
// verificar inicie sesion  ---->  logout option ---> ctl00_HeaderTopControl1_LinkButtonLogout

add new project button --> //td[text()='Add New Project']
project name txtbox ---> NewProjNameInput
add button ---> NewProjNameButton



// verificar la creacion  ---> //td[text()='Eynar'] --> SI EXISTE

click en el mennu desplegable ---> //div[contains(@style,'block')]/img
click edit option ---> //ul[@id="projectContextMenu"]//a[text()='Edit']
edit textbox --> //td/div/input[@id='ItemEditTextbox']
save button ---> //td/div/img[@id='ItemEditSubmit']

// verification update  ---> //td[text()='EynarUPDATE']  --> SI EXISTE

click en el mennu desplegable ---> //div[contains(@style,'block')]/img
click delete option ---> ProjShareMenuDel
click ok alert --> manejo de alertas selenium

// verification update  ---> //td[text()='EynarUPDATE'] ---> NO EXISTA


click en textArea --> id: NewItemContentInput

click en el boton --> id: NewItemAddButton

ItemContentDiv UnderEditingItem
itemid:1107885

ItemEditDiv

textarea id: ItemEditTextbox

<textarea id="ItemEditTextbox" type="text" value="" class="InputTextEdit InputTextEditItem" autocomplete="off" onkeydown="ItemList.ItemEditKeyDown(event, this);" onblur="ItemList.ItemLostFocus(this);" itemid="11079193" readonly="readonly" style="height: 15px; width: 579px;"></textarea>

//*[@id="ItemEditTextbox"]
/html/body/form/div[3]/table/tbody/tr[2]/td/div/div/table/tbody/tr/td[2]/div[1]/div[1]/div[4]/ul/li/div/table/tbody/tr/td[3]/div[5]/div/textarea

trl + f8 + \ . y lo pausas el navegador por si te sirve

------------------------------------
package browser;

import org.openqa.selenium.WebDriver;

public interface IBrowser {
    WebDriver create();
}


*******************

package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Chrome implements IBrowser{
    @Override
    public WebDriver create() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        return driver;
    }
}


*****************

package browser;

import org.openqa.selenium.WebDriver;

public class Firefox implements IBrowser{
    @Override
    public WebDriver create() {
            return null;
    }
}

*************

package browser;

import org.openqa.selenium.WebDriver;

public class Headless implements IBrowser{
    @Override
    public WebDriver create() {
        return null;
    }
}

**************

package browser;

public class FactoryBrowser {
    /**
     * 
     * @param browserType
     * @return
     */
    public static IBrowser make(String browserType){
        IBrowser browser;
        switch (browserType.toLowerCase()){
            case "chrome":
                browser= new Chrome();
                break; 
            case "headless":
                browser=new Headless();
                break;
            default:
                browser= new Firefox();
                break;
        }
        return browser;
    }
    
}

*********************

package session;

import browser.FactoryBrowser;
import org.openqa.selenium.WebDriver;

public class Session {
     private static Session instance=null;
     private WebDriver browser;
     private Session(){
         // todo -- create and move to properties  
         browser= FactoryBrowser.make("chrome").create();
     }
    
     public static Session getInstance(){
         if (instance==null)
             instance=new Session();
         return instance;
     }    
    
     public void closeSession(){
         browser.quit();
         instance=null;
     }

    public WebDriver getBrowser() {
        return browser;
    }
}

*****************


package control;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import session.Session;

public class Control {
    protected WebElement control;
    protected By locator;
    
    public Control(By locator){
        this.locator=locator;
    }
    
    protected void find(){
        control= Session.getInstance().getBrowser().findElement(this.locator);
    }
    
    public void click(){
        this.find();
        control.click();
    }
    
    
}


*****************************
******************************
package control;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import session.Session;

import java.time.Duration;

public class Control {
    protected WebElement control;
    protected By locator;

    public Control(By locator){
        this.locator=locator;
    }

    protected void find(){
        control= Session.getInstance().getBrowser().findElement(this.locator);
    }

    public void click(){
        this.find();
        control.click();
    }

    public boolean isControlDisplayed(){
       try {
           this.find();
           return control.isDisplayed();
       } catch (Exception e) {
           return false;
       }
    }

    public String getText(){
        this.find();
        return this.control.getText();
    }


    public void waitControlIsNotInThePage(){
        WebDriverWait explicitWait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(this.locator)));
    }

}


************

package session;

import browser.FactoryBrowser;
import org.openqa.selenium.WebDriver;

public class Session {
     private static Session instance=null;
     private WebDriver browser;
     private Session(){
         // todo -- create and move to properties
         browser= FactoryBrowser.make("chrome").create();
     }

     public static Session getInstance(){
         if (instance==null)
             instance=new Session();
         return instance;
     }

     public void closeSession(){
         browser.quit();
         instance=null;
     }

    public WebDriver getBrowser() {
        return browser;
    }

    public void acceptAlert() {
        browser.switchTo().alert().accept();
    }
}


**************
package testSuite.todoly;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import page.todoly.LoginSection;
import page.todoly.MainPage;
import page.todoly.MenuSection;
import page.todoly.ProjectSection;
import session.Session;

public class TestBase {
     MainPage mainPage= new MainPage();
     LoginSection loginSection = new LoginSection();
     MenuSection menuSection = new MenuSection();
     ProjectSection projectSection= new ProjectSection();

     // todo property file
     String user="bootcamp@mojix45.com";
     String password ="12345";


     @BeforeEach
     public void openBrowser(){
          // todo create property file
          Session.getInstance().getBrowser().get("http://todo.ly/");
     }

     @AfterEach
     public void closeBrowser(){
          Session.getInstance().closeSession();
     }

}


****************

package testSuite.todoly;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session.Session;

import java.util.Date;

public class CRUDProjectTest extends TestBase{

    @Test
    public void verifyCRUDProject(){
        String projectCreated="MOJIX"+new Date().getTime();
        String projectUpdated="QA"+new Date().getTime();

        mainPage.loginLabel.click();
        loginSection.emailTxtBox.setText(user);
        loginSection.passwordTxtBox.setText(password);
        loginSection.loginButton.click();
        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),"ERROR! the login was faield");

        projectSection.addNewProjecButton.click();
        projectSection.nameProjectTxtBox.setText(projectCreated);
        projectSection.addButton.click();
        Assertions.assertTrue(projectSection.isProjectDisplayedInList(projectCreated),"ERROR! the project was not created");

        projectSection.clickOnProject(projectCreated);
        projectSection.menuProjectSection.menuIconButton.click();
        projectSection.menuProjectSection.editButton.click();
        projectSection.editProjectTxtBox.cleanSetText(projectUpdated);
        projectSection.saveButton.click();
        Assertions.assertTrue(projectSection.isProjectDisplayedInList(projectUpdated),"ERROR! the project was not updated");

        projectSection.clickOnProject(projectUpdated);
        projectSection.menuProjectSection.menuIconButton.click();
        projectSection.menuProjectSection.deleteButton.click();
        Session.getInstance().acceptAlert();
        projectSection.getProject(projectUpdated).waitControlIsNotInThePage();
        Assertions.assertFalse(projectSection.isProjectDisplayedInList(projectUpdated),"ERROR! the project was not deleted");

    }


}

*************


package page.todoly;

import control.Button;
import control.Label;
import control.TextBox;
import org.openqa.selenium.By;

public class ProjectSection {
    public MenuProjectSection menuProjectSection= new MenuProjectSection();
    public Button addNewProjecButton = new Button(By.xpath("//td[text()='Add New Project']"));
    public TextBox nameProjectTxtBox= new TextBox(By.id("NewProjNameInput"));
    public Button addButton = new Button(By.id("NewProjNameButton"));
    public TextBox editProjectTxtBox= new TextBox(By.xpath("//td/div/input[@id='ItemEditTextbox']"));
    public Button saveButton= new Button(By.xpath("//td/div/img[@id='ItemEditSubmit']"));

    public ProjectSection(){}

    public void clickOnProject(String nameProject){
        Label projectCreated = new Label(By.xpath("//td[text()='"+nameProject+"']"));
        projectCreated.click();
    }

    public boolean isProjectDisplayedInList(String nameProject){
        Label projectCreated = new Label(By.xpath("//td[text()='"+nameProject+"']"));
        return projectCreated.isControlDisplayed();
    }

    public Label getProject(String nameProject){
        Label projectCreated = new Label(By.xpath("//td[text()='"+nameProject+"']"));
        return projectCreated;
    }

}

*******************



package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Headless implements IBrowser{
    @Override
    public WebDriver create() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        return driver;
    }
}

**********

browser=headless
host=http://todo.ly/
user=bootcamp@mojix45.com
pwd=12345
  
  *************
  
  package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties {
     private static GetProperties getProperties= null;
     private String browser;
     private String host;
     private String user;
     private String pwd;

     private GetProperties(){
         Properties properties = new Properties();
         String nameFile="todoly.properties";
         InputStream inputStream = getClass().getClassLoader().getResourceAsStream(nameFile);
         if(inputStream!= null){
             try {
                 properties.load(inputStream);
                 browser=properties.getProperty("browser");
                 host=properties.getProperty("host");
                 user=properties.getProperty("user");
                 pwd=properties.getProperty("pwd");
                 
             } catch (IOException e) {
                 throw new RuntimeException(e);
             }
         }
     }
    
     public static GetProperties getInstance(){
         if (getProperties == null)
             getProperties=new GetProperties();
         return getProperties;
     }

    public String getBrowser() {
        return browser;
    }

    public String getHost() {
        return host;
    }

    public String getUser() {
        return user;
    }

    public String getPwd() {
        return pwd;
    }
}

  *****
  
    
    package session;

import browser.FactoryBrowser;
import org.openqa.selenium.WebDriver;
import util.GetProperties;

public class Session {
     private static Session instance=null;
     private WebDriver browser;
     private Session(){
         browser= FactoryBrowser.make(GetProperties.getInstance().getBrowser()).create();
     }

     public static Session getInstance(){
         if (instance==null)
             instance=new Session();
         return instance;
     }

     public void closeSession(){
         browser.quit();
         instance=null;
     }

    public WebDriver getBrowser() {
        return browser;
    }

    public void acceptAlert() {
        browser.switchTo().alert().accept();
    }
}


**


package testSuite.todoly;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import page.todoly.LoginSection;
import page.todoly.MainPage;
import page.todoly.MenuSection;
import page.todoly.ProjectSection;
import session.Session;
import util.GetProperties;

public class TestBase {
     MainPage mainPage= new MainPage();
     LoginSection loginSection = new LoginSection();
     MenuSection menuSection = new MenuSection();
     ProjectSection projectSection= new ProjectSection();

     // todo property file
     String user=GetProperties.getInstance().getUser();
     String password =GetProperties.getInstance().getPwd();


     @BeforeEach
     public void openBrowser(){
          // todo create property file
          Session.getInstance().getBrowser().get(GetProperties.getInstance().getHost());
     }

     @AfterEach
     public void closeBrowser(){
          Session.getInstance().closeSession();
     }

}

  


