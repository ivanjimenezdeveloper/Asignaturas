/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.onload = function (){
    document.getElementById("boton").addEventListener("click", buscar);
};

function buscar(){
    busqueda = document.getElementById("texto").value;
   window.location.replace("https://www.google.com/search?q="+busqueda); 
}
