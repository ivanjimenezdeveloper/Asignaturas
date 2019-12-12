/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var valores = [true, 5 , false, "hola", "Adios", 2];

var stringLargo, suma;

suma = valores[1] + valores[5];

if(valores[3].length > valores[4].length){
    stringLargo = valores[3];
}else{
    stringLargo = valores[4]
}


document.getElementById("elementoMasLargo").innerHTML =stringLargo ;
document.getElementById("suma").innerHTML = suma;
        
