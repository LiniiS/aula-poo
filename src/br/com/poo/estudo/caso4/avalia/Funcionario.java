package br.com.poo.estudo.caso4.avalia;

public class Funcionario {
    private String nome;
    private String idade;

    public Funcionario(){

    }

    public void logar(){
        System.out.println("Logado - Funcionário");
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }
}
