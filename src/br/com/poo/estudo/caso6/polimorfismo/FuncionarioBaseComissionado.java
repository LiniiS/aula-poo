package br.com.poo.estudo.caso6.polimorfismo;

public class FuncionarioBaseComissionado extends FuncionarioComissionado{
    private double salarioBase;

    public FuncionarioBaseComissionado(String nome, String sobrenome, String cpf, double vendaBrutaSemanal,
                                       double taxaComissao, double salariBase) {
        super(nome, sobrenome, cpf, vendaBrutaSemanal, taxaComissao);
        if(salariBase < 0.0)
            throw new IllegalArgumentException("Salário base deve ser maior que zero");

        this.salarioBase = salariBase;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        if(salarioBase < 0.0)
            throw new IllegalArgumentException("Salário base deve ser maior que zero");
        this.salarioBase = salarioBase;
    }

    @Override
    public double faturamento() {
        return getSalarioBase() + super.faturamento();
    }

    @Override
    public String toString() {
        return String.format("%s, %s; %s: $%, .2f",
                "Funcionário ", super.toString(),
                "Salário base ", getSalarioBase());
    }
}
