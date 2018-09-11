<?php

class Usuario{

    private $nome;
    private $email;
    private $senha;


    function __construct($nome, $email,$senha){
        $this->email = $email;
        $this->nome = $nome;
        $this->senha = $senha;
    }

    public function getNome(){
        return $this->nome;
    }

    public function getEmail(){
        return $this->email;
    }

    public function getSenha(){
        return $this->senha;
    }

    public function setNome($nome){
        $this->nome = $nome;

    }
    public function setEmail($eemail){
        $this->email = $email;

    }

    public function setSenha($senha){
        $this->senha = $senha;

    }




}