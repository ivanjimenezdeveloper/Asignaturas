/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function factorial() {
    var numero = document.getElementById("numero").value;
    var resultado;


    resultado = calcularFactorial(numero);


    document.getElementById("resultado").innerHTML = resultado;
}

function calcularFactorial(numero) {
    var resultado;
    if (numero == 1) {
        return 1;

    } else {
        
        return numero*calcularFactorial(numero-1); 

    }

}