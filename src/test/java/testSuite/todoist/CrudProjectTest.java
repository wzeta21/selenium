package testSuite.todoist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.util.Date;

public class CrudProjectTest extends TestBase {

    @Test
    public void verifyCRUDProject(){

        String projectCreated="zetaProject"+new Date().getTime();
        String projectUpdated="zetaProjectUp"+new Date().getTime();

        //login
        mainPage.loginH.click();
        // loginSection.emailTxtBox.setText(user);
        // loginSection.passwordTxtBox.setText(user);
        loginSection.login(user, password);
        boolean resp = mainMenu.settingBtn.isControlDisplayed();
        Assertions.assertTrue(resp,"ERROR! the login was faield");

        // create project
        projectSectionIst.btnPlus.click();
        projectSectionIst.nameProject.setText(projectCreated);
        projectSectionIst.btnAdd.click();
        Assertions.assertTrue(projectSectionIst.isProjectDisplayedInList(projectCreated),"ERROR! the project was not created");

        //update project
        projectSectionIst.projectOptionMenu.click();
        projectSectionIst.editProject.click();
        projectSectionIst.newProjectName.cleanSetText(projectUpdated);
        projectSectionIst.savBtn.click();
        Assertions.assertTrue(projectSectionIst.isProjectDisplayedInList(projectUpdated),"ERROR! the project was not updated");

        // delete project
        projectSectionIst.projectOptionMenu.click();
        projectSectionIst.deleteProj.click();
        projectSectionIst.delete.click();
        Assertions.assertTrue(!projectSectionIst.isProjectDisplayedInList(projectUpdated),"ERROR! the project was not updated");
    }
}
