package br.com.poo.estudo.caso7.arcoiris;

import javax.swing.JFrame; // manipula a exibição
import javax.swing.JOptionPane;

public class FormasTeste {
    public static void main(String[] args) {

        String input = JOptionPane.showInputDialog(
                "Enter 1 to draw rectangles\n" +
                        "Enter 2 to draw ovals");

        int choice = Integer.parseInt(input); // converte a entrada em int

        // cria o painel com a entrada do usuário
        Formas panel = new Formas(choice);

        JFrame application = new JFrame(); // cria um novo JFrame

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(300, 300);
        application.setVisible(true);
    }
}
