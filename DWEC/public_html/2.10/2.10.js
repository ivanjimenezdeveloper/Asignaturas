/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function randomDado(){
    
    var caras = document.getElementById("selector");
    var numero = caras.options[caras.selectedIndex].value;
    
    document.getElementById("texto").innerHTML = Math.floor((Math.random() * numero )+1);

    
    
}