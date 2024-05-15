package br.com.poo.estudo.caso7.arcoiris;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Formas extends JPanel {
    private int choice; // escolha do usuário de qual forma desenhar

    // construtor configura a escolha do usuário
    public Formas(int userChoice) {
        choice = userChoice;
    }
    private Object objj;
    private Objects objs;
    // desenha uma cascata de formas que iniciam do canto superior esquerdo
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < 10; i++) {
            // seleciona a forma com base na escolha do usuário
            switch (choice) {
                case 1: // desenha retângulos
                    g.drawRect(10 + i * 10, 10 + i * 10,
                            50 + i * 10, 50 + i * 10);
                    break;
                case 2: // desenha ovais
                    g.drawOval(10 + i * 10, 10 + i * 10,
                            50 + i * 10, 50 + i * 10);
                    break;
            }
        }
    }
}
