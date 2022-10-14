Feature: Examples of Cucumber data table implementations

  Scenario: List of fruit I like
    Then user should see fruits I like
      | kiwi        |
      | banana      |
      | orange      |
      | cucumber    |
      | mango       |
      | grape       |
      | pomegranate |
    #ayni hizada yapmak icin ctrl + alt + L


  Scenario: User should be able to see all 12 months in months
  dropdown
    Given User is on the dropdowns page of practice tool
    Then User should see below info in month dropdown
      | January   |
      | February  |
      | March     |
      | April     |
      | May       |
      | June      |
      | July      |
      | August    |
      | September |
      | October   |
      | November  |
      | December  |



