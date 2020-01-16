/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.onload = function () {
    document.getElementById("boton").addEventListener("click", comprobar);
};

function comprobar() {
    var texto = document.getElementById('texto').value;
    var pattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if (pattern.test(texto) == true) {
        document.getElementById("resultado").innerHTML = "CORRECTO";
    } else {
        document.getElementById("resultado").innerHTML = "INCORRECTO";

    }

}
