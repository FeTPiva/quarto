<?php

session_start();
if(isset($_SESSION['nome'])){
    echo "welcome ".$_SESSION['nome']."!";
    echo "<br>".$_SESSION["ra"];
}else{

    $_SESSION["nome"] = "Tiago";
    $_SESSION["ra"] = "123456";
    echo 'vc nunca passou por aki';
}