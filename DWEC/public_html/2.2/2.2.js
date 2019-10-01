/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validacionUno(){
    var numero = document.getElementById('numeroIntervalo').value;
    var texto;
    
    if(isNaN(numero) || numero < -1 || numero > 1 ){
        texto="numero incorrecto";
    }else{
        texto="numero CORRECTO";
    }
    
    document.getElementById('textoValidacion').innerHTML = texto;
}
