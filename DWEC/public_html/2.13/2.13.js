/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function fechaFormato() {

    var dia, dia2, mes, mes2, ano, ano2, hora, min, formato;

    var fecha = new Date("Sat Mar 21 2009 12:15:00 GMT+0100 (CET)");


    var fecha2, fecha3, fecha4;

    dia = String(fecha.getDate()).padStart(2, "0");
    mes = String(fecha.getMonth() + 1).padStart(2, "0");
    ano = String(fecha.getFullYear()).padStart(4, "0");
    hora = String(fecha.getHours()).padStart(2, "0");
    min = String(fecha.getMinutes()).padStart(2, "0");

    dia2 = String(fecha.getDate() + 3).padStart(2, "0");
    mes2 = String(fecha.getMonth() + 6).padStart(2, "0");
    ano2 = String(fecha.getFullYear()-10).padStart(4, "0");

    fecha2 = dia2 + "/" + mes + "/" + ano + " " + hora + ":" + min;
    fecha3 = dia + "/" + mes2 + "/" + ano + " " + hora + ":" + min;
    fecha4 = dia + "/" + mes + "/" + ano2 + " " + hora + ":" + min;


    formato = dia + "/" + mes + "/" + ano + " " + hora + ":" + min;

    document.getElementById("texto").innerHTML = formato;
    document.getElementById("fechaOriginal").innerHTML = fecha;
    document.getElementById("fecha2").innerHTML = fecha2;
    document.getElementById("fecha3").innerHTML = fecha3;
    document.getElementById("fecha4").innerHTML = fecha4;


}
