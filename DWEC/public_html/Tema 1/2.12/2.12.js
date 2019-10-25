/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function fechaFormato() {

    var dia, mes, ano, hora, min, formato;

    var fecha = new Date("Sat Mar 21 2009 12:15:00 GMT+0100 (CET)");

    dia = String(fecha.getDate()).padStart(2, "0");
    mes = String(fecha.getMonth() + 1).padStart(2, "0");
    ano = String(fecha.getFullYear()).padStart(4, "0");
    hora = String(fecha.getHours()).padStart(2, "0");
    min = String(fecha.getMinutes()).padStart(2, "0");


    formato = dia + "/" + mes + "/" + ano + " " + hora + ":" + min;

    document.getElementById("texto").innerHTML = formato;

}

