<%--
  Created by IntelliJ IDEA.
  User: Ruslan
  Date: 02.12.2015
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    <title></title>
</head>
<body>
<div ng-app="main">
  <p>Name: <input type="text" ng-model="name"></p>
  <p ng-bind="name"></p>
</div>
<a href='logout'> LOGOUT</a>

hello from main!
</body>
</html>
