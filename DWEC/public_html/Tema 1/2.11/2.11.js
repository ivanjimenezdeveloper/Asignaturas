/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function fechaFormato() {

    var dia, mes, ano, hora, min, formato;

    var fechaActual = new Date();

    dia = String(fechaActual.getDate()).padStart(2,'0');
    mes = String(fechaActual.getMonth()+1).padStart(2,"0");
    ano = String(fechaActual.getFullYear()).padStart(4,"0");
    hora = String(fechaActual.getHours()).padStart(2,"0");
    min = String(fechaActual.getMinutes()).padStart(2,"0");

    formato = dia + "-" + mes + "-" + ano + " " + hora + ":" + min;
    
    document.getElementById("texto").innerHTML = formato;
}

function formatNumber(number, zeros, numZeros) {
    var format = zeros + number;
    format = format.substring(format.length - numZeros, format.length);
    return format;
}