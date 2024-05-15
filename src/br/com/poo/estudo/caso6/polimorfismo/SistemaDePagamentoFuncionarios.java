package br.com.poo.estudo.caso6.polimorfismo;

public class SistemaDePagamentoFuncionarios {
    public static void main(String[] args) {
        FuncionarioAssalariado assalariado = new FuncionarioAssalariado("Ana", "Clara", "123456789", 800.00);
        FuncionarioHorista horista = new FuncionarioHorista("João", "Victor", "123456789", 16.75, 40);
        FuncionarioComissionado comissionado = new FuncionarioComissionado("Lurdes", "Silva", "123456789", 5000, .06);
        FuncionarioBaseComissionado baseComissionado = new FuncionarioBaseComissionado("Antonio", "Soares", "123456789", 5000, .04, 300);

        System.out.println("::: Processamento dos funcionários :::");

        System.out.printf("%n%s%n%s: $%,.2f%n%n", assalariado, "Faturou", assalariado.faturamento());
        System.out.printf("%n%s%n%s: $%,.2f%n%n", horista, "Faturou", horista.faturamento());
        System.out.printf("%n%s%n%s: $%,.2f%n%n", comissionado, "Faturou", comissionado.faturamento());
        System.out.printf("%n%s%n%s: $%,.2f%n%n", baseComissionado, "Faturou", baseComissionado.faturamento());


        /* Criando array de Funcionários para manipular os objetos através do polimorfismo */
        Funcionario[] funcionarios = new Funcionario[4];

        funcionarios[0] = assalariado;
        funcionarios[1] = horista;
        funcionarios[2] = comissionado;
        funcionarios[3] = baseComissionado;

        System.out.println("::: Processamento dos Polimorficamente :::");
        for (Funcionario funcionario : funcionarios ) {
            System.out.println(funcionario); //o toString é chamado

            if(funcionario instanceof FuncionarioBaseComissionado){
                FuncionarioBaseComissionado funcionarioBase = (FuncionarioBaseComissionado) funcionario;
                funcionarioBase.setSalarioBase(1.10 * funcionarioBase.getSalarioBase());

                System.out.printf("Novo salário base com 10%% de aumento é: $%, .2f%n", funcionarioBase.getSalarioBase());
            }
        }
    }
}
