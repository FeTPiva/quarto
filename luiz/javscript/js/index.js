
/*
var thra1 = document.querySelector("#ra12345671").querySelector("th");

var navBarBrand1 = document.querySelector(".navbar-brand");
var navBarBrand2 = document.querySelector("#titulopag");
var navBarBrand3 = document.querySelector(".ttp");

console.log(thra1);
console.log(thra1.textContent);
console.log(navBarBrand1);
console.log(navBarBrand2);
console.log(navBarBrand3);

navBarBrand2.textContent = thra1.textContent;

var p1 = parseFloat(document.querySelector(".p1").textContent);
var p2 = parseFloat(document.querySelector(".p2").textContent);
var p3 = parseFloat(document.querySelector(".p3").textContent);
var p4 = parseFloat(document.querySelector(".p4").textContent);

var ra = "#ra12345671";

var nsei = document.querySelector(ra).querySelector("td");
console.log(p1);

var media = (p1+p2+p3+p4)/4.0;
media.textContent = nsei.textContent;

if( media >= 6){

document.querySelector(ra).querySelector(".r").textContent = "passssou";

} else{
    document.querySelector(ra).querySelector(".r").textContent = " nao passssou";
} */

trs = document.querySelectorAll(".aluno");
for (var i = 0; i < trs.length; i++) {

    calculamedia(trs[i]);

}

function calculamedia(aluno) {
    var p1 = parseFloat(aluno.querySelector(".p1").textContent);
    var p2 = parseFloat(aluno.querySelector(".p2").textContent);
    var p3 = parseFloat(aluno.querySelector(".p3").textContent);
    var p4 = parseFloat(aluno.querySelector(".p4").textContent);


    var media = (p1 + p2 + p3 + p4) / 4.0;
    var aprovado = "";

    if (media >= 6) {

        aprovado = "Sim";

    } else {

        aprovado = "nao";
    }

    aluno.querySelector(".media").textContent = media;
    aluno.querySelector(".aprovado").textContent = aprovado;

    console.log(aluno);

}


var botao = document.querySelector(".adiciona-button");

botao.addEventListener("click", function (event) { event.preventDefault();

    var ra = document.querySelector(".form-adiciona").querySelector("#ra");

    console.log(ra.textContent);

});
/