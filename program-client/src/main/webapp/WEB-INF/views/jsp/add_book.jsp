<%@ page import="com.example.application.client.service.model.DocumentTypeEnum" %>
<%@ page import="com.example.application.client.service.model.IdentificationDocumentTypeEnum" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Добавить производство</title>
    <spring:url value="/resources/core/css/hello.css" var="coreCss"/>
    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>
    <spring:url value="/resources/core/css/bootstrap-theme.min.css" var="bootstrapThemeCss"/>
    <spring:url value="/resources/core/css/jquery-ui.css" var="uiThemeCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${bootstrapThemeCss}" rel="stylesheet"/>
    <link href="${uiThemeCss}" rel="stylesheet"/>
    <link href="${coreCss}" rel="stylesheet"/>
    <spring:url value="/resources/core/js/jquery.min.js" var="jqueryJs"/>
    <spring:url value="/resources/core/js/jquery-ui.js" var="jqueryUIJs"/>
    <spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs"/>
    <spring:url value="/resources/core/js/hello.js" var="coreJs"/>
    <script type="text/javascript" src="${jqueryJs}"></script>
    <script type="text/javascript" src="${jqueryUIJs}"></script>
    <script type="text/javascript" src="${bootstrapJs}"></script>
    <script type="text/javascript" src="${coreJs}"></script>
    <style>
        .ui-datepicker-month {
            color: black;
        }

        .ui-datepicker-year {
            color: black;
        }
    </style>
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
<script>
    $(document).ready(function () {
        $(".datepicker").datepicker({
            changeMonth: true,
            changeYear: true,
            yearRange: "1990:2020"
        }).attr('readonly', 'readonly');
    });
</script>

