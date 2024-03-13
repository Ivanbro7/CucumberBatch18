Feature: Add my work experience details

  #empId: 92415622

  Background:
    #Given user is navigated to HRMS application
    When user enters admin username and password
    And user clicks on login button
    Then user is successfully logged in
    When user clicks on PIM option

    @work_experience
    Scenario:
      When user enters employee ID in ID input field
      And user clicks on searh button
      Then user select the employee
      And click on qualifications
      Then user will click on Add button under Work Experience
      Then user will click on From input field
      And user will select a day, month and year


