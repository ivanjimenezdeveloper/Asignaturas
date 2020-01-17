/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var size12 = makeSizer(12);
var size14 = makeSizer(14);
var size16 = makeSizer(16);
window.onload = function () {
    document.getElementById('size-12').addEventListener("click", size12);
    document.getElementById('size-14').addEventListener("click", size14);
    document.getElementById('size-16').addEventListener("click", size16);


}
;
function makeSizer(size) {
    return function () {
        document.body.style.fontSize = size + 'px';
    };
}

