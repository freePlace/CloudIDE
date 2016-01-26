<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

    <!--<script>
      $(document).ready(function() {
        $("#createUserButton").click(function() {
          $("#createUserForm").toggle();
        });
        $("#createUserAction").click(function() {
       //   $.post("service/user", {email: "John", login: "2pm", password: "2pm", firstName: "2pm", lastName: "2pm"});
          $.ajax({
            url: "service/user",
            type: "POST",
            data: {"email": "John", "login": "2pm", "password": "2pm", "firstName": "2pm", "lastName": "2pm"},
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            }
          });
        });
      });
    </script> -->
</head>
<body ng-app="main">
  <div>
    <form action="doLogin" method="post">
      <div>
        <label for="login"><i></i></label>
        <input type="text" id="login" name="login" placeholder="Enter Username" required>
      </div>
      <div>
        <label for="password"><i></i></label>
        <input type="password" id="password" name="password" placeholder="Enter Password" required>
      </div>
      <div>
        <input type="submit" value="Log in">
      </div>
    </form>
    <a href="/auth/facebook">Get my Facebook profile</a>
  </div>
  <div ng-controller="userController">
    <div>
      <button ng-click="user.toggle(item, $event)">Create new user</button>
    </div>
    <div style="display:none" id="createUserForm">
        <table>
          <tr>
            <td>Email:</td>
            <td><input type="text" name="email" id="newEmail" /></td>
          </tr>
          <tr>
            <td>Login:</td>
            <td><input type="text" name="login" id="newLogin" /></td>
          </tr>
          <tr>
            <td>Pasword:</td>
            <td><input type="text" name="password" id="newPassword" /></td>
          </tr>
          <tr>
            <td>First name:</td>
            <td><input type="text" name="firstName" id="newFirstName" /></td>
          </tr>
          <tr>
            <td>Last name:</td>
            <td><input type="text" name="lastName" id="newLastName" /></td>
          </tr>
        </table>
        <div>
          <button ng-click="user.create(item, $event)">Create</button>
        </div>
    </div>
  </div>
  <script src="/resources/js/main.js"></script>

</body>
</html>