//Event Functions for view

function revealForm (e) {
    let form = document.getElementById('editForm');
    let delt = document.getElementById('delete');
    let check = document.getElementById('formCheck');
    let button = document.getElementById('edit')


    if (form.hidden) {
        form.hidden = false;
        button.innerHTML = "Confirm Edit";
        if (delt != null) {
            delt.hidden = false;
        }
        check.hidden = false;

    } else {
        form.hidden = true;
        if (delt != null) {
            delt.hidden = true;
        }
        form.submit();
        check.hidden = true;
    }


}

function addCol (e) {
    e.preventDefault()
    let affilForm = document.getElementById('affilBody');

    let input = document.createElement("input", {type: "text", name: "links"});

    let tr = document.createElement("tr");
    let td = document.createElement("td");
    td.innerHTML = "Name &nbsp <input type=\"text\" name=\"links\">\n" +
        "                        &nbsp Relationship <input type=\"text\" name=\"relationships\">";
    tr.appendChild(td);


    affilForm.appendChild(tr);
}

function deleteEntity (e) {
    let confirm = document.getElementById("confirmCheck");

    if (!(confirm.checked)) {
        e.preventDefault()
    }
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