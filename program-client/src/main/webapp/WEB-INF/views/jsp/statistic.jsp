<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Список производств</title>
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
        $("#statisticByUser").click(function () {
            var userId = $("#statisticUser").val();
            window.location.replace("${pageContext.request.contextPath}/user/statistic/user?userId=" + userId);
        });
        $("#from").datepicker({
            defaultDate: "+1w",
            numberOfMonths: 3,
            onClose: function (selectedDate) {
                $("#to").datepicker("option", "minDate", selectedDate);
            }
        }).attr('readonly', 'readonly');
        $("#to").datepicker({
            defaultDate: "+1w",
            numberOfMonths: 3,
            onClose: function (selectedDate) {
                $("#from").datepicker("option", "maxDate", selectedDate);
            }
        }).attr('readonly', 'readonly');
    });
</script>

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
            <a href="${pageContext.request.contextPath}/user/statistic/field" role="button"
               class="btn btn-success">Вывести статистику по отделу</a>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4">
            <button id="statisticByUser" type="button" class="btn btn-success">Вывести статистику по судебному
                исполнителю</button>
        </div>
        <div class="col-md-4">
            <select id="statisticUser" class="form-control">
                <c:forEach var="userPerson" items="${users}">
                    <option
                            <c:if test="${search.user == userPerson.id}">selected</c:if>
                            value="${userPerson.id}">${userPerson.username}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-md-3">
        </div>
        <div class="col-md-1">
            <a href="${pageContext.request.contextPath}/user" role="button"
               class="btn btn-success">Назад</a>
        </div>
    </div>
    <form:form method="post" modelAttribute="search">
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-2">
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <form:label path="subType">Вид взыскания:</form:label>
                                    <select id="subType" name="subType" class="form-control">
                                        <option value="0">Выберите вид взыскания</option>
                                        <option value="" disabled>— Виды взысканий по уголовным делам</option>
                                        <option
                                                <c:if test="${search.subType == 1}">selected</c:if> value="1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Возмещение
                                            ущерба, причиненного преступлением
                                        </option>
                                        <option
                                                <c:if test="${search.subType == 2}">selected</c:if> value="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Моральный
                                            вред по уголовному делу
                                        </option>
                                        <option
                                                <c:if test="${search.subType == 3}">selected</c:if> value="3">
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Вещественные доказательства
                                        </option>
                                        <option
                                                <c:if test="${search.subType == 4}">selected</c:if> value="4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Уголовные
                                            штрафы
                                        </option>
                                        <option
                                                <c:if test="${search.subType == 5}">selected</c:if> value="5">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Услуги
                                            адвоката
                                        </option>
                                        <option
                                                <c:if test="${search.subType == 6}">selected</c:if> value="6">
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Конфискации по уголовному делу
                                        </option>
                                        <option
                                                <c:if test="${search.subType == 7}">selected</c:if> value="7">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Другие
                                            взыскания по уголовным делам
                                        </option>
                                        <option value="" disabled>— Виды взысканий по гражданским делам</option>
                                        <option
                                                <c:if test="${search.subType == 8}">selected</c:if> value="8">
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Страхование
                                        </option>
                                        <option
                                                <c:if test="${search.subType == 9}">selected</c:if> value="9">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Затраты
                                            на
                                            обучение
                                        </option>
                                        <option <c:if test="${search.subType == 10}">selected</c:if>value="10">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Телефон
                                            и
                                            иные услуги связи
                                        </option>
                                        <option
                                                <c:if test="${search.subType == 11}">selected</c:if> value="11">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Трудовые
                                        </option>
                                        <option
                                                <c:if test="${search.subType == 12}">selected</c:if> value="12">
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Интеллектуальная собственность
                                        </option>
                                        <option
                                                <c:if test="${search.subType == 13}">selected</c:if> value="13">
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Причинение вреда жизни и здоровью
                                        </option>
                                        <option
                                                <c:if test="${search.subType == 14}">selected</c:if> value="14">
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Возмещение материального ущерба
                                        </option>
                                        <option
                                                <c:if test="${search.subType == 15}">selected</c:if> value="15">
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Моральный вред по гражданскому делу
                                        </option>
                                        <option
                                                <c:if test="${search.subType == 16}">selected</c:if> value="16">
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Экологические
                                        </option>
                                        <option
                                                <c:if test="${search.subType == 17}">selected</c:if> value="17">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Защита
                                            прав потребителей
                                        </option>
                                        <option
                                                <c:if test="${search.subType == 18}">selected</c:if> value="18">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Защита
                                            чести и достоинства
                                        </option>
                                        <option
                                                <c:if test="${search.subType == 19}">selected</c:if> value="19">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Иные
                                            взыскания по гражданским делам
                                        </option>
                                        <option
                                                <c:if test="${search.subType == 20}">selected</c:if> value="20">
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Взыскание в пользу банков
                                        </option>
                                        <option value="" disabled>— Виды взысканий по административным делам</option>
                                        <option
                                                <c:if test="${search.subType == 21}">selected</c:if> value="21">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Штрафы
                                        </option>
                                        <option
                                                <c:if test="${search.subType == 22}">selected</c:if> value="22">
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Конфискация по административному делу
                                        </option>
                                        <option
                                                <c:if test="${search.subType == 23}">selected</c:if> value="23">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Прочие
                                            взыскания по административным делам
                                        </option>
                                        <option value="" disabled>— Процессуальные виды взысканий</option>
                                        <option
                                                <c:if test="${search.subType == 24}">selected</c:if> value="24">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;За
                                            проведение экспертизы
                                        </option>
                                        <option
                                                <c:if test="${search.subType == 25}">selected</c:if> value="25">
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Госпошлина
                                        </option>
                                        <option
                                                <c:if test="${search.subType == 26}">selected</c:if> value="26">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Штрафы,
                                            предусмотренные ГПК РБ
                                        </option>
                                        <option
                                                <c:if test="${search.subType == 27}">selected</c:if> value="27">
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Наложение ареста на имущество
                                        </option>
                                        <option
                                                <c:if test="${search.subType == 28}">selected</c:if> value="28">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Расходы
                                            на розыск
                                        </option>
                                        <option
                                                <c:if test="${search.subType == 29}">selected</c:if> value="29">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Прочие
                                            процессуальные взыскания
                                        </option>
                                        <option
                                                <c:if test="${search.subType == 30}">selected</c:if> value="30">
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Моральный вред по гражданскому делу
                                        </option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <form:label path="result">Результат исполнения:</form:label>
                                    <select id="result" name="result" class="form-control">
                                        <option value="">Выберите результат исполнения</option>
                                        <option
                                                <c:if test="${search.result eq 'На исполнении'}">selected</c:if>
                                                value="На исполнении">На исполнении
                                        </option>
                                        <option
                                                <c:if test="${search.result eq 'Исполнено'}">selected</c:if>
                                                value="Исполнено">
                                            Исполнено
                                        </option>
                                        <option
                                                <c:if test="${search.result eq 'Направлено по месту работы'}">selected</c:if>
                                                value="Направлено по месту работы">Направлено по месту работы
                                        </option>
                                        <option
                                                <c:if test="${search.result eq 'Иное'}">selected</c:if> value="Иное">
                                            Иное
                                        </option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <form:label path="user">Исполнитель:</form:label>
                                    <select id="user" name="user" class="form-control">
                                        <option value="0">Выберите исполнителя</option>
                                        <c:forEach var="userPerson" items="${users}">
                                            <option
                                                    <c:if test="${search.user == userPerson.id}">selected</c:if>
                                                    value="${userPerson.id}">${userPerson.username}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <p>Период</p>
                                    <form:label path="dateFrom">от :</form:label>
                                    <form:input id="from" cssClass="form-control datepicker" path="dateFrom"/>
                                    <form:label path="dateTo">до :</form:label>
                                    <form:input id="to" cssClass="form-control datepicker" path="dateTo"/>
                                </div>
                            </div>
                            <div class="col-md-2">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <input type="hidden"
                                       name="${_csrf.parameterName}"
                                       value="${_csrf.token}"/>
                                <button type="submit" class="btn btn-success">Поиск</button>
                                <a href="${pageContext.request.contextPath}/user/statistic" role="button"
                                   class="btn btn-danger">Очистить
                                    результаты поиска</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form:form>
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-body">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Должник</th>
                            <th>Взыскатель</th>
                            <th>Исполнитель</th>
                            <th>Вид взыскания</th>
                            <th>Дата начала производства</th>
                            <th>Дата окончания производства</th>
                            <th>Результат исполнения производства</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="process" items="${processes}">
                            <tr>
                                <th scope="row"><c:out value="${process.id}"/></th>
                                <td><c:out value="${process.debtor.name}"/></td>
                                <td><c:out value="${process.foreClosure.creditor}"/></td>
                                <td><c:out value='${process.user.username}'/></td>
                                <td><c:out value="${process.foreClosure.subType.name}"/></td>
                                <td><c:out value="${process.production.addedDate}"/></td>
                                <td><c:out value="${process.dateOfEndOfProduction}"/></td>
                                <td><c:out value="${process.result}"/></td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/user/report/${process.id}" role="button"
                                       class="btn btn-success btn-large" target="_blank">Отчет для печати по
                                        производству</a>
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
            </div>
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Вы действительно хотите удалить производство?</p>
            <div class="modal-footer">
                <button type="button"
                        onclick="window.location.replace('${pageContext.request.contextPath}/user/delete/' + $('#currentId').val())"
                        class="btn btn-danger">Удалить
                </button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Отмена</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
