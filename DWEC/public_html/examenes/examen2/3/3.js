/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var ventana1, ventana2, ventana3;
var intervalo1, intervalo2, intervalo3;
var color1 = 0, color2 = 0, color3 = 0;
function init() {

//crea las ventanas
    ventana1 = window.open("", "abrida", "width=100,height=100,left=500,top=500,menubar=no,location=no,resizable=0");

    ventana2 = window.open("", "abrida2", "width=100,height=100,left=650,top=500,menubar=no,location=no,resizable=0");

    ventana3 = window.open("", "abrida3", "width=100,height=100,left=850,top=500,menubar=no,location=no,resizable=0");
//le pone background color
    ventana1.document.body.setAttribute("style", "background-color: rgb(0,0,0)");
    ventana2.document.body.setAttribute("style", "background-color: rgb(0,0,0)");
    ventana3.document.body.setAttribute("style", "background-color: rgb(0,0,0)");
//crea los intervalos
    intervalo1 = setInterval(colorear1, 20, ventana1);
    intervalo2 = setInterval(colorear2, 20, ventana2);
    intervalo3 = setInterval(colorear3, 20, ventana3);


}



function colorear1(ventana) {

//aumenta el color
    color1++;

    //si el color es 255 para y crea un boton
    if (color1 == 255) {
        clearInterval(intervalo1);
        var button = document.createElement("button");
        button.setAttribute("onclick", "cerrar()");
        button.innerHTML = "cerrar";
        document.body.appendChild(button);
    }
//cambia el valor de background
    ventana.document.body.setAttribute("style", "background-color: rgb(" + color1 + ",0,0)");


}

function colorear2(ventana) {
//aumenta el color
    color2++;

    //si es 255 para el intervalo
    if (color2 == 255) {
        clearInterval(intervalo2);
    }
//cambia el valor de background

    ventana.document.body.setAttribute("style", "background-color: rgb(0," + color2 + ",0)");


}

function colorear3(ventana) {
//aumenta el color

    color3++;
    //si es 255 para el intervalo

    if (color3 == 255) {
        clearInterval(intervalo3);
    }
//cambia el valor de background

    ventana.document.body.setAttribute("style", "background-color: rgb(0,0," + color3 + ")");


}
//cierra la ventanas
function cerrar() {
    ventana1.close;
    ventana2.close;
    ventana3.close;
}