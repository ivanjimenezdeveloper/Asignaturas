/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function promptio() {
    var frase = prompt("Dime una frases desa");
    frase = frase.split(" ");
    if (frase.length != 0) {
        document.getElementById("primeraPalabra").innerHTML = frase[0];
        document.getElementById("ultimaPalabra").innerHTML = frase[frase.length -1];
        document.getElementById("cantidadPalabras").innerHTML = frase.length;
        document.getElementById("fraseOrdenada").innerHTML = frase.sort();


    }else
        alert("pero pon algo maestro");
}