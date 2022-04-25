<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<div class="grid-container">

    <h2 id="welcome"> Login </h2>

    <div>
    <form action="/login" method="POST" style="text-align: center">
        <table class="table">
            <tbody>
            <tr>
                <td>Username</td>
                <td><input type="text" name="username" id="usernameId"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="text" name="password" id="passId"></td>
            </tr>
            </tbody>
        </table>
        <div class="button">
            <button id="submit" class="btn btn-dark" action="/login"> Login </button>
        </div>
    </form>

    </div>




</div>

<jsp:include page="../include/footer.jsp"/>