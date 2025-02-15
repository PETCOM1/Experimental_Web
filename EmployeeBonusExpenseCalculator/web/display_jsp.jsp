<%-- 
    Document   : display_jsp
    Created on : 15 Feb 2025, 10:46:29 PM
    Author     : Munzhedzi Munyadziwa Petrus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Display Page</title>
    </head>
    <body>
        <h1>These are the compony's Net Expenses</h1>
        <%
            double total = (Double)request.getAttribute("total");
        %>
        
        <p>The total Expenses of the company are <%=total%></p>
        
    </body>
</html>
