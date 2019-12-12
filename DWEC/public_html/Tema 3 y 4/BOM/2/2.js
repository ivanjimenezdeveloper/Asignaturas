/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var ventana;

function abrirVentana() {

if(confirm()){
      ventana = window.open("", "Abrida", "width=200,height=80,left=500,top=500,menubar=no,location=no,resizable=0");

    ventana.document.write("<p>Bon dia tot el dia</p><button onclick='window.close()'>Cierra</button>\n\
        <script></script>");
  
}

}


function cierra() {

    if (ventana.close()) {
        alert("ERRORSITO")
    } else {
        ventana.close();
        ventana.focus();
    }

}

function mueveDiez() {

    ventana.moveBy(10, 10);
    ventana.focus();

}

function mueveACien() {
    ventana.moveTo(100, 100);
    ventana.focus();
}

function aumentaDiez() {

    ventana.resizeBy(10, 10);
    ventana.focus();


}

function aumentaCuatro() {
    ventana.resizeTo(400, 200);
    ventana.focus();


}