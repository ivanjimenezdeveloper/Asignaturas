/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var tamanio = 1;
var intervalo;
function init() {
    var barra = document.getElementById("barra");

    barra.setAttribute("style", "background-color: red; height: 50px;  width: " + tamanio + "%;");

}

function empezar() {
    var boton = document.getElementById("boton");
    
    boton.innerHTML = "parar";
        boton.setAttribute("onclick", "parar()");

    intervalo = setInterval(continuar, 30);



}

function parar(){
    clearInterval(intervalo);
    var boton = document.getElementById("boton");
    
    boton.innerHTML = "CONTINUAR";
    
    boton.setAttribute("onclick", "empezar()");
    
}

function continuar() {
    tamanio++;

    if (tamanio == 100) {
        tamanio = 0;
    } else {
        var barra = document.getElementById("barra");

        barra.setAttribute("style", "background-color: red; height: 50px;  width: " + tamanio + "%;");
    }

}