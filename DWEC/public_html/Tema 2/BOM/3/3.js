
var hora = 0, min = 0, segundo = 0;
var output = hora + ":" + min + ":" + segundo;
var imagen = ["clockimages/c0.gif", "clockimages/c1.gif", "clockimages/c2.gif", "clockimages/c3.gif", "clockimages/c4.gif",
    "clockimages/c5.gif", "clockimages/c6.gif", "clockimages/c7.gif", "clockimages/c8.gif", "clockimages/c9.gif"];


function startTime() {
    var today = new Date();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    m = checkTime(m);
    s = checkTime(s);
    var horaImagen1, horaImagen2, horaImagenCompleta;
    var minutoImagen1, minutoImagen2, minutoImagenCompleta;
    var segundoImagen1, segundoImagen2, segundoImagenCompleta;

    h += "";
    m += "";
    s += "";

    segundoImagen1 = "<img src='" + imagen[s.substring(0, 1)] + "'/>";
    segundoImagen2 = "<img src='" + imagen[s.substring(1, 2)] + "'/>";

    minutoImagen1 = "<img src='" + imagen[m.substring(0, 1)] + "'/>";
    minutoImagen2 = "<img src='" + imagen[m.substring(1, 2)] + "'/>";

    horaImagen1 = "<img src='" + imagen[h.substring(0, 1)] + "'/>";
    horaImagen2 = "<img src='" + imagen[h.substring(1, 2)] + "'/>";

    horaImagenCompleta = horaImagen1 + horaImagen2;
    minutoImagenCompleta = minutoImagen1 + minutoImagen2;
    segundoImagenCompleta = segundoImagen1 + segundoImagen2;

    document.getElementById('hora').innerHTML =
            horaImagenCompleta + "<img src='clockimages/colon.gif'/>" + minutoImagenCompleta + "<img src='clockimages/colon.gif'/>" + segundoImagenCompleta;
    var t = setTimeout(startTime, 1000);
}
function checkTime(i) {
    if (i < 10) {
        i = "0" + i
    }
    ;  // add zero in front of numbers < 10
    return i;
}

