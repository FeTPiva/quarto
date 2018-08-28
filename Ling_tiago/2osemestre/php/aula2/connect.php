<?php
$servername = "localhost:3307";
$username = "user";
$password = "senha";

try {
    $conn = new PDO("mysql:host=$servername;dbname=mercearia", $username, $password);
    // set the PDO error mode to exception
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    echo "Connected successfully"; 
    }
catch(PDOException $e)
    {
    echo "Connection failed: " . $e->getMessage();
    }
?>