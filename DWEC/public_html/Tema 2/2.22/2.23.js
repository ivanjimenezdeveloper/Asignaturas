/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function capicua() {
    var palabra = document.getElementById("texto").value;
    palabra.toLowerCase();
    var palabraRecortada = Array.from(palabra);
    var esCapicua;
    for (i = 0, e = palabraRecortada.length - 1; i < (e / 2); i++, e--) {

        if (palabraRecortada[i] == palabraRecortada[e]) {

            esCapicua = true;

        } else {
            document.getElementById("resultado").innerHTML = "no";
        }
        if (esCapicua == true) {
            document.getElementById("resultado").innerHTML = "si";

        }

    }

}