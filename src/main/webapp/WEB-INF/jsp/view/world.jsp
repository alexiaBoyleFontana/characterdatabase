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

    <h3 id="welcome">${world.name}</h3>

    <div>
        <table class="table">
            <thead class="table-dark">
            <th scope="col"></th>
            <th scope="col"></th>
            </thead>
            <tbody>
            <tr>
                <td>Name</td>
                <td>${world.name}</td>
            </tr>
            <tr>
                <td>Medium</td>
                <td>${world.medium}</td>
            </tr>
            <tr>
                <td>Description</td>
                <td>${world.desc}</td>
            </tr>
            <tr>
                <td>Characters</td>
                <td>
                    <list>
                        <c:forEach items="${world.characters}" var="character">
                            <li>
                                <a href="/char/${character.id}"> ${character.name}</a>
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
        <form action="/world/submit" method="post" id="editForm" hidden>
            <input type="hidden" name="id" value="${world.id}">
            <table class="table">
                <thead class="table-dark">
                <th scope="col"></th>
                <th scope="col"></th>
                </thead>
                <tbody>
                <tr>
                    <td>World</td>
                    <td><input type="text" name="name" id="nameId" value="${world.name}"></td>
                </tr>
                <tr>
                    <td>Medium</td>
                    <td><input type="text" name="medium" id="mediumId" value="${world.medium}"></td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td><input type="text" name="description" id="descriptionId" value="${world.desc}"></td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>
    <div class="button">
        <a class="btn btn-danger" id="delete" hidden href="/world/delete/${world.id}">
            Delete World
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