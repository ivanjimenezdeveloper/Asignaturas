/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var texto;
window.onload = function () {
    var texto = document.getElementById("texto");
    texto.addEventListener("keydown", guardarTexto);
    texto.addEventListener("keyup", anyadirTexto);
    document.getElementById("selector").addEventListener("change", borrar);

};

function guardarTexto() {
    texto = document.getElementById("texto").value;


}
function anyadirTexto() {
    var selector = document.getElementById("selector");

    selector = selector.options[selector.selectedIndex].text;
var texto = document.getElementById("texto").value;
var textoCambio = "";
    if (selector == "binario") {

        for (var i = 0; i < texto.length; i++) {
            
          textoCambio +=  texto.charAt(i).replace(/[^0-1]/, "");
            
            
        }

    } else if (selector == "octal") {
        for (var i = 0; i < texto.length; i++) {
            
          textoCambio +=  texto.charAt(i).replace(/[^0-7]/, "");
            
            
        }
    } else {
                for (var i = 0; i < texto.length; i++) {
            
          textoCambio +=  texto.charAt(i).replace(/[^1-9A-F]/, "");
            
            
        }

    }
    
    document.getElementById("texto").value = textoCambio;
}

function borrar() {
    document.getElementById("texto").value = "";
}