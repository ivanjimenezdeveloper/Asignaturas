/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.onload = function () {


    var divs = document.getElementsByTagName("div");

    for (var i = 0; i < divs.length; i++) {

        if (divs[i].getAttribute("id") != "wrapper") {
            divs[i].addEventListener("mouseover", mostarSobre);

        }


    }


};


function mostarSobre() {
    var footer = document.getElementById("footer");

    
    footer.innerHTML = "Este es el Footer " +this.getAttribute("id");

}
