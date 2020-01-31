/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


class Consumible {
    constructor(nom, descripcion, efecto) {
        this.nom = nom;
        this.descripcion = descripcion;
        this.efecto = efecto;
    }

    consumir(personaje) {
        console.log(personaje.nom + " consume " + this.nom + " y " + this.descripcion);
        this.efecto(personaje);


    }
}

class Personaje {
    constructor(nom, potencia, hp, hpMax) {
        this.nom = nom;
        this.potencia = potencia;
        this.hp = hp;
        this.hpMax = hpMax;

    }

    consumir(consumible) {
        consumible.consumir(this);
    }
}

var kaladin = new Personaje("Kaladin", 2, 5, 10);
var pocion = new Consumible("Pocion de vida", "Cura 2 puntos de vida", function (personaje) {
    personaje.hp = personaje.hp + 2;

    if (personaje.hp > personaje.hpMax) {
        personaje.hp = personaje.hpMax;
        console.log(personaje.nom + " Pero no ocurre nada ");

    } else {
            console.log(personaje.nom + " ahora tiene " + personaje.hp + " puntos de vida ");

    }

});

var pocionFuerza = new Consumible("Pocion de fuerza", "Aumenta la potencia en 1 pero baja la vida maxima en 1", function (personaje) {
    personaje.hpMax = personaje.hpMax - 1;
    personaje.potencia = personaje.potencia + 1;
    if (personaje.hpMax < 1) {
        personaje.hpMax = 1;
    }
    console.log(personaje.nom + " ahora tiene " + personaje.hpMax + " puntos de vida maximos y " + personaje.potencia + " de potencia ");

});

kaladin.consumir(pocion);

kaladin.consumir(pocionFuerza);