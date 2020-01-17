


window.onload = function () {
    document.getElementById("iniciar").addEventListener("click", cronometro);
    document.getElementById("stop").addEventListener("click", stop);
    document.getElementById("restaurar").addEventListener("click", restaurar);


};


var temporizador = function () {
    var milis = 0;
    var sec = 0;
    var min = 0;
    var crono;

    return{
        incrementar: function () {
            crono = setInterval(function () {
                milis += 10;
                if (milis === 1000) {
                    sec++;
                    milis = 0;
                }

                if (sec === 60) {
                    min++;
                    sec = 0;
                }
                document.getElementById("cronometro").innerHTML = min + ":" + sec + ":" + milis;
            }, 10);
            document.getElementById("iniciar").disabled = true;

        },

        parar: function () {
            clearInterval(crono);
            document.getElementById("iniciar").disabled = false;
        },

        restaurar: function () {
            stop();
            sec = 0;
            min = 0;
            milis = 00;
            document.getElementById("cronometro").innerHTML = min + ":" + sec + ":" + milis;
        }

    };
};

var reloj1 = temporizador();

function cronometro() {

    reloj1.incrementar();
}

function stop() {

    reloj1.parar();
}


function restaurar() {

    reloj1.restaurar();

}


