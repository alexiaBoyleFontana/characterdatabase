// Event Function

function passMatch (e) {
    let error = document.getElementById("passMatch");
    let form = document.getElementById("regForm");
    let pass = document.getElementById("passId");
    let cpass = document.getElementById("cPassId");

    console.log(pass.value);

    if (pass.value != cpass.value) {
        e.preventDefault();
        error.hidden = false;
    }


}


// Event Register

let submit = document.getElementById("submit");
submit.addEventListener("click", passMatch);