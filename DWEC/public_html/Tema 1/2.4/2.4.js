/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function radioLongitudCirculo(){
    var area =document.getElementById('numero').value;
    var longitud =  document.getElementById('numero').value;

    area=(Math.PI*Math.pow(area, 2)).toFixed(4);
    
    longitud = (2*Math.PI*longitud).toFixed(4);
    
    document.getElementById('resultado').innerHTML = 
            "L'area és " + area + " i la longitud " + longitud;
    
}
