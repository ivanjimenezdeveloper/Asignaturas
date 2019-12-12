/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.onload = function() {
  document.addEventListener("mousemove", mostrarCoor); 
    document.addEventListener("mousedown", mostrarClick);  

};

function mostrarCoor(){
    var x = event.clientX;
  var y = event.clientY; 
  
  document.getElementById("output").innerHTML = "x: " +x+ " y: "+ y;
}

function mostrarClick(){
    
    alert(event.which);
    
}