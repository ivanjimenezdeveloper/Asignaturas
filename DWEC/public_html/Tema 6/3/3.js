/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var texto;
window.onload = function () {
    var texto = document.getElementById("texto");
    texto.addEventListener("keydown", guardarTexto);
    texto.addEventListener("keyup", anyadirTexto);
    document.getElementById("selector").addEventListener("change", borrar);

};

function guardarTexto() {
    texto = document.getElementById("texto").value;


}
function anyadirTexto() {
    var selector = document.getElementById("selector");


    selector = selector.options[selector.selectedIndex].text;
var texto = document.getElementById("texto");
    if (selector == "binario") {

//        if (!RegExp("^[0-1]{1,}$").test(event.key)) {
//
//            document.getElementById("texto").value = texto;
//        }

    if (!texto.value.match(/^[0-1]{1,}$/)) {
        texto.value = texto.value.replace(/^[0-1]{1,}$/g, '');
    }

    } else if (selector == "octal") {

    } else {

    }
}

function borrar() {
    document.getElementById("texto").value = "";
}