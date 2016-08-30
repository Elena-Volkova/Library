<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">Постановление о возбуждении исполнительного производства</div>
                <div class="panel-body">
                    <p><img class="img-responsive" src="${pageContext.request.contextPath}/resources/core/images/gerb.jpg"></p>
                    <p>Номер производства: <c:out value="${process.id}"/></p>
                    <p>Взыскатель: <c:out value="${process.foreClosure.creditor}"/></p>
                    <p>Дата поступления: <c:out value="${process.production.addedDate}"/></p>
                    <p>Вид документа: <c:out value="${process.production.type.name}"/></p>
                    <p>Вид взыскания: <c:out value="${process.foreClosure.subType.name}"/></p>
                    <p>Должник: <c:out value="${process.debtor.name}"/></p>
                    <p>Адрес должника:</p>
                    <p><c:out value="${process.debtor.address.country}"/></p>
                    <p><c:out value="${process.debtor.address.city}"/></p>
                    <p><c:out value="${process.debtor.address.street}"/> <c:out
                            value="${process.debtor.address.house}"/>-<c:out
                            value="${process.debtor.address.flat}"/></p>
                    <p></p>
                    <p>Сумма задолженности: <c:out value="${process.foreClosure.amountAll}"/></p>
                    <p>-----------------------------------------—</p>
                    <p> Судебный исполнитель отдела принудительного исполнения возбудил в отношении должника
                        исполнительное производство.</p>
                    <p> Исполнительный документ оформлен надлежащим образом и предъявлен в установленные
                        законодательством сроки.</p>
                    <p> Оснований для отказа в возбуждении исполнительного производства не установлено.</p>
                    <p> В связи с чем, должнику предоставляется семидневный срок со дня получения данного постановления
                        добровольно погасить задолженность и предъявить квитанцию об оплате.</p>
                    <p> В случае неявки должника по вызову без уважительной причины он может быть подвергнут судом
                        приводу в соответствии со статьей 169 Гражданского процессуального кодекса Республики Беларусь
                        или привлечен к административной ответственности по статье 24.6 Кодекса Республики Беларусь об
                        административных правонарушениях.</p>

                    <p>Отдел принудительного исполнения</p>
                    <p>г.Минск, ул. Маяковского 119а</p>
                    <p>Тел. 256-67-89</p>
                    <p>-------------------------------------------</p>
                </div>
            </div>
        </div>
        <div class="col-md-3"></div>
    </div>
</div>
</body>
</html>
