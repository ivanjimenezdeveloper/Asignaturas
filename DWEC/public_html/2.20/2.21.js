/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function factorial() {
    var numero = document.getElementById("numero").value;
    var resultado = numero;
    for (var i = numero; i > 1; i--) {

        resultado = resultado * (i - 1);

    }

    document.getElementById("resultado").innerHTML = resultado;
}
