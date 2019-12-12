


document.body.appendChild(crearTitulo("Window"));

document.body.appendChild(listadoPropiedades(window));

document.body.appendChild(crearTitulo("History"));

document.body.appendChild(listadoPropiedades(history));

document.body.appendChild(crearTitulo("Location"));

document.body.appendChild(listadoPropiedades(location));

document.body.appendChild(crearTitulo("Navigator"));

document.body.appendChild(listadoPropiedades(navigator));

document.body.appendChild(crearTitulo("Screen"));

document.body.appendChild(listadoPropiedades(screen));

function listadoPropiedades(obj) {

    var ol = document.createElement("ol");
    for (var prop in obj) {

        if (typeof obj[prop] != ("object") && typeof obj[prop] != ("function")) {
            var li = document.createElement("li");
            li.innerHTML = prop + ": " + obj[prop];
            
            ol.appendChild(li);
        }

    }
            return ol;

}

function crearTitulo(objeto) {
    var titulo = document.createElement("h3");

    titulo.innerHTML = objeto;
    return titulo;


}



