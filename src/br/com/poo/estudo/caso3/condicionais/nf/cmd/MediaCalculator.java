package br.com.poo.estudo.caso3.condicionais.nf.cmd;

import br.com.poo.estudo.caso2.nota.NotaFiscal;

import java.util.List;

public class MediaCalculator{
public static double calculaMedia(List<NotaFiscal> notasFiscais) {
    if (notasFiscais == null || notasFiscais.isEmpty()) {
        throw new IllegalArgumentException("List cannot be null or empty");
    }

    double total = 0;
    for (NotaFiscal notaFiscal : notasFiscais) {
        total += notaFiscal.getValorTotal();
    }

    return total / notasFiscais.size();
    }

}
