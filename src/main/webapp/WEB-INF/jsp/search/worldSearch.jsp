<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<link rel="stylesheet" href="/pub/css/home.css">
<c:set var="count" value="0" scope="page" />

<div class="grid-container">

    <h3 id="welcome">Worlds</h3>

    <div>
        <form action="/search/world" method="get">
            <input type="text" name="search" id="searchId" value="${searchValue}">
            <button type="submit" class="btn btn-dark">Search</button>
        </form>
    </div>

    <table class="table">
        <thead>
        <tr class="table-dark">
            <th scope="col">#</th>
            <th scope="col">World</th>
            <th scope="col">Medium</th>
            <th scope="col">Description</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${worlds}" var="world">
            <tr>
                <c:set var="count" value="${count + 1}" scope="page"/>
                <th scope="row"> ${count}</th>
                <td><a href="/world/${world.id}"> ${world.name} </a> </td>
                <td>${world.medium}</td>
                <td>${world.desc}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="button">
        <a href="/create" class="btn btn-dark" role="button">
            Create
        </a>
    </div>

</div>

<jsp:include page="../include/footer.jsp"/>