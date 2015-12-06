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
            if(data.compilationResult != 0) {
                $("#executionResult").css("color", "rgb(200,0,0)");
                $("#executionResult").val("Compilation fails with " + data.compilationResult);
            } else if(data.errorStreamResult != '') {
                $("#executionResult").css("color", "rgb(200,0,0)");
                $("#executionResult").val(data.errorStreamResult);
            } else {
                $("#executionResult").css("color", "white");
                $("#executionResult").val(data.inputStreamResult);
            }
        });
        responsePromise.error(function(data, status, headers, config) {
            alert("AJAX failed!" + data + " " + status + " " + headers);
        });
    }
});