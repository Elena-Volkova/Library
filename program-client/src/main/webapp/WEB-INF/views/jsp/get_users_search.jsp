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
                    <li><a href="${pageContext.request.contextPath}/admin/libraries" role="button" class="">Библиотеки</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/users" role="button" class="">Пользователи</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/books" role="button" class="">Книги</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/books_search" role="button" class="">Поиск книг</a></li>
                    <li class="active"><a href="${pageContext.request.contextPath}/admin/users_search" role="button" class="">Выдача книг</a></li>
                </ul>
            </div>
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
    <form:form modelAttribute="search" method="post">
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-body">

                        <div class="form-group">
                            <form:label path="library">Выберите библиотеку:</form:label>
                            <form:select path="library" cssClass="form-control">
                                <c:forEach var="library" items="${allLibraries}">
                                    <c:choose>
                                        <c:when test="${search.library.equals(library)}">
                                            <form:option value="${library.id}" selected="true"><c:out value="${library.name}"/></form:option>
                                        </c:when>
                                        <c:otherwise>
                                            <form:option value="${library.id}"><c:out value="${library.name}"/></form:option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </form:select>
                        </div>

                        <div class="form-group">
                            <form:label path="surname">Введите фамилию:</form:label>
                            <form:input path="surname" cssClass="form-control"/>
                        </div>
                        <div class="form-group">
                            <form:label path="name">Введите имя:</form:label>
                            <form:input path="name" cssClass="form-control"/>
                        </div>
                        <div class="form-group">
                            <form:label path="patronymic">Введите отчество:</form:label>
                            <form:input path="patronymic" cssClass="form-control"/>
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
                <button type="submit" class="btn btn-success">Найти</button>
                <a href="${pageContext.request.contextPath}/admin/users_search" role="button"
                   class="btn btn-danger">Очистить
                    результаты поиска</a>
            </div>
        </div>
    </form:form>

    <br/>

    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-body">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Логин</th>
                            <th>Фамилия</th>
                            <th>Имя</th>
                            <th>Отчество</th>
                            <th>Роль</th>
                            <th>Страна</th>
                            <th>Город</th>
                            <th>Улица, номер дома</th>
                            <th>Телефон</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="user" items="${search.users}">
                            <tr>
                                <th scope="row"><c:out value="${user.id}"/></th>
                                <td><c:out value="${user.login}"/></td>
                                <td><c:out value="${user.surname}"/></td>
                                <td><c:out value="${user.name}"/></td>
                                <td><c:out value="${user.patronymic}"/></td>
                                <td><c:out value="${user.role}"/></td>
                                <td><c:out value="${user.address.country}"/></td>
                                <td><c:out value="${user.address.city}"/></td>
                                <td><c:out value="${user.address.street}"/></td>
                                <td><c:out value="${user.address.phone}"/></td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/admin/tracking/library/${search.library.id}/user/${user.id}"
                                       role="button" class="btn btn-warning btn-large">Выдать книгу</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
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
