package br.com.poo.estudo.caso7.arcoiris;

import javax.swing.*;
import java.awt.*;

public class DesenhaArcoIris extends JPanel {

    private final static Color VIOLETA = new Color(128, 0,128);
    private final static Color INDIGO = new Color(75,0,130);


    private Color[] cores = {
            Color.WHITE,
            Color.WHITE,
            VIOLETA,
            INDIGO,
            Color.BLUE,
            Color.GREEN,
            Color.YELLOW,
            Color.ORANGE,
            Color.RED
    };

    public DesenhaArcoIris(){
        setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics grafico){
        super.paintComponent(grafico);

        int raio = 20;

        int centroX = getWidth() / 2;
        int centroY = getHeight() -10;

        for(int contador = 0; contador < cores.length; contador ++){
            int ajustePosicao = cores.length - contador;
            grafico.setColor(cores[contador]);

            grafico.fillArc(
                    centroX - ajustePosicao * raio,
                    centroY - ajustePosicao * raio,
                    ajustePosicao * raio * 2,
                    ajustePosicao * raio * 2,
                    0,
                    180);
        }

    }
}
