<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Список библиотек</title>
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
                <img src="${logoImg}" alt="Logo">
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
            <div class="col-md-12">
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
    <c:if test="${not empty msg}">
        <div class="row">
            <div class="col-md-12">
                <div class="msg">${msg}</div>
            </div>
        </div>
    </c:if>

    <div class="row">
        <div class="col-md-12">
            <a href="${pageContext.request.contextPath}/admin/library" role="button" class="btn btn-success btn-large">Добавить</a>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-body">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Название библиотеки</th>
                            <th>Страна</th>
                            <th>Город</th>
                            <th>Улица, номер дома</th>
                            <th>Телефон</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="library" items="${libraries}">
                            <tr>
                                <th scope="row"><c:out value="${library.id}"/></th>
                                <td><c:out value="${library.name}"/></td>
                                <td><c:out value="${library.address.country}"/></td>
                                <td><c:out value="${library.address.city}"/></td>
                                <td><c:out value="${library.address.street}"/></td>
                                <td><c:out value="${library.address.phone}"/></td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/admin/library/${library.id}"
                                       role="button" class="btn btn-warning btn-large">Редактировать</a>
                                    <button data-id="${library.id}" type="button" class="delete-button-class btn btn-danger btn-large"
                                            data-toggle="modal"
                                            data-target=".bs-example-modal-lg">Удалить
                                    </button>
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
<input id="currentId" type="hidden">
<script>
    $(document).ready(function () {
        $(".delete-button-class").click(function () {
            $("#currentId").val($(this).attr('data-id'));
        });
    });
</script>
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
                <h4 class="modal-title">Удаление</h4>
            </div>
            <div class="modal-body">
                <p>Вы действительно хотите удалить библиотеку?</p>
            </div>
            <div class="modal-footer">
                <button type="button"
                        onclick="window.location.replace('${pageContext.request.contextPath}/admin/library/' + $('#currentId').val() + '/delete')"
                        class="btn btn-danger">Удалить
                </button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Отмена</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
