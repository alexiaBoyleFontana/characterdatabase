//Event Function for create

function swapChar(e) {
    let charForm = document.getElementById("characterForm");
    let worldForm = document.getElementById("worldForm");
    let charButton = document.getElementById("characterButton");
    let worldButton = document.getElementById("worldButton");

    charForm.hidden = false;
    charButton.hidden = false;
    worldForm.hidden = true;
    worldButton.hidden = true;
}

function swapWorld(e) {
    let charForm = document.getElementById("characterForm");
    let worldForm = document.getElementById("worldForm");
    let charButton = document.getElementById("characterButton");
    let worldButton = document.getElementById("worldButton");

    charForm.hidden = true;
    charButton.hidden = true;
    worldForm.hidden = false;
    worldButton.hidden = false;
}

function cSubmit(e) {
    let charForm = document.getElementById("characterForm");
    charForm.submit();
}

function wSubmit(e) {
    let worldForm = document.getElementById("worldForm");
    worldForm.submit();
}


// Event Register for view'

let charButton = document.getElementById("characterButton");
let worldButton = document.getElementById("worldButton");
let charRadio = document.getElementById("inlineRadio1");
let worldRadio = document.getElementById("inlineRadio2");
charRadio.addEventListener('change', swapChar);
worldRadio.addEventListener('change', swapWorld);
charButton.addEventListener('click', cSubmit);
worldButton.addEventListener('click', wSubmit);