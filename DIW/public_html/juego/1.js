/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



var myGamePiece;
var myObstacles = [];
var myScore;

function startGame() {
    //crea cubo
    myGamePiece = new component(30, 30, "red", 10, 120);
    //velocidad de caida inicial
    myGamePiece.gravity = 0.05;

    //puntuacion
    myScore = new component("30px", "Consolas", "black", 280, 40, "text");
    myGameArea.start();
}

var myGameArea = {
    //crea canvas
    canvas: document.createElement("canvas"),

    //declara la funcion start
    start: function () {

        //tamaño
        this.canvas.width = 480;
        this.canvas.height = 270;
        this.context = this.canvas.getContext("2d");
        document.body.insertBefore(this.canvas, document.body.childNodes[0]);
        //empiezan los obstaculos en el frame 0
        this.frameNo = 0;
        //cada 20 milisegundos hace update del area
        this.interval = setInterval(updateGameArea, 20);
    }, //borra todo
    clear: function () {
        this.context.clearRect(0, 0, this.canvas.width, this.canvas.height);
    }
}
//funcion que crea objetos
function component(width, height, color, x, y, type) {
    this.type = type;
    this.score = 0;
    this.width = width;
    this.height = height;
    this.speedX = 0;
    this.speedY = 0;
    this.x = x;
    this.y = y;
    this.gravity = 0;
    this.gravitySpeed = 0;
    this.update = function () {
        ctx = myGameArea.context;

        //si es texto hara lo siguiente
        if (this.type == "text") {
            ctx.font = this.width + " " + this.height;
            ctx.fillStyle = color;
            ctx.fillText(this.text, this.x, this.y);
        } else {
            ctx.fillStyle = color;
            ctx.fillRect(this.x, this.y, this.width, this.height);
        }
    }
    //actualiza la posicion
    this.newPos = function () {
        //aumenta la velocidad segun la gravedad
        this.gravitySpeed += this.gravity;
        this.x += this.speedX;
        this.y += this.speedY + this.gravitySpeed;
        //comprueba si ha chocado
        this.hitBottom();
        this.hitTop();
    }
    this.hitBottom = function () {
        var rockbottom = myGameArea.canvas.height - this.height;

        if (this.y > rockbottom) {
            this.y = rockbottom;
            this.gravitySpeed = 0;
        }
    }
    this.hitTop = function () {
        var rockbottom = 0;

        if (this.y < rockbottom) {
            this.y = rockbottom;
            this.gravitySpeed = 1;
        }
    }




    this.crashWith = function (otherobj) {
        // guarda los puntos del objeto que lo llama
        var myleft = this.x;
        var myright = this.x + (this.width);
        var mytop = this.y;
        var mybottom = this.y + (this.height);

        //guarda los puntos del objeto dado y los compara si estan en colision con alguno
        var otherleft = otherobj.x;
        var otherright = otherobj.x + (otherobj.width);
        var othertop = otherobj.y;
        var otherbottom = otherobj.y + (otherobj.height);
        var crash = true;

        //si no se tocan devuelve false
        if ((mybottom < othertop) || (mytop > otherbottom) || (myright < otherleft) || (myleft > otherright)) {
            crash = false;
        }
        return crash;
    }
}

function updateGameArea() {
    var x, height, gap, minHeight, maxHeight, minGap, maxGap;
    //comprueba si algun obstaculo ha chocado con el cubo
    for (i = 0; i < myObstacles.length; i += 1) {
        if (myGamePiece.crashWith(myObstacles[i])) {
            return;
        }
    }

    myGameArea.clear();
    //avanza un frame (cuanto mas avance mas obstaculos salen por momento)
    myGameArea.frameNo += 1;

//si esta en el frame 1 o han pasado 150 milisegundos crea un obstaculo
    if (myGameArea.frameNo == 1 || everyinterval(150)) {
        //lo crea a la derecha del canvas
        x = myGameArea.canvas.width;
        //tamaños minimos y maximos del obstaculo
        minHeight = 20;
        maxHeight = 200;
        //tamaño aleatorio
        height = Math.floor(Math.random() * (maxHeight - minHeight + 1) + minHeight);
        //minimos y maximos de espacios entre el centro de los obstaculos
        minGap = 50;
        maxGap = 200;
        //crea el espacio libre aleatorio
        gap = Math.floor(Math.random() * (maxGap - minGap + 1) + minGap);
        //crea los obstaculos de arriba y abajo
        myObstacles.push(new component(10, height, "blue", x, 0));
        myObstacles.push(new component(10, x - height - gap, "blue", x, height + gap));
    }
    for (i = 0; i < myObstacles.length; i += 1) {
        myObstacles[i].x += -1;
        myObstacles[i].update();
    }
    //muestra el score y lo aumenta
    myScore.text = "SCORE: " + myGameArea.frameNo;
    myScore.update();

    myGamePiece.newPos();
    myGamePiece.update();
}

function everyinterval(n) {
    if ((myGameArea.frameNo / n) % 1 == 0) {
        return true;
    }
    return false;
}
//cambia la gravedad actuando sobre el movimiento del cuadrado
function accelerate(n) {
    myGamePiece.gravity = n;
}