<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<div class="grid-container">

    <h2 id="welcome"> Register </h2>

    <div>
    <form action="/registerSubmit" method="post" style="text-align: center" id="regForm">
        <table class="table">
            <tbody>
            <tr>
                <td style="text-align: right;">Username</td>
                <td><input type="text" name="username" id="usernameId" value="${form.username}"> </td>

            </tr>
            <tr>
                <td style="text-align: right;">Password</td>
                <td><input type="password" name="password" id="passId" value="${form.password}"></td>
            </tr>
            <tr>
                <td style="text-align: left;">Confirm Password</td>
                <td><input type="password" name="confirmPassword" id="cPassId" value="${form.password}"></td>
            </tr>
            </tbody>
        </table>

        <c:forEach items='${bindingResult.getAllErrors()}' var="error">
            <div style="color:red">${error.getDefaultMessage()}</div>
        </c:forEach>
        <div style="color:red" id="passMatch" hidden>Passwords do not match.</div> <br>
        <div class="button">
            <button id="submit" class="btn btn-dark"> Register </button>
        </div>
    </form>
    </div>



</div>

<script src="/pub/js/register.js">
</script>

<jsp:include page="../include/footer.jsp"/>