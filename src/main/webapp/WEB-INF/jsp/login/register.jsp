<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<div class="grid-container">

    <h2 id="welcome"> Register </h2>

    <div>
    <form action="/registerSubmit" method="post" style="text-align: center">
        <table class="table">
            <tbody>
            <tr>
                <td style="text-align: right;">Username</td>
                <td><input type="text" name="username" id="usernameId"></td>
            </tr>
            <tr>
                <td style="text-align: right;">Password</td>
                <td><input type="text" name="password" id="passId"></td>
            </tr>
            <tr>
                <td style="text-align: left;">Confirm Password</td>
                <td><input type="text" name="confirmPassword" id="cPassId"></td>
            </tr>
            </tbody>
        </table>
        <div class="button">
            <button id="submit" class="btn btn-dark"> Register </button>
        </div>
    </form>
    </div>



</div>

<jsp:include page="../include/footer.jsp"/>