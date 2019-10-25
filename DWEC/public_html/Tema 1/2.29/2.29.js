/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var numero = new Array(8), suma = 0, suma36 = 0, suma50 = 0;

for (var i = 0; i <= numero.length - 1; i++) {
    var valor = i + 1;
    numero[i] = parseInt(prompt("Desime el numero " + valor + "/8"));
}

for (var i = 0; i <= numero.length - 1; i++) {

    if (isNaN(numero[i])== false) {
        suma = suma + numero[i];

    }

    if (numero[i] > 36) {
        suma36 = suma36 + numero[i];
    }

    if (numero[i] > 50) {
        suma50++;
    }

}

document.getElementById("numeros").innerHTML = numero;
document.getElementById("suma").innerHTML = suma;
document.getElementById("mayores36").innerHTML = suma36;
document.getElementById("mayores50").innerHTML = suma50;



