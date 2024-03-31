package br.com.poo.estudo.caso3.condicionais.exemplos;

public class ContadorDoWhile {

    public static void main(String[] args) {
        int contador = 0;
        do{
            System.out.println("Contador: " + contador);
            ++contador;
        }while(contador <= 5);
    }
}
