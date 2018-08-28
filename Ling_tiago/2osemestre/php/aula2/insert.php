<?php

$body = file_get_contents('php://input');
$body = trim($body);
$obj = json_decode($body,true);

$nome = $obj["nome"];
$cpf = $obj["cpf"];
$idade = $obj["idade"];

$servername = "localhost:3307";
$username = "root";
$password = "";
$dbname = "mercearia";

try {
    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
    // set the PDO error mode to exception
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    $sql = "INSERT INTO tbl_cliente (nome, cpf, idade)VALUES ($nome, $cpf, $idade)";
    // use exec() because no results are returned
    $conn->exec($sql);
    http_response_code(201);
    }
catch(PDOException $e)
    {
    echo $sql . "<br>" . $e->getMessage();
    }

$conn = null;

?>