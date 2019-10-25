
var numeroBolas = Math.floor((Math.random() * (15 - 5) + 5));

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
//La variable i sera la bola a comprobar si existe y la e la que pasara
//por todas las bolas a comprobar
for (var i = 0; i <= numeroBolas; i++) {

    for (var e = 0; e <= numeroBolas; e++) {
        //Si son el mismo indice seran la misma bola seguro por lo que no se 
        //hara el bucle
        if (e != i) {

//si son un indice distinto y la bola es el mismo emoji cambiara el boolean
//a true
            if (bolas[i] == bolas[e]) {
                bolaEnctrada = true;
            }

        }

    }
    //compruebo que no sean en mismo indice la e y la i para no dar un
    //falso positivo en el contador y añadir una bola equivocada
    //en caso de que se cumpla lo anterior y no se haya encontrado bola igual
    //aumentara el contador y lo añadire a la array de bolas distintas
    if (bolaEnctrada == false && e != i) {
        distintas++;
        bolasDistintas[i] = bolas[i];
    }
    //reinicio el boolean a su estado false
    bolaEnctrada = false;
}

document.getElementById("nBolas").innerHTML = numeroBolas;
document.getElementById("grupoFull").innerHTML = bolas;
document.getElementById("bolasDistintas").innerHTML = distintas;
document.getElementById("mostrarBolas").innerHTML = bolasDistintas;
