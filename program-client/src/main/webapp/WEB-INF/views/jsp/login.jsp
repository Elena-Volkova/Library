<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Войти</title>
    <spring:url value="/resources/core/css/hello.css" var="coreCss"/>
    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>
    <spring:url value="/resources/core/css/bootstrap-theme.min.css" var="bootstrapThemeCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${bootstrapThemeCss}" rel="stylesheet"/>
    <link href="${coreCss}" rel="stylesheet"/>
    <spring:url value="/resources/core/js/jquery.min.js" var="jqueryJs"/>
    <spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs"/>
    <spring:url value="/resources/core/js/hello.js" var="coreJs"/>
    <script src="${jqueryJs}"></script>
    <script src="${bootstrapJs}"></script>
    <script src="${coreJs}"></script>
</head>
<body onload='document.loginForm.username.focus();'>

<nav class="navbar navbar-default">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <spring:url value="/resources/core/images/logo.png" var="logoImg"/>
                <img src="${logoImg}" class="logo" alt="Logo">
            </div>
            <div class="col-md-9">
                <h2>
                    <p class="text-center">Автоматизация учета книг электронной библиотеки</p>
                </h2>
            </div>
        </div>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <div class="panel panel-default">
                <div class="panel-body">
                    <c:if test="${not empty error}">
                        <div class="error">${error}</div>
                    </c:if>
                    <c:if test="${not empty msg}">
                        <div class="msg">${msg}</div>
                    </c:if>
                    <c:url value="/login" var="loginUrl"/>
                    <form name='loginForm' action="${loginUrl}" method="post">
                        <div class="form-group">
                            <label for="username">Логин</label>
                            <input name="username" class="form-control" id="username" placeholder="Фамилия сотрудника">
                        </div>
                        <div class="form-group">
                            <label for="password">Пароль</label>
                            <input type="password" name="password" class="form-control" id="password"
                                   placeholder="Пароль">
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <button type="submit" class="btn btn-default">Войти</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>
<nav class="navbar navbar-default navbar-fixed-bottom">
    <div class="container">
        <div class="row">
            <div class="col-md-2 col-md-offset-5">&copy; Maksim Volkov 2016</div>
        </div>
    </div>
</nav>
</body>
</html>
