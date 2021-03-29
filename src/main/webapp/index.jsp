<%@ page import="java.util.Random" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<%!
    private int getRandom() {
        Random r = new Random();
        return r.nextInt(20);
    }
%>


<html>
<head>
    <title>Servlet demo</title>
</head>
<body>
<h1>
    Hello, world
</h1>
<h2>
    <jsp:include page="fragment/date.jsp"/>
</h2>

<%
    final int random = getRandom();
    out.println(String.format("<h2> Random value is %d </h2>", random));
%>

<%
    String type = random % 2 == 0 ? "even" : "odd";
%>
<h3> Random is <%=type%>
</h3>


<a href="<%= request.getRequestURI() %>">Retry</a>
<%@include file="fragment/footer.html" %>
</body>
</html>
