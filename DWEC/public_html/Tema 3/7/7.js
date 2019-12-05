/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.onload = function () {
    document.addEventListener("mousemove", mostrarCoor);
    document.addEventListener("mousedown", mostrarClick);
    document.addEventListener('keydown', mostrarTecla);

};

function mostrarCoor() {
    var x = event.screenX;
    var y = event.screenY;
    var x2 = event.pageX;
    var y2 = event.pageY;


    document.getElementById("posicionPantalla").innerHTML = "x: " + x + " y: " + y;
    document.getElementById("posicionPagina").innerHTML = "x: " + x2 + " y: " + y2;
}

function mostrarClick() {
    var iz = "no", der = "no";

    document.getElementById("raton").style.backgroundColor = "yellow";

    if (event.which == 1) {
        iz = "si";
    } else if (event.which == 3) {
        der = "si";
    }

    document.getElementById("clickIzquierdo").innerHTML = iz;
    document.getElementById("clickDerecho").innerHTML = der;

}

function mostrarTecla() {
    document.getElementById("teclado").style.backgroundColor = "blue";

    document.getElementById("caracter").innerHTML = event.key;
    document.getElementById("codigoCaracter").innerHTML = event.keyCode;


}
