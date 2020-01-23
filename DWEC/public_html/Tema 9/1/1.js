/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


window.onload = function () {
//    document.getElementById("submit").addEventListener("click", comprovar)
    document.getElementById("form").addEventListener("submit", comprovar);
    crearSuma();


};

function comprovar() {
    var inputTelefono = document.getElementById("tel");
    var pass = document.getElementById("pass1");
    var confPass = document.getElementById("pass2");
    var resultadoSuma = document.getElementById("resulSuma");

    var paradas = 0;


    paradas = paradas + anyadirParada(isValidPhone(inputTelefono));

    edad();

    paradas = paradas + anyadirParada(checkPass(pass));

    paradas = paradas + anyadirParada(mayor18());
    paradas = paradas + anyadirParada(checkSecondPass(pass, confPass));
    paradas = paradas + anyadirParada(comprobarSuma(resultadoSuma));
    paradas = paradas + almenosTres();


    if (paradas > 0) {
        event.preventDefault();
    } else {
        return true;
    }
}


function edad() {
    var fechaNacimiento = document.getElementById('nacimiento').value;

    var today = new Date();
    var birthDate = new Date(fechaNacimiento);
    var age = today.getFullYear() - birthDate.getFullYear();
    var m = today.getMonth() - birthDate.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
        age = age - 1;
    }

    document.getElementById("edad").innerHTML = age + " Años";

    return age;

}

function mayor18() {
    var fechaNacimiento = document.getElementById('nacimiento').value;
    var contrato = document.getElementById('contrato').value;


    var today = new Date(contrato);
    var birthDate = new Date(fechaNacimiento);
    var age = today.getFullYear() - birthDate.getFullYear();
    var m = today.getMonth() - birthDate.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
        age = age - 1;
    }
    try {
        if (age < 18)
            throw "USTET NO PODIA ERA PEQUENIO TENIA: " + age;
    } catch (err) {
        document.getElementById("mayor").innerHTML = err;
    }

    return false;


}
function anyadirParada(boolean) {
    if (boolean == false) {
        return 1;
    } else {
        return 0;
    }

}
;

function checkPass(pass) {
    var pattern = /^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)[0-9A-Za-z]{8,}$/g;

    var correcto = false;

    correcto = pattern.test(pass.value);

    if (!correcto) {
        pass.style.backgroundColor = "red";
    } else {
        pass.style.backgroundColor = "green";

    }


    return correcto;


}

function checkSecondPass(pass, confPass) {
    if (pass.value == confPass.value) {
        confPass.style.backgroundColor = "green";
        return true;
    } else {
        confPass.style.backgroundColor = "red";
        return false;

    }

}

function isValidPhone(numero) {
    var patternNumero = /^[0-9]{9}$/g;

    var correcto = false;
    correcto = patternNumero.test(numero.value);

    if (!correcto) {
        numero.style.backgroundColor = "red";
    } else {
        numero.style.backgroundColor = "green";

    }


    return correcto;
}

function crearSuma() {
    var a, b;
    a = Math.floor(Math.random() * ((10 - 1) + 1) + 1);
    b = Math.floor(Math.random() * ((10 - 1) + 1) + 1);

    document.getElementById("sumaA").innerHTML = a;
    document.getElementById("sumaB").innerHTML = b;


}

function comprobarSuma(resultado) {
    var a, b;

    a = parseInt(document.getElementById("sumaA").innerHTML, 10);
    b = parseInt(document.getElementById("sumaB").innerHTML, 10);

    if ((a + b) === resultado.value) {
        resultado.style.backgroundColor = "green";
        return true;
    } else {
        resultado.style.backgroundColor = "red";

        return false;
    }


}

function almenosTres() {
    var xekeaos = 0;
    for (var i = 1; i < 9; i++) {

        if (document.getElementById("ck" + i).checked == true)
            xekeaos++;

    }

    try {

        if (xekeaos < 3) {
            throw "Elige 3 o mas";
        } else {

            return true;
        }
    } catch (err) {

        document.getElementById("ckFunciona").innerHTML = err;
        return false;

    }

}