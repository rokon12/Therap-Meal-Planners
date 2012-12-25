<%--
  Created by IntelliJ IDEA.
  User: bazlur
  Date: 12/23/12
  Time: 9:41 AM
  To change this template use File | Settings | File Templates.
--%>

<%@include file="include.jsp" %>
<html>
<head>
    <title><fmt:message key="application.name"/> | <fmt:message key="menu.home"/></title>

</head>
<body>

<div class="jumbotron">
    <h1><fmt:message key="application.name"/></h1>

    <p class="lead">
        <fmt:message key="application.message"/>
    </p>
    <a class="btn btn-large btn-success" href="<c:url value="/meal"/>"> <fmt:message
            key="menu.viewtodaysmeal"/> </a>
    <br/> <br/>

    <p style="font-size: 14px; margin-left:10px;position:relative;top:2px">
        <fmt:message key="no.account.yet"/> -- <a href="<c:url value='/signup'/> "> <fmt:message key="menu.signup"/></a>
        <fmt:message
                key="start.sending.request"/>
    </p>

</div>

</body>
</html>