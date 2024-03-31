package br.com.poo.estudo.caso3.condicionais.exemplos;

import java.util.Scanner;

public class NotaFinalSwitchCase {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite a nota final: ");
        int nota = entrada.nextInt();

        switch (nota) {
            case 10:
            case 9:
                System.out.println("Nota maior ou igual a 8");
                System.out.println("Aprovado com conceito A");
                break;
            case 8:
            case 7:
                System.out.println("Nota maior ou igual a 7");
                System.out.println("Aprovado com conceito B");
                break;
            case 6:
                System.out.println("Nota maior ou igual a 6");
                System.out.println("Aprovado com conceito C");
                break;
            default:
                System.out.println("Reprovado");
        }

        entrada.close();
    }

}
