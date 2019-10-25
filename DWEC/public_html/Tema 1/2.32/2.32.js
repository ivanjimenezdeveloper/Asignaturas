/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function cuadrado() {
    numero = 127;
    document.getElementById("cuadrado").style.backgroundColor = "rgb(" + numero + "," + numero + "," + numero + ")";

}
function aumentocolor() {
    if (numero == 0) {
        numero = numero + 7;
    } else if (numero < 255) {
        numero = numero + 10;
    }
    if (numero > 255) {
        numero = 255;
    }
    document.getElementById("cuadrado").style.backgroundColor = "rgb(" + numero + "," + numero + "," + numero + ")";

}

function bajoocolor() {
    if (numero == 255) {
        numero = numero - 8;
    } else if (numero > 0) {
        numero = numero - 10;
    }
    if (numero < 0) {
        numero = 0;
    }


    document.getElementById("cuadrado").style.backgroundColor = "rgb(" + numero + "," + numero + "," + numero + ")";

}