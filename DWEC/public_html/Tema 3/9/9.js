/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var idAnterior = "1";
var contador = 0;
window.onload = function () {


    setInterval(colorear, 2000);


};

function colorear() {
    document.getElementById(idAnterior).style.backgroundColor = "white";

    if (contador != 0) {
        document.getElementById(idAnterior).removeEventListener("click", ganar);

    }

    var id = Math.floor(Math.random() * (9 - 1 + 1)) + 1;
    document.getElementById(id).style.backgroundColor = "red";
    document.getElementById(id).addEventListener("click", ganar);
    contador++;
    idAnterior = id;


}

function ganar() {
    alert("AS GANAO");
}