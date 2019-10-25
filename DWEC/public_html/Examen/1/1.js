
//Saco la fecha de hoy
var fechaHoy = new Date();


//Creo una variable con los nombres de la semana
var dia = ["Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"];


//Creo una variable con los nombres de los meses
var mes = ["Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"];



//Creo el formato segun el dia de la semana, el dia del mes,
// el nombre del mes y el año apoyandome en una array para los nombres
var formato = dia[fechaHoy.getDay()] + ", "
        + String(fechaHoy.getDate() + " de " + mes[fechaHoy.getMonth()] + " de " + fechaHoy.getFullYear());

//inserto el formato creado
document.getElementById("fecha").innerHTML = formato;


//Saco e inserto las horas y minutos haciendo un 
//formato en el que siempre hay minimo dos numeros tanto en horas como minutos
document.getElementById("hora").innerHTML = String(fechaHoy.getHours()).padStart(2, "0") +":" 
        +String(fechaHoy.getMinutes()).padStart(2, "0");