package br.com.poo.estudo.caso3.condicionais.exemplos;

import java.util.Scanner;

public class ContadorDoTeste {

    public static void main(String[] argumentos)	{

        Scanner entrada = new Scanner(System.in);
        double total = 0d;
        int contadorNotas = 1;

        System.out.println(":::: Balanço das últimas vendas do Usuário ::::");
        while(contadorNotas <= 3){
            System.out.print("Digite o valor total da nota: ");
            double valorNota= entrada.nextDouble();
            total = total + valorNota;
            contadorNotas = contadorNotas + 1;
        }

        double media = total / 3;

        System.out.printf("Balanço das últimas vendas foi: %.2f%n", total);
        System.out.printf("Média de vendas: %.2f%n", media);

    }
}

