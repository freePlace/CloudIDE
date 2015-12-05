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
<body ng-app="main">
<!-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
<div ng-controller="MyController" >
<button ng-click="myData.doClick(item, $event)">Send AJAX Request</button>
Data from server: {{myData.fromServer}}
<button ng-click="myData.click(item, $event)">Send data</button>
<a href='logout'> LOGOUT</a>
</div>
<textarea rows="10" cols="45" name="text" id="executableCode">
</textarea>
<script>
    angular.module("main", [])
            .controller("MyController", function($scope, $http) {
                $scope.myData = {};
                $scope.myData.doClick = function(item, event) {

                    var responsePromise = $http.get("/service/programmingLanguage");

                    responsePromise.success(function(data, status, headers, config) {
                        alert(data);
                        $scope.myData.fromServer = data;
                    });
                    responsePromise.error(function(data, status, headers, config) {
                        alert("AJAX failed!" + data + " " + status);
                    });
                }

                $scope.myData.click = function(item, event) {
                    var responsePromise = $http.post("/service/execute",document.getElementById("executableCode"));
                    responsePromise.success(function(data, status, headers, config) {
                        alert(data);
                    });
                    responsePromise.error(function(data, status, headers, config) {
                        alert("AJAX failed!" + data + " " + status);
                    });
                }
            } );
</script>
</body>
</html>
