<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Отчет</title>
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
<button type="button" class="btn btn-default" onclick="$(this).hide();window.print()">Напечатать эту страницу</button>
<div class="container">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">Основная информация</div>
                <div class="panel-body">
                    <p><img class="img-responsive"
                            src="${pageContext.request.contextPath}/resources/core/images/gerb.jpg"></p>
                    <p>Отдел принудительного исполнения</p>
                    <p>Дата: <fmt:formatDate pattern="dd.MM.yyyy" value="${report.currentDate}"/></p>
                    <p>На исполнении: <c:out value="${report.count}"/></p>
                    <c:forEach var="entry" items="${report.statisticByResult}">
                        <p>${entry.key}: ${entry.value} производств/производство</p>
                    </c:forEach>
                    <p>Сумма взыскания: <c:out value="${report.amount}"/></p>
                </div>
            </div>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>
</body>
</html>
