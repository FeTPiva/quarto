
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

    botao.addEventListener("click", function(event) {
    event.preventDefault();
    var ra = document.querySelector(".form-adiciona").querySelector("#ra");
    var nome = document.querySelector(".form-adiciona").querySelector("#nome");
    var p1 = document.querySelector(".form-adiciona").querySelector("#p1");
    var p2 = document.querySelector(".form-adiciona").querySelector("#p2");
    var p3 = document.querySelector(".form-adiciona").querySelector("#p3");
    var p4 = document.querySelector(".form-adiciona").querySelector("#p4");

    var trAluno = document.createElement("tr");
    var tdNome = document.createElement("td");
    var tdp1 = document.createElement("td");
    var tdp2 = document.createElement("td");
    var tdp3 = document.createElement("td");
    var tdp4 = document.createElement("td");
    
    var tdra = document.createElement("th");



    tdNome.setAttribute("class","nome");
    trAluno.setAttribute("class","aluno");
    tdRa.setAttribute("scope","row");
    tdp1.setAttribute("class","p1");
    tdp2.setAttribute("class","p2");
    tdp3.setAttribute("class","p3");
    tdp4.setAttribute("class","p4");


    tdNome.textContent = nome.value;
    tdra.textContent = ra.value;
    tdp1.textContent = p1.value;
    tdp2.textContent = p2.value;
    tdp3.textContent = p3.value;
    tdp4.textContent = p4.value;
 

    trAluno.appendChild(tdra);
    trAluno.appendChild(tdNome);
    trAluno.appendChild(tdp1);
    trAluno.appendChild(tdp2);
    trAluno.appendChild(tdp3);
    trAluno.appendChild(tdp4);    
    trAluno.appendChild(tdmedia);
    trAluno.appendChild(tdaprovado);

    

    var tableAluno = document.querySelector("table").querySelector("body");
    tableAluno.appendChild(trAluno);

    console.log(document.querySelector("table"));

});
