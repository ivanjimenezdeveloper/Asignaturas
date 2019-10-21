/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var d1, d2, ganador = "EMPATE";
document.getElementById("ganador").innerHTML = ganador;

d1 = Math.floor(Math.random()*(6 - 1) + 1);

d2 = Math.floor(Math.random()*(6 - 1) + 1);

if (d1 > d2) {
    ganador = "jugador 1";
} else if (d2 > d1) {
    ganador = "jugador 2";
}
document.getElementById("j1").src = "../imatges/"+d1 + ".svg";
document.getElementById("j2").src = "../imatges/"+d2 + ".svg";

document.getElementById("ganador").innerHTML = ganador;

