

window.onload = function () {
    document.getElementById("boton").addEventListener("click", cogerValor);
    document.getElementById("car").addEventListener("change", check);
    document.getElementById("bike").addEventListener("change", check);
    
    document.getElementById("carh").disabled = true;
    document.getElementById("bikeh").disabled = true;
    


}

function cogerValor() {

    var formulario = document.forms[0];
    var texto = "";
    for (var i = 0; i < formulario.length; i++) {

        texto += retornaValor(formulario[i]);

    }

    document.getElementById("output").innerHTML = texto;

}

function check() {
    
    var lista = document.getElementById(this.id + "h");
    
    if(this.checked){
        lista.disabled = false;
    }else{
        lista.disabled = true;
    }

}

function retornaValor(objeto) {

    var toReturn = "";

    if (objeto.type == "textarea" || objeto.type == "text") {
        toReturn = objeto.value + ", ";
    } else if (objeto.type == "radio") {



        if (objeto.checked) {
            toReturn = objeto.value + ", ";



        }


    } else if (objeto.type == "checkbox") {
        if (objeto.checked) {
            toReturn = objeto.value + " ";
        }
    } else if (objeto.type == "select-one") {
        

        toReturn = objeto.options[objeto.selectedIndex].text + ", ";
    }else if(objeto.type == "select-multiple"){
        toReturn += " [";
        for (var i = 0; i < objeto.selectedOptions.length; i++) {
           toReturn += objeto.selectedOptions[i].text +" ";
        }
        toReturn +=  "], ";
    }




    return toReturn;
}