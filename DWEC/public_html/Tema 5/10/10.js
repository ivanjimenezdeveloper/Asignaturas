/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.onload = function (){
    document.body.addEventListener("mousedown", click);
}


function click(){
    var cubo = document.getElementById("cubo");
    
    
    cubo.style.top = event.pageY -25 + "px" ;
    cubo.style.left = event.pageX -25 + "px";
    
    
}