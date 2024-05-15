package br.com.poo.estudo.caso6.polimorfismo;

public abstract class Funcionario {
    private final String nome;
    private final String sobrenome;
    private final String cpf;


    public Funcionario(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return String.format("%s %s CPF: %s", getNome(), getSobrenome(), getCpf());
    }

    public abstract double faturamento();
}
