/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function crearTabla(){
    //Coge el valor de filas y columnas
    var fila = document.getElementById("fila").value;
    var columna = document.getElementById("columna").value;
    
    //coge el body de la tabla
    var tablaBody = document.getElementById("tableBody");
    
    var row;
    var texto = "";
    var contador = 0;
    var atributo;
    
    //reinicia el content de la tabla
    tablaBody.textContent = "";
    
    //por cada fila creara una row
    for(var i=0; i< fila; i++){
        
        //si es primo pondra el color de background de color cyan
        if((i+1)%2 !=0){
            
            atributo = "background-color: cyan";
            
        }else{
            atributo = "";
        }
        
        row =tablaBody.insertRow(i);
        
        //por cada columna creara una celda
        for(var e=0; e < columna; e++){
            contador++;
            texto = row.insertCell(e);
            texto.setAttribute("style", atributo);
            texto.innerHTML = contador;
        }
        
        
    }
    
}