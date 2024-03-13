package utils;

import pages.*;

public class PageInitializer {

    public static LoginPage login;
    public static DashboardPage dashboardPage;
    public static AddEmployeePage addEmployeePage;
    public static EmployeeSearchPage employeeSearchPage;
    public static WorkExperienceDetailsPage workExperienceDetailsPage;


    public static void initializePageObjects(){
        login = new LoginPage();
        dashboardPage = new DashboardPage();
        addEmployeePage = new AddEmployeePage();
        employeeSearchPage = new EmployeeSearchPage();
        workExperienceDetailsPage = new WorkExperienceDetailsPage();

    }
}
