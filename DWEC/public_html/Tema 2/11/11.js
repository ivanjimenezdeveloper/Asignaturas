


function generaDecimos() {
    var numero1, numero2, numero3;

    numero1 = Math.floor(Math.random() * (999 - 1 + 1) + 1);
    numero2 = Math.floor(Math.random() * (999 - 1 + 1) + 1);
    numero3 = Math.floor(Math.random() * (999 - 1 + 1) + 1);


    document.getElementById("numero1").innerHTML = numero1;
    document.getElementById("numero2").innerHTML = numero2;
    document.getElementById("numero3").innerHTML = numero3;
}

function generaSorteo() {

    var sorteo;
    var numero1, numero2, numero3;


    sorteo = Math.floor(Math.random() * (999 - 1 + 1) + 1);

    numero1 = document.getElementById("numero1");
    numero2 = document.getElementById("numero2");
    numero3 = document.getElementById("numero3");


    if (numero1 == sorteo) {
        document.getElementById("numero1").setAttribute("style", "color: green");
    } else {
        document.getElementById("numero1").setAttribute("style", "color: red");
    }

    if (numero2 == sorteo) {
        document.getElementById("numero2").setAttribute("style", "color: green");
    } else {
        document.getElementById("numero2").setAttribute("style", "color: red");
    }

    if (numero3 == sorteo) {
        document.getElementById("numero3").setAttribute("style", "color: green");
    } else {
        document.getElementById("numero3").setAttribute("style", "color: red");
    }

    document.getElementById("sorteoNumero").innerHTML = sorteo;


}