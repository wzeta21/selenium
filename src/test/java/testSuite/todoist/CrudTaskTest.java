package testSuite.todoist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class CrudTaskTest extends TestBase{
    @Test
    public void verifyCRUDTask(){

        String projectCreated="zetaProject"+new Date().getTime();

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

        // add task
        String taskName = "TareaZ" + new Date().getTime();
        String newtaskName = "TareaZuP" + new Date().getTime();
        taskSection.addTaskBtn.click();
        taskSection.taskTitle.setText(taskName);
        taskSection.saveTaskBtn.click();
        //Assertions.assertTrue(taskSection.isTaskDisplayedInList(taskName),"ERROR! the task was not created");

        //update task
        taskSection.moreTaskActions.click();
        taskSection.editTaskTbn.click();
        taskSection.setNewTitle(taskName, newtaskName);
        taskSection.updateTaskBtn.click();
        Assertions.assertTrue(taskSection.isTaskDisplayedInList(newtaskName),"ERROR! the task was not updated");

        // delete task
        taskSection.moreTaskActions.click();
        taskSection.deleteTaskTbn.click();
        taskSection.deleteTask.click();
        Assertions.assertTrue(taskSection.isTaskDisplayedInList(newtaskName),"ERROR! the task was not deleted");
    }
}
