package br.com.poo.estudo.caso3.condicionais.nf.app;

import br.com.poo.estudo.caso2.nota.ItemServico;
import br.com.poo.estudo.caso2.nota.NotaFiscal;
import br.com.poo.estudo.caso2.nota.util.CnpjValidator;
import br.com.poo.estudo.caso3.condicionais.nf.app.exception.InvalidCnpjException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NotaFiscalAppGUI {
    private List<NotaFiscal> notasFiscais;
    private JFrame frame;
    private JTextField numeroField, valorField, cnpjField, inscricaoField, totalField;
    private JLabel numeroLabel, valorLabel, cnpjLabel, inscricaoLabel, totalLabel;
    private JButton createNotaButton, addItemButton, calculateMediaButton, calculateValorTotal, showNotaFiscalButton, showItensNotaFiscalButton;

    public NotaFiscalAppGUI() {
        notasFiscais = new ArrayList<>();

        initialize();
    }

    private void initialize() {
        frame = new JFrame("Nota Fiscal App");
        frame.setSize(600, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(7, 2));

        numeroLabel = new JLabel("Número da Nota Fiscal:");
        frame.add(numeroLabel);
        numeroField = new JTextField();
        frame.add(numeroField);

        cnpjLabel = new JLabel("CNPJ:");
        frame.add(cnpjLabel);
        cnpjField = new JTextField();
        frame.add(cnpjField);

        inscricaoLabel = new JLabel("Inscrição:");
        frame.add(inscricaoLabel);
        inscricaoField = new JTextField();
        frame.add(inscricaoField);

//        valorLabel = new JLabel("Valor:");
//        frame.add(valorLabel);
//        valorField = new JTextField();
//        frame.add(valorField);

        totalField = new JTextField();
        totalField.setEditable(false);
        frame.add(new JLabel("Total: "));
        frame.add(totalField);

        createNotaButton = new JButton("Criar Nota Fiscal");
        createNotaButton.addActionListener(new CreateNotaListener());
        frame.add(createNotaButton);

        addItemButton = new JButton("Adicionar Item");
        addItemButton.addActionListener(new AddItemListener());
        frame.add(addItemButton);
        addItemButton.setEnabled(false);

        calculateMediaButton = new JButton("Calcular Media");
        calculateMediaButton.addActionListener(new CalculateMediaListener());
        frame.add(calculateMediaButton);
        calculateMediaButton.setEnabled(false);

        calculateValorTotal = new JButton("Calcular Valor Total");
        calculateValorTotal.addActionListener(new CalculateValorTotalListener());
        frame.add(calculateValorTotal);
        calculateValorTotal.setEnabled(false);

        showNotaFiscalButton = new JButton("Ver Nota Fiscal");
        showNotaFiscalButton.addActionListener(new ShowNotaFiscalListener());
        frame.add(showNotaFiscalButton);
        showNotaFiscalButton.setEnabled(false);

        showItensNotaFiscalButton = new JButton("Ver itens da Nota Fiscal");
        showItensNotaFiscalButton.addActionListener(new ShowItensNotaFiscalListener());
        frame.add(showItensNotaFiscalButton);
        showItensNotaFiscalButton.setEnabled(false);

        frame.setVisible(true);
    }

    private class CreateNotaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(!totalField.getText().isEmpty()){
                totalField.setText("");

            }

            try {
                int numeroNotaFiscal = Integer.parseInt(numeroField.getText());
               // double valorTotal = Double.parseDouble(valorField.getText());
                LocalDate dataEmissao = LocalDate.now();
                String cnpj = String.valueOf(cnpjField.getText());
                String inscricao = String.valueOf(inscricaoField.getText());


                // Valida o CNPJ
                if (!CnpjValidator.isValidCNPJ(cnpj)) {
                    throw new InvalidCnpjException("CNPJ inválido.");
                }

                NotaFiscal currentNotaFiscal = new NotaFiscal(numeroNotaFiscal, dataEmissao, cnpj, inscricao, 0.0d);
                List<ItemServico> itens = new ArrayList<>();
                currentNotaFiscal.setItens(itens);
                notasFiscais.add(currentNotaFiscal);


                JOptionPane.showMessageDialog(frame, "Nota fiscal criada com sucesso!");

                // limpa os campos
                clearInputFields();

                addItemButton.setEnabled(true);
                calculateMediaButton.setEnabled(true);
                calculateValorTotal.setEnabled(true);
                showNotaFiscalButton.setEnabled(true);
                showItensNotaFiscalButton.setEnabled(true);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Entrada inválida. Verifique os campos.");
            } catch (InvalidCnpjException ex) {
                JOptionPane.showMessageDialog(frame, "CNPJ inválido. Por favor, insira um CNPJ válido.");
            }
        }

        private void clearInputFields() {
            numeroField.setText("");
  //          valorField.setText("");
            cnpjField.setText("");
            inscricaoField.setText("");
        }
    }


    private class AddItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            JFrame addItemFrame = new JFrame("Adicionar item");
            addItemFrame.setSize(300, 200);
            addItemFrame.setLayout(new GridLayout(3, 2));

            JTextField descricaoField = new JTextField();
            JTextField precoField = new JTextField();

            JLabel descricaoLabel = new JLabel("Descrição:");
            JLabel precoLabel = new JLabel("Preço:");

            JButton addButton = new JButton("Adicionar");
            addButton.addActionListener(evento -> {

                String descricao = descricaoField.getText();
                double preco = Double.parseDouble(precoField.getText());

                ItemServico itemServico = new ItemServico(descricao, preco);



                if (!notasFiscais.isEmpty()) {
                    NotaFiscal currentNotaFiscal = notasFiscais.get(notasFiscais.size() - 1);
                    List<ItemServico> itens = currentNotaFiscal.getItens();
                    itens.add(itemServico);


                    JOptionPane.showMessageDialog(addItemFrame, "Item adicionado com sucesso!");


                    int option = JOptionPane.showConfirmDialog(addItemFrame, "Deseja adicionar outro item?", "Adicionar Item", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {

                    } else {
                        JOptionPane.showMessageDialog(addItemFrame, "Itens adicionados! O valor da nota será atualizado.");
                        addItemFrame.dispose();
                    }

                    double valorTotalAtualizado = currentNotaFiscal.calcularValorTotalDaNota(currentNotaFiscal.getItens());
                    totalField.setText(String.format("%.2f", valorTotalAtualizado));

                } else {
                    JOptionPane.showMessageDialog(addItemFrame, "Nenhuma nota fiscal foi criada ainda!");
                }


            });

            addItemFrame.add(descricaoLabel);
            addItemFrame.add(descricaoField);
            addItemFrame.add(precoLabel);
            addItemFrame.add(precoField);
            addItemFrame.add(addButton);

            addItemFrame.setVisible(true);
        }
    }

    private class CalculateMediaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (notasFiscais.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Sem notas Fiscais criadas");
                return;
            }


            double totalValue = 0;
            for (NotaFiscal notaFiscal : notasFiscais) {
                totalValue += notaFiscal.calcularValorTotalDaNota(notaFiscal.getItens());
            }

            double media = totalValue / notasFiscais.size();
            JOptionPane.showMessageDialog(frame, "Média das notas fiscais: " + media);
        }
    }

    private class CalculateValorTotalListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            NotaFiscal currentNotaFiscal = notasFiscais.get(notasFiscais.size() - 1);
            List<ItemServico> currentItens = currentNotaFiscal.getItens();
            double valorTotal = currentNotaFiscal.calcularValorTotalDaNota(currentItens);
            totalField.setText(String.valueOf(valorTotal));

            JOptionPane.showMessageDialog(frame, "Valor da nota atualizado: " + valorTotal);

        }
    }

    private class ShowNotaFiscalListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (notasFiscais.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Nenhuma Nota Fiscal criada ainda!");
                return;
            }

            NotaFiscal currentNotaFiscal = notasFiscais.get(notasFiscais.size() - 1);

            String notaFiscalInfo = "Número da Nota Fiscal: " + currentNotaFiscal.getNumeroNotaFiscal() + "\n" +
                    "Data de Emissão: " + currentNotaFiscal.getDataEmissao() + "\n" +
                    "CNPJ: " + currentNotaFiscal.getCnpj() + "\n" +
                    "Inscrição: " + currentNotaFiscal.getInscricao() + "\n" +
                    "Valor Total: " + String.format("%.2f", currentNotaFiscal.calcularValorTotalDaNota(currentNotaFiscal.getItens()));


            JOptionPane.showMessageDialog(frame, notaFiscalInfo, "Detalhes da Nota Fiscal", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private class ShowItensNotaFiscalListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (notasFiscais.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Nenhuma Nota Fiscal criada ainda!");
                return;
            }

            NotaFiscal currentNotaFiscal = notasFiscais.get(notasFiscais.size() - 1);

            StringBuilder notaFiscalInfo = new StringBuilder();
            notaFiscalInfo.append("Número da Nota Fiscal: ").append(currentNotaFiscal.getNumeroNotaFiscal()).append("\n")
                    .append("Data de Emissão: ").append(currentNotaFiscal.getDataEmissao()).append("\n")
                    .append("CNPJ: ").append(currentNotaFiscal.getCnpj()).append("\n")
                    .append("Inscrição: ").append(currentNotaFiscal.getInscricao()).append("\n")
                    .append("Valor Total: ").append(String.format("%.2f", currentNotaFiscal.calcularValorTotalDaNota(currentNotaFiscal.getItens()) )).append("\n\n");



            StringBuilder itensInfo = new StringBuilder();
            for (ItemServico item : currentNotaFiscal.getItens()) {
                itensInfo.append("- Descrição: ").append(item.getDescricao()).append(", Preço: ").append(item.getPreco()).append("\n");
            }


            notaFiscalInfo.append("Itens:\n").append(itensInfo);

            JOptionPane.showMessageDialog(frame, notaFiscalInfo.toString(), "Detalhes da Nota Fiscal", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NotaFiscalAppGUI();

            }
        });
    }
}

