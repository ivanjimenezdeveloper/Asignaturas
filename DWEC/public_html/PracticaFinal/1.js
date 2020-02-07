/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var palabras = [
    "IVAN",
    "JIMENEZ",
    "LUQUE",
    "BUTANERO",
    "CHAVAL",
    "PIM",
    "PAM"
];
var palabraOculta;
var palabraSelec, numero;
var errores = 0;
function seleccionarPalabra() {
    numero = Math.floor(Math.random() * 6) + 0
    palabraSelec = palabras[numero];

    palabraOculta = palabraSelec.replace(/[A-Za-z]/g, "*");

    document.getElementById("palbraOculta").innerHTML = palabraOculta + " , " + palabraSelec;
}

function comprobarLetra() {
    var letra = this.innerHTML;
    var letras = palabraSelec.split("");
    var encontrado = false;
    for (var i = 0; i < letras.length; i++) {

        if (letra == letras[i]) {
            encontrado = true;
            palabraOculta = palabraOculta.replaceAt(i, letra);
            document.getElementById("palbraOculta").innerHTML = palabraOculta + " , " + palabraSelec;


        }
        if (palabraOculta == palabraSelec) {
            alert("HAS GANADO");
            reiniciar();
        }

    }

    if (encontrado == false) {
        errores++;
        crearCanvas();
    }
}

String.prototype.replaceAt = function (index, replacement) {
    return this.substr(0, index) + replacement + this.substr(index + replacement.length);
};

function crearCanvas() {
    // Creant l'objecte Canvas
    var c = document.getElementById("myCanvas");
    var ctx = c.getContext("2d");
    // dibuixant el terra
    var c = document.getElementById("myCanvas");
    var ctx = c.getContext("2d");
    ctx.moveTo(0, 280);
    ctx.lineTo(300, 280);
    ctx.stroke();
    // pint estructura de la forca
    if (errores == 0) {
        ctx.moveTo(100, 280);
        ctx.lineTo(100, 80);
        ctx.stroke();
        ctx.moveTo(100, 80);
        ctx.lineTo(160, 80);
        ctx.stroke();
        ctx.moveTo(160, 80);
        ctx.lineTo(160, 130);
        ctx.stroke();
    }

    // pint cap
    if (errores == 1) {
        ctx.beginPath();
        ctx.arc(160, 140, 10, 0, 2 * Math.PI);
        ctx.stroke();
    }

    // pint tronc
    if (errores == 2) {
        ctx.moveTo(160, 150);
        ctx.lineTo(160, 190);
        ctx.stroke();
    }

    // pint braç esquerre
    if (errores == 3) {
        ctx.moveTo(160, 160);
        ctx.lineTo(155, 175);
        ctx.stroke();
    }

    // pint braç dret

    if (errores == 4) {
        ctx.moveTo(160, 160);
        ctx.lineTo(165, 175);
        ctx.stroke();
    }

    // pint cama esquerra
    if (errores == 5) {
        ctx.moveTo(160, 190);
        ctx.lineTo(155, 205);
        ctx.stroke();
    }

    // pint cama dreta
    if (errores >= 6) {
        ctx.moveTo(160, 190);
        ctx.lineTo(165, 205);
        ctx.stroke();
        alert("HAS PERDIDO");
        reiniciar();
    }

    // si voleu ficar imatges
    // var imatge = new Image();
    // imatge.src = "DWEC_P02_sol01_Content.png";
    // ctx.drawImage(imatge, 0, 0);
}

function reiniciar() {
    seleccionarPalabra();
    var c = document.getElementById("myCanvas");
    c.parentNode.removeChild(c);
    
    c = document.createElement("canvas");
    c.id = "myCanvas";
    document.body.appendChild(c);
    errores = 0;
    crearCanvas();
}

