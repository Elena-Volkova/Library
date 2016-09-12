<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <form:form modelAttribute="tracking" method="post">
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-body">

                        <form:input path="library.id" type="hidden"/>
                        <form:input path="user.id" type="hidden"/>

                        <div class="form-group">
                            <form:label path="library.name">Библиотека:</form:label>
                            <form:input path="library.name" cssClass="form-control" disabled="true"/>
                        </div>

                        <div class="form-group">
                            <form:label path="name">Введите название:</form:label>
                            <form:input path="name" cssClass="form-control"/>
                        </div>
                        <div class="form-group">
                            <form:label path="author">Введите автора:</form:label>
                            <form:input path="author" cssClass="form-control"/>
                        </div>
                        <div class="form-group">
                            <form:label path="publisher">Введите издательство:</form:label>
                            <form:input path="publisher" cssClass="form-control"/>
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
    <div>Выберите книгу</div>

    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-body">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Название</th>
                            <th>Автор</th>
                            <th>Издательство</th>
                            <th>Год издания</th>
                            <th>Количество страниц</th>
                            <th>Доступность</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="book" items="${tracking.books}">
                            <tr>
                                <th scope="row"><c:out value="${book.id}"/></th>
                                <td><c:out value="${book.name}"/></td>
                                <td><c:out value="${book.author}"/></td>
                                <td><c:out value="${book.publisher}"/></td>
                                <td><c:out value="${book.publishYear}"/></td>
                                <td><c:out value="${book.pages}"/></td>
                                <td><c:choose>
                                    <c:when test="${book.availability}">
                                        Да
                                    </c:when>
                                    <c:otherwise>
                                        Нет
                                    </c:otherwise>
                                </c:choose></td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/admin/tracking/library/${tracking.library.id}/book/${book.id}/user/${tracking.user.id}"
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

    <br/>
    <div>Карта книг пользователя</div>

    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-body">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Книга</th>
                            <th>Автор</th>
                            <th>Издательство</th>
                            <th>Дата выдачи</th>
                            <th>Дата возврата</th>
                            <th>Возвращена</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="userCard" items="${tracking.userCards}">
                            <tr>
                                <th scope="row"><c:out value="${userCard.id}"/></th>
                                <td><c:out value="${userCard.book.name}"/></td>
                                <td><c:out value="${userCard.book.author}"/></td>
                                <td><c:out value="${userCard.book.publisher}"/></td>
                                <td><fmt:formatDate pattern="dd-MM-yyyy" value="${userCard.dateFrom}"/></td>
                                <td><fmt:formatDate pattern="dd-MM-yyyy" value="${userCard.dateTo}"/></td>
                                <td><c:choose>
                                    <c:when test="${userCard.returned}">
                                        Да
                                    </c:when>
                                    <c:otherwise>
                                        Нет
                                    </c:otherwise>
                                </c:choose></td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/admin/tracking/library/${tracking.library.id}/book/${userCard.book.id}/user/${tracking.user.id}/return"
                                       role="button" class="btn btn-warning btn-large">Вернуть книгу</a>
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
