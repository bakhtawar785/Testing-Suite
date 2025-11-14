============================================================
               Cypress - end-to-end tests
============================================================

The tests use the Page Object Model (POM) and custom Cypress command for reusability and better code structure.

------------------------------------------------------------
Tools & Technologies Used:
------------------------------------------------------------
- Cypress 
- Page Object Model
- Custom Cypress Commands

------------------------------------------------------------
Test Cases Included:
------------------------------------------------------------

1. Valid Login:
   - Logs in with standard_user and secret_sauce
   - Verifies navigation to the Products page

2. Invalid Login:
   - Logs in with incorrect credentials
   - Verifies that error message is displayed

------------------------------------------------------------
Custom Cypress Command:
------------------------------------------------------------
Defined in support/commands.js

- cy.login(username, password)
  → Logs in using given credentials

------------------------------------------------------------
How to Run the Tests:
------------------------------------------------------------

1. Open the project folder in Visual Studio Code.

2. Install dependencies (Cypress):
   npm install cypress

3. Launch Cypress Test Runner:
   npx cypress open

4. In the Cypress window, select:
   login.spec.js
   product.spec.js

------------------------------------------------------------
Notes:
------------------------------------------------------------

- Page Object Model is used for cleaner, maintainable code
- Custom command used for reusable login functionality
- Tests are written for https://www.saucedemo.com

------------------------------------------------------------
Author:
------------------------------------------------------------
- Bakhtawar Pirzada
