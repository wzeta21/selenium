package testSuite.yopmail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import page.yopmail.LoginSection;
import page.yopmail.MailSection;
import session.Session;
import util.YopmailGetProperties;

public class TestBase {

    String user= YopmailGetProperties.getInstance().getUser();
    String password =YopmailGetProperties.getInstance().getPwd();
    LoginSection loginSection = new LoginSection();
    MailSection mailSection = new MailSection();
    @BeforeEach
    public void openBrowser(){
        // todo create property file
        Session.getInstance().getBrowser().get(YopmailGetProperties.getInstance().getHost());
    }

    @AfterEach
    public void closeBrowser(){
        Session.getInstance().closeSession();
    }
}
