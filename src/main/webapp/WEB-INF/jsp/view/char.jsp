<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<link rel="stylesheet" href="/pub/css/home.css">

<style>
    #art{
        max-height:400px;
        max-width:400px;
        height:auto;
        width:auto;
    }
</style>

<div class="grid-container">

    <h3 id="welcome">${character.name}</h3>


    <div>
        <c:if test="${not empty character.imageLink}">
            <img id="art" src="${character.imageLink}">
        </c:if>
    </div>
    <div>
    <table class="table">
        <thead class="table-dark">
            <th scope="col"></th>
            <th scope="col"></th>
        </thead>
        <tbody>
            <tr>
                <td>Name</td>
                <td>${character.name}</td>
            </tr>
            <tr>
                <td>World</td>
                <td><a href="/world/${character.world.id}"> ${character.world.name} </a> </td>
            </tr>
            <tr>
                <td>Race</td>
                <td>${character.race}</td>
            </tr>
            <tr>
                <td>Title</td>
                <td>${character.title}</td>
            </tr>
            <tr>
                <td>Affiliations</td>
                <td>
                    <list>
                        <c:forEach items="${character.links}" var="link">
                            <li>
                                <a href="/char/${link.to.id}"> ${link.to.name}</a>
                                <c:if test="${not empty link.relation}"> (${link.relation}) </c:if>
                            </li>
                        </c:forEach>
                    </list>
                </td>
            </tr>
        </tbody>
    </table>
    </div>

    <div class="button">
        <button class="btn btn-dark" type="button" id="edit">
            Edit
        </button>
    </div>
    <div>
    <form action="/char/submit" method="post" id="editForm" hidden>
        <input type="hidden" name="id" value="${character.id}">
        <table class="table">
            <thead class="table-dark">
            <th scope="col">Details</th>
            <th scope="col"></th>
            </thead>
            <tbody>
            <tr>
                <td>Image Link</td>
                <td><input type="text" name="img" id="imgId" value="${character.imageLink}"></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" id="nameId" value="${character.name}"></td>
            </tr>
            <tr>
                <td>World</td>
                <td><input type="text" name="world" id="worldId" value="${character.world.name}"></td>
            </tr>
            <tr>
                <td>Race</td>
                <td><input type="text" name="race" id="raceId" value="${character.race}"></td>
            </tr>
            <tr>
                <td>Title</td>
                <td><input type="text" name="title" id="titleId" value="${character.title}"></td>
            </tr>
            </tbody>
        </table>
        <div>
            <table class="table">
                <thead class="table-dark">
                <th scope="col">Affiliations</th>
                <th scope="col">
                    <div style="align-items: end">
                    <button class="btn btn-dark" type="button" id="addAffil" style="align-self: end">
                        <b>+</b>
                    </button>
                </div>
                </th>
                </thead>
                <tbody id="affilBody">

                    <c:forEach items="${character.links}" var="link">
                    <tr>
                        <td>
                            Name &nbsp <input type="text" name="links" value="${link.to.name}">
                        &nbsp Relationship <input type="text" name="relationships" value="<c:if test="${not empty link.relation}">${link.relation}</c:if>">
                        </td>
                    </tr>
                    </c:forEach>

                <tr>
                    <td>
                        Name &nbsp <input type="text" name="links">
                        &nbsp Relationship <input type="text" name="relationships">
                    </td>
                </tr>
                </tbody>
            </table>
        </div>

    </form>

    </div>

    <div class="button">
        <a class="btn btn-danger" id="delete" hidden href="/char/delete/${character.id}">
                Delete Character
        </a>
    </div>

    <div id="formCheck" hidden>
        <input type="checkbox" id="confirmCheck">
        <label for="confirmCheck"> Confirm </label><br>
    </div>


</div>

<script src="/pub/js/view.js">
</script>

<jsp:include page="../include/footer.jsp"/>