/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




function usarPass(){
    var herramienta = document.getElementById("herramienta").value;

    
    var numero = document.getElementById("pass").value;
    
    
    document.getElementById("tiempo").innerHTML = pass(numero.length, herramienta);
    }

function pass(numero, herramienta) {
    var tamanio = Math.pow(256, numero);

    var anyo = 0, meses = 0, semanas = 0, dias = 0, horas = 0, minutos = 0, segundos = 0;

    if (herramienta == 1) {

        tamanio = tamanio / 1000;

    } else if (herramienta == 2) {

        tamanio = tamanio / 12000;

    } else if (herramienta == 3) {

        tamanio = tamanio / 1500000;

    }

    if (tamanio < 1) {

        return "instantaneo";

    }

    if (tamanio >= 31536000) {

        anyo = tamanio / 31536000;
        tamanio = tamanio % 31536000;

    }
    if (tamanio >= 2592000) {

        meses = tamanio / 2592000;
        tamanio = tamanio % 2592000;

    }
    if (tamanio >= 604800) {

        semanas = tamanio / 604800;
        tamanio = tamanio % 604800;

    }
    if (tamanio >= 86400) {

        dias = tamanio / 86400;
        tamanio = tamanio % 86400;

    }
    if (tamanio >= 3600) {

        horas = tamanio / 3600;
        tamanio = tamanio % 3600;

    }
    if (tamanio >= 60) {

        minutos = tamanio / 60;
        tamanio = tamanio % 60;

    }
    if (tamanio < 60) {

        segundos = tamanio;

    }

    return Math.floor(anyo) + " anos " + Math.floor(meses) + " meses " + Math.floor(semanas) + " semanas " + Math.floor(dias) + " dias " + Math.floor(horas) + " horas "
            + Math.floor(minutos) + " minutos " + Math.floor(segundos) + " segundos";

}
