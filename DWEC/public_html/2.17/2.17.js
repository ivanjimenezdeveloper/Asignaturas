/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function calcularMajorFecha() {
    var fecha1 = document.getElementById("fecha1").value;
    var fecha2 = document.getElementById("fecha2").value;

    if (fecha1 > fecha2) {
        
        document.getElementById("fechaMayor").innerHTML = fecha1;
        
    } else if (fecha1 < fecha2) {
        
        document.getElementById("fechaMayor").innerHTML = fecha2;

    } else {
        
        document.getElementById("fechaMayor").innerHTML = "Las dos fechas son iguales";

    }
}


