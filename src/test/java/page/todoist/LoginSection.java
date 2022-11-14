package page.todoist;

import control.Button;
import control.Hyperlink;
import control.TextBox;
import org.openqa.selenium.By;
//boton login: //div//ul/li/a[text()='Log in']
// input email: id:element-0
// input pwd: id="element-3"
//boton log in: //form/button
public class LoginSection {
    public TextBox emailTxtBox = new TextBox(By.id("element-0"));
    public TextBox passwordTxtBox = new TextBox(By.id("element-3"));
    public Button loginButton= new Button(By.xpath("//form/button"));

    public void login(String user, String pwd){
        emailTxtBox.setText(user);
        passwordTxtBox.setText(pwd);
        loginButton.click();
    }

}
