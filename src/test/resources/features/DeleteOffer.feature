Feature: Login

  Scenario: FDAA

    Given user is on login page
    When user enters username and password
    And user clicks on "Log in" button
    Then user is logged in and selects the "View all stores"
    And On a new tab choose an Account select the "Cloathing asa" account
    Then user selects the "Cloathing Proveway" store and is navigated to the Store Home page
    When user clicks on "Pumper Bundles Quantity Breaks" tool
    And user is on the "Pumper Dashboard"
    #Then user can "Clone" the "Bundle_Offer_S7D1" Offer
    And user can "Delete" the "Bundle_Offer_S7D1 (clone-16)" Offer