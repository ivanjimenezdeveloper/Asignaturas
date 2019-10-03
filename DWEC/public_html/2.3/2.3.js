/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function calculo(){
    var numeroX = document.getElementById('multiplicadorX').value;
    var numeroSumando = document.getElementById('sumandoX').value;
    var resultado;
    
    resultado = (-1*numeroSumando)/numeroX;
    
    document.getElementById('resultado').innerHTML = resultado;
    
}