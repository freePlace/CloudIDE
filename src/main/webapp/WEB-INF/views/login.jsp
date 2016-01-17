<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
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
</body>
</html>
