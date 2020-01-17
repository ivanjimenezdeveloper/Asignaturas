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
var crono;
var cron = document.getElementById("cronometro");

function cronometro() {

    document.getElementById("iniciar").disabled = true;
    var cron = document.getElementById("cronometro");

    sec = document.getElementById("numero").value;
    cron.innerHTML = sec;

    crono = setInterval(function () {
        sec--;

        cron.innerHTML = sec;
        if (sec == 0) {
            stop();
            alert("SACABO");
        }
    }, 1000);


}

function stop() {
    clearInterval(crono);
    document.getElementById("iniciar").disabled = false;

}

function restaurar() {
    stop();
    sec = 0;

    cron.innerHTML = sec;


}





