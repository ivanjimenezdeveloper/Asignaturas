/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function crearCookies() {
    var nom = document.getElementById("nom").value;
    var apellidos = document.getElementById("apellido").value;

    document.cookie = "nom=" + nom + ";path/=";
    document.cookie = "apellidos="+apellidos+";" ;
    window.location.replace("redirect.html");
}

function cogerCookies() {
    var nom;
    var apellidos;

    if (document.cookie.length == 0) {
        window.location.replace("index.html");
    } else {
        nom = getCookie("nom");
        apellidos = getCookie("apellidos");
        
        document.getElementById("output").innerHTML = "OLA "+ nom + " " + apellidos;
    }



}

function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}