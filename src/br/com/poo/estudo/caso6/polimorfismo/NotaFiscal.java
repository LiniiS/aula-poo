package br.com.poo.estudo.caso6.polimorfismo;

public class NotaFiscal implements Pagavel{

    private final String numero;
    private final String descricao;
    private int quantidade;
    private double precoUnitario;


    public NotaFiscal(String numero, String descricao, int quantidade, double precoUnitario) {
       if(quantidade < 0)
           throw new IllegalArgumentException("Quantidade deve ser maior que zero");

       if(precoUnitario < 0.0)
           throw new IllegalArgumentException("valor unitário deve ser maior que 0.0");

        this.numero = numero;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public String getNumero() {
        return numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if(quantidade < 0)
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        if(precoUnitario < 0.0)
            throw new IllegalArgumentException("Valor unitário deve ser maior que 0.0");
        this.precoUnitario = precoUnitario;
    }

    @Override
    public String toString(){
        return String.format("%s: %n%s: %s (%s) %n%s: %d %n%s: $%,.2f",
        "Nota Fiscal", "número do item", getNumero(), getDescricao(),
        "quantidade", getQuantidade(), "preço unitário", getPrecoUnitario());
    }


    @Override
    public double getValorPagamento() {
        return getQuantidade() * getPrecoUnitario();
    }
}
