<%--
  Created by IntelliJ IDEA.
  User: arif
  Date: 11/10/16
  Time: 8:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Tweet Search</title>
    <style>
        table, tr, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<form action="/search">
    <input type="text" name="query"/>
    <input type="submit" value="Search"/>
</form>

Hashtag : ${tweetName}<br/>
<br/>
Tweets : <br/>
<hr size="4" color="gray"/>
<table>
<c:forEach items="${tweetList}" var="tweet">
    <tr>
        <td>${tweet}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>
