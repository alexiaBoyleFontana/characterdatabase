<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<div class="grid-container">

    <h2> Login </h2>

    <form action="/login" method="POST">
        Username <input type="text" name="username" id="usernameId"> <br>
        Password <input type="text" name="password" id="passId"> <br>

        <button id="submit"> Login </button>
    </form>



</div>

<jsp:include page="../include/footer.jsp"/>