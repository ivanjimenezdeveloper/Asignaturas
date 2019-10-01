/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function cambioImagen() {
    var x = document.getElementById('imagenENV');

    if (x.src.match("Open")) {
        x.src = "imagenes/envelope.png";
    } else {
        x.src = "imagenes/envelopeOpen.png";

    }
}

