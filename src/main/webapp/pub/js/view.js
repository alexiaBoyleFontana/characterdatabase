//Event Functions for view

function revealForm (e) {
    let form = document.getElementById('editForm');
    let delt = document.getElementById('delete');
    if (form.hidden) {
        form.hidden = false;
        if (delt != null) {
            delt.hidden = false;
        }
    } else {
        form.hidden = true;
        if (delt != null) {
            delt.hidden = true;
        }
        form.submit();
    }


}

function deleteEntity (e) {

}

function addCol (e) {
    e.preventDefault()
    let affilForm = document.getElementById('affilBody');
    affilForm.innerHTML += "<tr>\n" +
        "                    <td>\n" +
        "                        Name &nbsp <input type=\"text\" name=\"link\">\n" +
        "                        &nbsp Relationship <input type=\"text\" name=\"relationship\">\n" +
        "                    </td>\n" +
        "                </tr>"

    console.log("clicked");
}

//Event Register for view

let button = document.getElementById('edit');
button.addEventListener('click', revealForm);

let deleteButton = document.getElementById('delete')
if (deleteButton != null) {
    deleteButton.addEventListener('click', deleteEntity);
}

let addAfilButton = document.getElementById('addAffil');
if (addAfilButton != null) {
    addAfilButton.addEventListener('click', addCol);
}