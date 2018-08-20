/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maua;

/**
 *
 * @author Aluno 16
 */
public class Aluno {
    
    private Integer codAluno;
private String nome;
public Aluno() { }
public Aluno(Integer codAluno, String nome) {
this.codAluno = codAluno;
this.nome = nome;
}
public Integer getCodAluno() {
return codAluno;
}
public void setCodAluno(Integer codAluno) {
this.codAluno = codAluno;
}
public String getNome() {
return nome;
}
public void setNome(String nome) {
this.nome = nome;
}
    
}
