$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 1,
  "name": "LoginFeature",
  "description": "This feature deals with the login functionality of the application",
  "id": "loginfeature",
  "keyword": "Feature"
});
formatter.before({
  "duration": 5361687391,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Login with correct username and password",
  "description": "",
  "id": "loginfeature;login-with-correct-username-and-password",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@login"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I navigate to the login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I enter the following for Login",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 7
    },
    {
      "cells": [
        "admin",
        "adminpassword"
      ],
      "line": 8
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I click login button",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I should see the userform page",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStep.iNavigateToTheLoginPage()"
});
formatter.result({
  "duration": 1211033677,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iEnterTheFollowingForLogin(DataTable)"
});
formatter.result({
  "duration": 311653966,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iClickLoginButton()"
});
formatter.result({
  "duration": 74016659,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iShouldSeeTheUserformPage()"
});
formatter.result({
  "duration": 488427544,
  "status": "passed"
});
formatter.after({
  "duration": 209240280,
  "status": "passed"
});
formatter.uri("UserForm.feature");
formatter.feature({
  "line": 1,
  "name": "UserFormFeature",
  "description": "This feature deals with the userform functionality of the application",
  "id": "userformfeature",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3420331967,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "User Should be able to fill the Userform with correct details",
  "description": "",
  "id": "userformfeature;user-should-be-able-to-fill-the-userform-with-correct-details",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@userForm"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I am logged in to the application",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 7
    },
    {
      "cells": [
        "admin",
        "adminpassword"
      ],
      "line": 8
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I should see the userform page",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I fill following user details in the form",
  "rows": [
    {
      "cells": [
        "title",
        "initial",
        "firstName",
        "middleName",
        "gender",
        "languages"
      ],
      "line": 11
    },
    {
      "cells": [
        "Mr.",
        "TT",
        "Tester",
        "tester",
        "Female",
        "hindi"
      ],
      "line": 12
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I click save button",
  "keyword": "And "
});
formatter.match({
  "location": "UserFormStep.iAmLoggedInToTheApplication(DataTable)"
});
formatter.result({
  "duration": 1264586224,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iShouldSeeTheUserformPage()"
});
formatter.result({
  "duration": 492438493,
  "status": "passed"
});
formatter.match({
  "location": "UserFormStep.iFillFollowingUserDetailsInTheForm(DataTable)"
});
formatter.result({
  "duration": 418662410,
  "status": "passed"
});
formatter.match({
  "location": "UserFormStep.iClickSaveButton()"
});
formatter.result({
  "duration": 43495993,
  "status": "passed"
});
formatter.after({
  "duration": 176865211,
  "status": "passed"
});
});