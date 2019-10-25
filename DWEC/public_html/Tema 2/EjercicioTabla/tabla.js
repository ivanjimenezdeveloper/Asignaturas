/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function mostrarTabla(){
    var filas = document.getElementById("filas").value;
    var columnas = document.getElementById("columnas").value;
    var contadorFilas=0, contadorColumnas=0;
    var output;
    
    output = "<table>"
    
    for(var i=0; i<=filas;i++){
//        contadorFilas++;
        output += "<tr>"
        
        for (var e=0; e <= columnas; e++){
            contadorColumnas++;
            output += "<td>";
            
            output += /*contadorFilas+*/""+contadorColumnas;
            
            output += "</td>";
            
        }
        
        output+= "</tr>"
        
        
    }
    
    
    output += "</table>"
    
    
    document.getElementById("tabla").innerHTML = output;
    
}