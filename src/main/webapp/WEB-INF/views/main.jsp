<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    <script src="http://d1n0x3qji82z53.cloudfront.net/src-min-noconflict/ace.js" type="text/javascript" charset="utf-8"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <link href="resources/css/main.css" rel="stylesheet" />
    <title></title>
</head>
<body ng-app="main">
<div id="logout">
    <form action="logout">
        <input type="submit" value="Logout" />
    </form>
</div>
<div ng-controller="executorController">
    <button ng-click="executor.execute(item, $event)">Execute</button>
</div>
<div id="editor">
    public class X {
        public static void main(String [] args) {
            System.out.println("Hello world!");
        }
    }
</div>
<script>
    var editor = ace.edit("editor");
    editor.setTheme("ace/theme/monokai");
    editor.getSession().setMode("ace/mode/java");
</script>
<textarea rows="10" cols="180" id="executionResult" disabled >
</textarea>
<script src="/resources/js/main.js">
</script>
</body>
</html>
