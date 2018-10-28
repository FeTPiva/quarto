<?php
#conteudo valioso
#acessa bd e retorna uma monte de info privilegiada

session_start();
if(isset($_SESSION["id"])){

//autenticado
echo "autenticado";
    if($_SESSION["perm"]<1){
    echo " -aceeso feito c sucesso";
    }else {
    echo "n privilegiado";
    }

}else{
//n autenticado

echo "n ta logado";

header("location:localhost/app/login/"); //html do front
}