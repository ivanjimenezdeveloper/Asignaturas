/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function separacionMail() {
    var x = document.getElementById("mail").value;


    document.getElementById("nombreUsuario").innerHTML = x.slice(0, x.indexOf("@"));
    document.getElementById("nombreDominio").innerHTML = x.slice(x.indexOf("@")+1, x.length);

}