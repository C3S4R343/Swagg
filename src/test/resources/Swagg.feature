Feature: Swag Labs End-to-End Flow

  Scenario: Complete user journey on Swag Labs in a single session
    Given the browser is launched and test environment is set up
    When the user navigates to the login page
    And the Swag Labs logo is displayed on the login page

    When the user logs in with valid credentials
    Then the products page is displayed

    When the user opens the menu
    And the logout button is visible

    When the user navigates to the product details page
    Then the product name is displayed

    When the user adds 3 items to the cart
    Then the cart icon shows 3 items

    When the user clicks the "Remove" button on an item
    Then the item is removed from the cart

    When the user navigates to the cart page
    Then the correct items are listed in the cart

    When the user proceeds to checkout
    Then the checkout page is displayed

    When the user enters the required shipping and payment information
    Then the user proceeds to the confirmation page

    When the user reviews the order on the confirmation page
    Then the correct items are displayed

    When the user logs out of the website
    Then the user is logged out successfully

    When the user attempts to log in with the "locked_out_user" credentials
    Then the system displays a locked-out error message

    When the browser session is closed
    Then the driver is terminated
