/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var palabra = prompt("Desime una palabro");
var minusculas = false;
var mayusculas = false;

minisculas = /[a-z]/.test(palabra);
mayusculas = /[A-Z]/.test(palabra);

if (mayusculas == true && minisculas == true) {
    
    document.getElementById("output").innerHTML = "Tiene minusculas y mayusculas";
    
} else if (mayusculas == true) {
    
    document.getElementById("output").innerHTML = "Solo contiene mayusculas";

} else if (minisculas == true) {
    
    document.getElementById("output").innerHTML = "Solo contiene minusculas";

} else {
    
    document.getElementById("output").innerHTML = "No contiene ni minusculas ni mayusculas";

}