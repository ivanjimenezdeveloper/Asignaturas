
//Palabras a adivinar
var palabras = [
    "IVAN",
    "JIMENEZ",
    "LUQUE",
    "BUTANERO",
    "CHAVAL",
    "PIM",
    "PAM"
];
var palabraOculta;
var palabraSelec, numero;
var errores = 0;

//selecciona una palabra de la array aleatoria
function seleccionarPalabra() {
    numero = Math.floor(Math.random() * 6) + 0
    palabraSelec = palabras[numero];
//Crea una palabra que cambia los caracteres por asteriscos
    palabraOculta = palabraSelec.replace(/[A-Za-z]/g, "*");
//las muestra una para saber como va el jugador y otra para saber si va bien el programa
//(en una version final palabraSelec no deberia mostrarse
    document.getElementById("palbraOculta").innerHTML = palabraOculta + " , " + palabraSelec;
}
//Comprueba si la tecla presionada existe en la palabra
function comprobarLetra() {
    //recoge la tecla pulsada
    var letra = this.innerHTML;
    //el boton pulsado pasa a estar deshabilitado
    this.disabled = true;
    //convierto la palabra correcta en una array de chars
    var letras = palabraSelec.split("");

    var encontrado = false;

    for (var i = 0; i < letras.length; i++) {
//si la letra es igual a alguna letra de la array entrara 
        if (letra == letras[i]) {
            //encontrado pasa a true
            encontrado = true;
            //hace un replace de palabra oculta en el indice de la letra de la palabra original
            //y asi cambiar el asterisco correctamente
            palabraOculta = palabraOculta.replaceAt(i, letra);

            //vuelve a pintar el nombre
            document.getElementById("palbraOculta").innerHTML = palabraOculta + " , " + palabraSelec;


        }
        //si palabra oculta y la seleccionada en la array son iguales acaba el juego
        if (palabraOculta == palabraSelec) {
            alert("HAS GANADO");
            //reinicia el juego
            reiniciar();
        }

    }

//si no ha encontrado ninguna letra aumentan los errores y continua con el canvas
    if (encontrado == false) {
        errores++;
        crearCanvas();
    }
}

//habilita los botones deshabilitados 
function reiniciarBotones() {
    var elements = document.querySelectorAll("button");
    for (var i = 0, len = elements.length; i < len; i++) {
        elements[i].disabled = false;
    }

}
//Cambia una letra de un string segun en el indice indicado con la letra indicada
String.prototype.replaceAt = function (index, replacement) {
    return this.substr(0, index) + replacement + this.substr(index + replacement.length);
};

//crea el canvas
function crearCanvas() {

    // Creant l'objecte Canvas
    var c = document.getElementById("myCanvas");


    var ctx = c.getContext("2d");
    // dibuixant el terra
    var c = document.getElementById("myCanvas");
    var ctx = c.getContext("2d");
    ctx.moveTo(0, 280);
    ctx.lineTo(300, 280);
    ctx.stroke();
    // pint estructura de la forca
    if (errores == 0) {
        ctx.moveTo(100, 280);
        ctx.lineTo(100, 80);
        ctx.stroke();
        ctx.moveTo(100, 80);
        ctx.lineTo(160, 80);
        ctx.stroke();
        ctx.moveTo(160, 80);
        ctx.lineTo(160, 130);
        ctx.stroke();
    }

    // pint cap
    if (errores == 1) {
        ctx.beginPath();
        ctx.arc(160, 140, 10, 0, 2 * Math.PI);
        ctx.stroke();
    }

    // pint tronc
    if (errores == 2) {
        ctx.moveTo(160, 150);
        ctx.lineTo(160, 190);
        ctx.stroke();
    }

    // pint braç esquerre
    if (errores == 3) {
        ctx.moveTo(160, 160);
        ctx.lineTo(155, 175);
        ctx.stroke();
    }

    // pint braç dret

    if (errores == 4) {
        ctx.moveTo(160, 160);
        ctx.lineTo(165, 175);
        ctx.stroke();
    }

    // pint cama esquerra
    if (errores == 5) {
        ctx.moveTo(160, 190);
        ctx.lineTo(155, 205);
        ctx.stroke();
    }

    // pint cama dreta
    if (errores >= 6) {
        ctx.moveTo(160, 190);
        ctx.lineTo(165, 205);
        ctx.stroke();
        alert("HAS PERDIDO");
        reiniciar();
    }


}
//reinicia el juego
function reiniciar() {
    //vuelve a seleccionar una palabra
    seleccionarPalabra();

    //borra el canvas
    var c = document.getElementById("myCanvas");
    c.parentNode.removeChild(c);

    //añade de nuevo un canvas
    c = document.createElement("canvas");
    c.id = "myCanvas";
    document.getElementById("palbraOculta").after(c);
    //pone los errores a 0
    errores = 0;

    var canvas = document.getElementById("myCanvas");
    //añade los atributos que hacen que se vea correctamente el canvas
    canvas.setAttribute("width", "300");
    canvas.setAttribute("height", "300");
    
    //pinta el canvas
    crearCanvas();
    //reinicia los botones
    reiniciarBotones();



}

//Funcion que se ejecuta al cargar la pagina
window.onload = function () {

    //selecciona una palabra de la array
    seleccionarPalabra();
    //selecciona todos los botones y le añade un event listener
    var elements = document.querySelectorAll("button");
    for (var i = 0, len = elements.length; i < len; i++) {
        elements[i].addEventListener("click", comprobarLetra);
    }

    //pinta el canvas
    crearCanvas();
};