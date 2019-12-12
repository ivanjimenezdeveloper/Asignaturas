/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function toOctal(){
    var x = document.getElementById("numero").value;
    
    x = parseInt(x).toString("8");
    
    document.getElementById("octal").innerHTML = x;
}

