/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var rojo, verde, azul, atributoColorTotal;
var tbody = "";
for (var i = 0; i < 20; i++) {

    rojo = Math.floor(Math.random() * (255 - 0 + 1) + 1);
    verde = Math.floor(Math.random() * (255 - 0 + 1) + 1);
    azul = Math.floor(Math.random() * (255 - 0 + 1) + 1)
    atributoColorTotal = "rgb("+rojo+","+verde+","+azul+")";

    tbody += "<tr><td>" + rojo + "</td>" + "<td>" + verde + "</td>" + "<td>" + azul 
            + "</td> "+"<td style='background-color: "+ atributoColorTotal+ "'></td>"+ "</tr>";
}

document.getElementById("bodyTabla").innerHTML = tbody;