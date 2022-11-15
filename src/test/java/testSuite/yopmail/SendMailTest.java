package testSuite.yopmail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session.Session;

import java.util.Date;

public class SendMailTest extends TestBase{
    @Test
    public void sendingMail(){

        String mail = "wzeta21"+ new Date().getTime();
        loginSection.mail.click();
        loginSection.mail.setText(mail);
        loginSection.loginBtn.click();
        boolean resp = mailSection.isMailDisplayed(mail+"@yopmail.com");
        Assertions.assertTrue(resp,"ERROR! the login was faield");

        //send mail
        mailSection.newMail.click();
        Session.getInstance().getBrowser().switchTo().frame("ifmail");
        mailSection.to.setText(mail+"@yopmail.com");
        mailSection.subject.setText("Mi correo");
        mailSection.message.setText("Te envio este correo para que puedas ...");
        mailSection.sendbtn.click();
        boolean out = mailSection.isSuccessfulSent("Your message has been sent");
        Assertions.assertTrue(out,"ERROR! The mail wasn't sent successfully.");
    }
}
