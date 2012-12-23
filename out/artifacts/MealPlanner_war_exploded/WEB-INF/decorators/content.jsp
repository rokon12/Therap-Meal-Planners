<%--
  Created by IntelliJ IDEA.
  User: rokon
  Date: 12/13/12
  Time: 10:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8">

    <title>
        <decorator:title/>
    </title>
    <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.css'/>" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bootstrap-wysihtml5.css'/>"/>

    <link rel="shortcut icon" href="<c:url value='/resources/favicon.ico'/>" type="image/x-icon">
    <link rel="icon" href="<c:url value='/resources/favicon.ico'/>" type="image/x-icon">

    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/prettify.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bootstrap-wysihtml5.css'/>"/>

    <script type="text/javascript" src="<c:url value='/resources/js/wysihtml5-0.3.0.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/jquery-1.7.2.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/prettify.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/bootstrap-wysihtml5.js'/>"></script>


    <script type="text/javascript">

        jQuery(document).ready(function () {
            jQuery(".richtext").wysihtml5();
        });
    </script>

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

            /* Main marketing message and sign up button */
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

            /* Supporting marketing content */
        .marketing {
            margin: 60px 0;
        }

        .marketing p+h4 {
            margin-top: 28px;
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
            <li><a href="#"><fmt:message key="menu.contact"/></a></li>

            <c:if test="${pageContext['request'].userPrincipal != null}">
                <spring:url value="/static/j_spring_security_logout" var="logout"/>
                <li><a href="profile/index"><fmt:message key="menu.profile"/></a></li>
                <li><a href="${logout}"> [<fmt:message key="menu.logout"/>] </a></li>
            </c:if>
            <c:if test="${pageContext['request'].userPrincipal == null}">
                <li><a href="login"><fmt:message key="menu.login"/></a></li>
            </c:if>
        </ul>
        <h3 class="muted">
            <a href="/"> <fmt:message key="application.name"/> </a>
        </h3>
    </div>
    <hr>
    <decorator:body/>

    <hr>
    <div class="footer">
        <p align="center"><a href="/"><fmt:message key="application.name"/></a> . Brought to you by&nbsp;&nbsp;
            <a target="_blank" href="http://www.codexplo.wordpress.com">Code Explosion</a> | <a
                    href="/privacy"><fmt:message
                    key="menu.privacy"/> </a> | <a
                    href="?locale=en">
                <fmt:message key="language.english"/>
            </a> | <a href="?locale=bn"><fmt:message key="language.bangla"/></a>
        </p>
    </div>
</div>
</body>
</html>