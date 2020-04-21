Feature: Search For Properties For Sale
  As a customer
  I want the ability to search for property for sale
  So that i can purchase the property


  Scenario Outline: Customer Can Search For Properties For Sale
    Given I navigate to zoopla homepage
    When I enter a "<Location>" in the search textbox
    And  I select "<Minprice>" from minprice dropdown
    And I select "<Maxprice>" from maxprice dropdown
    And I select "<PropertyType>" from propertytype dropdown
    And I select "<Bed>" from bedroom dropdown
    And I click on searchbutton
    Then A list of "<PropertyType>" in "<Location>" are displayed
    And I click on any of the result to view more detail


    Examples:

      | Location| Minprice|Maxprice |PropertyType|Bed  |
      |Manchester| £120,000|£230,000| Houses     |3+   |
     #| London   | 250,000|£400,000|            \Property   |No min|
     # | Coventary| 120,000|£250,000|            \Flats      |3+   |
      #|         |        |        |                       |
@ignore
  Scenario Outline: Customer Cannot Search For Property With Missing Value
   Given I navigate to zoopla homepage
   When I enter a "<Location>" in the search textbox
    And I select "<Minprice>" from minprice dropdown
    And I select "<Maxprice>" from maxprice dropdown
   And I select "<Property>" from property type dropdown
   And I select "<Bed>" from bedroom dropdown
    And I click on search button
    Then An error message is displayed

    Examples:
      | Location| Minprice|Maxprice|Property|Bed  |             |
      |          | 120,000|£230,000|House   | 3+    | Houses    |

@ignore
  Scenario Outline: error page is displayed for invalid search
    Given i navigate to zoopla hompageWhen i enter a "<Location>" in the search text box
    And i select "<Minprice>" from min price dropdown
    And i select "<Maxprice>" from max price dropdown And i select "<Property>" from property type dropdown
    And i select "<Bed>" from bedroom dropdownAnd i click on search button
    Then An error result page is displayed

   Examples:
      | Location| Minprice|Maxprice|Property|Bed    |PropertyType|
      |M39 1xc   | 120,000|£230,000|House   | 3+    | House      |
      | ££££££   | 250,000|£400,000|Farm/land|No Min| Property   |
      |  123     | 120,000|£250,000|   Flat  | 3+   | Flats      |
      |   123    |     |       |           |      |           |