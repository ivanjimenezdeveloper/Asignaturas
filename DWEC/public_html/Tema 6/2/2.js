/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.onload = function () {
    document.getElementById("texto").addEventListener("keydown", letra);
};


function letra() {

    var texto = document.getElementById("texto");
    var output = document.getElementById("output");

    output.innerHTML = 150 - texto.value.length;


}


