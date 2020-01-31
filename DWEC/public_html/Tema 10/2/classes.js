//Constructor de la classe classTabla
//tabla: L'objecte de la taula.
//filas: número files.
//columnas: número columnes.
//texto: text que es ficarà a les cel·les.
function classTabla(tabla, filas, columnas, texto) {
//Propietats de la classe classTabla
    this.objTabla = tabla;
    this.numFilas = filas;
    this.numColumnas = columnas;
//this.textoInicial = texto;
//Mètodes de la classe classTabla
//Mètode que inserta una fila
//numFila: A partir de quina fila s'inserta
//textP: text que es posará en les cel·les
    this.insertaFila = function (numFila, textoP) {

        var row = this.objTabla.insertRow(numFila);

        for (var i = 0; i < this.numColumnas; i++) {

            var cell = row.insertCell(i);
            cell.innerHTML = textoP;

        }

    };
//Mètode que inserta moltes file
//numFila: A partir de quina fila s'inserta
//nRep número de files a insertar
//textP: text que es posará en les cel·les
    this.insertaFilas = function (numFila, nRep, textoP) {

        for (var e = numFila; e < nRep; e++) {

            var row = this.objTabla.insertRow(e);

            for (var i = 0; i < this.numColumnas; i++) {

                var cell = row.insertCell(i);
                cell.innerHTML = textoP;

            }
        }

    };
//Mètode que inserta una columna
//numFila: número fila on s'inserta
//texto: texte que es posarà en les cel·les de la fila insertada
//Retorna true si columna ben insertada, false en cas contrari
    this.insertaColumna = function (numColumna, texto) {



        for (var i = 0; i < this.numColumnas; i++) {
            var row = this.objTabla.rows[i];

            var cell = row.insertCell(numColumna);
            cell.innerHTML = texto;

        }

    }
//Mètode que esborra la columna en numColumna
//numColumna: número columna on s'esborrarà
    this.borraColumna = function (numColumna) {

        for (var i = 0; i < this.numColumnas; i++) {
            var row = this.objTabla.rows[i];

            var cell = row.deleteCell(numColumna);

        }

    }
//Mètode intern que esborra una cel·la
//és privada, tot i que això no es pot definir en JS
//no fer servir tota sola perquè desquadra this.numFilas i this.numColumnas
    this._borraCelda = function (numFila, numColumna) {
    }
//Mètode que esborra la fila en numFila
//numFila: número fila on s'esborrarà
    this.borraFila = function (numFila) {



        this.objTabla.deleteRow(numFila);
    }
//Mètode que canvia el contingut d'una cel·la
//numFila: número fila de la cel·la
//numColumna: número columna de la cel·la
    this.cambiaCelda = function (numFila, numColumna, texto) {

        var row = this.objTabla.rows[numFila].cells;

        row[numColumna].innerHTML = texto;
    }
//Mètode que canvia totes les cel·les de la taula per texto
//texto: text que es posarà dins les cel·les
    this.cambiaCeldasTabla = function (texto) {

        for (var e = 0; e < this.numFilas; e++) {

            var row = this.objTabla.rows[e].cells;

            for (var i = 0; i < this.numColumnas; i++) {

                row[i].innerHTML = texto;

            }
        }


    }
//Mètode que canvia el color de fons de la taula per pColor
//pColor: color
    this.cambiaFondo = function (pColor) {
        
        this.objTabla.style.backgroundColor = pColor;
        
    };

    this.insertaFilas(0, this.numFilas, texto);

}
//Inicialitzar l'objecte
//crear la taula inicial això com s'ha especificat en el constructor
