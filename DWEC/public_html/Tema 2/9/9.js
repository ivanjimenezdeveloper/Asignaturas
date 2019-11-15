

var output = "";

var tablaBody, row, rojo, verde, azul, atributoColorTotal, tr, td, rojoTexto
        , azulTexto, verdeTexto;
var body = document.getElementById("bodyTabla");
for (var i = 0; i <= 20; i++) {
    rojo = Math.floor(Math.random() * (255 - 0 + 1) + 1);
    verde = Math.floor(Math.random() * (255 - 0 + 1) + 1);
    azul = Math.floor(Math.random() * (255 - 0 + 1) + 1);
    atributoColorTotal = "rgb(" + rojo + "," + verde + "," + azul + ")";


    row = body.insertRow(i);

    rojoTexto = row.insertCell(0);
    verdeTexto = row.insertCell(1);
    azulTexto = row.insertCell(2);
    row.insertCell().setAttribute("style", "background-color: "+ atributoColorTotal);

    rojoTexto.innerHTML = rojo;
    verdeTexto.innerHTML = verde;
    azulTexto.innerHTML = azul;
    
         
}

body.appendChild(tr);
