<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    <script src="http://d1n0x3qji82z53.cloudfront.net/src-min-noconflict/ace.js" type="text/javascript" charset="utf-8"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <link rel="stylesheet" href="resources/css/main.css" />
    <link rel="stylesheet" href="resources/css/font-awesome.min.css">
    <link rel="stylesheet" href="resources/css/normalize.css">
    <link rel="stylesheet" href="resources/css/fonts.css" />
    <link rel="stylesheet" href="resources/css/style.css" />
    <link rel="stylesheet" href="resources/css/media.css" />
    <title></title>
</head>
<body ng-app="main">

<div id="ide">
    <div id="header">
        <ul class="main_nav clearfix">
            <li>
                <a href="#"><i class="fa fa-folder-open-o"></i></a>
                <select id="file" class="fa fa-folder-open-o">
                    <c:forEach var="navigationProject" items="${navigationPanel.navigationProjects}">
                        <option>
                            <c:out value="${navigationProject.name}"/>
                        </option>
                    </c:forEach>
                </select>
            </li>
            <li>
                <a href="#"><i class="fa fa-floppy-o"></i></a>
                <select id="run">
                    <c:forEach var="navigationExecute" items="${navigationPanel.navigationExecutes}">
                        <option>
                            <c:out value="${navigationExecute.name}"/>
                        </option>
                    </c:forEach>
                </select>
            </li>
            <li><a href="#"><i class="fa fa-refresh"></i></a></li>
            <li class="nav_line"></li>
            <li><a href="#"><i class="fa fa-arrow-left"></i></a></li>
            <li><a href="#"><i class="fa fa-arrow-right"></i></a></li>
            <li class="nav_line"></li>
            <li><a href="#"><i class="fa fa-scissors"></i></a></li>
            <li><a href="#"><i class="fa fa-files-o"></i></a></li>
            <li><a href="#"><i class="fa fa-clipboard"></i></a></li>
            <li class="nav_line"></li>
            <li><a href="#"><i class="fa fa-search-plus"></i></a></li>
            <li><a href="#"><i class="fa fa-search-minus"></i></a></li>
            <li class="nav_line"></li>
            <li><a href="#"><i class="fa fa-arrow-circle-o-left"></i></a></li>
            <li><a href="#"><i class="fa fa-arrow-circle-o-right"></i></a></li>
            <li class="nav_line"></li>
            <li><a href="">$?</a></li>
            <li>
                <select name="" id="">
                    <option value="1">Пункт 1</option>
                    <option value="2">Пункт 2</option>
                    <option value="3">Пункт 3</option>
                    <option value="4">Пункт 4</option>
                </select>
            </li>
            <li ng-controller="executorController">
                <i id="play" class="fa fa-play" ng-click="executor.execute(item, $event)"></i>
            </li>
            <li><a href=""><i class="fa fa-bug"></i></a></li>
            <li><a href=""><i class="fa fa-play-circle"></i></a></li>
            <li><a href=""><i class="fa fa-play-circle-o"></i></a></li>
            <li class="nav_line"></li>
            <li>
                <form action="logout">
                    <input type="submit" value="Logout" />
                </form>
            </li>
        </ul>
        <ul class="dop_nav clearfix">
            <li><a href="#">что то_1</a></li>
            <li><a href="#">что то_2</a></li>
            <li class="nav_line"></li>
            <li><a href="#">что то_3</a></li>
            <li><a href="#">что то_4</a></li>
            <li class="nav_line"></li>
            <li><a href="#">что то_5</a></li>
        </ul>
        <div class="broadcamp">
            <label for="broad">Folder: </label>
            <input type="text" id="broad" placeholder="C:\....\....\....">
        </div>
    </div>

    <!-- working space -->
    <div id="working_space">
        <div class="project">
            <div class="block_title">
                <div class="project_name">
                    <input type="text" id="proj_name" placeholder="project_name">
                </div>
            </div>
        </div>
        <div class="code" id="editor">
                public class X {
                    public static void main(String [] args) {
                        System.out.println("Hello world!");
                    }
                }
        </div>
    </div>
</div>




<!--
<div id="logout">
    <form action="logout">
        <input type="submit" value="Logout" />
    </form>
</div>
<div id="navigationPanel">
    <table>
        <tr>
            <td>
                <select id="file">
                    <c:forEach var="navigationProject" items="${navigationPanel.navigationProjects}">
                        <option>
                            <c:out value="${navigationProject.name}"/>
                        </option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <select id="run">
                    <c:forEach var="navigationExecute" items="${navigationPanel.navigationExecutes}">
                        <option>
                            <c:out value="${navigationExecute.name}"/>
                        </option>
                    </c:forEach>
                </select>
            </td>
        </tr>
    </table>
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
-->
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
