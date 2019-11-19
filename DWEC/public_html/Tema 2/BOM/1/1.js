/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var height = innerWidth;
var width = innerHeight;
var rojo, verde, azul;

for(var i =0; i < 2000; i++){
   var positionX = Math.floor(Math.random() *(width - 0 +1) +1);
   var positionY = Math.floor(Math.random() *(height - 0 +1) +1);
    rojo = Math.floor(Math.random() * (255 - 0 + 1) + 1);
    verde = Math.floor(Math.random() * (255 - 0 + 1) + 1);
    azul = Math.floor(Math.random() * (255 - 0 + 1) + 1);
var divChulo = document.createElement("div");

divChulo.style.backgroundColor = "rgb("+rojo+","+verde+","+azul+")";
divChulo.style.width = "50px";
divChulo.style.height = "50px";
divChulo.style.top = positionX+"px";
divChulo.style.left = positionY+"px";
divChulo.style.position = "absolute";

document.body.appendChild(divChulo);
 
}



