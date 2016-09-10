<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Добавить сотрудника</title>
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
<body>

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
<nav class="navbar navbar-default">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <ul class="nav nav-pills">
                    <li class="active"><a href="${pageContext.request.contextPath}/admin/libraries" role="button" class="">Библиотеки</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/users" role="button" class="">Пользователи</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/books" role="button" class="">Книги</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/books" role="button" class="">жырафик</a></li>
                </ul>
            </div>
            <div class="col-md-3">
                <c:url value="/logout" var="logoutUrl"/>
                <!-- csrt support -->

                <form action="${logoutUrl}" method="post" id="logoutForm">
                    <input type="hidden"
                           name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>
                </form>
                <script>
                    function formSubmit() {
                        document.getElementById("logoutForm").submit();
                    }
                </script>
                <p class="text-right">
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        Добро пожаловать : ${pageContext.request.userPrincipal.name} | <a
                            href="javascript:formSubmit()"> Выйти</a>
                    </c:if>
                </p>
            </div>
        </div>
    </div>
</nav>


<div class="container">
    <form:form modelAttribute="library" method="post">
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-body">

                        <form:input path="id" type="hidden"/>
                        <form:input path="address.id" type="hidden"/>

                        <div class="form-group">
                            <form:label path="name">Название библиотеки:</form:label>
                            <form:input path="name" required="true" cssClass="form-control"/>
                        </div>
                        <div class="form-group">
                            <form:label path="address.country">Страна:</form:label>
                            <form:input path="address.country" required="true" cssClass="form-control"/>
                        </div>
                        <div class="form-group">
                            <form:label path="address.city">Город:</form:label>
                            <form:input path="address.city" required="true" cssClass="form-control"/>
                        </div>
                        <div class="form-group">
                            <form:label path="address.street">Улица, номер дома:</form:label>
                            <form:input path="address.street" required="true" cssClass="form-control"/>
                        </div>
                        <div class="form-group">
                            <form:label path="address.phone">Телефон:</form:label>
                            <form:input path="address.phone" required="true" cssClass="form-control"/>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
                <button type="submit" class="btn btn-success">
                    <c:choose>
                        <c:when test="${empty library.id}">
                            Добавить
                        </c:when>
                        <c:otherwise>
                            Обновить
                        </c:otherwise>
                    </c:choose>
                </button>
                <button type="button" class="btn btn-btn-danger btn-large" data-toggle="modal"
                        data-target=".bs-example-modal-lg">Отменить
                </button>
            </div>
        </div>
    </form:form>
</div>
<nav class="navbar navbar-default navbar-fixed-bottom">
    <div class="container">
        <div class="row">
            <div class="col-md-2 col-md-offset-5">&copy; Maksim Volkov 2016</div>
        </div>
    </div>
</nav>
<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Отмена</h4>
            </div>
            <div class="modal-body">
            </div>
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Вы действительно хотите отменить?</p>
            <div class="modal-footer">
                <a href="${pageContext.request.contextPath}/admin/libraries" role="button" class="btn btn-danger">Да</a>
                <button type="button" class="btn btn-default" data-dismiss="modal">Нет</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
