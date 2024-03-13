package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

import java.util.List;

public class WorkExperienceDetailsSteps extends CommonMethods {

    @When("user enters employee ID in ID input field")
    public void user_enters_employee_id_in_id_input_field() throws InterruptedException {
        sendText("92415622", employeeSearchPage.empIdLoc);
        Thread.sleep(3000);

    }
    @When("user clicks on searh button")
    public void user_clicks_on_searh_button() throws InterruptedException {
        click(employeeSearchPage.searchOption);
        Thread.sleep(3000);
    }
    @Then("user select the employee")
    public void user_select_the_employee() throws InterruptedException {
        click(workExperienceDetailsPage.employeeLink);
        Thread.sleep(2000);
    }
    @Then("click on qualifications")
    public void click_on_qualifications() throws InterruptedException {
        click(workExperienceDetailsPage.qualificationsBtn);
        Thread.sleep(2000);
    }
    @Then("user will click on Add button under Work Experience")
    public void user_will_click_on_add_button_under_work_experience() {
        click(workExperienceDetailsPage.addWorkExperience);
    }
    @Then("user will click on From input field")
    public void user_will_click_on_from_input_field() {
        click(workExperienceDetailsPage.fromInputField);
    }
    @Then("user will select a day, month and year")
    public void user_will_select_a_day_month_and_year() throws InterruptedException {
        selectFromDropDown(workExperienceDetailsPage.workExpCalenderMonth, "Mar");
        selectFromDropDown(workExperienceDetailsPage.workExperienceYear, "2020");
        List<WebElement> days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
        for (WebElement day:days){
            if(day.getText().equals("15")){
                day.click();
            }
        }
    }



}
