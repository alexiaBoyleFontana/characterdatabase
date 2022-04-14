<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="include/header.jsp"/>

<link rel="stylesheet" href="/pub/css/home.css">

<div class="grid-container">

    <img src="/pub/images/castle.png" height="350vh" width="1280vh">

    <h3 id="welcome">Characters</h3>

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
                <th scope="row"> ${character.id}</th>
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

</div>

<jsp:include page="include/footer.jsp"/>