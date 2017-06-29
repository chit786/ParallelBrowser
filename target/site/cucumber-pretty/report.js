$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("UserForm.feature");
formatter.feature({
  "line": 1,
  "name": "UserFormFeature",
  "description": "This feature deals with the userform functionality of the application",
  "id": "userformfeature",
  "keyword": "Feature"
});
formatter.before({
  "duration": 4571433923,
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
  "duration": 1392093363,
  "status": "passed"
});
formatter.match({
  "location": "LoginStep.iShouldSeeTheUserformPage()"
});
formatter.result({
  "duration": 430440266,
  "status": "passed"
});
formatter.match({
  "location": "UserFormStep.iFillFollowingUserDetailsInTheForm(DataTable)"
});
formatter.result({
  "duration": 283879432,
  "status": "passed"
});
formatter.match({
  "location": "UserFormStep.iClickSaveButton()"
});
formatter.result({
  "duration": 28995952,
  "status": "passed"
});
formatter.after({
  "duration": 193501842,
  "status": "passed"
});
});