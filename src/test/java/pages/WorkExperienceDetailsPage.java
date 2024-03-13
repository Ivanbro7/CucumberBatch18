package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class WorkExperienceDetailsPage extends CommonMethods {

    @FindBy(xpath = "//*[@id='resultTable']/tbody/tr/td[3]/a")
    public WebElement employeeLink;

    @FindBy(xpath = "//*[@id='sidenav']/li[10]/a")
    public WebElement qualificationsBtn;

    @FindBy(xpath = "//input[@id='addWorkExperience']")
    public WebElement addWorkExperience;

    @FindBy(id="experience_from_date")
    public WebElement fromInputField;

    @FindBy(xpath = "//select[@class='ui-datepicker-month']")
    public WebElement workExpCalenderMonth;

    @FindBy(xpath = "//select[@class='ui-datepicker-year']")
    public WebElement workExperienceYear;

    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']/tbody/tr/td")
    public WebElement calendarDays;


    public WorkExperienceDetailsPage() {

        PageFactory.initElements(driver, this);
    }
}
