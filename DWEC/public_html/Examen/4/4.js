
var numeroBolas = Math.floor((Math.random() * (15 - 5+1) + 5));

//Guardo las bolas en una array (no recuerdo como poner un tamaño fijo sin
//introducir valores)
var bolas = ["", "", "", "", "", "", "", "", "", "", "", "", "", "", ""];
var bolasDistintas = ["", "", "", "", "", "", "", "", "", "", "", "", "", "", ""];

//Variable donde guardo el emoji
var emoji;

//variable que indicara si encontre X bola en ese caso no sera unica
var bolaEnctrada = false;


//contador de cantidad de bolas distintas encontradas
var distintas = 0;


for (var i = 0; i <= numeroBolas; i++) {
//creo el emoji y lo añado a la array
    emoji = Math.floor(Math.random() * (10111 - 10102) + 10102);
    bolas[i] = "&#" + emoji;

}

for (var i = 0; i <= numeroBolas; i++) {

    for (var e = 0; e <= numeroBolas; e++) {

        if (e != i) {


            if (bolas[i] == bolasDistintas[e]) {
                bolaEnctrada = true;
            }

        }

    }

    if (bolaEnctrada == false && e != i) {
        distintas++;
        bolasDistintas[i] = bolas[i];
    }
    bolaEnctrada = false;
}

document.getElementById("nBolas").innerHTML = numeroBolas+1;
document.getElementById("grupoFull").innerHTML = bolas;
document.getElementById("bolasDistintas").innerHTML = distintas;
document.getElementById("mostrarBolas").innerHTML = bolasDistintas;
