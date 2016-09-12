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
                    <li><a href="${pageContext.request.contextPath}/user/books_search" role="button" class="">Поиск книг</a></li>
                    <li class="active"><a href="${pageContext.request.contextPath}/user/tracking" role="button" class="">Я читаю</a></li>
                    <li><a href="${pageContext.request.contextPath}/user/user" role="button" class="">Мой профиль</a></li>
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
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-body">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Библиотека</th>
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
                                <td><c:out value="${userCard.library.name}"/></td>
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
