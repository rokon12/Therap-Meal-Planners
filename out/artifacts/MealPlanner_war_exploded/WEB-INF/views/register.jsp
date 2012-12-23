<%--
  Created by IntelliJ IDEA.
  User: bazlur
  Date: 12/23/12
  Time: 12:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="include.jsp" %>
<html>
<head><title><fmt:message key="register.title"/></title></head>

<body>
<div>
    <%--<h1 style="text-align:center;"><fmt:message key="register.title"/></h1>--%>

    <div class="form-horizontal">
        <form action="/signup" method="post">
            <c:if test="${fn:length(error) > 0 }">
                <div class="span6 well text-error">
                    <c:forEach items="${error}" var="entry">
                        ${entry.value}<br>
                    </c:forEach>
                </div>
            </c:if>

            <fieldset>
                <legend><fmt:message key="register.title"/></legend>
                <div class="control-group">
                    <label class="control-label"><fmt:message key="register.userName"/></label>

                    <div class="controls">
                        <input type="text" name="userName">
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label"><fmt:message key="register.password"/></label>

                    <div class="controls">
                        <input type="password" name="password">
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label"><fmt:message key="register.passwordConfirmed"/></label>

                    <div class="controls">
                        <input type="password" name="passwordConfirmed">
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label"><fmt:message key="register.email"/></label>

                    <div class="controls">
                        <input type="text" name="email">
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <input type="submit" class="btn btn-primary" value="<fmt:message key="menu.signup"/>"/>
                    </div>
                </div>
            </fieldset>
        </form>
    </div>
</div>

</body>
</html>