<?php

$body = file_get_contents('php://input');
#boa pratica
$body = trim($body);
$obj_json = json_decode($body,true);

//codigo.... 

//pessima pratica
$sql = "Select * from tab where id_prod=".$obj_json["id_produto"]; //pode dar problema de sql injection

//var_dump($obj_json);

echo $sql;






