//Event Functions for view/char

function revealForm (e) {
    let form = document.getElementById('editForm');
    if (form.hidden) {
        form.hidden = false;
    } else {
        form.hidden = true;
        form.submit();
    }


}

//Event Register for view/char

let button = document.getElementById('edit');
button.addEventListener('click', revealForm);