<div class="container">
    <form:form method="post" modelAttribute="process">
        <div class="row">
            <div class="col-md-12">
                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
                <button type="submit" class="btn btn-success">Добавить</button>
                <button type="button" class="btn btn-btn-danger btn-large" data-toggle="modal"
                        data-target=".bs-example-modal-lg">Отменить
                </button>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">Основная информация</div>
                    <div class="panel-body">
                        <div class="form-group">
                            <form:label path="production.addedDate">Дата поступления:</form:label>
                            <form:input cssClass="form-control datepicker" path="production.addedDate"/>
                        </div>
                        <div class="form-group">
                            <form:label path="production.type">Вид документа:</form:label>
                            <select id="production.type" name="production.type" class="form-control">
                                <c:forEach var="type" items="<%= DocumentTypeEnum.values() %>">
                                    <option value="${type}">${type.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <form:label path="production.documentNumber">Номер документа:</form:label>
                            <form:input onkeypress='return event.charCode >= 48 && event.charCode <= 57'
                                        cssClass="form-control" path="production.documentNumber"/>
                        </div>
                        <div class="form-group">
                            <form:label path="production.issuedBy">Кем выдан:</form:label>
                            <form:input cssClass="form-control" path="production.issuedBy"/>
                        </div>
                        <div class="form-group">
                            <form:label path="production.name">Наименование:</form:label>
                            <form:input cssClass="form-control" path="production.name"/>
                        </div>
                        <div class="form-group">
                            <form:label path="foreClosure.subType.id">Вид взыскания:</form:label>
                            <select id="foreClosure.subType.id" name="foreClosure.subType.id" class="form-control">
                                <option value="" disabled>— Виды взысканий по уголовным делам</option>
                                <option value="1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Возмещение ущерба, причиненного
                                    преступлением
                                </option>
                                <option value="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Моральный вред по уголовному делу
                                </option>
                                <option value="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Вещественные доказательства</option>
                                <option value="4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Уголовные штрафы</option>
                                <option value="5">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Услуги адвоката</option>
                                <option value="6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Конфискации по уголовному делу</option>
                                <option value="7">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Другие взыскания по уголовным делам
                                </option>
                                <option value="" disabled>— Виды взысканий по гражданским делам</option>
                                <option value="8">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Страхование</option>
                                <option value="9">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Затраты на обучение</option>
                                <option value="10">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Телефон и иные услуги связи</option>
                                <option value="11">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Трудовые</option>
                                <option value="12">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Интеллектуальная собственность</option>
                                <option value="13">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Причинение вреда жизни и здоровью
                                </option>
                                <option value="14">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Возмещение материального ущерба
                                </option>
                                <option value="15">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Моральный вред по гражданскому делу
                                </option>
                                <option value="16">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Экологические</option>
                                <option value="17">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Защита прав потребителей</option>
                                <option value="18">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Защита чести и достоинства</option>
                                <option value="19">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Иные взыскания по гражданским делам
                                </option>
                                <option value="20">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Взыскание в пользу банков</option>
                                <option value="" disabled>— Виды взысканий по административным делам</option>
                                <option value="21">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Штрафы</option>
                                <option value="22">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Конфискация по административному делу
                                </option>
                                <option value="23">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Прочие взыскания по административным
                                    делам
                                </option>
                                <option value="" disabled>— Процессуальные виды взысканий</option>
                                <option value="24">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;За проведение экспертизы</option>
                                <option value="25">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Госпошлина</option>
                                <option value="26">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Штрафы, предусмотренные ГПК РБ</option>
                                <option value="27">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Наложение ареста на имущество</option>
                                <option value="28">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Расходы на розыск</option>
                                <option value="29">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Прочие процессуальные взыскания
                                </option>
                                <option value="30">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Моральный вред по гражданскому делу
                                </option>
                            </select>
                        </div>
                        <div class="form-group">
                            <form:label path="foreClosure.creditor">Взыскатель:</form:label>
                            <form:input cssClass="form-control" path="foreClosure.creditor"/>
                        </div>
                        <div class="form-group">
                            <form:label
                                    path="foreClosure.amountAll">Всего подлежит взысканию в белорусских рублях:</form:label>
                            <form:input cssClass="form-control" path="foreClosure.amountAll"/>
                        </div>
                        <div class="form-group">
                            <form:label
                                    path="foreClosure.amountToBeCollected">Всего взыскано в белорусских рублях:</form:label>
                            <form:input cssClass="form-control" path="foreClosure.amountToBeCollected"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">Должник</div>
                    <div class="panel-body">
                        <div class="form-group">
                            <form:label path="debtor.name">Должник:</form:label>
                            <form:input cssClass="form-control" path="debtor.name"/>
                        </div>
                        <div class="form-group">
                            <form:label path="debtor.dateOfBirth">Дата рождения:</form:label>
                            <form:input cssClass="form-control datepicker" path="debtor.dateOfBirth"/>
                        </div>
                        <div class="form-group">
                            <form:label path="debtor.citizenship">Гражданство:</form:label>
                            <form:input cssClass="form-control" path="debtor.citizenship"/>
                        </div>
                        <div class="form-group">
                            <form:label path="debtor.identificationNumber">Идентификационный номер:</form:label>
                            <form:input cssClass="form-control" path="debtor.identificationNumber"/>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">Документ удостоверяющий личность</div>
                    <div class="panel-body">
                        <div class="form-group">
                            <form:label
                                    path="debtor.identificationDocument.type">Документ удостоверяющий личность:</form:label>
                            <select id="debtor.identificationDocument.type"
                                    name="debtor.identificationDocument.type"
                                    class="form-control">
                                <c:forEach var="type" items="<%= IdentificationDocumentTypeEnum.values() %>">
                                    <option value="${type}">${type.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <form:label path="debtor.identificationDocument.series">Серия и номер:</form:label>
                            <form:input cssClass="form-control" path="debtor.identificationDocument.series"/>
                        </div>
                        <div class="form-group">
                            <form:label
                                    path="debtor.identificationDocument.issuedBy">Орган, выдавший документ:</form:label>
                            <form:input cssClass="form-control" path="debtor.identificationDocument.issuedBy"/>
                        </div>
                        <div class="form-group">
                            <form:label path="debtor.identificationDocument.date">Дата выдачи:</form:label>
                            <form:input cssClass="form-control datepicker"
                                        path="debtor.identificationDocument.date"/>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">Адрес</div>
                    <div class="panel-body">
                        <div class="form-group">
                            <form:label path="debtor.address.country">Страна:</form:label>
                            <form:input cssClass="form-control" path="debtor.address.country"/>
                        </div>
                        <div class="form-group">
                            <form:label path="debtor.address.field">Область:</form:label>
                            <form:input cssClass="form-control" path="debtor.address.field"/>
                        </div>
                        <div class="form-group">
                            <form:label path="debtor.address.city">Город:</form:label>
                            <form:input cssClass="form-control" path="debtor.address.city"/>
                        </div>
                        <div class="form-group">
                            <form:label path="debtor.address.street">Улица:</form:label>
                            <form:input cssClass="form-control" path="debtor.address.street"/>
                        </div>
                        <div class="form-group">
                            <form:label path="debtor.address.house">Дом:</form:label>
                            <form:input cssClass="form-control" path="debtor.address.house"/>
                        </div>
                        <div class="form-group">
                            <form:label path="debtor.address.housing">Корпус:</form:label>
                            <form:input cssClass="form-control" path="debtor.address.housing"/>
                        </div>
                        <div class="form-group">
                            <form:label path="debtor.address.flat">Квартира:</form:label>
                            <form:input cssClass="form-control" path="debtor.address.flat"/>
                        </div>
                        <div class="form-group">
                            <form:label path="debtor.placeOfWork">Место работы:</form:label>
                            <form:input cssClass="form-control" path="debtor.placeOfWork"/>
                        </div>
                        <div class="form-group">
                            <form:label path="debtor.addressPlaceOfWork">Адрес места работы:</form:label>
                            <form:input cssClass="form-control" path="debtor.addressPlaceOfWork"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">Исполнитель</div>
                    <div class="panel-body">
                        <div class="form-group">
                            <form:label path="user.id">Исполнитель:</form:label>
                            <select id="user.id" name="user.id" class="form-control">
                                <c:forEach var="user" items="${users}">
                                    <option value="${user.id}">${user.username}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <form:label path="termOfExecutionOfTheLaw">Срок исполнению по закону:</form:label>
                            <form:input cssClass="form-control datepicker" path="termOfExecutionOfTheLaw"/>
                        </div>
                        <div class="form-group">
                            <form:label path="termOfVoluntaryCompliance">Срок добровольного исполнения:</form:label>
                            <form:input cssClass="form-control datepicker" path="termOfVoluntaryCompliance"/>
                        </div>
                        <div class="form-group">
                            <form:label path="dateOfEndOfProduction">Дата окончания производства:</form:label>
                            <form:input cssClass="form-control datepicker" path="dateOfEndOfProduction"/>
                        </div>
                        <div class="form-group">
                            <form:label path="deliveryDateArchive">Дата сдачи в архив:</form:label>
                            <form:input cssClass="form-control datepicker" path="deliveryDateArchive"/>
                        </div>
                        <div class="form-group">
                            <form:label path="result">Результат исполнения:</form:label>
                            <select id="result" name="result" class="form-control">
                                <option value="На исполнении">На исполнении</option>
                                <option value="Исполнено">Исполнено</option>
                                <option value="Направлено по месту работы">Направлено по месту работы</option>
                                <option value="Иное">Иное</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form:form>
</div>
<nav class="navbar navbar-default">
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
                <a href="${pageContext.request.contextPath}/user" role="button" class="btn btn-danger">Да</a>
                <button type="button" class="btn btn-default" data-dismiss="modal">Нет</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
