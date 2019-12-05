/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var audio = new Audio("audio1.mp3");
var audios;
var sourceAudio = document.getElementById("srcaudio");
var cancionActual = 0;
function crearArray() {
    audios = ["audio1.mp3", "audio2.mp3", "audio3.mp3", "audio4.mp3", "audio5.mp3"];
}

function playe() {
    audio = new Audio(audios[cancionActual]);
    audio.play();
}

function aleatorio() {


    audios.sort(function (a, b) {
        return 0.5 - Math.random()
    });


    cancionActual = 0;

    audio.pause();

    playe();

}

function reset() {


    cancionActual = 0;
    audio.pause();

    playe();

}

function back() {

    if (cancionActual == 0) {
        cancionActual = audios.length - 1;
    } else {
        cancionActual--;
    }
    audio.pause();
    playe();

}

function next() {

    if (cancionActual == audios.length - 1) {
        cancionActual = 0;
    } else {
        cancionActual++;
    }
    audio.pause();
    playe();

}