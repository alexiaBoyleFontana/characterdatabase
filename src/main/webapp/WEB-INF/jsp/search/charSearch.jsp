<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<link rel="stylesheet" href="/pub/css/home.css">
<c:set var="count" value="0" scope="page" />

<div class="grid-container">

    <h3 id="welcome">Characters</h3>

    <div>
    <form action="/search/char" method="get">
        <input type="text" name="search" id="searchId" value="${searchValue}">
        <button type="submit" class="btn btn-dark">Search</button>
    </form>
    </div>

    <table class="table">
        <thead>
        <tr class="table-dark">
            <th scope="col">#</th>
            <th scope="col">Character</th>
            <th scope="col">World</th>
            <th scope="col">Race</th>
            <th scope="col">Title</th>
            <th scope="col">Links</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${characters}" var="character">
            <tr>
                <c:set var="count" value="${count + 1}" scope="page"/>
                <th scope="row"> ${count}</th>
                <td><a href="/char/${character.id}"> ${character.name} </a> </td>
                <td><a href="/world/${character.world.id}"> ${character.world.name} </a> </td>
                <td>${character.race}</td>
                <td>${character.title}</td>
                <td>
                    <c:forEach items="${character.links}" var="link">
                        <a href="/char/${link.to.id}"> ${link.to.name}</a>
                        <c:if test="${not empty link.relation}"> (${link.relation}) </c:if> ;
                    </c:forEach>
                </td>
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