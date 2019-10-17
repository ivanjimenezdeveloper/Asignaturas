/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



var fecha1 = new Date(2015,01,01,01,00,01);

var fecha2 = new Date(2015,02,14,02,05,23);

var dia, horas, minutos, segundos
dia = Math.round((fecha2.getTime() - fecha1.getTime())/(1000*60*60*24));
horas = fecha2.getHours() - fecha1.getHours();
minutos = fecha2.getMinutes() - fecha1.getMinutes();
segundos = fecha2.getSeconds() - fecha1.getSeconds();

document.getElementById("dias").innerHTML = dia +" d " + horas + " h " +minutos+" min " +segundos +" sec";
document.getElementById("fecha1").innerHTML = fecha1;
document.getElementById("fecha2").innerHTML = fecha2;