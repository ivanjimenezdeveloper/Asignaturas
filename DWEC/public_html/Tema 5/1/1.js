/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.onload = function () {
    document.getElementById("vincle_1").onclick = ocultar;
    document.getElementById("vincle_2").onclick = ocultar;
    document.getElementById("vincle_3").onclick = ocultar;
    
}

function ocultar() {

    var id = this.getAttribute("id");

    id = id.split("_")[1];

    this.innerHTML = "Muestra contenidos";

    this.onclick = mostrar;


    document.getElementById("continguts_" + id).setAttribute("style", "display: none");

}

function mostrar() {

    var id = this.getAttribute("id");

    id = id.split("_")[1];

    this.onclick = ocultar;

    this.innerHTML = "Oculta contenido";


    document.getElementById("continguts_" + id).setAttribute("style", "display: block");

}

