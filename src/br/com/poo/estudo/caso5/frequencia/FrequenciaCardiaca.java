package br.com.poo.estudo.caso5.frequencia;

import java.time.LocalDate;

public class FrequenciaCardiaca {
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;

    public FrequenciaCardiaca(String nome, String sobrenome, LocalDate dataNascimento) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
    }

    // Métodos getters e setters para os atributos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    // Método para calcular e retornar a idade em anos
    public int calcularIdade() {
        LocalDate hoje = LocalDate.now();
        int idade = hoje.getYear() - dataNascimento.getYear();
        if (hoje.getMonthValue() < dataNascimento.getMonthValue() ||
                (hoje.getMonthValue() == dataNascimento.getMonthValue() && hoje.getDayOfMonth() < dataNascimento.getDayOfMonth())) {
            idade--;
        }
        return idade;
    }

    // Método para calcular e retornar a frequência cardíaca máxima
    public int calcularFrequenciaCardiacaMaxima() {
        int idade = calcularIdade();
        return 220 - idade;
    }

    // Método para calcular e retornar a frequência cardíaca alvo
    public String calcularFrequenciaCardiacaAlvo() {
        int frequenciaCardiacaMaxima = calcularFrequenciaCardiacaMaxima();
        int frequenciaMinima = (int) (frequenciaCardiacaMaxima * 0.5);
        int frequenciaMaxima = (int) (frequenciaCardiacaMaxima * 0.85);
        return frequenciaMinima + "-" + frequenciaMaxima;
    }


}