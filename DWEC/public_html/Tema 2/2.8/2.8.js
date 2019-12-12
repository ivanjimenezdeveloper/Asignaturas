/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function mitad() {
    var x = document.getElementById("textoCortar").innerHTML;

    document.getElementById("primero").innerHTML = x.slice(0, (x.length)/2);
    document.getElementById("segundo").innerHTML = x.slice((x.length)/2, x.length);

}

