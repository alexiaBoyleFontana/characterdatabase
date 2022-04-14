<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<div class="grid-container">

    <h2> Register </h2>

    <form action="/registerSubmit" method="post">
        Username <input type="text" name="username" id="usernameId"> <br>
        Password <input type="text" name="password" id="passId"> <br>
        Confirm Password <input type="text" name="confirmPassword" id="cPassId"> <br>

        <button id="submit"> Input </button>
    </form>



</div>

<jsp:include page="../include/footer.jsp"/>