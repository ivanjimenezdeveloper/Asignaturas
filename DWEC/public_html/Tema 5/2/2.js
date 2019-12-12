
window.onload = function () {
    document.getElementById("afegir").onclick = addTasca;
};

var lista = document.getElementById("lista");
var contador = 0;
function addTasca() {
    var texto = document.getElementById("text").value;

    var li = document.createElement("li");
    contador++;

    li.setAttribute("id", texto + contador);
    var eliminar = document.createElement("button");
//    eliminar.onclick = eliminarElemento;
    eliminar.onclick = eliminarBien;
    eliminar.setAttribute("id", texto + "button" + contador);

    eliminar.innerHTML = "ELIMINAR";

    li.innerHTML = texto;

    li.appendChild(eliminar);

    lista.appendChild(li);


}

function eliminarElemento() {

    var texto = this.getAttribute("id");

    texto = texto.replace("button", "");

    document.getElementById(texto).remove();

}

function eliminarBien() {
    this.parentNode.remove();
}