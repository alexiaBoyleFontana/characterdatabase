<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="include/header.jsp"/>

<link rel="stylesheet" href="/pub/css/home.css">

<div class="grid-container">

    <h1 id="welcome">Character Database</h1>

    <p>
        Keep track of the many characters in your stories. Create stories, add characters to them, and edit and view them as you please. Please <a href="/register">create an account</a> or <a href="/login">login</a> to begin.
    </p>

    <div class="dropdown" style="margin: auto;">
        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
            Search
        </button>
        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
            <li><a class="dropdown-item" href="/search/char"> Search Characters </a> </li>
            <li><a class="dropdown-item" href="/search/world">Search Worlds</a></li>
            <li><a class="dropdown-item">Filter Search</a></li>
        </ul>
    </div>

</div>

<jsp:include page="include/footer.jsp"/>