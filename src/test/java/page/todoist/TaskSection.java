package page.todoist;

import control.Button;
import control.Label;
import control.TextBox;
import org.openqa.selenium.By;

public class TaskSection {
    public Button addTaskBtn = new Button(By.xpath("//button[text()=\"Add task\"]"));
    public TextBox taskTitle = new TextBox(By.xpath("//div[@role=\"textbox\"]"));
    public Button saveTaskBtn = new Button(By.xpath("//span[text()=\"Add task\"]"));
    public Button moreTaskActions = new Button(By.xpath("//button[@aria-label=\"More task actions\"]"));
    public Button editTaskTbn = new Button(By.xpath("//div[text()=\"Edit task\"]"));
    private TextBox newTaskTitle;
    public Button updateTaskBtn = new Button(By.xpath("//span[text()=\"Save\"]"));

    public Button deleteTaskTbn = new Button(By.xpath("//div[text()=\"Delete task\"]"));
    public Button deleteTask = new Button(By.xpath("//span[text()=\"Delete\"]"));

    public boolean isTaskDisplayedInList(String taskName){
        Label taskCreated = new Label(By.xpath("//div[text()='"+taskName+"']"));
        return taskCreated.isControlDisplayed();
    }

    public Label getTask(String taskName){
        Label taskCreated = new Label(By.xpath("//div[[text()='"+taskName+"']"));
        return taskCreated;
    }

    public void setNewTitle(String oldTitle, String newTitle){
        newTaskTitle = new TextBox(By.xpath("//span[text()='"+oldTitle+"']"));
        newTaskTitle.cleanSetText(newTitle);
    }
}
