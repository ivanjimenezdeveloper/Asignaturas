/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.onload = function () {
    document.getElementById("iniciar").addEventListener("click", cronometro);
    document.getElementById("stop").addEventListener("click", stop);
    document.getElementById("restaurar").addEventListener("click", restaurar);


}
var sec = 0;
var min = 0;
var milis = 00;
var crono;
var cron = document.getElementById("cronometro");

function cronometro() {

    document.getElementById("iniciar").disabled = true;
    var cron = document.getElementById("cronometro");

    crono = setInterval(function () {
        milis += 10;
        if (milis == 1000) {
            sec++;
            milis = 0;
        }

        if (sec == 60) {
            min++;
            sec = 0;
        }
        cron.innerHTML = min + ":" + sec + ":" + milis;
    }, 10);


}

function stop() {
    clearInterval(crono);
    document.getElementById("iniciar").disabled = false;

}

function restaurar() {
    stop();
    sec = 0;
    min = 0;
    milis = 00;
    cron.innerHTML = min + ":" + sec + ":" + milis;


}





