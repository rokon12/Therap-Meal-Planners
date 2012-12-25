<%--
  Created by IntelliJ IDEA.
  User: bazlur
  Date: 12/25/12
  Time: 12:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/include.jsp" %>
<html>
<head>
    <title><fmt:message key="meal.editMeal"/></title>
</head>
<body>
<div class="container">
    <form method="PUT" action="<c:url value="/meal"/>" class="span8">

        <fieldset>
            <legend><fmt:message key="meal.editMeal"/></legend>

            <c:if test="${fn:length(errors) > 0 }">
                <div class="span6 well text-error">
                    <c:forEach items="${errors}" var="entry">
                        ${entry.value}<br>
                    </c:forEach>
                </div>
            </c:if>

            <div class="span8">
                <div class="span3">
                    <div class="control-group">
                        <label class="control-label"> <fmt:message key="meal.mealtype"/> </label>
                        <select name="mealType" id="mealType">
                            <optgroup label="Meal Type">
                                <c:if test="${fn:length(mealType) > 0 }">
                                    <c:forEach items="${mealType}" var="entry">
                                        <option> ${entry} </option>
                                    </c:forEach>
                                </c:if>
                            </optgroup>
                        </select>
                    </div>
                </div>
                <div class="span3">
                    <div class="control-group">
                        <label class="control-label"> <fmt:message key="menu.day"/> </label>
                        <input id="day" type="text" name="day" readonly="true" value="${meal.day}"/>

                    </div>

                </div>
            </div>
            <br/>

            <div class="span8">
                <div class="control-group">
                    <div class="span3">
                        <label class="control-label" for="startTime"><fmt:message key="meal.starttime"/></label>

                        <div class="controls">
                            <input id="startTime"
                                   name="startTime" type="text" readonly="true" value="${meal.startTime}"/></div>
                    </div>
                    <div class="span3">
                        <label class="control-label" for="endTime"><fmt:message key="meal.endtime"/></label>

                        <div class="controls">
                            <input id="endTime"
                                   name="endTime" type="text" readonly="true" value="${meal.endTime}"/></div>
                    </div>
                </div>
            </div>

            <br/>
            <br/>

            <div class="span8">
                <div class="span7">
                    <div class="control-group">
                        <label class="control-label"> <fmt:message key="meal.items"/> </label>

                        <div class="controls">
                            <textarea name="dish" cols="80" rows="3"
                                      style="margin: 0px 0px 9px; width: 443px; height: 137px;"> ${meal.dish}</textarea>

                        </div>
                    </div>
                </div>

            </div>
            <div class="span8">
        <span class="span7">
            <button class="btn btn-primary large" type="submit"><fmt:message key="button.submit"/></button>
        </span>
            </div>
        </fieldset>
    </form>
</div>


<script>
    jQuery(document).ready(function () {
        jQuery("#startTime").timepicker();
        jQuery("#endTime").timepicker();
        jQuery("#day").datepicker();
    });

</script>
</body>
</html>