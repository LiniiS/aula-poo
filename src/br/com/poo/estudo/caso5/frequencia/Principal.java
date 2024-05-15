package br.com.poo.estudo.caso5.frequencia;

import java.time.LocalDate;

public class Principal {

    public static void main(String[] args) {

        FrequenciaCardiaca pessoa = new FrequenciaCardiaca("Aline", "S", LocalDate.of(1987, 3, 26));

        // Imprimir informações da pessoa
        imprimeDadosPaciente(pessoa);
    }

    private static void imprimeDadosPaciente(FrequenciaCardiaca pessoa) {
        System.out.println("Nome: " + pessoa.getNome() + " " + pessoa.getSobrenome());
        System.out.println("Data de Nascimento: " + pessoa.getDataNascimento());
        System.out.println("Idade: " + pessoa.calcularIdade() + " anos");
        System.out.println("Frequência Cardíaca Máxima: " + pessoa.calcularFrequenciaCardiacaMaxima() + " bpm");
        System.out.println("Frequência Cardíaca Alvo: " + pessoa.calcularFrequenciaCardiacaAlvo() + " bpm");
    }
}
