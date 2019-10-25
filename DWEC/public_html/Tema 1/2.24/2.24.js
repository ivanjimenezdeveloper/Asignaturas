/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function rectangulo() {
    var filas = document.getElementById("filas").value;
    var columnas = document.getElementById("columnas").value;
    var cuadrado = "";
    for (var i = 0; i < 3; i++) {

        for (var e = 0; e < columnas; e++) {
            if (i == 0) {

                for (var y = 0; y < filas; y++) {

                    cuadrado = cuadrado + "#";

                }

                i++;

            } else if (i == 1) {

                cuadrado = cuadrado + "\n#";
                cuadrado = cuadrado + new Array(filas - 1).join(" ") + "#";

            } else {
                if (e == 0) {
                    cuadrado = cuadrado + "\n";
                }
                for (var y = 0; y < filas; y++) {
                    cuadrado = cuadrado + "#";

                }
                break;
            }


        }

    }



    document.getElementById("output").innerHTML = cuadrado;
}
