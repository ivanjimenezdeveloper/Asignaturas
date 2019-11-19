/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var height = window.innerHeight;
var width = window.innerWidth;



var positionX = Math.floor(Math.random() *(width - 0 +1) +1);
var positionY = Math.floor(Math.random() *(height - 0 +1) +1);

var divChulo = document.createElement("div");

divChulo.style.backgroundColor = "red";
divChulo.style.width = "50px";
divChulo.style.height = "50px";
divChulo.style.top = height;
divChulo.style.position = "relative";

document.body.appendChild(divChulo);



