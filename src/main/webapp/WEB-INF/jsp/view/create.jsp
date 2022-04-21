<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<link rel="stylesheet" href="/pub/css/home.css">

<div class="grid-container">

    <h3 id="welcome">Create</h3>

    <div class="form-check form-check-inline" style="margin: auto">
        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
        <label class="form-check-label" for="inlineRadio1">Character &nbsp</label>
    <div class="form-check form-check-inline" style="margin: auto">
        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
        <label class="form-check-label" for="inlineRadio2">World</label>
    </div>

    </div>

    <div>
        <form action="/char/submit" method="post" id="characterForm" hidden>
            <input type="hidden" name="id" value="">
            <table class="table">
                <thead class="table-dark">
                <th scope="col"></th>
                <th scope="col"></th>
                </thead>
                <tbody>
                <tr>
                    <td>Image Link</td>
                    <td><input type="text" name="img" id="imgId"></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name" id="cNameId"></td>
                </tr>
                <tr>
                    <td>World</td>
                    <td><input type="text" name="world" id="worldId"></td>
                </tr>
                <tr>
                    <td>Race</td>
                    <td><input type="text" name="race" id="raceId"></td>
                </tr>
                <tr>
                    <td>Title</td>
                    <td><input type="text" name="title" id="titleId"></td>
                </tr>
                <tr>
                    <td>Affiliations</td>
                    <td>
                        <input type="text" name="affiliation">
                    </td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>
    <div class="button">
        <button class="btn btn-dark" type="button" id="characterButton" hidden>
            Create
        </button>
    </div>
    <div>
        <form action="/world/submit" method="post" id="worldForm" hidden>
            <input type="hidden" name="id" value="${world.id}">
            <table class="table">
                <thead class="table-dark">
                <th scope="col"></th>
                <th scope="col"></th>
                </thead>
                <tbody>
                <tr>
                    <td>World</td>
                    <td><input type="text" name="name" id="wNameId"></td>
                </tr>
                <tr>
                    <td>Medium</td>
                    <td><input type="text" name="medium" id="mediumId"></td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td><input type="text" name="description" id="descriptionId"></td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>
    <div class="button">
        <button class="btn btn-dark" type="button" id="worldButton" hidden>
           Create
        </button>
    </div>

</div>

<script src="/pub/js/create.js">
</script>

<jsp:include page="../include/footer.jsp"/>