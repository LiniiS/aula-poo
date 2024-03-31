package br.com.poo.estudo.caso2.nota;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NotaFiscalTeste {

    public static void main(String[] args) {

        NotaFiscal notaFiscalUm = new NotaFiscal(12345, LocalDate.now(), "82114925000128","01020321", 0.0d);

        ItemServico itemUm = new ItemServico("Caneta azul, azul caneta", 2.95);
        ItemServico itemDois = new ItemServico("Lápis de Cor Faber Castell", 52.99);
        ItemServico itemTres = new ItemServico("Borracha macia", 0.55);

        List<ItemServico> itens = new ArrayList<>();
        itens.add(itemUm);
        itens.add(itemDois);
        itens.add(itemTres);

        notaFiscalUm.setItens(itens);

        notaFiscalUm.setValorTotal(notaFiscalUm.calcularValorTotalDaNota(itens));

    }
}
