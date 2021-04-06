<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
    Date now = new Date();
    DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
%>
<h4>Current Time:</h4>
<%=df.format(now)%>