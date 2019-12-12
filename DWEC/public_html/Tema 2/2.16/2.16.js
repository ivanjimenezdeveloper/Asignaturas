/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var nacimiento = new Date(1984,01,07);
var hoy = new Date();

var diferencia =hoy.getTime() - nacimiento.getTime();

var fechaDiferencia  = new Date(diferencia);

document.getElementById("diferencia").innerHTML = Math.abs(fechaDiferencia.getFullYear()-1970);

