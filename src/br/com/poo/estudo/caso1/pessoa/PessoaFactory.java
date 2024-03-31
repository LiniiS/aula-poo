package br.com.poo.estudo.caso1.pessoa;

public class PessoaFactory {
    public static Pessoa criarPessoa(String nome, String sobrenome, String email, String endereco, String telefone) {
        return new Pessoa(nome, sobrenome, email, endereco, telefone);
    }
}
