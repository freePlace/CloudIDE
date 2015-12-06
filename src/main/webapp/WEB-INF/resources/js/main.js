/**
 * Created by Ruslan on 06.12.2015.
 */
var tmpDefaultCode= 'public class X {	public static void main(String [] args) {		System.out.println("here we are!");	}}';
$("#executableCode").val(tmpDefaultCode);

angular.module("main", [])
    .controller("MyController", function($scope, $http) {
        $scope.myData = {};
        $scope.myData.click = function(item, event) {
            var requestData =
            {
                "executableCode": $("#executableCode").val(),
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