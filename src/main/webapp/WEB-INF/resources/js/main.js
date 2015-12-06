/**
 * Created by Ruslan on 06.12.2015.
 */

var mainModule = angular.module("main", []);

mainModule.controller("executorController", function($scope, $http) {
    $scope.executor = {};
    $scope.executor.execute = function(item, event) {
        var requestData =
        {
            "executableCode": ace.edit("editor").getValue(),
            "language": "java"
        };
        var responsePromise = $http.post("/service/execute",requestData);
        responsePromise.success(function(data, status, headers, config) {
            $("#inputStreamResult").val(data.inputStreamResult);
        });
        responsePromise.error(function(data, status, headers, config) {
            alert("AJAX failed!" + data + " " + status + " " + headers);
        });
    }
});