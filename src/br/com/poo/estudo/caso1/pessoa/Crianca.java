package br.com.poo.estudo.caso1.pessoa;

public class Crianca extends Pessoa{
    private String nome;

    public Crianca(String nome, String sobrenome, String email, String endereco, String telefone, String nome1) {
        super(nome, sobrenome, email, endereco, telefone);
        this.nome = nome1;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }
}
