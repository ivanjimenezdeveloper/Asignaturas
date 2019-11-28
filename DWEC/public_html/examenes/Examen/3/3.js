

function triangulo() {
    var cateto = document.getElementById("numero").value;

    //Creo la variable donde hare los triangulos
    var triangulo = "";

    //El bucle añadira # rows por cada cateto 
    for (var i = 0; i <= cateto; i++) {

        if (i != 0) {

//las # extra las añado con una array que pondra # por cada pasada 
//(la primera "0", no añade ningun extra, la segunda "1" añade 1 # extra

            triangulo = triangulo + "#" + new Array(i).join("#");

            triangulo = triangulo + "\n";
        }

    }

    for (var i = 0; i <= cateto; i++) {
        if (i != 0) {

//igual que el anterior pero ademas pongo espacios segun por la 
//pasada que va (primera pasada todos los catetos que faltan menos las pasadas
//en este caso es la primera por lo que hay 0 añado un +1 para que quede 
//simetrico al anterior triangulo

            triangulo = triangulo + new Array((cateto - i) + 1).join(" ") + "#" + new Array(i).join("#");
            triangulo = triangulo + "\n";
        }

    }
    
    //añado el triangulo al html
    document.getElementById("output").innerHTML = triangulo;

}


