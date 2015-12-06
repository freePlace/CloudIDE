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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <link href="resources/css/main.css" rel="stylesheet" />
    <title></title>
</head>
<body ng-app="main">
<!-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
<div ng-controller="MyController" >
    <button ng-click="myData.click(item, $event)">Send data</button>
    <a href='logout'> LOGOUT</a>
</div>
<textarea rows="10" cols="180" name="text" id="executableCode">
</textarea>
<textarea rows="10" cols="180" name="text" id="inputStreamResult" disabled >
</textarea>
<script src="/resources/js/main.js">
</script>
</body>
</html>
