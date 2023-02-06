#Author: manzoor056@gmail.com

@Rental_Cover_UI
Feature: This feature tests Get Instant Quote scenarios
  This feature deals with navigating to home page, filling the form data and getting an instant quote

  Background: User starts the tests
    Given User Initializes Tests

  @Get_Instant_Quote
  Scenario: User navigates to home page, fills out the form and gets the instant quote for car rent

    Given User Navigates to Home Page
    When User Enter Fields.Text
      | FieldName                | FieldValue    |
      | Select or type a country | United States |
    And User Select Field.Calender
      | FieldName     | FieldValue     |
      | Pick up date  | 16-May-2023    |
      | Drop off date | 24-August-2023 |
    And User Click Button."Get Your Instant Quote"
    Then User Validate "Policy Information & Payment"
