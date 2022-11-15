package page.yopmail;

import control.Button;
import control.Label;
import control.TextBox;
import org.openqa.selenium.By;

public class MailSection {

    public Button newMail = new Button(By.id("newmail"));
    public TextBox to = new TextBox(By.id("msgto"));
    public TextBox subject = new TextBox(By.id("msgsubject"));
    public TextBox message = new TextBox(By.id("msgbody"));
    public Button sendbtn = new Button(By.id("msgsend"));
    public Button refresh = new Button(By.id("refresh"));
    public boolean isMailDisplayed(String mailParam){
        Label mail = new Label(By.xpath("//div[text()='"+mailParam+"']"));
        return mail.isControlDisplayed();
    }

    public boolean isSuccessfulSent(String msg){
        Label successful = new Label(By.id("msgpopmsg"));
        String content = successful.getText();
        return content.equals(msg);
    }
}
