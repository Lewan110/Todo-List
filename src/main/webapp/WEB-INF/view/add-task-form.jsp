<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Lewan
  Date: 30.04.2018
  Time: 08:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add task</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/main.css"/>
</head>
<body>
<div id="container">
    <form:form action="saveTask" modelAttribute="task" method="post">
        <table class="flatTable">
            <tr class="titleTr">
                <td class="titleTd">Add Task</td>
                <td colspan="2"></td>
            </tr>

            <tr>
                <td>Task name:</td>
                <td><form:input path="taskName"></form:input></td>
            </tr>
            <tr>
                <td>Time:</td>
                <td><form:input path="estimatedTime"></form:input></td>
            </tr>
            <tr>
                <td>desc:</td>
                <td><form:input path="description"></form:input></td>
            </tr>
            <tr>
                <td><input type="submit" value="Save" class="save"></td>
            </tr>

        </table>

    </form:form>
    <div style="clear;">
        <a href="${pageContext.request.contextPath}/tasks">Back to tasks</a>
    </div>
</div>
</body>
</html>
