<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Airports</title>
</head>
<body>

<form action="/">
    <table>
        <tr>
            <td>
                <select name="country">
                    <option></option>
                    <c:forEach items="${paramList}" var="country">
                        <option value="${country}"><c:out value="${country}"/></option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <input type="submit" value="Поиск"/>
            </td>
        </tr>
    </table>
</form>

<div>
    <table class="tg">
        <tr>
            <th>№</th>
            <th>Название аэропорта</th>
            <th>Город</th>
            <th>Страна</th>
            <th>Код IATA</th>
            <th>Код ICAO</th>
            <th>Широта</th>
            <th>Долгота</th>
            <th>Высота НУМ (ft)</th>
            <th>UTC+</th>
            <th>DST</th>
            <th>Часовой пояс</th>
            <th>Тип</th>
            <th>Источник</th>
        </tr>
        <c:forEach items="${airportList}" var="airport">
            <tr>
                <td>${airport.n}</td>
                <td>${airport.nameAirport}</td>
                <td>${airport.city}</td>
                <td>${airport.country}</td>
                <td>${airport.iata}</td>
                <td>${airport.icao}</td>
                <td>${airport.latitude}</td>
                <td>${airport.longitude}</td>
                <td>${airport.num}</td>
                <td>${airport.tz}</td>
                <td>${airport.dst}</td>
                <td>${airport.tzName}</td>
                <td>${airport.type}</td>
                <td>${airport.source}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
