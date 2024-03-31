package br.com.poo.estudo.caso2.nota;

import br.com.poo.estudo.caso2.nota.util.CnpjValidator;

import java.time.LocalDate;
import java.util.List;

public class NotaFiscal {
    private int numeroNotaFiscal;
    private LocalDate dataEmissao;
    private String cnpj;
    private String inscricao;
    private List<ItemServico> itens;
    private double valorTotal;


    public NotaFiscal(int numeroNotaFiscal, LocalDate dataEmissao, String cnpj, String inscricao, double valorTotal) {
        if(!CnpjValidator.isValidCNPJ(cnpj)){
            throw new IllegalArgumentException("CNPJ inválido");
        }
        this.numeroNotaFiscal = numeroNotaFiscal;
        this.dataEmissao = dataEmissao;
        this.cnpj = cnpj;
        this.inscricao = inscricao;
        this.valorTotal = valorTotal;
    }

    public int getNumeroNotaFiscal() {
        return numeroNotaFiscal;
    }

    public void setNumeroNotaFiscal(int numeroNotaFiscal) {
        this.numeroNotaFiscal = numeroNotaFiscal;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricao() {
        return inscricao;
    }

    public void setInscricao(String inscricao) {
        this.inscricao = inscricao;
    }

    public List<ItemServico> getItens() {
        return itens;
    }

    public void setItens(List<ItemServico> itens) {
        this.itens = itens;
        this.valorTotal = atualizaValorTotal(itens);
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double atualizaValorTotal(List<ItemServico> itens) {
        return this.valorTotal += calcularValorTotalDaNota(itens);
    }

    public void adicionarItem(ItemServico item){
        itens.add(item);
        System.out.println("Novo item adicionado: ");
    }

    public double calcularValorTotalDaNota(List<ItemServico> itens){
        double somaDoPrecoDosItens = 0d;

        for(ItemServico item : itens){
            somaDoPrecoDosItens += item.getPreco();
            System.out.println("Item adicionado: " + item.getDescricao());
        }

        System.out.println("Valor total da Nota: " + somaDoPrecoDosItens);
        return somaDoPrecoDosItens;

    }

}
