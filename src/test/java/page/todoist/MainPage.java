package page.todoist;

import control.Hyperlink;
import org.openqa.selenium.By;

public class MainPage {
    public Hyperlink loginH = new Hyperlink(By.xpath("//div//ul/li/a[text()='Log in']"));
}
