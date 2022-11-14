package testSuite.todoist;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import page.todoist.*;
import session.Session;
import util.GetProperties;

public class TestBase {
    String user=GetProperties.getInstance().getUser();
    String password =GetProperties.getInstance().getPwd();

    public MainPage mainPage = new MainPage();
    public LoginSection loginSection = new LoginSection();
    public MainMenu mainMenu = new MainMenu();

    public ProjectSectionIst projectSectionIst = new ProjectSectionIst();

    public TaskSection taskSection = new TaskSection();

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
