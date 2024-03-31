package br.com.poo.estudo.caso3.condicionais.exemplos;

public class ContadorWhile {

    public static void main(String[] args) {
        int contador = 0;
        int numero = 5;

        while(contador <= numero){
            System.out.println("Contador: " + contador);
            ++contador;
        }
    }
}
