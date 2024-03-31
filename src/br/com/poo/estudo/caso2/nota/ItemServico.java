package br.com.poo.estudo.caso2.nota;

public class ItemServico {
    private String descricao;
    private double preco;

    public ItemServico(String descricao, double preco) {
        if(preco < 0){
            throw new IllegalArgumentException("valor não pode ser negativo");
        }
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
