package br.com.poo.estudo.caso7.arcoiris;

import br.com.poo.estudo.caso7.arcoiris.DesenhaArcoIris;

import javax.swing.*;

public class DesenhaArcoIrisTeste {

    public static void main(String[] args) {

       DesenhaArcoIris painel = new DesenhaArcoIris();
       JFrame aplicacao = new JFrame();

       aplicacao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       aplicacao.setTitle("Estudo de Caso  7 - Listas e Arrays");
       aplicacao.add(painel);
       aplicacao.setSize(400,250);
       aplicacao.setVisible(true);

    }
}