<?php
mb_internal_encoding('UTF-8');
mb_http_output('UTF-8');


if(isset($_SESSION["id"])){
    echo "vc esta logado";


}else{

$body = file_get_contents('php://input');
$body = trim($body);
$obj = json_decode($body,true);
$email = $obj["email"];
$senha = $obj["senha"];

$host = '127.0.0.1:3307';
$db   = 'db_banco';
$user = 'root'; 
$pass = '';
$charset = 'utf8mb4';
$dsn = "mysql:host=$host;dbname=$db;charset=$charset";
$pdo = new PDO($dsn, $user, $pass);


$stmt = $pdo->prepare("SELECT * FROM tbl_user WHERE email = :email and senha = :senha");
$stmt->bindParam(":email", $email);
$stmt->bindParam(":senha", $senha);
$stmt->execute();

$result = $stmt->fetchAll(PDO::FETCH_ASSOC);


if($stmt->rowCount()>0){
    session_start();
    $_SESSION["id"] = $result[0]["id"];
    $_SESSION["perm"] = $result[2]["permissao"];


  
    echo"<br>";
    echo"O login foi efetuado com sucesso!";
    

    

 }else{

    echo"<br>"; 
    echo"Não foi possível efetuar o login. Tente novamente.";
    session_destroy();
    
 }
}

?>
      