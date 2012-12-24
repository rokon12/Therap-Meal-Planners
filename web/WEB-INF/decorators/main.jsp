<%--
  Created by IntelliJ IDEA.
  User: rokon
  Date: 12/13/12
  Time: 10:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>
<fmt:setLocale value="en"/>
<fmt:setBundle basename="messages"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title><decorator:title/></title>

    <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.css'/>" type="text/css"/>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-ui-timepicker-addon.js"/>"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" type="text/css"/>


    <style type="text/css">
        body {
            padding-top: 60px;
            padding-bottom: 40px;
        }

        .container-narrow {
            margin: 0 auto;
            max-width: 700px;
        }

        .container-narrow>hr {
            margin: 30px 0;
        }

        .jumbotron {
            margin: 60px 0;
            text-align: center;
        }

        .jumbotron h1 {
            font-size: 72px;
            line-height: 1;
        }

        .jumbotron .btn {
            font-size: 21px;
            padding: 14px 24px;
        }

        .marketing {
            margin: 60px 0;
        }

        .marketing p+h4 {
            margin-top: 28px;
        }

        .form-signin {
            max-width: 400px;
            padding: 30px 30px 30px;
            margin: 0 auto 20px;
            background-color: #fff;
            border: 1px solid #e8e8e8;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
        }

        .form-signin .form-signin-heading, .form-signin .checkbox {
            margin-bottom: 10px;
        }

        .form-signin input[type="text"], .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }

            /* css for timepicker */
        .ui-timepicker-div .ui-widget-header {
            margin-bottom: 8px;
        }

        .ui-timepicker-div dl {
            text-align: left;
        }

        .ui-timepicker-div dl dt {
            height: 25px;
            margin-bottom: -25px;
        }

        .ui-timepicker-div dl dd {
            margin: 0 10px 10px 65px;
        }

        .ui-timepicker-div td {
            font-size: 90%;
        }

        .ui-tpicker-grid-label {
            background: none;
            border: none;
            margin: 0;
            padding: 0;
        }

        .ui-timepicker-rtl {
            direction: rtl;
        }

        .ui-timepicker-rtl dl {
            text-align: right;
        }

        .ui-timepicker-rtl dl dd {
            margin: 0 65px 10px 10px;
        }

    </style>
</head>
<body>
<div class="container-narrow">
    <div class="masthead">
        <ul class="nav nav-pills pull-right">
            <li class="active"><a
                    href="/"><fmt:message key="menu.home"/> </a></li>
            <li><a href="#"><fmt:message key="menu.aboutUs"/></a></li>
            <%--<li><a href="#"><fmt:message key="menu.contact"/></a></li>--%>

            <c:if test="${ authenticUser != null}">
                <li><a href="profile/index"><fmt:message key="menu.profile"/></a></li>
                <li><a href="/logout"> [<fmt:message key="menu.logout"/>] </a></li>
            </c:if>
            <c:if test="${ authenticUser == null}">
                <li><a href="/login"><fmt:message key="menu.login"/></a></li>
            </c:if>
        </ul>
        <h3 class="muted">
            <a href="/"> <fmt:message key="application.name"/> </a>
        </h3>
    </div>
    <hr>
    <hr>

    <decorator:body/>

    <hr>
    <hr>
    <div class="footer">
        <p align="center"><a href="${pageContext.request.servletPath}"><fmt:message key="application.name"/></a> .
            Brought to you by&nbsp;&nbsp;
            <a target="_blank" href="http://www.codexplo.net">Bazlur Rahman</a> | <a
                    href="${pageContext.request.servletPath}/privacy"><fmt:message
                    key="menu.privacy"/>
        </p>
    </div>
</div>
</body>
</html>