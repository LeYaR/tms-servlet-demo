<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>User Info</title>
        <link rel="stylesheet" type="text/css" href="static/main.css">
</head>
<body>
<jsp:useBean id="userProvider" class="by.yarzl.servlet.jstl.UserProvider" scope="request"/>


<c:if test="${fn:length(userProvider.users) > 0}">
    <table class="styled-table">
        <thead>
        <tr>
            <td>
                ID
            </td>
            <td>
                Name
            </td>
            <td>
                Banned
            </td>
            <td>
                Period
            </td>
        </tr>
        </thead>
        <c:forEach var="user" items="${userProvider.users}">
            <tr>
                <td>
                        ${user.id}
                </td>
                <td>
                        ${user.name}
                </td>
                <td>
                    <c:if test="${user.banned}">Banned</c:if>
                    <c:if test="${!user.banned}">Not banned</c:if>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${user.period > 0 && user.period < 3 }">
                            Short
                        </c:when>
                        <c:when test="${user.period >= 3}">
                            Long
                        </c:when>
                        <c:otherwise>
                            -
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${fn:length(userProvider.users) == 0}">
    <c:redirect url="index.jsp"/>
</c:if>
</body>
</html>