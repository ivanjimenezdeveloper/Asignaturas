/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function calcularLetra() {
    var letras = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B ', ' N ', ' J ', ' Z ', ' S ', ' Q ', ' V ', ' H ', ' L', 'C', 'K', 'E'];

    dni = document.getElementById("numeroDni").value;

    if (dni.length < 8 || dni > 99999999 || dni < 0) {
        document.getElementById("dni").innerHTML = "valor no valido";
    } else {
        dni = dni + letras[dni % 23];
        document.getElementById("dni").innerHTML = dni;


    }



}
