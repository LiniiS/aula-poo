package br.com.poo.estudo.caso4.avalia;

public class Principal {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
        Funcionario gerenteUm = new Gerente();

        Gerente gerenteDois = new Gerente();

        System.out.println("Funcionario Logando...");
        funcionario.logar();

        System.out.println("GerenteUm Logando...");
        gerenteUm.logar();

        System.out.println("GerenteDois Logando...");
        gerenteDois.logar();
    }
}
