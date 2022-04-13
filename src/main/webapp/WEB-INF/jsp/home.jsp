<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="include/header.jsp"/>

<link rel="stylesheet" href="/pub/css/home.css">

<div class="grid-container">

    <img src="/pub/images/castle.png" height="350vh" width="1280vh">

    <h1 id="welcome">Character Database</h1>

    <p>
        Keep track of the many characters in your stories. Create stories, add characters to them, and edit and view them as you please. Please <a href="register.html">create an account</a> or <a href="login.html">login</a> to begin.
    </p>

    <div class="dropdown" style="margin: auto;">
        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
            Search
        </button>
        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
            <li><a class="dropdown-item">Search Characters</a></li>
            <li><a class="dropdown-item">Search Worlds</a></li>
            <li><a class="dropdown-item">Filter Search</a></li>
        </ul>
    </div>

    <table class="table">
        <thead>
        <tr class="table-dark">
            <th scope="col">#</th>
            <th scope="col">Character</th>
            <th scope="col">World</th>
            <th scope="col">Race</th>
            <th scope="col">Title</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${characters}" var="character">
            <tr>
                <th scope="row"> ${character.id}</th>
                <td>${character.name}</td>
                <td>${character.worldId}</td>
                <td>${character.race}</td>
                <td>${character.title}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

<jsp:include page="include/footer.jsp"/>