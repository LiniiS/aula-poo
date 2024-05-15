package br.com.poo.estudo.caso6.polimorfismo;

public class FuncionarioComissionado extends Funcionario{

    private double vendaBrutaSemanal;
    private double taxaComissao;

    public FuncionarioComissionado(String nome, String sobrenome, String cpf,
                                   double vendaBrutaSemanal, double taxaComissao) {
        super(nome, sobrenome, cpf);

        if(taxaComissao <= 0.0 || taxaComissao >= 1.0) // valida
            throw new IllegalArgumentException("Taxa de comissão deve ser > 0.0 e < 1.0");

        if (vendaBrutaSemanal < 0.0) // valida
            throw new IllegalArgumentException("Venda bruta semanal com valor inválido.");

        this.vendaBrutaSemanal = vendaBrutaSemanal;
        this.taxaComissao = taxaComissao;
    }

    public double getVendaBrutaSemanal() {
        return vendaBrutaSemanal;
    }

    public void setVendaBrutaSemanal(double vendaBrutaSemanal) {
        if (vendaBrutaSemanal < 0.0) // valida
            throw new IllegalArgumentException("Venda bruta semanal com valor inválido.");

        this.vendaBrutaSemanal = vendaBrutaSemanal;
    }

    public double getTaxaComissao() {
        return taxaComissao;
    }

    public void setTaxaComissao(double taxaComissao) {
        if(taxaComissao <= 0.0 || taxaComissao >= 1.0) // valida
            throw new IllegalArgumentException("Taxa de comissão deve ser > 0.0 e < 1.0");
        this.taxaComissao = taxaComissao;
    }

    @Override
    public double faturamento() {
        return getTaxaComissao() * getVendaBrutaSemanal();
    }

     public String toString(){
        return String.format("%s: %s%n%s: $%,.2f; %s: %.2f",
        "Funcionário comissionado ", super.toString(),
        "Vendas brutas ", getVendaBrutaSemanal(),
        "Taxa de comissão ", getTaxaComissao());
        }

}
