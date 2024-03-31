package br.com.poo.estudo.caso3.condicionais.nf.cmd;

import br.com.poo.estudo.caso2.nota.ItemServico;
import br.com.poo.estudo.caso2.nota.NotaFiscal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static br.com.poo.estudo.caso3.condicionais.nf.cmd.MediaCalculator.calculaMedia;

public class NotaFiscalTeste {

    public static void main(String[] args) {
        NotaFiscal nf1 = new NotaFiscal(1, LocalDate.now(), "82114925000128", "1236547", 0.0);
        NotaFiscal nf2 = new NotaFiscal(1, LocalDate.now(), "82114925000128", "1236547", 0.0);
        NotaFiscal nf3 = new NotaFiscal(1, LocalDate.now(), "82114925000128", "1236547", 0.0);


        ItemServico itemUm = new ItemServico("Caneta azul, azul caneta", 2.95);
        ItemServico itemDois = new ItemServico("Lápis de Cor Faber Castell", 52.99);
        ItemServico itemTres = new ItemServico("Borracha macia", 0.55);

        List<ItemServico> listaNf1 = new ArrayList<>();
        listaNf1.add(itemUm);
        listaNf1.add(itemDois);

        List<ItemServico> listaNf2 = new ArrayList<>();
        listaNf2.add(itemUm);
        listaNf2.add(itemTres);

        List<ItemServico> listaNf3 = new ArrayList<>();
        listaNf3.add(itemDois);
        listaNf3.add(itemTres);


        nf1.setItens(listaNf1);
        nf2.setItens(listaNf2);
        nf3.setItens(listaNf3);



        List<NotaFiscal> notasFiscais = List.of(nf1, nf2, nf3);
        double media = calculaMedia(notasFiscais);
        System.out.printf("Media das Notas: $%.2f%n", media);


    }
}
