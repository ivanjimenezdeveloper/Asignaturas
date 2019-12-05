
window.onload = function (){
    var botones =document.body.getElementsByTagName("button");
    
    for (var i = 0; i < botones.length; i++) {
        
        botones[i].addEventListener("click", anyadir) ;
        
    }
}

function anyadir() {
    
    var texto = document.getElementById("output").innerHTML;
    
    texto += this.innerHTML;
    
   document.getElementById("output").innerHTML = texto; 
    
}

