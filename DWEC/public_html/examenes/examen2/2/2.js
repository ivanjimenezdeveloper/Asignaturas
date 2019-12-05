/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function crearLista() {

    var body = document.body;

    //coge todos los td
    var casilla = body.getElementsByTagName("td");

    //crea el elemento ul
    var ul = document.createElement("ul");


//le añade atributo id
    ul.setAttribute("id", "lista");

    //por cada casilla añade un li
    for (var i = 0; i <= casilla.length - 1; i++) {

        var li = document.createElement("li");

        li.innerHTML = casilla[i].innerHTML;

        ul.appendChild(li);


    }

    body.appendChild(ul);

}