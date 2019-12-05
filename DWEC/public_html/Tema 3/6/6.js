/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var botones;
var contador =0;

window.onload = function () {
    botones = document.body.getElementsByTagName("button");

    for (var i = 0; i < botones.length; i++) {

        botones[i].addEventListener("click", xo);

    }
}

function xo() {

    if (contador%2 == 0) {
        this.innerHTML = "x";
    } else {
        this.innerHTML = "o";
    }
contador++;
    comprobar();

}

function comprobar() {
    var ganador;
    var gana = false;
    //primer cuadro
    if (botones[0].innerHTML == botones[1].innerHTML && botones[1].innerHTML == botones[2].innerHTML) {
        gana = true;
        if (botones[0].innerHTML != "")
            ganador = botones[0].innerHTML;
    }
    if (botones[0].innerHTML == botones[3].innerHTML && botones[3].innerHTML == botones[6].innerHTML) {
        gana = true;
        if (botones[0].innerHTML != "")
            ganador = botones[0].innerHTML;
    }
    if (botones[0].innerHTML == botones[4].innerHTML && botones[4].innerHTML == botones[8].innerHTML) {
        gana = true;
        if (botones[0].innerHTML != "") {
            ganador = botones[0].innerHTML;
        }
    }

    //segundo cuadro

    if (botones[1].innerHTML == botones[4].innerHTML && botones[4].innerHTML == botones[7].innerHTML) {
        gana = true;
        if (botones[1].innerHTML != "") {
            ganador = botones[1].innerHTML;
        }
    }

    //tercer cuadro
    if (botones[2].innerHTML == botones[5].innerHTML && botones[5].innerHTML == botones[8].innerHTML) {
        gana = true;
        if (botones[2].innerHTML != "") {
            ganador = botones[2].innerHTML;
        }
    }
    if (botones[2].innerHTML == botones[4].innerHTML && botones[4].innerHTML == botones[6].innerHTML) {
        gana = true;
        if (botones[2].innerHTML != "") {
            ganador = botones[2].innerHTML;
        }
    }

    //medio

    if (botones[3].innerHTML == botones[4].innerHTML && botones[4].innerHTML == botones[5].innerHTML) {
        gana = true;
        if (botones[3].innerHTML != "") {
            ganador = botones[3].innerHTML;
        }
    }

    //bajo
    if (botones[6].innerHTML == botones[7].innerHTML && botones[7].innerHTML == botones[8].innerHTML) {
        gana = true;
        if (botones[6].innerHTML != "") {
            ganador = botones[6].innerHTML;
        }
    }
    if (gana) {

        if (ganador == "x" || ganador == "o") {
            alert("gana: " + ganador);
            reinicio();



        }
    }



}

function reinicio() {
    for (var i = 0; i < botones.length; i++) {

        botones[i].innerHTML = "";

    }
}