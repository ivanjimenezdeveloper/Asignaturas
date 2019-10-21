/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function preguntas() {
    var correctas = 0, res1, res2, res3, res4;

    res1 = document.getElementById("pregunta1").value;
    res2 = document.getElementById("pregunta2").value;
    res3 = document.getElementById("pregunta3").value;
    res4 = document.getElementById("pregunta4").value;


    if (res1 == 1) {
        correctas++;
    }
    if (res2 == 2) {
        correctas++;
    }
    if (res3 == 3) {
        correctas++;
    }
    if (res4 == 4) {
        correctas++;
    }
    
    document.getElementById("correctas").innerHTML = correctas;
    
}