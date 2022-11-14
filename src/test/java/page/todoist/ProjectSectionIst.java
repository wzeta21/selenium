package page.todoist;

import control.Button;
import control.Label;
import control.TextBox;
import org.openqa.selenium.By;

// projecto plus btn //div[@id ="left_menu_inner"]/div/div/div/div/button[@aria-label="Add project"]
// project name input: id:edit_project_modal_field_name
//btn add : //button[text()="Add"]


public class ProjectSectionIst {

    public Button btnPlus= new Button(By.xpath("//div[@id =\"left_menu_inner\"]/div/div/div/div/button[@aria-label=\"Add project\"]"));
    public TextBox nameProject = new TextBox(By.id("edit_project_modal_field_name"));
    public Button btnAdd = new Button(By.xpath("//button[text()=\"Add\"]"));
    public Button projectOptionMenu = new Button(By.xpath("//button[@aria-label=\"Project options menu\"]"));
    public Button editProject = new Button(By.xpath("//div[text()=\"Edit project\"]"));
    public TextBox newProjectName = new TextBox(By.id("edit_project_modal_field_name"));
    public Button savBtn = new Button(By.xpath("//button[text()=\"Save\"]"));

    public Button deleteProj = new Button(By.xpath("//div[text()=\"Delete project\"]"));
    public Button delete = new Button(By.xpath("//button/span[text()=\"Delete\"]"));

    public void clickOnProject(String projectName){
        Label projectCreated = new Label(By.xpath("//span[text()='"+projectName+"']"));
        projectCreated.click();
    }

    public boolean isProjectDisplayedInList(String projectName){
        Label projectCreated = new Label(By.xpath("//span[text()='"+projectName+"']"));
        return projectCreated.isControlDisplayed();
    }

    public Label getProject(String projectName){
        Label projectCreated = new Label(By.xpath("//span[text()='"+projectName+"']"));
        return projectCreated;
    }
}
