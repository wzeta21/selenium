package page.yopmail;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class LoginSection {
    public TextBox mail = new TextBox(By.id("login"));
    public Button loginBtn = new Button(By.xpath("//button[@title=\"Check Inbox @yopmail.com\"]"));
}
