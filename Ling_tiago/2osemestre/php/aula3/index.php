<?php

require_once "Usuario.php";
require_once "app/model/Produto.php";
require_once "vendor/submarino/Produto.php";
//require_once "config.php";
use PHPMailer\src\PHPMailer;
use PHPMailer\src\Exception;

require 'PHPMailer/src/Exception.php';
require 'PHPMailer/src/PHPMailer.php';
require 'PHPMailer/src/SMTP.php';

$user = new Usuario("nome", "email", "senha");
$prod = new app\model\Produto(12, "produto", 500);
$prod2 = new vendor\submarino\Produto(12, "produto2", 500);


echo "usuario: ".$user->getNome()."<br>";
echo "produto: ".$prod->getNome()."<br>";
echo "produto: ".$prod2->getNome()."<br>";

echo "funcionou?";


