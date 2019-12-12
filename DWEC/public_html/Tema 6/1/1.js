

window.onload = function () {
    document.getElementById("boton").addEventListener("click", cogerValor);
}

function cogerValor() {

    var formulario = document.forms[0];
    var texto = "";
    for (var i = 0; i < formulario.length; i++) {

        texto += retornaValor(formulario[i]);

    }

    document.getElementById("output").innerHTML = texto;

}

function retornaValor(objeto) {

    var toReturn = "";

    if (objeto.type == "textarea" || objeto.type == "text") {
        toReturn = objeto.value + ", ";
    } else if (objeto.type) {



        if (objeto.checked) {
            toReturn = objeto.value + ", ";



        }


    } else if (objeto.type == "checkbox") {
        if (objeto.checked) {
            toReturn = objeto.value + ", ";
        }
    } else if (objeto.type == "select-one") {
        toReturn = objeto.options[objeto.selectedIndex].text + ", ";
    }




    return toReturn;
}