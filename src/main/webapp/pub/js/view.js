//Event Functions for view

function revealForm (e) {
    let form = document.getElementById('editForm');
    if (form.hidden) {
        form.hidden = false;
    } else {
        form.hidden = true;
        form.submit();
    }


}

//Event Register for view

let button = document.getElementById('edit');
button.addEventListener('click', revealForm);