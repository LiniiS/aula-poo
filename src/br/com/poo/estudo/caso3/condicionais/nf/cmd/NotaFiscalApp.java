package br.com.poo.estudo.caso3.condicionais.nf.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NotaFiscalApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<NotaFiscal> notasFiscais = new ArrayList<>();

        do {
            NotaFiscal notaFiscal = createNotaFiscal(scanner);
            addItensServico(scanner, notaFiscal);
            notasFiscais.add(notaFiscal);
        } while (askForMoreNotasFiscais(scanner));

        // Calculate a média das Notas Fiscais
        System.out.print("Especifique quantas notas ficais serão avaliadas: ");
        int numeroDeNotasFiscais = scanner.nextInt();
        double media = calculaMedia(notasFiscais, numeroDeNotasFiscais);
        System.out.println("Media das Notas Fiscais: " + media);

        scanner.close();
    }

    private static NotaFiscal createNotaFiscal(Scanner scanner) {
        System.out.print("Digite o número da Nota Fiscal: ");
        int number = scanner.nextInt();
        return new NotaFiscal(number);
    }

    private static void addItensServico(Scanner scanner, NotaFiscal notaFiscal) {
        char addMoreItens;
        do {
            System.out.print("Enter the description of the item: ");
            String description = scanner.next();
            System.out.print("Enter the price of the item: ");
            double price = scanner.nextDouble();
            ItemServico itemServico = new ItemServico(description, price);
            notaFiscal.addItem(itemServico);

            System.out.print("Do you want to add another item? (Y/N): ");
            addMoreItens = scanner.next().charAt(0);
        } while (addMoreItens == 'Y' || addMoreItens == 'y');
    }

    private static boolean askForMoreNotasFiscais(Scanner scanner) {
        System.out.print("Do you want to add another Nota Fiscal? (Y/N): ");
        char response = scanner.next().charAt(0);
        return response == 'Y' || response == 'y';
    }

    private static double calculaMedia(List<NotaFiscal> notasFiscais, int numberOfNotas) {
        if (numberOfNotas > notasFiscais.size()) {
            numberOfNotas = notasFiscais.size();
        }

        double total = 0;
        for (int i = 0; i < numberOfNotas; i++) {
            total += notasFiscais.get(i).getTotal();
        }

        return total / numberOfNotas;
    }
}

class NotaFiscal {
    private int number;
    private List<ItemServico> itensServico;

    public NotaFiscal(int number) {
        this.number = number;
        this.itensServico = new ArrayList<>();
    }

    public void addItem(ItemServico itemServico) {
        itensServico.add(itemServico);
    }

    public double getTotal() {
        double total = 0;
        for (ItemServico item : itensServico) {
            total += item.getPrice();
        }
        return total;
    }
}

class ItemServico {
    private String description;
    private double price;

    public ItemServico(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}