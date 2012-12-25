<%--
  Created by IntelliJ IDEA.
  User: bazlur
  Date: 12/23/12
  Time: 5:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/include.jsp" %>
<html>
<head>
    <title><fmt:message key="meal.view"/></title>
</head>
<body>
<fieldset>
    <legend><fmt:message key="meal.today"/></legend>

    <c:if test="${meal ==null}">
        <h3> No meal for today :P</h3>
    </c:if>
    <c:if test="${meal!=null}">
        <dl class="dl-horizontal">
            <dt><fmt:message key="meal.mealtype"/></dt>
            <dd>${meal.mealType}</dd>

            <dt><fmt:message key="meal.starttime"/></dt>
            <dd>${meal.startTime}</dd>

            <dt><fmt:message key="meal.endtime"/></dt>
            <dd>${meal.endTime}</dd>

            <dt><fmt:message key="meal.items"/></dt>
            <dd>${meal.dish}</dd>
        </dl>
    </c:if>

</fieldset>

</body>
</html>