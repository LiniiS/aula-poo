package br.com.poo.estudo.caso4.avalia;

public class Gerente extends Funcionario{
    public Gerente(){}

    public void logar(){
        System.out.println("Logado - Gerente");
    }

    public void logar(String codigo){
        super.logar();
    }
}
