/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    var fecha = new Date();
    var dia = ["Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"];
    
    document.getElementById("dia").innerHTML = dia[fecha.getDay()];
    
    

