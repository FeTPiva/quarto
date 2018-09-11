<?php
namespace app\model;
class Produto{

    private $idp;
    private $nome;
    private $preco;
    
function __construct($idp, $nome, $preco){
   
    $this->nome = $nome;
    $this->idp = $idp;
    $this->preco = $preco;
}

public function getPreco(){
    return $this->preco;
}

public function setPreco($preco){
    $this->preco = $preco;

}


public function getIdp(){
    return $this->idp;
}

public function setIdp($idp){
    $this->idp = $idp;

}
public function getNome(){
    return $this->nome;
}

public function setNome($nome){
    $this->nome = $nome;

}

}
?>
