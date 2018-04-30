<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lewan
  Date: 28.04.2018
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/main.css"/>
    <title>Todo tasks</title>
</head>
<body>
<table class="flatTable">
    <tr class="titleTr">
        <td class="titleTd">Todo List</td>
        <td colspan="2"></td>
        <td><input type="button" value="Add task"
                   onclick="window.location.href='AddTaskForm';return false;"
                   class="add-button"
        /></td>
    </tr>
    <tr class="headingTr">
        <td>NAME</td>
        <td>ESTIMATED TIME</td>
        <td>DESCRIPTION</td>
        <td>ACTION</td>

        <c:forEach var="tempTask" items="${tasks}">
        <c:url var="updateLink" value="/showFormUpdate">
            <c:param name="taskId" value="${tempTask.id}" />
        </c:url>

        <c:url var="deleteLink" value="/delete">
            <c:param name="taskId" value="${tempTask.id}" />
        </c:url>
    <tr>
        <td>${tempTask.taskName}</td>
        <td>${tempTask.estimatedTime}</td>
        <td>${tempTask.description}</td>
        <td>
            <a href="${updateLink}">Edit </a>
            |
            <a href="${deleteLink}"> Done!</a>
        </td>
    </tr>

    </c:forEach>

</table>
</body>
</html>
