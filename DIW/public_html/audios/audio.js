/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var audios;
var sourceAudio = document.getElementById("srcaudio");

function crearArray(){
    audios = ["audio1", "audio2", "audio3", "audio4", "audio5"];
}


function aleatorio() {


    audios.sort(function (a, b) {
        return 0.5 - Math.random()
    });




    sourceAudio.setAttribute("src", audios[0]);

}

function reset() {

    sourceAudio.setAttribute("src", audios[0]);

}

function back() {

    var cancionActual;

    for (var i = 0; i <= audios.length; i++) {

        if (sourceAudio.getAttribute("src") == audios[i]) {
            cancionActual = i;
        }

    }

    if (cancionActual == 0) {
        cancionActual = audios.length - 1;
    } else {
        cancionActual--;
    }

    sourceAudio.setAttribute("src", audios[cancionActual]);

}

function next() {

    var cancionActual;

    for (var i = 0; i <= audios.length; i++) {

        if (sourceAudio.getAttribute("src") == audios[i]) {
            cancionActual = i;
        }

    }

    if (cancionActual == audios.length - 1) {
        cancionActual = 0;
    } else {
        cancionActual++;
    }

    sourceAudio.setAttribute("src", audios[cancionActual]);

}