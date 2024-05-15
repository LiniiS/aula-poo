package br.com.poo.estudo.caso6.polimorfismo;

public class FuncionarioAssalariado extends Funcionario{

    private double salarioSemanal;

    public FuncionarioAssalariado(String nome, String sobrenome, String cpf, double salarioSemanal) {
        super(nome, sobrenome, cpf);

        if(salarioSemanal < 0.0)
            throw new IllegalArgumentException("Salário semanal deve ser maior que 0.0");
        this.salarioSemanal = salarioSemanal;
    }

    public void setSalarioSemanal(double salarioSemanal){
        if(salarioSemanal < 0.0)
            throw new IllegalArgumentException("Salário semanal deve ser maior que 0.0");
        this.salarioSemanal = salarioSemanal;
    }

    public double getSalarioSemanal() {
        return salarioSemanal;
    }

    @Override
    public double faturamento() {
        return getSalarioSemanal();
    }

    @Override
    public String toString() {
        return String.format("Funcionário assalariado: %s%n%s: $%, .2f",
                super.toString(), "Salário semanal", getSalarioSemanal());

    }
}
