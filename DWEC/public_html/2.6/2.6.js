/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function separacionMail() {
    var x = document.getElementById("mail").value;


    document.getElementById("nombreUsuario").innerHTML = x.split("@")[0];
    document.getElementById("nombreDominio").innerHTML = x.split("@")[1];



}
